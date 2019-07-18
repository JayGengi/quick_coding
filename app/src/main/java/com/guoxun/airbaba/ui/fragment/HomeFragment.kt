package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.contract.HomeContract
import com.guoxun.airbaba.mvp.model.bean.GirlsEntity
import com.guoxun.airbaba.mvp.model.bean.ToDayEntity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.home.CategoryFragment
import com.guoxun.airbaba.ui.fragment.home.HomeIndexFragment
import kotlinx.android.synthetic.main.fragment_home.sliding_tabs
import kotlinx.android.synthetic.main.fragment_home.viewpager
import java.util.*

/**
   * @description: 首页
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeFragment : BaseFragment(), HomeContract.View {


    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyLoad() {
        loadData()
    }
    override fun initView() {
//        initTopSearch()
        fragments.add(HomeIndexFragment())
        fragments.add(CategoryFragment.newInstance("Android"))
        fragments.add(CategoryFragment.newInstance("App"))
        fragments.add(CategoryFragment.newInstance("iOS"))
        fragments.add(CategoryFragment.newInstance("休息视频"))
        fragments.add(CategoryFragment.newInstance("前端"))
        titles.add("首页")
        titles.add("Android")
        titles.add("App")
        titles.add("iOS")
        titles.add("休息视频")
        titles.add("前端")
        viewpager.adapter = HomePageAdapter(childFragmentManager).apply {
            setData(fragments,titles)
        }
        viewpager.offscreenPageLimit = 4

        sliding_tabs.setViewPager(viewpager)
    }
    private fun loadData(){

    }

    /**
     * @des    头部搜索栏
     * @auther JayGengi
     * @data 2019/7/18 14:24
     * @email JayGengi@163.com
     */
//    private fun initTopSearch() {
//        homeTopSearchAdapter = HomeTopSearchAdapter(
//                LinearLayoutHelper() as LayoutHelper,
//                R.layout.item_home_top_search,
//                null)
//        mAdapters!!.add(homeTopSearchAdapter!!)
//
//
//    }
    override fun showGirlInfo(dataInfo: GirlsEntity) {
    }
    override fun showToDayInfo(todayInfo: ToDayEntity) {
    }


    override fun showError(msg: String, errorCode: Int) {
//        if (errorCode == ErrorStatus.NETWORK_ERROR) {
//            multipleStatusView?.showNoNetwork()
//
//        } else {
//            multipleStatusView?.showError()
//        }
    }
    /**
     * 显示 Loading （下拉刷新的时候不需要显示 Loading）
     */
    override fun showLoading() {
        mLayoutStatusView?.showLoading()
    }
    /**
     * 隐藏 Loading
     */
    override fun dismissLoading() {
//        multipleStatusView?.showContent()
//        if(mRefreshLayout!=null && mRefreshLayout.isLoading){
//            mRefreshLayout.finishRefresh()
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        mPresenter.detachView()
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
