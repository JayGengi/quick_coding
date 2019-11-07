package com.guoxun.demo

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃   神兽保佑
//    ┃　　　┃   代码无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛
/**
 * Created by xuhao on 2017/11/27.
 * desc: 常量
 */
class Constants private constructor() {

    companion object {
        /**
         * ========================================
         * ********        状态请求码        ********
         * ========================================
         */
        val RESULT_CODE_1 = 101
        val RESULT_CODE_2 = 102
        val RESULT_CODE_3 = 103
        val RESULT_CODE_4 = 104

        /**
         * 文件共享
         */
        const val FILE_PROVIDER = "com.guoxun.easycheck.fileprovider"


        // sharedPrefrence
        const val SP_FILE_NAME = "easycheck.xml"
        const val SP_KEY_TOKEN = "SP_KEY_TOKEN"
        const val SP_KEY_IS_LOGIN = "SP_KEY_IS_LOGIN"
    }
}