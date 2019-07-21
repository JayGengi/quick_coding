package com.guoxun.airbaba.ui.fragment.goods

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.ui.adapter.home.GoodsDetailAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeMenuAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.fragment_goods_info.*
import java.util.ArrayList

/**
  *   商品详情基本信息
  * @auther JayGengi
  * 2019/7/21  11:45
  * @email jaygengiii@gmail.com
  */
class GoodsInfoFragment : BaseFragment(), View.OnClickListener {

    private var mTitle: String? = null
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { GoodsDetailAdapter( baseList) } }

    companion object {
        fun getInstance(title: String): GoodsInfoFragment {
            val fragment = GoodsInfoFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_goods_info

    override fun lazyLoad() {

    }
    override fun initView() {

//        ll_pull_up.setOnClickListener(this)
        val baseList = ArrayList<String>()
        baseList.add("https://gw.alicdn.com/tps/TB1W_X6OXXXXXcZXVXXXXXXXXXX-400-400.png")
        baseList.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg")
        initBanner(baseList)

        val proAttributeList = ArrayList<String>()
        proAttributeList.add("晒图（12145）")
        proAttributeList.add("回头客（1045）")
        proAttributeList.add("实惠（55）")
        proAttribute(proAttributeList)

        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }

        baseList.clear()
        baseList.add("1")
        baseList.add("1")
        mAdapter!!.setNewData(baseList)
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

    /**
      *   评价标签
      * @auther JayGengi
      * 2019/7/21  14:26
      * @email jaygengiii@gmail.com
      */
    private fun proAttribute(proAttributeList: List<String>) {
        flow_layout!!.apply {
            adapter = object : TagAdapter<String>(proAttributeList) {
                override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                    val tv = LayoutInflater.from(context).inflate(R.layout.pop_tag_comment, parent, false) as TextView
                    tv.text = t
                    return tv
                }
            }
        }
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.ll_pull_up ->{
//                //上拉查看图文详情
//                sv_switch.smoothOpen(true)
//            }
        }
    }




}