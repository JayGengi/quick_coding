package com.guoxun.airbaba.ui.activity.home

import android.content.Intent
import android.view.View
import android.widget.Button
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import kotlinx.android.synthetic.main.activity_home_message.*

/**
  * 消息中心
  * @auther JayGengi
  * 2019/7/19 0019 上午 11:09
  * @email jaygengiii@gmail.com
  */
class HomeMessageActivity : BaseActivity(),View.OnClickListener{

    private var rightButton: Button? = null

    override fun layoutId(): Int {
        return R.layout.activity_home_message
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

        oreder_lay.setOnClickListener(this)
        repair_lay.setOnClickListener(this)
        asset_lay.setOnClickListener(this)
        activity_lay.setOnClickListener(this)
        system_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.oreder_lay ->{
                startActivity(Intent(this, MessageActivity::class.java))
            }
            R.id.repair_lay ->{
                startActivity(Intent(this, RepairMessageActivity::class.java))
            }
            R.id.asset_lay ->{
                startActivity(Intent(this, AssetMessageActivity::class.java))
            }
            R.id.activity_lay ->{
                startActivity(Intent(this, ActivityMessageActivity::class.java))
            }
            R.id.system_lay ->{
                startActivity(Intent(this, SystemNoticeActivity::class.java))
            }
        }
    }
    override fun initData() {
    }
}
