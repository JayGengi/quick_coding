package com.guoxun.coding.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.guoxun.coding.R;

import java.util.ArrayList;
import java.util.List;

import cc.shinichi.library.ImagePreview;
import cc.shinichi.library.bean.ImageInfo;

/**
 * 多形态九宫格图片展示
 */
public class NineGridView extends NineGridLayout {

    private Context mContext;
    private RequestOptions options;


    public NineGridView(Context context) {
        this(context,null);
    }

    public NineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        options = new RequestOptions();
        options.placeholder(R.mipmap.ic_error);
    }

    @Override
    protected boolean displayOneImage(RatioImageView imageView, String url, int parentWidth) {

        Glide.with(mContext).load(url).apply(options).into(imageView);
        setOneImageLayoutParams(imageView);
        return false;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        Glide.with(mContext).load(url).apply(options).into(imageView);
    }

    @Override
    protected void onClickImage(int position, String url, ArrayList<String> urlList) {
        if (urlList == null || "".equals(url)){
            return;
        }
        setLargeImageView(position,urlList);

    }


    private void setLargeImageView(int position,ArrayList<String> urlList){


        List<ImageInfo> imageInfoList = new ArrayList<>();
        ImageInfo img = null;
        for (String imgUrl : urlList){
            img = new ImageInfo();
            img.setOriginUrl(imgUrl);
            img.setThumbnailUrl(imgUrl);
            imageInfoList.add(img);
        }

        ImagePreview
                .getInstance()
                .setContext(mContext)
                .setIndex(position)// 从第一张图片开始，索引从0开始哦
                .setImageInfoList(imageInfoList)
                .setShowDownButton(true)
                .setLoadStrategy(ImagePreview.LoadStrategy.Default)
                .setFolderName("coding")
                .setScaleLevel(1, 3, 8)
                .setZoomTransitionDuration(500)
                .setEnableDragClose(true)// 是否启用上拉/下拉关闭。默认不启用
                //                            .setShowIndicator(showIndicator)// 设置是否显示顶部的指示器（1/9）。默认显示
                //                            .setErrorPlaceHolder(R.drawable.load_failed)// 设置失败时的占位图，默认为R.drawable.load_failed，设置为0时不显示
                .start();
    }
}
