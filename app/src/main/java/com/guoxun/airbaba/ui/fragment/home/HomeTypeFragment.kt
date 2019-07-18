package com.guoxun.airbaba.ui.fragment.home

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.adapter.home.HomeMenuAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeTypeShopAdapter
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_home_type.*
import java.util.ArrayList

/**
   * @description: android
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeTypeFragment : BaseFragment() {


    private var menuList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { HomeMenuAdapter( menuList) } }

    private var shopList = ArrayList<String>()
    private val shopAdapter by lazy { activity?.let { HomeTypeShopAdapter( menuList) } }

    override fun getLayoutId(): Int = R.layout.fragment_home_type

    companion object {
        fun newInstance(key: String): HomeTypeFragment {
            val args = Bundle()
            args.putString("key", key)
            val fragment = HomeTypeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun lazyLoad() {
        loadData()
    }
    override fun initView() {

        recycler_menu.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,5)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }
        menuList.clear()
        menuList.add("休闲食品")
        menuList.add("粮油调味")
        menuList.add("酒水饮料")
        menuList.add("方便速食")
        menuList.add("糖果")
        mAdapter?.setNewData(menuList)


        //recycler_shop
        recycler_shop.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            //android自带分割线
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = shopAdapter
        }

        shopList.clear()
        shopList.add("休闲食品")
        shopList.add("粮油调味")
        shopList.add("酒水饮料")
        shopList.add("方便速食")
        shopList.add("糖果")
        shopAdapter?.setNewData(shopList)
    }
    private fun loadData(){

    }

}
