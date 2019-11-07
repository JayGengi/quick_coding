package com.guoxun.demo.ui.fragment.mine

import android.os.Bundle
import android.view.View
import com.guoxun.demo.R
import com.guoxun.demo.base.BaseFragment

/**
  *   个人中心
  * @auther JayGengi
  * 2019/7/22  14:26
  * @email jaygengiii@gmail.com
  */
class MineFragment : BaseFragment(), View.OnClickListener {

    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }

    }

    override fun getLayoutId(): Int= R.layout.fragment_mine

    override fun initView() {

    }

    override fun lazyLoad() {

    }

    override fun onClick(v: View?) {
        val bundle = Bundle()
    }



}