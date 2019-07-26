package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_common.*

/**
  * @des    首页免费设计
  * @auther JayGengi
  * 2019/7/26  11:48
  * @email  jaygengiii@gmail.com
  */
class FreeDesignFragment : BaseFragment() {


    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): FreeDesignFragment {
            val fragment = FreeDesignFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_free_design

    override fun initView() {
    }

    override fun lazyLoad() {

    }


}