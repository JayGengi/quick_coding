package com.guoxun.airbaba.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.guoxun.airbaba.Constants
import com.guoxun.airbaba.MyApplication
import com.guoxun.airbaba.R
import com.guoxun.airbaba.aspectj.AopUtil
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.contract.AdListContract
import com.guoxun.airbaba.mvp.contract.GoodsListContract
import com.guoxun.airbaba.mvp.contract.SelectGoodsContract
import com.guoxun.airbaba.mvp.model.bean.AdListEntity
import com.guoxun.airbaba.mvp.model.bean.GoodsListEntity
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.mvp.model.bean.SelectGoodsEntity
import com.guoxun.airbaba.mvp.presenter.AdListPresenter
import com.guoxun.airbaba.mvp.presenter.GoodsListPresenter
import com.guoxun.airbaba.mvp.presenter.SelectGoodsPresenter
import com.guoxun.airbaba.ui.activity.home.*
import com.guoxun.airbaba.ui.activity.home.goods.GoodsDetailsActivity
import com.guoxun.airbaba.ui.activity.home.goods.GoodsTypeActivity
import com.guoxun.airbaba.ui.adapter.home.HomeMenuAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeSelectAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeShopAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.SharedPreferencesUtils
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home_index.*
import java.util.*


/**
  * @des    首页 AdList  SelectGoods GoodsList
  * @auther JayGengi
  * @data   2019/7/27  14:35
  * @email  jaygengiii@gmail.com
  */

class HomeIndexFragment : BaseFragment() , AdListContract.View
                    ,SelectGoodsContract.View
                    , GoodsListContract.View{

    private var menuList = ArrayList<MenuEntity>()
    private var menu = MenuEntity()
    private val mAdapter by lazy { activity?.let { HomeMenuAdapter( menuList) } }

    private var selectList = ArrayList<SelectGoodsEntity.ResultsBean>()
    private val selectAdapter by lazy { activity?.let { HomeSelectAdapter( selectList) } }

    private var shopList = ArrayList<GoodsListEntity.ResultsBean>()
    private val shopAdapter by lazy { activity?.let { HomeShopAdapter( shopList) } }

    private val mPresenter by lazy { AdListPresenter() }
    private val mSelectGoodsPresenter by lazy { SelectGoodsPresenter() }
    private val mGoodsListPresenter by lazy { GoodsListPresenter() }
    init {
        mPresenter.attachView(this)
        mSelectGoodsPresenter.attachView(this)
        mGoodsListPresenter.attachView(this)
    }
    override fun getLayoutId(): Int = R.layout.fragment_home_index


    override fun lazyLoad() {
        loadData()
    }
    private fun loadData(){
        //类型 1根据广告位置 2根据商品分类
        // types ==1时广告位置id，首页轮播，请传入1。types==2时传递商品一级分类
        mPresenter.requestAdListInfo("1","1")
        //首页商城优选商品（只有四个）
        mSelectGoodsPresenter.requestSelectGoodsInfo()
        mGoodsListPresenter.requestGoodsListInfo("","","","",CURRENT_PAGE)
    }

    override fun initView() {

        refreshLayout.setOnRefreshListener {
            CURRENT_PAGE =1
            loadData()
        }
//        refreshLayout.setOnLoadMoreListener {
//            CURRENT_PAGE++
//            loadData()
//        }

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
//                    startActivity(Intent(context, LoginActivity::class.java))
                    startActivity(Intent(context, HomeFactoryOutletActivity::class.java))
                }
                //新零售特供
                1 ->{
                    bundle.putString("title","新零售特供")
                    startActivity(Intent(context, HomeMenuMainActivity::class.java).putExtras(bundle))
                }
                //免费设计
                2 ->{
//                    startActivity(Intent(context, HomeFreeDesignActivity::class.java))
                    AopUtil.getInstance().isLogin = SharedPreferencesUtils.get(context,Constants.SP_KEY_IS_LOGIN, false) as Boolean
                    context?.let { HomeFreeDesignActivity.startNoDialog(it) }
                }
                //签到
                3 ->{
                    startActivity(Intent(context, SignInActivity::class.java))
                }
                //空气商城
                4 ->{
                    startActivity(Intent(context, GoodsTypeActivity::class.java))
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
                    bundle.putString("title","优惠活动")
                    startActivity(Intent(context, DiscountsActActivity::class.java).putExtras(bundle))
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
        selectAdapter!!.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(context, GoodsDetailsActivity::class.java))
        }

        recycler_shop.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = shopAdapter
        }
        shopAdapter!!.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(context, GoodsDetailsActivity::class.java))
        }
        val base2List = ArrayList<String>()
        base2List.add("https://www.airbaba.cn/data/gallery_album/229/original_img/1556475130887604624.jpg")
        base2List.add("https://www.airbaba.cn/data/gallery_album/229/original_img/1556475159455662649.jpg")
        initTwoBanner(base2List)
    }

    private fun initBanner(dataInfo: List<AdListEntity.ResultsBean>) {
        val bannerList = ArrayList<String>()
        for(item : AdListEntity.ResultsBean in dataInfo.iterator()){
            item.picture?.let { bannerList.add(it) }
        }
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

    override fun showAdListInfo(dataInfo: List<AdListEntity.ResultsBean>) {
        initBanner(dataInfo)
    }
    override fun showSelectGoodsInfo(dataInfo: List<SelectGoodsEntity.ResultsBean>) {
        selectAdapter?.setNewData(dataInfo)
    }

    override fun showGoodsListInfo(dataInfo: List<GoodsListEntity.ResultsBean>) {
        shopAdapter?.run {
            if ((dataInfo.isNotEmpty()) || CURRENT_PAGE>1) {
                if (CURRENT_PAGE == 1) {
                    shopList.clear()
                }
                shopList.addAll(dataInfo)
                setNewData(shopList)
            }
        }
    }
    override fun showError(msg: String, errorCode: Int) {
//        showToast(msg)
    }
    /**
     * 显示 Loading
     */
    override fun showLoading() {
        mLayoutStatusView?.showLoading()
    }
    /**
     * 隐藏 Loading
     */
    override fun dismissLoading() {
        if(refreshLayout!=null && refreshLayout.isRefreshing){
            refreshLayout.finishRefresh()
        }
        if(refreshLayout!=null && refreshLayout.isLoading){
            refreshLayout.finishLoadMore()
        }
        mLayoutStatusView?.dismissLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
        mSelectGoodsPresenter.detachView()
        mGoodsListPresenter.detachView()
    }
}

