package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.ShopListContract
import com.guoxun.airbaba.mvp.model.ShopListModel
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle


/**
 * Created by xuhao on 2017/11/8.
 * 首页精选的 Presenter
 * (数据是 Banner 数据和一页数据组合而成的 HomeBean,查看接口然后在分析就明白了)
 */

class ShopListPresenter : BasePresenter<ShopListContract.View>(), ShopListContract.Presenter {


    private val girlsModel: ShopListModel by lazy {
        ShopListModel()
    }

    override fun requestShopListInfo(page: Int) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = girlsModel.getShopListInfo(page)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            responseInfo.response?.let { showShopListInfo(it) }
                        }else{
                            responseInfo.msg?.let { showError(it,ExceptionHandle.errorCode) }
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