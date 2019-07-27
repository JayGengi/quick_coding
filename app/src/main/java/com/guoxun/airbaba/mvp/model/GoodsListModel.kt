package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.mvp.model.bean.GoodsListEntity
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable


class GoodsListModel {

    /**
     * ****
     */
    fun getGoodsListInfo(keyword: String,shop_id: String,goods_cate: String,sort: String,page: Int)
            : Observable<GoodsListEntity> {
        return RetrofitManager.service.getGoodsListInfo(keyword, shop_id, goods_cate, sort, page)
                .compose(SchedulerUtils.ioToMain())
    }
}