package com.guoxun.airbaba.ui.activity.home

import android.widget.Button
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.activity_message.multipleStatusView
import kotlinx.android.synthetic.main.fragment_repair.*

/**
  * 消息中心
  * @auther JayGengi
  * 2019/7/19 0019 上午 11:09
  * @email jaygengiii@gmail.com
  */
class HomeMessageActivity : BaseActivity(){

    private var rightButton: Button? = null

    override fun layoutId(): Int {
        return R.layout.activity_message
    }

    override fun initView() {
        mTopBar.setTitle("消息中心")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        rightButton = mTopBar.addRightTextButton("一键阅读",R.id.right)
        rightButton?.apply {
            setTextColor(R.drawable.common_btn_angle)
            setOnClickListener { showToast("一键阅读")  }
        }
        mLayoutStatusView = multipleStatusView

    }


    override fun start() {
        initData()
    }

    override fun initData() {
    }
}
