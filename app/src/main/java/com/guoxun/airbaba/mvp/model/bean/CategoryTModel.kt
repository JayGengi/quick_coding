package com.guoxun.airbaba.mvp.model.bean

class CategoryTEntity {
    /**
     * msg : 请求成功
     * flag : 200
     * response : {"ad":[{"id":3,"ad_url":"http://192.168.0.106:8106/Index/adInfo/id/3","title":"1111","picture":"/public/upload/ad/20190626/f77095fe84c6a567aa5349dbe8345aeb.jpg","picture_url":"http://192.168.0.106:8106/public/upload/ad/20190626/f77095fe84c6a567aa5349dbe8345aeb.jpg","types":2,"url":"","goodscate_level":1,"keyid":12},{"id":2,"ad_url":"http://192.168.0.106:8106/Index/adInfo/id/2","title":"1111","picture":"/public/upload/ad/20190626/e95b13a3aeefacd8c7e31a2da4045acc.png","picture_url":"http://192.168.0.106:8106/public/upload/ad/20190626/e95b13a3aeefacd8c7e31a2da4045acc.png","types":0,"url":"","goodscate_level":0,"keyid":0},{"id":1,"ad_url":"http://192.168.0.106:8106/Index/adInfo/id/1","title":"1111","picture":"/public/upload/ad/20190626/8d3bc12b264d62434a073e25048caf1f.jpg","picture_url":"http://192.168.0.106:8106/public/upload/ad/20190626/8d3bc12b264d62434a073e25048caf1f.jpg","types":0,"url":"","goodscate_level":0,"keyid":0}],"cates":[{"id":21,"name":"羽绒服","picture":"","picture_url":"http://192.168.0.106:8106","thirdcate":[{"id":23,"name":"长款羽绒服","picture":"/public/upload/goodscate/20171116/318c30bd17032d8deda6cd52b54080da.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/318c30bd17032d8deda6cd52b54080da.jpg"},{"id":24,"name":"短款羽绒服","picture":"/public/upload/goodscate/20171116/de854bdf6dfd1a26b1e0063e30bb44da.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/de854bdf6dfd1a26b1e0063e30bb44da.jpg"},{"id":25,"name":"轻薄羽绒服","picture":"/public/upload/goodscate/20171116/0320cfd19f8ee0c2cdb6a07992e14512.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/0320cfd19f8ee0c2cdb6a07992e14512.jpg"}]},{"id":22,"name":"牛仔裤","picture":"","picture_url":"http://192.168.0.106:8106","thirdcate":[{"id":26,"name":"加绒牛仔","picture":"/public/upload/goodscate/20171116/133bd96460da1306a7600184f95bedcb.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/133bd96460da1306a7600184f95bedcb.jpg"},{"id":27,"name":"修身牛仔","picture":"/public/upload/goodscate/20171116/24c09a2c720f24a1f7f6e0bbeb2b4890.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/24c09a2c720f24a1f7f6e0bbeb2b4890.jpg"}]}]}
     */

    var ad: List<AdBean>? = null
    var cates: List<CatesBean>? = null

    class AdBean {
        /**
         * id : 3
         * ad_url : http://192.168.0.106:8106/Index/adInfo/id/3
         * title : 1111
         * picture : /public/upload/ad/20190626/f77095fe84c6a567aa5349dbe8345aeb.jpg
         * picture_url : http://192.168.0.106:8106/public/upload/ad/20190626/f77095fe84c6a567aa5349dbe8345aeb.jpg
         * types : 2
         * url :
         * goodscate_level : 1
         * keyid : 12
         */

        var id: Int = 0
        var ad_url: String? = null
        var title: String? = null
        var picture: String? = null
        var picture_url: String? = null
        var types: Int = 0
        var url: String? = null
        var goodscate_level: Int = 0
        var keyid: Int = 0
    }

    class CatesBean {
        /**
         * id : 21
         * name : 羽绒服
         * picture :
         * picture_url : http://192.168.0.106:8106
         * thirdcate : [{"id":23,"name":"长款羽绒服","picture":"/public/upload/goodscate/20171116/318c30bd17032d8deda6cd52b54080da.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/318c30bd17032d8deda6cd52b54080da.jpg"},{"id":24,"name":"短款羽绒服","picture":"/public/upload/goodscate/20171116/de854bdf6dfd1a26b1e0063e30bb44da.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/de854bdf6dfd1a26b1e0063e30bb44da.jpg"},{"id":25,"name":"轻薄羽绒服","picture":"/public/upload/goodscate/20171116/0320cfd19f8ee0c2cdb6a07992e14512.jpg","picture_url":"http://192.168.0.106:8106/public/upload/goodscate/20171116/0320cfd19f8ee0c2cdb6a07992e14512.jpg"}]
         */

        var id: Int = 0
        var name: String? = null
        var picture: String? = null
        var picture_url: String? = null
        var thirdcate: List<ThirdcateBean>? = null

        class ThirdcateBean {
            /**
             * id : 23
             * name : 长款羽绒服
             * picture : /public/upload/goodscate/20171116/318c30bd17032d8deda6cd52b54080da.jpg
             * picture_url : http://192.168.0.106:8106/public/upload/goodscate/20171116/318c30bd17032d8deda6cd52b54080da.jpg
             */

            var id: Int = 0
            var name: String? = null
            var picture: String? = null
            var picture_url: String? = null
        }
    }
}
