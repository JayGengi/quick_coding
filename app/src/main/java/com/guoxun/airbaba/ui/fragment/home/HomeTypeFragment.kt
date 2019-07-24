package com.guoxun.airbaba.ui.fragment.home

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.ui.adapter.home.HomeMenuAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeTypeShopAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home_type.*
import kotlinx.android.synthetic.main.fragment_home_type.banner
import kotlinx.android.synthetic.main.fragment_home_type.recycler_shop
import java.util.ArrayList

/**
   * @description: android
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeTypeFragment : BaseFragment() {


    private var menuList = ArrayList<MenuEntity>()
    private var menu = MenuEntity()
    private val mAdapter by lazy { activity?.let { HomeMenuAdapter( menuList) } }

    private var shopList = ArrayList<String>()
    private val shopAdapter by lazy { activity?.let { HomeTypeShopAdapter( shopList) } }

    override fun getLayoutId(): Int = R.layout.fragment_home_type

    companion object {
        fun newInstance(key: String): HomeTypeFragment {
            val args = Bundle()
            args.putString("key", key)
            val fragment = HomeTypeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun lazyLoad() {
        loadData()
    }
    override fun initView() {

        recycler_menu.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,5)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }
        menuList.clear()
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


        //recycler_shop
        recycler_shop.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            //android自带分割线
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = shopAdapter
        }

        shopList.clear()
        shopList.add("休闲食品")
        shopList.add("粮油调味")
        shopList.add("酒水饮料")
        shopList.add("方便速食")
        shopList.add("糖果")
        shopAdapter?.setNewData(shopList)

        val baseList = ArrayList<String>()
        baseList.add("https://www.airbaba.cn/data/gallery_album/229/original_img/1556475130887604624.jpg")
        baseList.add("https://www.airbaba.cn/data/gallery_album/229/original_img/1556475159455662649.jpg")
        initBanner(baseList)
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
    private fun loadData(){

    }

}
