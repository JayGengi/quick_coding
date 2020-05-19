package com.guoxun.coding.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class ProgressView extends ImageView {
    private AnimationDrawable animationDrawable;

    public ProgressView(Context context) {
        super(context);
        initView();
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        animationDrawable = (AnimationDrawable) getBackground();
        startAnim();
    }

    @Override
    public void setVisibility(int visibility) {
        if (getVisibility() != visibility) {
            super.setVisibility(visibility);
            if (visibility == GONE || visibility == INVISIBLE) {
                stopAnim();
            } else {
                startAnim();
            }
        }
    }

    public void startAnim() {
        if (animationDrawable == null) {
            initView();
        }
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopAnim() {
        if (animationDrawable == null) {
            initView();
        }
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }
}