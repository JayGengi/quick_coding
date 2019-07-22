package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment

/**
 * Created by xuhao on 2017/11/9.
 * 我的
 */
class ShopCartFragment : BaseFragment() {


    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): ShopCartFragment {
            val fragment = ShopCartFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_shop_car

    override fun initView() {

    }

    override fun lazyLoad() {

    }





}