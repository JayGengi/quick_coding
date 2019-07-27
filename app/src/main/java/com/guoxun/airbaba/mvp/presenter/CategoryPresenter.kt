package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.CategoryContract
import com.guoxun.airbaba.mvp.model.CategoryModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle

class CategoryPresenter : BasePresenter<CategoryContract.View>(), CategoryContract.Presenter {
    private val mCategoryModel: CategoryModel by lazy {

        CategoryModel()
    }

    override fun requestCategoryInfo() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = mCategoryModel.getCategoryInfo()
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            responseInfo.response?.let { showCategoryInfo(it) }
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