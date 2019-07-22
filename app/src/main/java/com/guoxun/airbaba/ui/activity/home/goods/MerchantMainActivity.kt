package com.guoxun.airbaba.ui.activity.home.goods

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.widget.Button
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.activity.home.DiscountsActActivity
import com.guoxun.airbaba.ui.adapter.home.MerchatMainAdapter
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_home_message.multipleStatusView
import kotlinx.android.synthetic.main.activity_merchant_main.*

/**
  *  商品商家
  * @auther JayGengi
  * 2019/7/22  8:55
  * @email jaygengiii@gmail.com
  */
class MerchantMainActivity : BaseActivity(){
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { MerchatMainAdapter(baseList) }
    private var rightButton: Button? = null
    override fun layoutId(): Int {
        return R.layout.activity_merchant_main
    }

    override fun initView() {
        val bundle = intent.extras
        val title = bundle.getString("title")
        mTopBar.setTitle(title)
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        rightButton = mTopBar.addRightTextButton("专享优惠",R.id.right)
        rightButton?.apply {
            setTextColor(ContextCompat.getColor(context, R.color.mine_red))
            setOnClickListener {
                val bun = Bundle()
                bun.putString("title","优惠券")
                startActivity(Intent(context, DiscountsActActivity::class.java).putExtras(bun))
            }
        }
        mLayoutStatusView = multipleStatusView

        refreshLayout.setOnRefreshListener {
            CURRENT_PAGE = 1
            initData()
        }
        refreshLayout.setOnLoadMoreListener {
            CURRENT_PAGE++
            initData()
        }
        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }
        baseList.clear()
        baseList.add("1")
        baseList.add("2")
        baseList.add("3")
        mAdapter.setNewData(baseList)

        /**
         * OnItemClickListener
         * */
        mAdapter.setOnItemClickListener { adapter, view, position ->
//            val item : FansListEntity.ListBean = adapter.getItem(position) as FansListEntity.ListBean
            startActivity(Intent(this, GoodsDetailsActivity::class.java))
        }

    }

    override fun start() {
        initData()
    }

    override fun initData() {
    }
}
