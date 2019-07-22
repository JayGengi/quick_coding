package com.guoxun.airbaba.ui.activity.mine

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_personal_data.*

/**
  *  个人资料
  * @auther JayGengi
  * 2019/7/22  16:04
  * @email jaygengiii@gmail.com
  */
class PersonalDataActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_personal_data
    }

    override fun initView() {
        mTopBar.setTitle("个人资料")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
//        oreder_lay.setOnClickListener(this)
//        repair_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.oreder_lay ->{
//                startActivity(Intent(this, MessageActivity::class.java))
//            }
//            R.id.repair_lay ->{
//                startActivity(Intent(this, RepairMessageActivity::class.java))
//            }
        }
    }
    override fun initData() {
    }
}














