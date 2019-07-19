package com.guoxun.airbaba.ui.activity.home

import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_free_design.*

/**
  * 免费设计
  * @auther JayGengi
  * 2019/7/19 0019 上午 11:09
  * @email jaygengiii@gmail.com
  */
class HomeFreeDesignActivity : BaseActivity(){

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
