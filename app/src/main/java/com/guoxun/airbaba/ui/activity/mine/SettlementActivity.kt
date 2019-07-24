package com.guoxun.airbaba.ui.activity.mine

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_order_details.*

/**
  * @des    结算
  * @auther JayGengi
  * 2019/7/24  16:22
  * @email  jaygengiii@gmail.com
  */
class SettlementActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_settlement
    }

    override fun initView() {

        mTopBar.setTitle("结算")
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














