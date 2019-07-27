package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.NewRetailContract
import com.guoxun.airbaba.mvp.model.NewRetailModel
import com.guoxun.airbaba.mvp.model.bean.NewRetailEntity
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle


/**
 * 首页-新零售特供商品列表
 * @auther JayGengi
 * 2019/7/27  21:55
 * @email jaygengiii@gmail.com
 */

class NewRetailPresenter : BasePresenter<NewRetailContract.View>(), NewRetailContract.Presenter {


    private val girlsModel: NewRetailModel by lazy {
        NewRetailModel()
    }

    override fun requestNewRetailInfo(page: Int) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = girlsModel.getNewRetailInfo(page)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            responseInfo.response?.let { showNewRetailInfo(it) }
                        }else{
                            responseInfo.msg?.let { showError(it,ExceptionHandle.errorCode) }
                        }
                    }
                }, { t ->
                    mRootView?.apply {
                        //处理异常
                        dismissLoading()
                        showError(ExceptionHandle.handleException(t),ExceptionHandle.errorCode)
                    }

                })

        addSubscription(disposable)
    }


}