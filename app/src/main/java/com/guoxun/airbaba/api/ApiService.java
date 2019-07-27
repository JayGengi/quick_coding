package com.guoxun.airbaba.api;

import com.guoxun.airbaba.db.User;
import com.guoxun.airbaba.mvp.model.bean.AdListEntity;
import com.guoxun.airbaba.mvp.model.bean.CategoryEntity;
import com.guoxun.airbaba.mvp.model.bean.CategoryTEntity;
import com.guoxun.airbaba.mvp.model.bean.GoodsListEntity;
import com.guoxun.airbaba.mvp.model.bean.NewRetailEntity;
import com.guoxun.airbaba.mvp.model.bean.SelectGoodsEntity;
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity;
import com.guoxun.airbaba.net.BaseResponse;
import com.guoxun.airbaba.ui.activity.mine.IntegralActivity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    /**
     *  首页-厂家直销（商铺列表）
     */
    @GET("Index/shopList")
    Observable<ShopListEntity> getShopListInfo(@Query("page") int page);

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("Login/login")
    Observable<BaseResponse<User>> getLoginInfo(@FieldMap Map<String, Object> map);

    /**
     * 发送验证码
     */
    @FormUrlEncoded
    @POST("Login/sendLine")
    Observable<BaseResponse<String>> getSendLineInfo(@FieldMap Map<String, Object> map);

    /**
     *  商品分类：第一级分类
     */
    @GET("Goods/categoryList")
    Observable<CategoryEntity> getCategoryInfo();

    /**
     *  广告列表
     */
    @GET("Index/adList")
    Observable<AdListEntity> getAdListInfo(@Query("types") String types,@Query("pid") String pid);

    /**
     *  首页商城优选商品（只有四个）
     */
    @GET("Goods/selectGoods")
    Observable<SelectGoodsEntity> getSelectGoodsInfo();

    /**
     *  商品列表
     */
    @GET("Goods/goodsList")
    Observable<GoodsListEntity> getGoodsListInfo(@Query("keyword") String keyword, @Query("shop_id") String shop_id,
                                                 @Query("goods_cate") String goods_cate,
                                                 @Query("sort") String sort, @Query("page") int page);


    /**
     *  商品分类：一级分类下二三级分类以及广告
     */
    @GET("Goods/categoryInfo")
    Observable<BaseResponse<CategoryTEntity>> getCategoryTInfo(@Query("pid") int pid);

    /**
     * 首页-新零售特供商品列表
     */
    @GET("Index/newRetailList")
    Observable<NewRetailEntity> getNewRetailInfo(@Query("page") int page);
}
