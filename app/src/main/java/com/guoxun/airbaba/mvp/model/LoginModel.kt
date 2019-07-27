package com.guoxun.airbaba.mvp.model

import com.guoxun.airbaba.db.User
import com.guoxun.airbaba.net.BaseResponse
import com.guoxun.airbaba.net.RetrofitManager
import com.guoxun.airbaba.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
   * @description: 福利数据模型
   * @author JayGengi
   * @date  2018/11/13 0013 下午 3:35
   * @email jaygengiii@gmail.com
   */
class LoginModel {


    /**
     * 获取福利数据信息
     */
    fun getLoginInfo(map: Map<String, Any>): Observable<BaseResponse<User>> {
        return RetrofitManager.service.getLoginInfo(map)
                .compose(SchedulerUtils.ioToMain())
    }
}