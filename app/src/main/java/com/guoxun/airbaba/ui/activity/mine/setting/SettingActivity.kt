package com.guoxun.airbaba.ui.activity.mine.setting

import android.content.Intent
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.activity.mine.account.AccountActivity
import kotlinx.android.synthetic.main.activity_setting.*

/**
  *   设置
  * @auther JayGengi
  * 2019/7/22  16:04
  * @email jaygengiii@gmail.com
  */
class SettingActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initView() {
        mLayoutStatusView = multipleStatusView
        mTopBar.setTitle("设置")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        data_lay.setOnClickListener(this)
        account_lay.setOnClickListener(this)
//        asset_lay.setOnClickListener(this)
//        activity_lay.setOnClickListener(this)
//        system_lay.setOnClickListener(this)
        about_us_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.data_lay ->{
                startActivity(Intent(this, PersonalDataActivity::class.java))
            }
            R.id.account_lay ->{
                startActivity(Intent(this, AccountActivity::class.java))
            }
//            R.id.asset_lay ->{
//                startActivity(Intent(this, AssetMessageActivity::class.java))
//            }
//            R.id.activity_lay ->{
//                startActivity(Intent(this, ActivityMessageActivity::class.java))
//            }
//            R.id.system_lay ->{
//                startActivity(Intent(this, SystemNoticeActivity::class.java))
//            }
            R.id.about_us_lay ->{
                startActivity(Intent(this, AboutUsActivity::class.java))
            }
        }
    }
    override fun initData() {
    }
}














