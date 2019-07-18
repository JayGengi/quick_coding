package com.guoxun.airbaba.mvp.contract

import com.guoxun.airbaba.base.IBaseView
import com.guoxun.airbaba.base.IPresenter
import com.guoxun.airbaba.mvp.model.bean.GirlsEntity
import com.guoxun.airbaba.mvp.model.bean.ToDayEntity

/**
 * @description: 契约类
 * @author JayGengi
 * @date  2018/11/13 0013 上午 10:35
 * @email jaygengiii@gmail.com
 */

interface HomeContract {

    interface View : IBaseView {
        /**
         * 显示福利轮播图
         */
        fun showGirlInfo(dataInfo: GirlsEntity)
        /**
         * 获取最新一天的干货
         */
        fun showToDayInfo(todayInfo: ToDayEntity)
        /**
         * 显示错误信息
         */
        fun showError(msg: String,errorCode:Int)

    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取福利轮播图
         */
        fun requestGirlInfo()
        /**
         * 获取最新一天的干货
         */
        fun requestToDayInfo()
    }


}