package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.mine.MyRepairGuyFragment
import kotlinx.android.synthetic.main.fragment_repair_guy.*
import java.util.*

/**
  * @des    维修工首页
  * @auther JayGengi
  * 2019/7/26  11:48
  * @email  jaygengiii@gmail.com
  */
class RepairGuyFragment : BaseFragment() {

    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): RepairGuyFragment {
            val fragment = RepairGuyFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_repair_guy

    override fun initView() {
        fragments.add(MyRepairGuyFragment.setInstance(1))
        fragments.add(MyRepairGuyFragment.setInstance(2))
        fragments.add(MyRepairGuyFragment.setInstance(3))
        titles.add("待抢单")
        titles.add("进行中")
        titles.add("已完成")
        viewpager.adapter = HomePageAdapter(childFragmentManager).apply {
            setData(fragments, titles)
        }
        viewpager.offscreenPageLimit = titles.size
        sliding_tabs.setViewPager(viewpager)
        //根据选中的数据显示相对应的页面
//        viewpager.currentItem = position

//        hos.setOnClickListener {
//            startActivity(Intent(context, MyRepairActivity::class.java))
//        }
    }

    override fun lazyLoad() {

    }


}