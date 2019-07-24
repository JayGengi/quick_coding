package com.guoxun.airbaba.ui.activity.home

import android.content.Intent
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

/**
  * @des    签到
  * @auther JayGengi
  * 2019/7/24  17:16
  * @email  jaygengiii@gmail.com
  */
class SignInActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_sign_in
    }

    override fun initView() {

        mTopBar.setTitle("签到")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
//        detail.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.detail ->{
//            }
//            R.id.real_name_lay ->{
//            }
        }
    }
    override fun initData() {
    }
}














