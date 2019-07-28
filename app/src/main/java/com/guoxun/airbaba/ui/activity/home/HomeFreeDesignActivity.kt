package com.guoxun.airbaba.ui.activity.home

import android.content.Context
import android.content.Intent
import com.guoxun.airbaba.R
import com.guoxun.airbaba.aspectj.annotation.NeedLogin
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.activity.LoginActivity
import com.guoxun.airbaba.ui.activity.MainActivity
import kotlinx.android.synthetic.main.activity_free_design.*

/**
  * 免费设计
  * @auther JayGengi
  * 2019/7/19 0019 上午 11:09
  * @email jaygengiii@gmail.com
  */
class HomeFreeDesignActivity : BaseActivity(){

    companion object {
        @NeedLogin(tipType = NeedLogin.SHOW_DIALOG, loginActivity = LoginActivity::class)
        fun startNoDialog(context: Context) {
            val intent = Intent(context, HomeFreeDesignActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_free_design
    }

    override fun initView() {
        mTopBar.setTitle("免费设计")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        mLayoutStatusView = multipleStatusView

    }


    override fun start() {
        initData()
    }

    override fun initData() {
    }
}
