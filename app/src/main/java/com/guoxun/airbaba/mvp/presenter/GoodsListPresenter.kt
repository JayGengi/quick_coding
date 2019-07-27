package com.guoxun.airbaba.mvp.presenter

import com.guoxun.airbaba.base.BasePresenter
import com.guoxun.airbaba.mvp.contract.GoodsListContract
import com.guoxun.airbaba.mvp.model.GoodsListModel
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.net.exception.ExceptionHandle

class GoodsListPresenter : BasePresenter<GoodsListContract.View>(), GoodsListContract.Presenter {
    private val mGoodsListModel: GoodsListModel by lazy {

        GoodsListModel()
    }

    override fun requestGoodsListInfo(keyword: String,shop_id: String,goods_cate: String,sort: String,page: Int) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = mGoodsListModel.getGoodsListInfo(keyword, shop_id, goods_cate, sort, page)
                .subscribe({ responseInfo ->
                    mRootView?.apply {
                        dismissLoading()
                        if (responseInfo.flag == ErrorStatus.SUCCESS) {
                            responseInfo.response?.let { showGoodsListInfo(it) }
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