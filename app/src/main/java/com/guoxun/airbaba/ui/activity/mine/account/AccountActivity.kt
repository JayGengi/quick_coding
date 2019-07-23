package com.guoxun.airbaba.ui.activity.mine.account

import android.content.Intent
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_account.*

/**
  * 账户与安全
  * @auther JayGengi
  * 2019/7/22  17:23
  * @email jaygengiii@gmail.com
  */
class AccountActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_account
    }

    override fun initView() {

        mTopBar.setTitle("账户与安全")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        phone_lay.setOnClickListener(this)
        real_name_lay.setOnClickListener(this)
        push_lay.setOnClickListener(this)
        user_agreement_lay.setOnClickListener(this)
        privacy_policy_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.phone_lay ->{
                startActivity(Intent(this, ModifyPhoneActivity::class.java))
            }
            R.id.real_name_lay ->{
                startActivity(Intent(this, RealNameActivity::class.java))
            }
            R.id.push_lay ->{
                startActivity(Intent(this, BankCardActivity::class.java))
            }
            R.id.user_agreement_lay ->{
                startActivity(Intent(this, UserAgreementActivity::class.java))
            }
            R.id.privacy_policy_lay ->{
                startActivity(Intent(this, UserPrivacyPolicyActivity::class.java))
            }
        }
    }
    override fun initData() {
    }
}














