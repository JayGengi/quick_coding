package com.classic.common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;

public class ProgressDialogUtils extends Dialog {
    private Context mContext;

    private static ProgressDialogUtils progressDialog;


    public ProgressDialogUtils(Context context) {
        super(context);
    }

    public ProgressDialogUtils(Context context, int theme) {
        super(context, theme);
    }

    protected ProgressDialogUtils(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public  static ProgressDialogUtils createDialog(Context context){
        //设置是否全屏，是否昏暗等效果
        progressDialog = new ProgressDialogUtils(context, R.style.MyDialog);
        //设置布局，开启动画
        progressDialog.setContentView(R.layout.progresslayout);
        progressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

        return progressDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (progressDialog == null){
            return;
        }

        ImageView imageView = (ImageView) progressDialog.findViewById(R.id.loadingprogressimg);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
    }
}