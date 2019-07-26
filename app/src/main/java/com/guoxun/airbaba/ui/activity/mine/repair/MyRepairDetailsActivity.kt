package com.guoxun.airbaba.ui.activity.mine.repair

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity

/**
  * @des    报修详情
  * @auther JayGengi
  * 2019/7/26  13:45
  * @email  jaygengiii@gmail.com
  */
class MyRepairDetailsActivity : BaseActivity(),View.OnClickListener{
    override fun layoutId(): Int {
        return R.layout.activity_my_repair_details
    }

    override fun initView() {
//        val bundle = intent.extras
//        if(null != bundle) {
//            position = bundle.getInt("position")
//        }
        mTopBar.setTitle("报修详情")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
    }

    override fun start() {
        initData()
    }
    override fun initData() {

    }
    override fun onClick(v: View?) {
        when(v!!.id){
        }
    }
}
