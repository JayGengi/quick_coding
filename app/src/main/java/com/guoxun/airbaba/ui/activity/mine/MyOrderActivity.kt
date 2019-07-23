package com.guoxun.airbaba.ui.activity.mine

import android.support.v4.app.Fragment
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.mine.CollectionGoodsFragment
import com.guoxun.airbaba.ui.fragment.mine.OrderFragment
import kotlinx.android.synthetic.main.common_tab_viewpager.*
import java.util.*

/**
  * 我的订单
  * @auther JayGengi
  * 2019/7/23  14:53
  * @email jaygengiii@gmail.com
  */
class MyOrderActivity : BaseActivity(),View.OnClickListener{
    private var position: Int = 0
    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    override fun layoutId(): Int {
        return R.layout.common_tab_viewpager
    }

    override fun initView() {
        val bundle = intent.extras
        if(null != bundle) {
            position = bundle.getInt("position")
        }
        mTopBar.setTitle("我的订单")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        mTopBar.addRightImageButton(R.mipmap.ic_search_black_nor,R.id.right).setOnClickListener {
            showToast("订单搜索")
        }
        fragments.add(OrderFragment.setInstance(1))
        fragments.add(OrderFragment.setInstance(2))
        fragments.add(OrderFragment.setInstance(3))
        fragments.add(OrderFragment.setInstance(4))
        fragments.add(OrderFragment.setInstance(5))
        fragments.add(OrderFragment.setInstance(6))
        titles.add("全部")
        titles.add("待付款")
        titles.add("待发货")
        titles.add("待收货")
        titles.add("待评价")
        titles.add("售后")
        viewpager.adapter = HomePageAdapter(supportFragmentManager).apply {
            setData(fragments, titles)
        }
        viewpager.offscreenPageLimit = titles.size
        sliding_tabs.setViewPager(viewpager)
    //根据选中的数据显示相对应的页面
        viewpager.currentItem = position
    }

    override fun start() {
        initData()
    }
    override fun initData() {

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ll_back ->{
                finish()
            }
        }
    }

}
