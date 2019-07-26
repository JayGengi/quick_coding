package com.guoxun.airbaba.ui.activity.mine.repair

import android.support.v4.app.Fragment
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.mine.MyRepairFragment
import kotlinx.android.synthetic.main.common_tab_viewpager.*
import java.util.*

/**
  * @des    报修管理
  * @auther JayGengi
  * 2019/7/26  11:25
  * @email  jaygengiii@gmail.com
  */
class MyRepairActivity : BaseActivity(),View.OnClickListener{
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
        mTopBar.setTitle("报修管理")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        fragments.add(MyRepairFragment.setInstance(1))
        fragments.add(MyRepairFragment.setInstance(2))
        fragments.add(MyRepairFragment.setInstance(3))
        titles.add("未接单")
        titles.add("进行中")
        titles.add("已完成")
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
        }
    }
}
