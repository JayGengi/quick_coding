package com.guoxun.airbaba.ui.fragment.goods

import android.os.Bundle
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_goods_commont_list.*

/**
 * Created by xuhao on 2017/11/9.
 * 我的
 */
class GoodsDetailFragment : BaseFragment() {


    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): GoodsDetailFragment {
            val fragment = GoodsDetailFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_goods_details

    override fun initView() {

    }

    override fun lazyLoad() {

    }


}