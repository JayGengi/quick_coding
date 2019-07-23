package com.guoxun.airbaba.ui.activity.mine.setting

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity

/**
  *  昵称
  * @auther JayGengi
  * 2019/7/22  16:04
  * @email jaygengiii@gmail.com
  */
class ModifyInfoActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_modify_info
    }

    override fun initView() {
        mTopBar.setTitle("昵称")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        mTopBar.addRightTextButton("保存",R.id.right).setOnClickListener { finish() }
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.per_head_lay ->{
//            }
//            R.id.nike_lay ->{
//                startActivity(Intent(this, RepairMessageActivity::class.java))
//            }
        }
    }
    override fun initData() {
    }
}














