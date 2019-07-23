package com.guoxun.airbaba.mvp.model.bean

/**
  * @des    首页-厂家直销（商铺列表） Entity
  * @auther JayGengi
  * 2019/7/23  17:20
  * @email  jaygengiii@gmail.com
  */
class ShopListEntity {
    var flag: Int? = null
    var msg: String? = null
    var response: List<ResultsBean>? = null

    class ResultsBean {

        var shop_id: Int? = null
            var shop_name: String? = null
            var picture: String? = null
            var is_self: Int? = null
            var goods_num: Int? = null
    }
}
