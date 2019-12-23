package com.guoxun.shanzuo.utils

import android.content.Context
import com.guoxun.shanzuo.Constants

/**
 * @des    用户信息私有构造函数
 * @auther JayGengi
 * @data   2019/8/2  14:44
 * @email  jaygengiii@gmail.com
 */
class UserSession private constructor() {

    companion object {
        val instance: UserSession by lazy { UserSession() }
    }
    /*用户id*/
    fun setUId(context: Context, u_id: String) {
        SharedPreferencesUtils.put(context, Constants.SP_KEY_ID, u_id)
    }

    fun getUId(context: Context): String {
        return SharedPreferencesUtils.get(context, Constants.SP_KEY_ID, "") as String
    }
}
