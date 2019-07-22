package com.guoxun.airbaba.ui.activity.mine

import android.content.Intent
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*

/**
  *   账户与安全
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
        data_lay.setOnClickListener(this)
//        repair_lay.setOnClickListener(this)
//        asset_lay.setOnClickListener(this)
//        activity_lay.setOnClickListener(this)
//        system_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.data_lay ->{
                startActivity(Intent(this, PersonalDataActivity::class.java))
            }
//            R.id.repair_lay ->{
//                startActivity(Intent(this, RepairMessageActivity::class.java))
//            }
//            R.id.asset_lay ->{
//                startActivity(Intent(this, AssetMessageActivity::class.java))
//            }
//            R.id.activity_lay ->{
//                startActivity(Intent(this, ActivityMessageActivity::class.java))
//            }
//            R.id.system_lay ->{
//                startActivity(Intent(this, SystemNoticeActivity::class.java))
//            }
        }
    }
    override fun initData() {
    }
}














