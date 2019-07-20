package com.guoxun.airbaba.utils.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * 网络图片的工具类
 * <p>
 * (1)ImageView设置图片（错误图片）
 * （2）ImageView设置图片---BitMap(不设置默认图)
 * （3）设置RelativeLayout
 * （4）设置LinearLayout
 * （5）设置FrameLayout
 * （6）高斯模糊------ RelativeLayout
 * （7）高斯模糊------ LinearLayout
 * （8）圆角显示图片  ImageView
 * 使用工具类
 * （9）多种样式（模糊+圆角）
 *
 * @author huangshuyuan
 */
public class GlideUtils {

    /**
     * (1)
     * 显示图片Imageview
     *
     * @param context  上下文
     * @param errorimg 错误的资源图片
     * @param url      图片链接
     * @param imgeview 组件
     */
    public static void showImageView(Context context, Drawable errorimg, String url,
                                     ImageView imgeview) {
        Glide.with(context).load(url)// 加载图片
                .apply(new RequestOptions().placeholder(errorimg))
                .into(imgeview);

    }


    public static void showImageView(Context context, int errorimgRes, String url,
                                     ImageView imgeview) {
        Glide.with(context).load(url)// 加载图片
                .apply(new RequestOptions().placeholder(errorimgRes))
                .into(imgeview);

    }
}