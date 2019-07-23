package com.guoxun.airbaba.ui.activity.mine

import android.support.v4.app.Fragment
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.mine.CouponsFragment
import kotlinx.android.synthetic.main.common_tab_viewpager.*

/**
  * 优惠券
  * @auther JayGengi
  * 2019/7/23  10:45
  * @email jaygengiii@gmail.com
  */

class CouponsActivity : BaseActivity() {
    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    override fun layoutId(): Int {
        return R.layout.common_tab_viewpager
    }

    override fun initView() {
        mTopBar.setTitle("优惠券")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }

        fragments.add(CouponsFragment.setInstance(1))
        fragments.add(CouponsFragment.setInstance(2))
        fragments.add(CouponsFragment.setInstance(3))
        titles.add("未使用")
        titles.add("已使用")
        titles.add("已失效")
        viewpager.adapter = HomePageAdapter(supportFragmentManager).apply {
            setData(fragments,titles)
        }
        viewpager.offscreenPageLimit =titles.size
        sliding_tabs.apply {
//            setLeftRightMargin(DensityUtil.dip2px(context, 80f))
            setViewPager(viewpager)
        }
    }

    override fun start() {

    }

    override fun initData() {
    }

}
