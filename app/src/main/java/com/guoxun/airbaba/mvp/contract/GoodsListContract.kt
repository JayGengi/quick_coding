package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.GoodsListEntity
import com.guoxun.airbaba.mvp.model.bean.SelectGoodsEntity

/**
 * @des    契约类 登录
 */
interface GoodsListContract {

    interface View : IBaseView {

        /**
         *
         */
        fun showGoodsListInfo(dataInfo: List<GoodsListEntity.ResultsBean>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         *
         */
        fun requestGoodsListInfo(keyword: String,shop_id: String,goods_cate: String,sort: String,page: Int)
    }

}