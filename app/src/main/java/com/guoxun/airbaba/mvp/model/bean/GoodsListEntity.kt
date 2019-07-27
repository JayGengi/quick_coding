package com.guoxun.airbaba.mvp.model.bean

class GoodsListEntity {
    var flag: Int? = null
    var msg: String? = null
    var response: List<ResultsBean>? = null

    class ResultsBean {

        var id: Int = 0
        var name: String? = null
        var subtitle:String? = null
        var original_price: String? = null
        var first_price: String? = null
        var picture: String? = null
        var volume: Int = 0
        var tags: String? = null
    }
}
