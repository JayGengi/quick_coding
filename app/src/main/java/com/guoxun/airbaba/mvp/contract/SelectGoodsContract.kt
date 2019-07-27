package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.SelectGoodsEntity

/**
 * @des    契约类 登录
 */
interface SelectGoodsContract {

    interface View : IBaseView {

        /**
         *
         */
        fun showSelectGoodsInfo(dataInfo: List<SelectGoodsEntity.ResultsBean>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         *
         */
        fun requestSelectGoodsInfo()
    }

}