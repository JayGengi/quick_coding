package com.guoxun.coding.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.guoxun.coding.R;


/**
 * 根据宽高比例自动计算高度
 */
@SuppressLint("AppCompatCustomView")
public class RatioImageView extends ImageView {
    /**
     * 宽高比例
     */
    private float mRatio = 0f;

    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        mRatio = typedArray.getFloat(R.styleable.RatioImageView_ratio,0f);
        typedArray.recycle();
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置 ImageView 的宽高比
     * @param ratio
     */
    public void setRatio(float ratio){
        mRatio = ratio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (mRatio != 0){
            float height = width / mRatio;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) height,MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            /**
             *  这种变暗效果好low,pass
             * */
//            case MotionEvent.ACTION_DOWN:
//                Drawable drawable = getDrawable();
//                if (drawable != null){
//                    drawable.mutate().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//                break;
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_UP:
//                Drawable drawableUp = getDrawable();
//                if (drawableUp != null){
//                    drawableUp.mutate().clearColorFilter();
//                }
//                break;
        }
        return super.onTouchEvent(event);
    }
}
