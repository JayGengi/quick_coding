package com.guoxun.airbaba.ui.activity.home.goods

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.ui.adapter.home.GoodsSellHotAdapter
import kotlinx.android.synthetic.main.activity_goods_sell_hot.*
import kotlinx.android.synthetic.main.activity_home_message.multipleStatusView

/**
  *   热销商品
  * @auther JayGengi
  * 2019/7/22  10:35
  * @email jaygengiii@gmail.com
  */
class GoodsSellHotActivity : BaseActivity() ,View.OnClickListener{
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { GoodsSellHotAdapter(baseList) }
    override fun layoutId(): Int {
        return R.layout.activity_goods_sell_hot
    }

    override fun initView() {
//        val bundle = intent.extras
//        val title = bundle.getString("title")
        mLayoutStatusView = multipleStatusView
        //目的是为了透明状态栏 ps:QMUI适配的沉浸状态栏，问题根源在这套架构找不到，死办法解决
        mBaseLayout.visibility = View.GONE
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
            layoutManager = LinearLayoutManager(context)
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
        ll_back.setOnClickListener(this)

    }

    override fun start() {
        initData()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ll_back ->{
                finish()
            }
        }
    }
    override fun initData() {
    }
}
