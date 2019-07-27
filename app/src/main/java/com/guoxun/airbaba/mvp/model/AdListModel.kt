package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.AdListEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable


class AdListModel {

    /**
     * ****
     */
    fun getAdListInfo(types: String , pid : String): Observable<AdListEntity> {
        return RetrofitManager.service.getAdListInfo(types,pid)
                .compose(SchedulerUtils.ioToMain())
    }
}