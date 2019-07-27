package com.guoxun.airbaba.mvp.model.bean

/**
 * 首页-新零售特供商品列表
 * @auther JayGengi
 * 2019/7/27  21:55
 * @email jaygengiii@gmail.com
 */
class NewRetailEntity {
    var flag: Int? = null
    var msg: String? = null
    var response: List<ResultsBean>? = null

    class ResultsBean {

        var id: Int? = null
        var name: String? = null
        var picture: String? = null
        var original_price: String? = null
        var first_price: String? = null
    }
}
