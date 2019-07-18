package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_common.*

/**
 * Created by xuhao on 2017/11/9.
 * 我的
 */
class RepairFragment : BaseFragment() {


    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): RepairFragment {
            val fragment = RepairFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_repair

    override fun initView() {
        content.text = mTitle
    }

    override fun lazyLoad() {

    }





}