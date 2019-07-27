package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.NewRetailEntity

/**
  * 契约类 首页-新零售特供商品列表
  * @auther JayGengi
  * 2019/7/27  21:55
  * @email jaygengiii@gmail.com
  */

interface NewRetailContract {

    interface View : IBaseView {

        /**
         * 显示首页-厂家直销（商铺列表）
         */
        fun showNewRetailInfo(dataInfo: List<NewRetailEntity.ResultsBean>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String,errorCode:Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页-厂家直销（商铺列表）
         */
        fun requestNewRetailInfo(page: Int)

    }


}