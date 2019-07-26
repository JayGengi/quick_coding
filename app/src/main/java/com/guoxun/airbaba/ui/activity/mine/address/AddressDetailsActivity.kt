package com.guoxun.airbaba.ui.activity.mine.address

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity

/**
  * @des    报修详情
  * @auther JayGengi
  * 2019/7/26  13:45
  * @email  jaygengiii@gmail.com
  */
class AddressDetailsActivity : BaseActivity(),View.OnClickListener{
    override fun layoutId(): Int {
        return R.layout.activity_my_address_details
    }

    override fun initView() {
//        val bundle = intent.extras
//        if(null != bundle) {
//            title = bundle.getInt("title")
//        }
        mTopBar.setTitle("收货地址")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        mTopBar.addRightTextButton("删除",R.id.right).setOnClickListener { finish() }
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
