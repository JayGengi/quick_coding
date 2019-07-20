package com.guoxun.airbaba.ui.activity.home.goods

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.mvp.model.bean.MySection
import com.guoxun.airbaba.mvp.model.bean.ShopLeftEntity
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.activity.home.HomeFactoryOutletActivity
import com.guoxun.airbaba.ui.adapter.home.SectionAdapter
import com.guoxun.airbaba.ui.adapter.home.ShopTypeLeftAdapter
import com.guoxun.airbaba.utils.BannerImageLoader
import com.guoxun.airbaba.utils.picture.ImagePreviewUtils
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.activity_shop_type.*

/**
 * @des    商品分类
 * @auther JayGengi
 * @data 2018/12/19 13:59
 * @email JayGengi@163.com
 */
class GoodsTypeActivity : BaseActivity() {

    private var leftEntity = ArrayList<ShopLeftEntity>()
    private val mAdapter by lazy { ShopTypeLeftAdapter(leftEntity) }


    private val mData = ArrayList<MySection>()
    private var menu = ShopLeftEntity()
    override fun layoutId(): Int {
        return R.layout.activity_shop_type
    }

    override fun initView() {

        //TopBar定制View
        val view = LayoutInflater.from(this).inflate(R.layout.common_topbar_search, null)
        mTopBar.setCenterView(view)
        val searchTitle = view.findViewById<EditText>(R.id.srarch_title)
        searchTitle.hint = "油性肌肤护肤品"

        searchTitle.setOnEditorActionListener { arg0, arg1, arg2 ->
            if (arg1 == EditorInfo.IME_ACTION_UNSPECIFIED) {
                showToast(searchTitle.text.toString())
            }
            false
        }
        mTopBar.addRightTextButton("取消",R.id.right).setOnClickListener { finish() }

        rv_sort.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
        leftEntity.clear()
        menu = ShopLeftEntity()
        menu.apply {
            name = "美妆个户"
            choose =true
        }
        leftEntity.add(menu)

        menu = ShopLeftEntity()
        menu.apply {
            name = "食品饮料"
            choose =false
        }
        leftEntity.add(menu)

        menu = ShopLeftEntity()
        menu.apply {
            name = "生鲜"
            choose =false
        }
        leftEntity.add(menu)

        menu = ShopLeftEntity()
        menu.apply {
            name = "家居生活"
            choose =false
        }
        leftEntity.add(menu)

        mAdapter.setNewData(leftEntity)
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val item : ShopLeftEntity = adapter.getItem(position) as ShopLeftEntity
            for(mySection : ShopLeftEntity in leftEntity){
                mySection.choose = false
            }
            item.choose = true
            mAdapter.notifyDataSetChanged()
        }

        val baseList = java.util.ArrayList<String>()
        baseList.add("https://gw.alicdn.com/tps/TB1W_X6OXXXXXcZXVXXXXXXXXXX-400-400.png")
        baseList.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg")
        initBanner(baseList)

        flow_layout.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,3)
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        mData.clear()
        mData.add( MySection(true,"面部护理",false))
        val menu = MenuEntity()
        menu.apply {
            name = "面膜"
            icon = R.mipmap.bangbangtang
        }
        mData.add(MySection(menu))
        val menu2 = MenuEntity()
        menu2.apply {
            name = "护理套餐"
            icon = R.mipmap.bangbangtang
        }
        mData.add(MySection(menu))
        val menu3 = MenuEntity()
        menu3.apply {
            name = "保湿乳"
            icon = R.mipmap.bangbangtang
        }
        mData.add(MySection(menu))


        mData.add( MySection(true,"沐浴清理",false))
        val menu4 = MenuEntity()
        menu4.apply {
            name = "沐浴露"
            icon = R.mipmap.bangbangtang
        }
        mData.add(MySection(menu))
        val menu5 = MenuEntity()
        menu5.apply {
            name = "香皂"
            icon = R.mipmap.bangbangtang
        }
        mData.add(MySection(menu))
        val menu6 = MenuEntity()
        menu6.apply {
            name = "润肤"
            icon = R.mipmap.bangbangtang
        }
        mData.add(MySection(menu))
        val rightAdapter = SectionAdapter(R.layout.item_shop_type_right, R.layout.item_shop_type_right_head, mData)

        flow_layout.adapter = rightAdapter

        rightAdapter.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(this, GoodsListActivity::class.java))

        }

        loadData()
    }

    override fun start() {
    }

    private fun initBanner(bannerList: List<String>) {
        banner.setOnBannerListener { position1 ->
            ImagePreviewUtils.largerView(this, position1, bannerList)
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
    private fun loadData() {
    }


    override fun initData() {

    }
}
