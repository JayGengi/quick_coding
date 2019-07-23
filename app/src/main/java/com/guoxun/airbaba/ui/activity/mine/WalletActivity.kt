package com.guoxun.airbaba.ui.activity.mine

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity

/**
  * 钱包
  * @auther JayGengi
  * 2019/7/23  9:13
  * @email jaygengiii@gmail.com
  */
class WalletActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_wallet
    }

    override fun initView() {

        mTopBar.setTitle("钱包")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.phone_lay ->{
//                startActivity(Intent(this, PersonalDataActivity::class.java))
//            }
//            R.id.real_name_lay ->{
//            }
        }
    }
    override fun initData() {
    }
}














