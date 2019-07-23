package com.guoxun.airbaba.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.KeyEvent
import android.view.View
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.guoxun.airbaba.mvp.model.bean.TabEntity
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


 /**  
   * @description: 首页
   * @author JayGengi
   * @date  2019/7/17 0029 上午 11:57
   * @email jaygengiii@gmail.com
   */

class MainActivity : BaseActivity() {


    private val mTitles = arrayOf("首页", "报修管理","免费设计", "购物车",  "个人中心")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_repair_normal, R.mipmap.ic_freedesign_normal, R.mipmap.ic_shoppingcart_normal, R.mipmap.ic_my_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_repair_selected, R.mipmap.ic_freedesign_selected, R.mipmap.ic_shoppingcart_selected, R.mipmap.ic_my_selected)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null
     private var mRepairFragment: RepairFragment? = null
     private var mFreeDesignFragment: FreeDesignFragment? = null
     private var mShopCartFragment: ShopCartFragment? = null
//    private var mHotFragment: GankTypeFragment? = null
    private var mMineFragment: MineFragment? = null

    //默认为0
    private var mIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        //目的是为了透明状态栏 ps:QMUI适配的沉浸状态栏，问题根源在这套架构找不到，死办法解决
        mBaseLayout.visibility = View.GONE
        //首页侧滑关闭[false]
        setSwipeBackEnable(false)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)

    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }


    //初始化底部菜单
    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
        //为Tab赋值
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    /**
     * 切换Fragment
     * @param position 下标
     */
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 // 首页
            -> mHomeFragment?.let {
                transaction.show(it)
            } ?: HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container, it, "home")
            }
            1  //报修管理
            -> mRepairFragment?.let {
                transaction.show(it)
            } ?: RepairFragment.getInstance(mTitles[position]).let {
                mRepairFragment = it
                transaction.add(R.id.fl_container, it, "repair") }
            2  //免费设计
            -> mFreeDesignFragment?.let {
                transaction.show(it)
            } ?: FreeDesignFragment.getInstance(mTitles[position]).let {
                mFreeDesignFragment = it
                transaction.add(R.id.fl_container, it, "freeDesign") }
            3  //购物车
            -> mShopCartFragment?.let {
                transaction.show(it)
            } ?: ShopCartFragment.getInstance(mTitles[position]).let {
                mShopCartFragment = it
                transaction.add(R.id.fl_container, it, "shopCart") }
            4 //我的
            -> mMineFragment?.let {
                transaction.show(it)
            } ?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.fl_container, it, "mine") }

            else -> {

            }
        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }


    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mRepairFragment?.let { transaction.hide(it) }
        mFreeDesignFragment?.let { transaction.hide(it) }
        mShopCartFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }


    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
//        showToast("onSaveInstanceState->"+mIndex)
//        super.onSaveInstanceState(outState)
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun start() {

    }

    private var mExitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}
