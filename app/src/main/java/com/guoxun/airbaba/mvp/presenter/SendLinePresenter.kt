package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.SendLineContract
import com.guoxun.airbaba.mvp.model.SendLineModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle


/**
  * @des    发送验证码
  * @auther JayGengi
  * @data   2019/7/27  10:38
  * @email  jaygengiii@gmail.com
  */

class SendLinePresenter : BasePresenter<SendLineContract.View>(), SendLineContract.Presenter {


    private val mSendLineModel: SendLineModel by lazy {
        SendLineModel()
    }

    override fun requestSendLineInfo(map: Map<String, Any>) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = mSendLineModel.getSendLineInfo(map)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            showSendLineInfo(responseInfo.msg)
                        }else{
                            showError( responseInfo.msg,ExceptionHandle.errorCode)
                        }
                    }
                }, { t ->
                    mRootView?.apply {
                        //处理异常
                        showError(ExceptionHandle.handleException(t),ExceptionHandle.errorCode)
                    }

                })

        addSubscription(disposable)
    }


}