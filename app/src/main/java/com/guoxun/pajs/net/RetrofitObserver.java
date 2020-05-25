package com.guoxun.pajs.net;


import com.blankj.utilcode.util.LogUtils;
import com.guoxun.pajs.base.BaseActivity;
import com.guoxun.pajs.base.BaseFragment;
import com.guoxun.pajs.net.exception.ErrorStatus;
import com.guoxun.pajs.net.exception.ExceptionHandle;

import java.lang.ref.WeakReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 描述：Retrofit Observer Activity封装
 * <p>
 * Activity
 *
 * @author zhangqin
 * @date 2018/4/4
 */
public abstract class RetrofitObserver<T> implements Observer<T> {

    private WeakReference<BaseActivity> aContent;
    private WeakReference<BaseFragment> fContent;
    public RetrofitObserver(BaseActivity context) {
        super();
        aContent = new WeakReference<>(context);
    }
    public RetrofitObserver(BaseFragment context) {
        super();
        fContent = new WeakReference<>(context);
    }
    @Override
    public void onSubscribe(Disposable d) {
        if(null != aContent) {
            aContent.get().addSubscribe(d);
        }else if(null != fContent) {
            fContent.get().addSubscribe(d);
        }
    }

    @Override
    public void onComplete() {
        if (aContent != null && aContent.get() != null) {
            aContent.get().dismiss();
        }else if (fContent != null && fContent.get() != null) {
            fContent.get().dismiss();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (aContent != null && aContent.get() != null) {
            aContent.get().dismiss();
        }else if (fContent != null && fContent.get() != null) {
            fContent.get().dismiss();
        }
        onNetError(e);
    }

    @Override
    public void onNext(T response) {
        try {
            if (response instanceof BaseResponse) {
                if (ErrorStatus.SUCCESS == ((BaseResponse) response).getFlag()) {
                    onSuccess(response);
                } else {
                    onServiceError(response);
                }
            } else {
                onOtherSuccess(response);
            }
        } catch (Exception e) {
//            CrashReport.postCatchedException(e);
            onError(e);
        }
    }

    /**
     * 请求成功并且服务器未下发异常
     *
     * @param response
     */
    protected abstract void onSuccess(T response);

    /**
     * 请求成功, 返回非JavaBean
     *
     * @param response
     */
    protected void onOtherSuccess(T response) {

    }

    /**
     * 请求成功，服务器下发异常
     *
     * @param response
     */
    protected void onServiceError(T response) {

    }

    /**
     * 网络异常
     *
     * @param e
     */
    protected void onNetError(Throwable e) {
        LogUtils.e(e);
        if (aContent != null && aContent.get() != null
        || fContent != null && fContent.get() != null) {
            ExceptionHandle.Companion.handleException(e);
//            NetworkError.error(mContent.get(), e);
        }
    }
}

