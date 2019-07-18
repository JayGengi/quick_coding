package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.contract.HomeContract
import com.guoxun.airbaba.mvp.model.bean.GirlsEntity
import com.guoxun.airbaba.mvp.model.bean.ToDayEntity
import com.guoxun.airbaba.ui.adapter.home.vlayout.HomeTopSearchAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

/**
   * @description: 首页
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeFragment : BaseFragment(), HomeContract.View {

    private var mAdapters: LinkedList<DelegateAdapter.Adapter<*>>? = null
    private var mDelegateAdapter: DelegateAdapter? = null
    private var homeTopSearchAdapter: HomeTopSearchAdapter? = null
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyLoad() {
        loadData()
    }
    override fun initView() {
        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = VirtualLayoutManager(context!!)
            mDelegateAdapter = DelegateAdapter(layoutManager as VirtualLayoutManager, false)
            adapter = mDelegateAdapter
            //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
            recycledViewPool = RecyclerView.RecycledViewPool()
            recycledViewPool.setMaxRecycledViews(0, 10)
        }

        mAdapters = LinkedList()
        initTopSearch()

        mDelegateAdapter!!.setAdapters(mAdapters)

    }
    private fun loadData(){

    }

    /**
     * @des    头部搜索栏
     * @auther JayGengi
     * @data 2019/7/18 14:24
     * @email JayGengi@163.com
     */
    private fun initTopSearch() {
        homeTopSearchAdapter = HomeTopSearchAdapter(
                LinearLayoutHelper() as LayoutHelper,
                R.layout.item_home_top_search,
                null)
        mAdapters!!.add(homeTopSearchAdapter!!)


    }
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
