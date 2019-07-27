package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.NewRetailEntity
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * 首页-新零售特供商品列表
 * @auther JayGengi
 * 2019/7/27  21:55
 * @email jaygengiii@gmail.com
 */
class NewRetailModel {


    /**
     * 获取福利数据信息
     */
    fun getNewRetailInfo(page: Int): Observable<NewRetailEntity> {
        return RetrofitManager.service.getNewRetailInfo(page)
                .compose(SchedulerUtils.ioToMain())
    }
}