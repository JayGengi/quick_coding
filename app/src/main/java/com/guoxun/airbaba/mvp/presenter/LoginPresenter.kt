package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.LoginContract
import com.guoxun.airbaba.mvp.model.LoginModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle


/**
  * @des    登录
  * @auther JayGengi
  * @data   2019/7/27  10:38
  * @email  jaygengiii@gmail.com
  */

class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {


    private val mLoginModel: LoginModel by lazy {
        LoginModel()
    }

    override fun requestLoginInfo(map: Map<String, Any>) {
        checkViewAttached()
//        mRootView?.showLoading()
        val disposable = mLoginModel.getLoginInfo(map)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
//                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            showLoginInfo(responseInfo.response)
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