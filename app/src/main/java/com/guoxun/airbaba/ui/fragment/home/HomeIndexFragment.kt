package com.guoxun.airbaba.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.ui.activity.home.DiscountsActActivity
import com.guoxun.airbaba.ui.activity.home.HomeFactoryOutletActivity
import com.guoxun.airbaba.ui.activity.home.HomeFreeDesignActivity
import com.guoxun.airbaba.ui.activity.home.HomeMenuMainActivity
import com.guoxun.airbaba.ui.adapter.home.HomeMenuAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeSelectAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeShopAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home_index.*
import java.util.*


/**
   * @description: 福利
   * @author JayGengi
   * @date  2018/11/15 0015 下午 4:59
   * @email jaygengiii@gmail.com
   */

class HomeIndexFragment : BaseFragment() {


    private var menuList = ArrayList<MenuEntity>()
    private var menu = MenuEntity()
    private val mAdapter by lazy { activity?.let { HomeMenuAdapter( menuList) } }

    private var selectList = ArrayList<MenuEntity>()
    private val selectAdapter by lazy { activity?.let { HomeSelectAdapter( selectList) } }

    private var shopList = ArrayList<String>()
    private val shopAdapter by lazy { activity?.let { HomeShopAdapter( shopList) } }

    override fun getLayoutId(): Int = R.layout.fragment_home_index

    override fun initView() {

        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,4)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }
        menuList.clear()
        menu = MenuEntity()
        menu.apply {
            name = "厂家直销"
            icon = R.mipmap.ic_manufacturer_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "新零售特供"
            icon = R.mipmap.ic_retail_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "免费设计"
            icon = R.mipmap.ic_couple_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "签到"
            icon = R.mipmap.ic_sign_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "空气商城"
            icon = R.mipmap.ic_airmall_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "我要报修"
            icon = R.mipmap.ic_repair_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "积分换购"
            icon = R.mipmap.icintegral_nor
        }
        menuList.add(menu)

        menu = MenuEntity()
        menu.apply {
            name = "优惠活动"
            icon = R.mipmap.ic_activity_nor
        }
        menuList.add(menu)
        mAdapter?.setNewData(menuList)

        mAdapter?.setOnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            when(position){
                //厂家直销
                0 ->{
                    startActivity(Intent(context, HomeFactoryOutletActivity::class.java))
                }
                //新零售特供
                1 ->{
                    bundle.putString("title","新零售特供")
                    startActivity(Intent(context, HomeMenuMainActivity::class.java).putExtras(bundle))
                }
                //免费设计
                2 ->{
                    startActivity(Intent(context, HomeFreeDesignActivity::class.java))
                }
                //签到
                3 ->{

                }
                //空气商城
                4 ->{

                }
                //我要报修
                5 ->{

                }
                //积分换购
                6 ->{
                    bundle.putString("title","积分换购")
                    startActivity(Intent(context, HomeMenuMainActivity::class.java).putExtras(bundle))
                }
                //优惠活动
                7 ->{
                    startActivity(Intent(context, DiscountsActActivity::class.java))
                }
            }
        }



        recycler_select.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,4)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = selectAdapter
        }
        selectList.clear()
        menu = MenuEntity()
        menu.apply {
            name = "棒棒糖"
            icon = R.mipmap.bangbangtang
        }
        selectList.add(menu)
        menu = MenuEntity()
        menu.apply {
            name = "棒棒糖"
            icon = R.mipmap.bangbangtang
        }
        selectList.add(menu)
        menu = MenuEntity()
        menu.apply {
            name = "棒棒糖"
            icon = R.mipmap.bangbangtang
        }
        selectList.add(menu)
        selectAdapter?.setNewData(selectList)


        recycler_shop.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = shopAdapter
        }
        shopList.clear()
        shopList.add("名称")
        shopList.add("名称")
        shopList.add("名称")
        shopList.add("名称")
        shopAdapter?.setNewData(shopList)
        val baseList = ArrayList<String>()
        baseList.add("https://gw.alicdn.com/tps/TB1W_X6OXXXXXcZXVXXXXXXXXXX-400-400.png")
        baseList.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg")
        initBanner(baseList)

        val base2List = ArrayList<String>()
        base2List.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg")
        initTwoBanner(base2List)
    }

    private fun initBanner(bannerList: List<String>) {
        banner.setOnBannerListener { position1 ->
            context?.let { ImagePreviewUtils.largerView(it, position1, bannerList) }
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        banner.setImageLoader(BannerImageLoader())
        //设置图片集合
        banner.setImages(bannerList)
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default)
        //设置自动轮播，默认为true
        banner.isAutoPlay(true)
        //设置轮播时间
        banner.setDelayTime(3000)
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER)
        //banner设置方法全部调用完毕时最后调用
        banner.start()

    }

    private fun initTwoBanner(bannerList: List<String>) {
        banner_two.setOnBannerListener { position1 ->
            context?.let { ImagePreviewUtils.largerView(it, position1, bannerList) }
        }
        banner_two.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        banner_two.setImageLoader(BannerImageLoader())
        //设置图片集合
        banner_two.setImages(bannerList)
        //设置banner动画效果
        banner_two.setBannerAnimation(Transformer.Default)
        //设置自动轮播，默认为true
        banner_two.isAutoPlay(true)
        //设置轮播时间
        banner_two.setDelayTime(3000)
        //设置指示器位置（当banner模式中有指示器时）
        banner_two.setIndicatorGravity(BannerConfig.CENTER)
        //banner设置方法全部调用完毕时最后调用
        banner_two.start()

    }
    override fun lazyLoad() {
        loadData()
    }
    private fun loadData(){

    }
}
