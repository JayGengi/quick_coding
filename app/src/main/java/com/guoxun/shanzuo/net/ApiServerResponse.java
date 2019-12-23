package com.guoxun.shanzuo.net;

import com.guoxun.shanzuo.utils.RxUtil;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ApiServerResponse {
    private static ApiServerResponse apiServerResponse;

    public static ApiServerResponse getInstence() {
        if (apiServerResponse == null) {
            synchronized (ApiServerResponse.class) {
                if (apiServerResponse == null)
                    apiServerResponse = new ApiServerResponse();
            }
        }
        return apiServerResponse;
    }
//    public void createQueryOrder(Map<String, Object> map, RetrofitObserver<BaseResponse<OrderEntity>> scheduler) {
//        RetrofitManager
//                .INSTANCE
//                .getService()
//                .CreateQueryOrder(map)
//                .compose(RxUtil.rxObservableSchedulerHelper())
//                .subscribe(scheduler);
//    }
}
