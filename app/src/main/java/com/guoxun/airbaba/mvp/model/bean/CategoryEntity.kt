package com.guoxun.airbaba.mvp.model.bean

class CategoryEntity {

    var flag: Int? = null
    var msg: String? = null
    var response: List<ResultsBean>? = null

    class ResultsBean {

        var id: Int = 0
        var name: String? = null
    }
}
