package com.guoxun.airbaba.ui.activity.home.goods

import android.support.v4.app.Fragment
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.goods.GoodsCommentFragment
import com.guoxun.airbaba.ui.fragment.goods.GoodsDetailFragment
import com.guoxun.airbaba.ui.fragment.goods.GoodsInfoFragment
import kotlinx.android.synthetic.main.activity_free_design.*
import kotlinx.android.synthetic.main.activity_goods_details.*
import java.util.*

/**
  * 免费设计
  * @auther JayGengi
  * 2019/7/19 0019 上午 11:09
  * @email jaygengiii@gmail.com
  */
class GoodsDetailsActivity : BaseActivity(){

    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    override fun layoutId(): Int {
        return R.layout.activity_goods_details
    }

    override fun initView() {
        mLayoutStatusView = multipleStatusView

        fragments.add(GoodsInfoFragment())
        fragments.add(GoodsCommentFragment())
        fragments.add(GoodsDetailFragment())
        titles.add("商品")
        titles.add("评价")
        titles.add("详情")
        viewpager.adapter = HomePageAdapter(supportFragmentManager).apply {
            setData(fragments, titles)
        }
        viewpager.offscreenPageLimit = titles.size
        //底部横线与字体宽度一致
        sliding_tabs.setViewPager(viewpager)


    }

    override fun start() {
        initData()
    }
    override fun initData() {

    }
}
