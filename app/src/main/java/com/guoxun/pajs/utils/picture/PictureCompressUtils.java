package com.guoxun.pajs.utils.picture;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.util.Log;

import com.blankj.utilcode.util.FileUtils;
import com.guoxun.pajs.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * 描述：图片压缩工具类
 * <p>
 * 开源库地址：https://github.com/Curzibn/Luban
 *
 * @author JayGengi
 * @date 2018/7/19
 */
public class PictureCompressUtils {

    /**
     * 单图压缩
     */
    public static void singleCompress(Activity activity, Uri image) {

        FileUtils.createOrExistsDir(Constants.Companion.getSAVE_REAL_PATH());

        Luban.with(activity)
                .load(image)
                .ignoreBy(100)
                .setTargetDir(Constants.Companion.getSAVE_REAL_PATH())
                .setCompressListener(new OnCompressListener(){
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                })
                .launch();
    }

    /**
     * 多图压缩
     */
    public static List<File> multiCompress(Activity activity, List<String> image) {
//        private var pathResult: ArrayList<String>? = ArrayList()
        List<File> pathResult = new ArrayList<>();
        FileUtils.createOrExistsDir(Constants.Companion.getSAVE_REAL_PATH());

        Luban.with(activity)
                .load(image)
                .ignoreBy(100)
                .setTargetDir(Constants.Companion.getSAVE_REAL_PATH())
                .setCompressListener(new OnCompressListener(){
                    @Override
                    public void onStart() {

                    }
                    @Override
                    public void onSuccess(File file) {
                        Log.d("onSuccess", FileUtils.getLength(file)+"-----");
                        pathResult.add(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                })
                .launch();
        return pathResult;
    }

    /**
     * 使用鲁班RxJava模式压缩
     *
     * @param photos
     */
    @SuppressLint("CheckResult")
    public static List<File> initLuBanRxJava(Activity activity, List<String> photos) {
        List<File> pathResult = new ArrayList<>();
        Flowable.just(photos)//注意，可以单个压缩，也可以list压缩
                .subscribeOn(Schedulers.io())
                .map(strings -> {
                    /**
                     * 如果需要保存到本地就使用setTargetDir方法
                     */
                    return Luban.with(activity)
                            .ignoreBy(100)
                            .load(photos)
                            .get();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pathResult::addAll);
        return pathResult;
    }

}
