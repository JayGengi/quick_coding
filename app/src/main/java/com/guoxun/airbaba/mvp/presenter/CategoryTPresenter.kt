package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.CategoryTContract
import com.guoxun.airbaba.mvp.model.CategoryTModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle

class CategoryTPresenter : BasePresenter<CategoryTContract.View>(), CategoryTContract.Presenter {
    private val mCategoryTModel: CategoryTModel by lazy {

        CategoryTModel()
    }

    override fun requestCategoryTInfo(pid: Int) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = mCategoryTModel.getCategoryTInfo(pid)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            showCategoryTInfo(responseInfo.response)
                        } else {
                            showError(responseInfo.msg, ExceptionHandle.errorCode)
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