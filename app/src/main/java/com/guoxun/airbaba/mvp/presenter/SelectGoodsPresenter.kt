package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.SelectGoodsContract
import com.guoxun.airbaba.mvp.model.SelectGoodsModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle

class SelectGoodsPresenter : BasePresenter<SelectGoodsContract.View>(), SelectGoodsContract.Presenter {
    private val mSelectGoodsModel: SelectGoodsModel by lazy {

        SelectGoodsModel()
    }

    override fun requestSelectGoodsInfo() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = mSelectGoodsModel.getSelectGoodsInfo()
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            responseInfo.response?.let { showSelectGoodsInfo(it) }
                        } else {
                            responseInfo.msg?.let { showError(it, ExceptionHandle.errorCode) }
                        }
                    }
                }, { t ->
                    mRootView?.apply {
                        //处理异常
                        dismissLoading()
                        showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                    }

                })

        addSubscription(disposable)
    }
}