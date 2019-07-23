package com.guoxun.airbaba.ui.activity.mine

import android.support.v4.app.Fragment
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.mine.WalletInComeFragment
import com.guoxun.airbaba.ui.fragment.mine.WalletSpendingFragment
import com.guoxun.airbaba.utils.DensityUtil
import kotlinx.android.synthetic.main.common_tab_viewpager.*

/**
  * 明细
  * @auther JayGengi
  * 2019/7/23  10:45
  * @email jaygengiii@gmail.com
  */

class WalletDetailActivity : BaseActivity() {
    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    override fun layoutId(): Int {
        return R.layout.common_tab_viewpager
    }

    override fun initView() {
        mTopBar.setTitle("明细")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }

        fragments.add(WalletInComeFragment())
        fragments.add(WalletSpendingFragment())
        titles.add("收入")
        titles.add("支出")
        viewpager.adapter = HomePageAdapter(supportFragmentManager).apply {
            setData(fragments,titles)
        }
        viewpager.offscreenPageLimit =titles.size
        sliding_tabs.apply {
            setLeftRightMargin(DensityUtil.dip2px(context, 80f))
            setViewPager(viewpager)
        }
    }

    override fun start() {

    }

    override fun initData() {
    }

}
