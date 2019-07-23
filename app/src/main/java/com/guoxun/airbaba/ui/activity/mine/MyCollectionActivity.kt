package com.guoxun.airbaba.ui.activity.mine

import android.support.v4.app.Fragment
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.mine.CollectionGoodsFragment
import com.guoxun.airbaba.ui.fragment.mine.CollectionMerchantsFragment
import kotlinx.android.synthetic.main.activity_my_collection.*
import java.util.*

/**
  * 我的收藏
  * @auther JayGengi
  * 2019/7/23  14:05
  * @email jaygengiii@gmail.com
  */
class MyCollectionActivity : BaseActivity(),View.OnClickListener{

    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    override fun layoutId(): Int {
        return R.layout.activity_my_collection
    }

    override fun initView() {
        fragments.add(CollectionGoodsFragment())
        fragments.add(CollectionMerchantsFragment())
        titles.add("商品")
        titles.add("店铺")
        viewpager.adapter = HomePageAdapter(supportFragmentManager).apply {
            setData(fragments, titles)
        }
        viewpager.offscreenPageLimit = titles.size
        //底部横线与字体宽度一致
        sliding_tabs.setViewPager(viewpager)

        ll_back.setOnClickListener(this)
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
