package com.guoxun.airbaba.ui.fragment.goods

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.ui.activity.home.goods.MerchantMainActivity
import com.guoxun.airbaba.ui.adapter.home.DiscountsActAdapter
import com.guoxun.airbaba.ui.adapter.home.GoodsDetailAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.fragment_goods_info.*
import java.util.*


/**
  *   商品详情基本信息
  * @auther JayGengi
  * 2019/7/21  11:45
  * @email jaygengiii@gmail.com
 *
  */
class GoodsInfoFragment : BaseFragment(), View.OnClickListener {

    private var mTitle: String? = null
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { GoodsDetailAdapter( baseList) } }

    private var discountsList = ArrayList<String>()
    private val discountsAdapter by lazy { DiscountsActAdapter(discountsList) }
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

        goods_discount.setOnClickListener(this)
        merchant_lay.setOnClickListener(this)
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
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onClick(v: View) {
        val bundle = Bundle()
        when(v.id){
            R.id.goods_discount ->{
                openPop()
            }
            R.id.merchant_lay ->{
                bundle.putString("title","玉珠")
                startActivity(Intent(context, MerchantMainActivity::class.java).putExtras(bundle))
            }

        }
    }


    /** 弹出底部对话框 */
    private fun openPop(){
        val popView : View  = LayoutInflater . from (context).inflate(
                R.layout.window_goods_discounts_act, null)
        val rootView :View  = popView.findViewById (R.id.multipleStatusView) // 當前頁面的根佈局
        val cancel :TextView  = popView.findViewById (R.id.cancel)
        val recycler :RecyclerView  = popView.findViewById (R.id.recycler)
        val popupWindow  = PopupWindow (popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        activity?.let { setBackgroundAlpha(it,0.5f) }//设置屏幕透明度
        popupWindow.setBackgroundDrawable(ColorDrawable())
        popupWindow.isFocusable = true// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM , 0,0)
        popupWindow.setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            activity?.let { setBackgroundAlpha(it,1f) }//设置屏幕透明度
        }
        cancel.setOnClickListener {
            popupWindow.dismiss()
        }
        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            //android自带分割线
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = discountsAdapter
        }
        discountsList.clear()
        discountsList.add("￥40")
        discountsList.add("￥50")
        discountsList.add("￥60")
        discountsAdapter.setNewData(discountsList)
    }



    }