package com.guoxun.airbaba.ui.activity.mine

import android.content.Intent
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_wallet.*

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
        detail.setOnClickListener(this)
        withdrawal.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.detail ->{
                startActivity(Intent(this, WalletDetailActivity::class.java))
            }
            R.id.withdrawal ->{
                startActivity(Intent(this, WithdrawalActivity::class.java))

            }
        }
    }
    override fun initData() {
    }
}














