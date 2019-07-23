package com.guoxun.airbaba.ui.activity.mine.setting

import android.content.Intent
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
        per_head_lay.setOnClickListener(this)
        nike_lay.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.per_head_lay ->{
            }
            R.id.nike_lay ->{
                startActivity(Intent(this, ModifyInfoActivity::class.java))
            }
        }
    }
    override fun initData() {
    }
}














