package com.guoxun.airbaba.ui.activity.mine.account

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_real_name.*

/**
  * 实名认证
  * @auther JayGengi
  * 2019/7/23  9:49
  * @email jaygengiii@gmail.com
  */
class RealNameActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_real_name
    }

    override fun initView() {

        mTopBar.setTitle("实名认证")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }

//        get_code.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.phone_lay ->{
//                startActivity(Intent(this, PersonalDataActivity::class.java))
//            }
        }
    }
    override fun initData() {
    }

}














