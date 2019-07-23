package com.guoxun.airbaba.ui.activity.mine.setting

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web_view.*

/**
  * 用户隐私政策
  * @auther JayGengi
  * 2019/7/23  9:49
  * @email jaygengiii@gmail.com
  */
class HelpDetailsActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_web_view
    }

    override fun initView() {

        val bundle = intent.extras
        val title = bundle.getString("title")
        mTopBar.setTitle(title)
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














