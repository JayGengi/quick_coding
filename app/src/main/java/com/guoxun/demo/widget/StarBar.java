package com.guoxun.demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.guoxun.demo.R;


/**
 * 描述：星星评分
 * @author JayGengi
 * @date 2018/8/13 0013 下午 2:25
 */
public class StarBar extends View{
    public int starDistance = 0; //星星间距
    public int starCount = 5;  //星星个数
    private int starSize;     //星星高度大小，星星一般正方形，宽度等于高度
    private float starMark = 0.0F;   //评分星星
    private Bitmap starFillBitmap; //亮星星
    private Drawable starEmptyDrawable; //暗星星
    private OnStarChangeListener onStarChangeListener;//监听星星变化接口
    private Paint paint;         //绘制星星画笔
    private boolean integerMark = false;//是否整数
    private boolean halfMark = false;//是否一半
    private boolean isEnable = true;
    public StarBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public StarBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * 初始化UI组件
     *
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs){
        setClickable(true);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.RatingBar);
        this.starDistance = (int) mTypedArray.getDimension(R.styleable.RatingBar_starDistance, 0);
        this.starSize = (int) mTypedArray.getDimension(R.styleable.RatingBar_starSize, 35);
        this.starCount = mTypedArray.getInteger(R.styleable.RatingBar_starCount, 5);

        this.starEmptyDrawable = mTypedArray.getDrawable(R.styleable.RatingBar_starEmpty);


        this.starEmptyDrawable = getResources().getDrawable(R.drawable.ic_evaluate_nor);
        this.starFillBitmap =  drawableToBitmap(getResources().getDrawable(R.drawable.ic_evaluate_selected));

        mTypedArray.recycle();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(starFillBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
    }

    /**
     * 设置是否需要整数评分
     * @param integerMark
     */
    public void setIntegerMark(boolean integerMark){
        this.integerMark = integerMark;
        this.halfMark=false;
    }

    /**
     * 设置是否需要一半评分
     * @param halfMark
     */
    public void setHalfMark(boolean halfMark){
        this.halfMark = halfMark;
        this.integerMark=false;
    }

    /**
     * 是否可点击
     *
     * @return starMark
     */
    public void clickable(boolean enable){
        setClickable(enable);
        setEnabled(enable);
        isEnable = enable;
    }


    /**
     * 设置显示的星星的分数
     *
     * @param mark
     */
    public void setStarMark(float mark){
        float oldStarMark=starMark;
        if (integerMark) {//整数显示
            starMark = (int)Math.ceil(mark);
        }else if(halfMark){//一半显示
            starMark = (int)Math.ceil(mark);
            if(starMark-0.5f==oldStarMark){
                starMark = oldStarMark+0.5f;
            }else{
                starMark = oldStarMark+(starMark-oldStarMark-0.5f);
            }
        }else{//小数显示
            starMark = Math.round(mark * 10) * 1.0f / 10;
        }
        if(starMark<0){
            starMark=0;
        }
        if (this.onStarChangeListener != null) {
            this.onStarChangeListener.onStarChange(starMark);  //调用监听接口
        }
        invalidate();
    }

    /**
     * 获取显示星星的数目
     *
     * @return starMark
     */
    public float getStarMark(){
        return starMark;
    }


    /**
     * 定义星星点击的监听接口
     */
    public interface OnStarChangeListener {
        void onStarChange(float mark);
    }

    /**
     * 设置监听
     * @param onStarChangeListener
     */
    public void setOnStarChangeListener(OnStarChangeListener onStarChangeListener){
        this.onStarChangeListener = onStarChangeListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(starSize * starCount + starDistance * (starCount - 1), starSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (starFillBitmap == null || starEmptyDrawable == null) {
            return;
        }
        for (int i = 0;i < starCount;i++) {
            starEmptyDrawable.setBounds((starDistance + starSize) * i, 0, (starDistance + starSize) * i + starSize, starSize);
            starEmptyDrawable.draw(canvas);
        }
        if (starMark > 1) {
            canvas.drawRect(0, 0, starSize, starSize, paint);
            if(starMark-(int)(starMark) == 0) {
                for (int i = 1; i < starMark; i++) {
                    canvas.translate(starDistance + starSize, 0);
                    canvas.drawRect(0, 0, starSize, starSize, paint);
                }
            }else {
                for (int i = 1; i < starMark - 1; i++) {
                    canvas.translate(starDistance + starSize, 0);
                    canvas.drawRect(0, 0, starSize, starSize, paint);
                }
                canvas.translate(starDistance + starSize, 0);
                canvas.drawRect(0, 0, starSize * (Math.round((starMark - (int) (starMark))*10)*1.0f/10), starSize, paint);
            }
        }else {
            canvas.drawRect(0, 0, starSize * starMark, starSize, paint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(isEnable){
            int x = (int) event.getX();
            if (x < 0) x = 0;
            if (x > getMeasuredWidth()) x = getMeasuredWidth();
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN: {
                    setStarMark(x*1.0f / (getMeasuredWidth()*1.0f/starCount));
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    setStarMark(x*1.0f / (getMeasuredWidth()*1.0f/starCount));
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    break;
                }
            }
            invalidate();
        }
        return super.onTouchEvent(event);
    }

    /**
     * drawable转bitmap
     *
     * @param drawable
     * @return
     */
    private Bitmap drawableToBitmap(Drawable drawable)
    {
        if (drawable == null)return null;
        Bitmap bitmap = Bitmap.createBitmap(starSize, starSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, starSize, starSize);
        drawable.draw(canvas);
        return bitmap;
    }
}
