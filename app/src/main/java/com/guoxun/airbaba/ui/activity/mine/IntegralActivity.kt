package com.guoxun.airbaba.ui.activity.mine

import android.content.Intent
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_integral.*

/**
  * 积分
  * @auther JayGengi
  * 2019/7/23  9:13
  * @email jaygengiii@gmail.com
  */
class IntegralActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_integral
    }

    override fun initView() {

        mTopBar.setTitle("积分")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        detail.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.detail ->{
                startActivity(Intent(this, WalletDetailActivity::class.java))
            }
//            R.id.real_name_lay ->{
//            }
        }
    }
    override fun initData() {
    }
}














