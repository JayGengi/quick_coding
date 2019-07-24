package com.guoxun.airbaba.ui.activity.mine.order

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_order_details.*

/**
  * @des    我的订单详情
  * @auther JayGengi
  * 2019/7/24  9:03
  * @email  jaygengiii@gmail.com
  */
class MyOrderDetailsActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_my_order_details
    }

    override fun initView() {

        mTopBar.setTitle("订单详情")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
//        phone_lay.setOnClickListener(this)
//        real_name_lay.setOnClickListener(this)
//        push_lay.setOnClickListener(this)
//        user_agreement_lay.setOnClickListener(this)
//        privacy_policy_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.phone_lay ->{
//                startActivity(Intent(this, ModifyPhoneActivity::class.java))
//            }
        }
    }
    override fun initData() {
    }
}














