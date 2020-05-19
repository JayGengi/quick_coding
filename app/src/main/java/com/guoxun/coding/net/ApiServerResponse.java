package com.guoxun.coding.net;

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
