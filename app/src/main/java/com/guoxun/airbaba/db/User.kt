package com.guoxun.airbaba.db

import org.litepal.crud.LitePalSupport

/**
 * 描述：用户表
 *
 * @author JayGengi
 * @date 2018/11/30
 */
class User : LitePalSupport(){

    var user_id: Int = 0
    var token: String? = null
    var username: String? = null
    var expired_date: String? = null//token过期日期
}
