package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.AdListEntity

/**
 * @des    契约类 登录
 */
interface AdListContract {

    interface View : IBaseView {

        /**
         *
         */
        fun showAdListInfo(dataInfo: List<AdListEntity.ResultsBean>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         *
         */
        fun requestAdListInfo(types: String , pid : String)
    }

}