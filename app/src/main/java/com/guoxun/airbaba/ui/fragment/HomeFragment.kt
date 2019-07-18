package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.home.HomeIndexFragment
import com.guoxun.airbaba.ui.fragment.home.HomeTypeFragment
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

/**
   * @description: 首页
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeFragment : BaseFragment() {


    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyLoad() {
        loadData()
    }
    override fun initView() {
        real_lib_lay.layoutParams.height = QMUIStatusBarHelper.getStatusbarHeight(context)
//        initTopSearch()
        fragments.add(HomeIndexFragment())
        fragments.add(HomeTypeFragment.newInstance("类型"))
        fragments.add(HomeTypeFragment.newInstance("类型"))
        fragments.add(HomeTypeFragment.newInstance("类型"))
        fragments.add(HomeTypeFragment.newInstance("类型"))
        fragments.add(HomeTypeFragment.newInstance("类型"))
        titles.add("首页")
        titles.add("类型1")
        titles.add("类型2")
        titles.add("类型3")
        titles.add("类型4")
        titles.add("类型5")
        viewpager.adapter = HomePageAdapter(childFragmentManager).apply {
            setData(fragments,titles)
        }
        viewpager.offscreenPageLimit = 4

        sliding_tabs.setViewPager(viewpager)
    }
    private fun loadData(){

    }

    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
//            fragment.mTitle = title
            return fragment
        }
    }

}
