package com.guoxun.airbaba.ui.activity.mine.order

import android.graphics.drawable.ColorDrawable
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
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
            openPop()
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
    /** 弹出底部对话框 */
    private fun openPop(){
        val popView : View = LayoutInflater . from (this).inflate(
                R.layout.window_order_screen, null)
        val rootView : LinearLayout = popView.findViewById (R.id.goods_screen) // 當前頁面的根佈局
        val reset : TextView = popView.findViewById (R.id.reset)
        val confirm : TextView = popView.findViewById (R.id.confirm)
        val popupWindow  = PopupWindow (popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setBackgroundAlpha(this, 0.5f)//设置屏幕透明度
        popupWindow.setBackgroundDrawable(ColorDrawable())
        popupWindow.isFocusable = true// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.END , 0,0)
        popupWindow.setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            setBackgroundAlpha(this, 1f)//设置屏幕透明度
        }
        reset.setOnClickListener {
            popupWindow.dismiss()
        }

        confirm.setOnClickListener {
            popupWindow.dismiss()
        }
    }
}
