package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.CategoryTEntity

/**
 * @des    契约类 登录
 */
interface CategoryTContract {

    interface View : IBaseView {

        /**
         *
         */
        fun showCategoryTInfo(dataInfo: CategoryTEntity)

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         *
         */
        fun requestCategoryTInfo(pid: Int)
    }

}