package com.guoxun.airbaba.ui.fragment.home

import android.support.v7.widget.GridLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.adapter.home.HomeMenuAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeSelectAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeShopAdapter
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_home_index.*
import java.util.ArrayList


/**
   * @description: 福利
   * @author JayGengi
   * @date  2018/11/15 0015 下午 4:59
   * @email jaygengiii@gmail.com
   */

class HomeIndexFragment : BaseFragment() {


    private var menuList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { HomeMenuAdapter( menuList) } }

    private var selectList = ArrayList<String>()
    private val selectAdapter by lazy { activity?.let { HomeSelectAdapter( selectList) } }

    private var shopList = ArrayList<String>()
    private val shopAdapter by lazy { activity?.let { HomeShopAdapter( shopList) } }

    override fun getLayoutId(): Int = R.layout.fragment_home_index

    override fun initView() {

        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,4)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }
        menuList.clear()
        menuList.add("厂家直销")
        menuList.add("新零售特供")
        menuList.add("免费设计")
        menuList.add("签到")
        menuList.add("空气商城")
        menuList.add("我要报修")
        menuList.add("积分换购")
        menuList.add("优惠活动")
        mAdapter?.setNewData(menuList)



        recycler_select.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,4)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = selectAdapter
        }
        selectList.clear()
        selectList.add("名称")
        selectList.add("名称")
        selectList.add("名称")
        selectList.add("名称")
        selectAdapter?.setNewData(selectList)


        recycler_shop.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = shopAdapter
        }
        shopList.clear()
        shopList.add("名称")
        shopList.add("名称")
        shopList.add("名称")
        shopList.add("名称")
        shopAdapter?.setNewData(shopList)
    }

    override fun lazyLoad() {
        loadData()
    }
    private fun loadData(){

    }
}
