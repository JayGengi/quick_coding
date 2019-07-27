package com.guoxun.airbaba.mvp.model.bean

class AdListEntity {
    var flag: Int? = null
    var msg: String? = null
    var response: List<ResultsBean>? = null

    class ResultsBean {

        var id: Int = 0
        var ad_url: String? = null//	广告详情页地址，当types==0跳转此地址
        var title: String? = null
        var picture: String? = null
        var picture_url: String? = null//广告图片（带连接）
        var types: Int = 0//广告类型
        var url: String? = null //	跳转地址，当types==1时跳转此地址
        var goodscate_level: Int = 0 //商品分类级别，总共三级
        var keyid: Int = 0 //相关主键id，types=2时，是商品分类id；types=3时，商品id；types=4时商铺shop_id
    }
}
