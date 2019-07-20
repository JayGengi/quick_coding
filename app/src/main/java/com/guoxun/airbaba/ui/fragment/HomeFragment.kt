package com.guoxun.airbaba.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.activity.home.HomeMessageActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.home.HomeIndexFragment
import com.guoxun.airbaba.ui.fragment.home.HomeTypeFragment
import com.guoxun.airbaba.utils.DensityUtil
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

/**
   * @description: 首页
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeFragment : BaseFragment() , View.OnClickListener{

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getLayoutId(): Int = R.layout.fragment_home

    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
//            fragment.mTitle = title
            return fragment
        }
    }

    override fun lazyLoad() {
        loadData()
    }
    override fun initView() {
        real_lib_lay.layoutParams.height = QMUIStatusBarHelper.getStatusbarHeight(context)
//        initTopSearch()
        fragments.add(HomeIndexFragment())
        fragments.add(HomeTypeFragment.newInstance("空气能家用"))
        fragments.add(HomeTypeFragment.newInstance("空气能商用"))
        fragments.add(HomeTypeFragment.newInstance("环保"))
        fragments.add(HomeTypeFragment.newInstance("空气能特供"))
        fragments.add(HomeTypeFragment.newInstance("配件"))
        fragments.add(HomeTypeFragment.newInstance("空气动力"))
        fragments.add(HomeTypeFragment.newInstance("工具"))
        fragments.add(HomeTypeFragment.newInstance("手机数码"))
        titles.add("首页")
        titles.add("空气能家用")
        titles.add("空气能商用")
        titles.add("环保")
        titles.add("空气能特供")
        titles.add("配件")
        titles.add("空气动力")
        titles.add("工具")
        titles.add("手机数码")
        viewpager.adapter = HomePageAdapter(childFragmentManager).apply {
            setData(fragments,titles)
        }
        viewpager.offscreenPageLimit = 4

        sliding_tabs.setViewPager(viewpager)
        sliding_tabs.setLeftRightMargin(DensityUtil.dip2px(context, 120f))
        message_lay.setOnClickListener(this)
    }
    private fun loadData(){

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.message_lay ->{
                startActivity(Intent(activity, HomeMessageActivity::class.java))
            }
        }
    }
}
