package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.AdListContract
import com.guoxun.airbaba.mvp.model.AdListModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle

class AdListPresenter : BasePresenter<AdListContract.View>(), AdListContract.Presenter {
    private val mAdListModel: AdListModel by lazy {

        AdListModel()
    }

    override fun requestAdListInfo(types: String , pid : String) {
        checkViewAttached()
//        mRootView?.showLoading()
        val disposable = mAdListModel.getAdListInfo(types, pid)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
//                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            responseInfo.response?.let { showAdListInfo(it) }
                        } else {
                            responseInfo.msg?.let { showError(it, ExceptionHandle.errorCode) }
                        }
                    }
                }, { t ->
                    mRootView?.apply {
                        //处理异常
//                        dismissLoading()
                        showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                    }

                })

        addSubscription(disposable)
    }
}