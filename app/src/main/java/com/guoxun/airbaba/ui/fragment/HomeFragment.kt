package com.guoxun.airbaba.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.contract.CategoryContract
import com.guoxun.airbaba.mvp.model.bean.CategoryEntity
import com.guoxun.airbaba.mvp.presenter.CategoryPresenter
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.activity.home.HomeMessageActivity
import com.guoxun.airbaba.ui.activity.home.SearchActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.home.HomeIndexFragment
import com.guoxun.airbaba.ui.fragment.home.HomeTypeFragment
import com.guoxun.airbaba.utils.DensityUtil
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

/**
   * @description: 首页  Category
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeFragment : BaseFragment() ,CategoryContract.View, View.OnClickListener{

    private val mPresenter by lazy { CategoryPresenter() }
    init {
        mPresenter.attachView(this)
    }
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
        search_lay.setOnClickListener(this)
        message_lay.setOnClickListener(this)
    }
    private fun loadData(){
        mPresenter.requestCategoryInfo()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.search_lay ->{
                startActivity(Intent(activity, SearchActivity::class.java))
            }
            R.id.message_lay ->{
                startActivity(Intent(activity, HomeMessageActivity::class.java))
            }
        }
    }
    private fun setAdapter(dataInfo: List<CategoryEntity.ResultsBean>){
        fragments.add(HomeIndexFragment())
        titles.add("首页")
        for(item : CategoryEntity.ResultsBean in dataInfo.iterator()){
            fragments.add(HomeTypeFragment.newInstance(item.id))
            item.name?.let { titles.add(it) }
        }
        viewpager.adapter = HomePageAdapter(childFragmentManager).apply {
            setData(fragments,titles)
        }
        viewpager.offscreenPageLimit = 4

        sliding_tabs.setViewPager(viewpager)
        sliding_tabs.setLeftRightMargin(DensityUtil.dip2px(context, 120f))
    }
    override fun showCategoryInfo(dataInfo: List<CategoryEntity.ResultsBean>) {
        setAdapter(dataInfo)
    }

    override fun showError(msg: String, errorCode: Int) {
        showToast(msg)
    }
    /**
     * 显示 Loading
     */
    override fun showLoading() {
        mLayoutStatusView?.showLoading()
    }
    /**
     * 隐藏 Loading
     */
    override fun dismissLoading() {
        mLayoutStatusView?.dismissLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
