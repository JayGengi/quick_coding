package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.ShopListEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
   * @description: 福利数据模型
   * @author JayGengi
   * @date  2018/11/13 0013 下午 3:35
   * @email jaygengiii@gmail.com
   */
class ShopListModel {


    /**
     * 获取福利数据信息
     */
    fun getShopListInfo(page: Int): Observable<ShopListEntity> {
        return RetrofitManager.service.getShopListInfo(page)
                .compose(SchedulerUtils.ioToMain())
    }
}