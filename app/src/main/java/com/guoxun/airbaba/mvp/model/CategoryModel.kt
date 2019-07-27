package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.CategoryEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable


class CategoryModel {

    /**
     * ****
     */
    fun getCategoryInfo(): Observable<CategoryEntity> {
        return RetrofitManager.service.categoryInfo
                .compose(SchedulerUtils.ioToMain())
    }
}