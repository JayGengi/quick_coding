package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.SelectGoodsEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable


class SelectGoodsModel {

    /**
     * ****
     */
    fun getSelectGoodsInfo(): Observable<SelectGoodsEntity> {
        return RetrofitManager.service.selectGoodsInfo
                .compose(SchedulerUtils.ioToMain())
    }
}