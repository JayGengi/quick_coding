package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.db.User
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity

/**
  * @des    契约类 登录
  * @auther JayGengi
  * @data   2019/7/27  10:22
  * @email  jaygengiii@gmail.com
  */

interface SendLineContract {

    interface View : IBaseView {

        /**
         * 登录
         */
        fun showSendLineInfo(dataInfo: String)

        /**
         * 显示错误信息
         */
        fun showError(msg: String,errorCode:Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         * 登录
         */
        fun requestSendLineInfo(map: Map<String, Any>)

    }


}