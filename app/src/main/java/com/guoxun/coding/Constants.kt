package com.guoxun.coding

import com.blankj.utilcode.util.SDCardUtils

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

        val REGEX4 ="^(.{6,12})$"
        /**
         * 文件共享
         */
        const val FILE_PROVIDER = "com.guoxun.coding.fileprovider"

        /**
         * 图片保存位置
         * TODO: 用的时候看下有没有这个目录
         * 判断目录是否存在，不存在则判断是否创建成功
         * FileUtils.createOrExistsDir(Constants.SAVE_REAL_PATH);
         */
        val SAVE_REAL_PATH = SDCardUtils.getSDCardPathByEnvironment() + "/coding"
        // sharedPrefrence
        const val SP_FILE_NAME = "coding.xml"
        const val SP_KEY_ID = "SP_KEY_ID"
    }
}