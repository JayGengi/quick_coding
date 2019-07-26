package com.guoxun.airbaba.ui.activity.mine

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_bingding_phone.*

/**
  * @des    一键登录
  * @auther JayGengi
  * @data   2019/7/26  16:20
  * @email  jaygengiii@gmail.com
  */
class AKeyLoginActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_a_key_login
    }

    override fun initView() {

        mTopBar.addLeftTextButton("取消",R.id.left).setOnClickListener { finish() }
        get_code.setOnClickListener(this)
        call_service.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.call_service ->{

            }
        }
    }
    override fun initData() {
    }
}














