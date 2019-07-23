package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity

/**
  * 契约类 首页-厂家直销（商铺列表）
  * @auther JayGengi
  * 2019/7/23  16:55
  * @email jaygengiii@gmail.com
  */

interface ShopListContract {

    interface View : IBaseView {

        /**
         * 显示首页-厂家直销（商铺列表）
         */
        fun showShopListInfo(dataInfo: List<ShopListEntity.ResultsBean>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String,errorCode:Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页-厂家直销（商铺列表）
         */
        fun requestShopListInfo(page: Int)

    }


}