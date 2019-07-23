package com.guoxun.airbaba.ui.activity.mine.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about_us.*

/**
  * 关于我们
  * @auther JayGengi
  * 2019/7/22  17:23
  * @email jaygengiii@gmail.com
  */
class AboutUsActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_about_us
    }

    override fun initView() {

        mTopBar.setTitle("关于我们")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        help1_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        val bun = Bundle()

        when(v.id){
            R.id.help1_lay ->{
                bun.putString("title","帮助列表")
                startActivity(Intent(this, HelpListActivity::class.java).putExtras(bun))
            }
        }
    }
    override fun initData() {
    }
}














