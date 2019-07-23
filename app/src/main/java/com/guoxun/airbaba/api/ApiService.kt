package com.guoxun.airbaba.api

import com.guoxun.airbaba.mvp.model.bean.ShopListEntity
import com.guoxun.airbaba.net.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
   *  Api 接口
   * @auther JayGengi
   * 2019/7/23  17:08
   * @email jaygengiii@gmail.com
   */

interface ApiService{

    /**
     * 首页-厂家直销（商铺列表）
     */
    @GET("Index/shopList")
    fun getShopListInfo(@Query("page")page:Int): Observable<ShopListEntity>

 }