package com.guoxun.shanzuo.widget;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;


import com.guoxun.shanzuo.R;

import java.util.List;

/**
  * @des    仿淘宝首页的 淘宝头条滚动的自定义View
  * @auther JayGengi
  * @data   2019/11/19  10:39
  * @email  jaygengiii@gmail.com
  */
public class UPMarqueeView extends ViewFlipper {

    private Context mContext;

    public UPMarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        int interval = 2000;
        setFlipInterval(interval);
        Animation animIn = AnimationUtils.loadAnimation(mContext, R.anim.anim_marquee_in);
        boolean isSetAnimDuration = false;
        /*
      动画时间
     */
        int animDuration = 500;
        if (isSetAnimDuration) animIn.setDuration(animDuration);
        setInAnimation(animIn);
        Animation animOut = AnimationUtils.loadAnimation(mContext, R.anim.anim_marquee_out);
        if (isSetAnimDuration) animOut.setDuration(animDuration);
        setOutAnimation(animOut);
    }


    /**
     * 设置循环滚动的View数组
     *
     * @param views
     */
    public void setViews(List<View> views) {
        if (views == null || views.size() == 0) return;
        removeAllViews();
        for (int i = 0; i < views.size(); i++) {
            addView(views.get(i));
        }
        startFlipping();
    }

    public void setView(View views) {
        if (views == null) return;
        removeAllViews();
        addView(views);
        startFlipping();
    }
}

