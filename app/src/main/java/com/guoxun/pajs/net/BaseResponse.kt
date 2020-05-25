package com.guoxun.pajs.net

/**
 * 封装返回的数据
 * @auther JayGengi
 * 2019/7/23  16:58
 * @email jaygengiii@gmail.com
 */
class BaseResponse<T>(val flag: Int, val msg: String,
                      val data: T)