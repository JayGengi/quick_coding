package com.guoxun.shanzuo.api;

import com.guoxun.shanzuo.net.BaseResponse;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface ApiService {

    /**
     *  图片上传
     */
    @Multipart
    @POST("uploadImg")
    Observable<BaseResponse<String>> uploadImg(@Part MultipartBody.Part maps);

    /**
     * 车型查询
     */
    @FormUrlEncoded
    @POST("vehicleTypeInquiry")
    Observable<BaseResponse<String>> vehicleTypeInquiry(@FieldMap Map<String, Object> map);
}