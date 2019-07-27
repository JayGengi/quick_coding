package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.CategoryTEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable


class CategoryTModel {

    /**
     * ****
     */
    fun getCategoryTInfo(pid: Int): Observable<BaseResponse<CategoryTEntity>> {
        return RetrofitManager.service.getCategoryTInfo(pid)
                .compose(SchedulerUtils.ioToMain())
    }
}