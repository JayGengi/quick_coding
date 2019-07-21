package com.guoxun.airbaba.ui.fragment.goods

import android.os.Bundle
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_goods_info.*

/**
  *   商品详情基本信息
  * @auther JayGengi
  * 2019/7/21  11:45
  * @email jaygengiii@gmail.com
  */
class GoodsInfoFragment : BaseFragment(), View.OnClickListener {

    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): GoodsInfoFragment {
            val fragment = GoodsInfoFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_goods_info

    override fun lazyLoad() {

    }
    override fun initView() {

//        ll_pull_up.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
//            R.id.ll_pull_up ->{
//                //上拉查看图文详情
//                sv_switch.smoothOpen(true)
//            }
        }
    }




}