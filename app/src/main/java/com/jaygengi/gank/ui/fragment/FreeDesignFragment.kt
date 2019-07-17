package com.jaygengi.gank.ui.fragment

import android.os.Bundle
import com.jaygengi.gank.R
import com.jaygengi.gank.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by xuhao on 2017/11/9.
 * 我的
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
    override fun getLayoutId(): Int= R.layout.fragment_home

    override fun initView() {
        content.text = mTitle
    }

    override fun lazyLoad() {

    }


}