package com.guoxun.airbaba.ui.fragment.home

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.contract.CategoryTContract
import com.guoxun.airbaba.mvp.contract.GoodsListContract
import com.guoxun.airbaba.mvp.model.bean.CategoryTEntity
import com.guoxun.airbaba.mvp.model.bean.GoodsListEntity
import com.guoxun.airbaba.mvp.presenter.CategoryTPresenter
import com.guoxun.airbaba.mvp.presenter.GoodsListPresenter
import com.guoxun.airbaba.ui.adapter.home.HomeTypeMenuAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeTypeShopAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home_type.*
import java.util.*

/**
   * @description: CategoryT
   * @author JayGengi
   * @date  2018/11/7 0007 下午 5:00
   * @email jaygengiii@gmail.com
   */

class HomeTypeFragment : BaseFragment(),CategoryTContract.View , GoodsListContract.View{

    private var pid : Int? = 0
    private var menuList = ArrayList<CategoryTEntity.CatesBean>()
    private val mAdapter by lazy { activity?.let { HomeTypeMenuAdapter( menuList) } }

    private var shopList = ArrayList<GoodsListEntity.ResultsBean>()
    private val shopAdapter by lazy { activity?.let { HomeTypeShopAdapter( shopList) } }

    private val mPresenter by lazy { CategoryTPresenter() }
    private val mGoodsListPresenter by lazy { GoodsListPresenter() }
    init {
        mPresenter.attachView(this)
        mGoodsListPresenter.attachView(this)
    }
    override fun getLayoutId(): Int = R.layout.fragment_home_type

    companion object {
        fun newInstance(key: Int): HomeTypeFragment {
            val args = Bundle()
            args.putInt("key", key)
            val fragment = HomeTypeFragment()
//            fragment.arguments = args
            fragment.pid = key
            return fragment
        }
    }

    override fun lazyLoad() {
        loadData()
    }
    private fun loadData(){
        mPresenter.requestCategoryTInfo(pid!!)

        mGoodsListPresenter.requestGoodsListInfo("","",pid.toString(),"",CURRENT_PAGE)
    }
    override fun initView() {

        recycler_menu.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,5)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }

        //recycler_shop
        recycler_shop.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            //android自带分割线
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = shopAdapter
        }
    }

    private fun initBanner(adList: List<CategoryTEntity.AdBean>) {
        val bannerList = ArrayList<String>()
        for(item : CategoryTEntity.AdBean in adList.iterator()){
            item.picture_url?.let { bannerList.add(it) }
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

    override fun showCategoryTInfo(dataInfo: CategoryTEntity) {
        initBanner(dataInfo.ad!!)
        mAdapter!!.setNewData(dataInfo.cates)
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
        mLayoutStatusView?.dismissLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}
