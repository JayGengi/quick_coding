package com.guoxun.airbaba.ui.fragment.mine

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.ui.activity.mine.order.ApplyAfterSalesActivity
import com.guoxun.airbaba.ui.activity.mine.order.MyOrderAfterSalesActivity
import com.guoxun.airbaba.ui.activity.mine.order.MyOrderCommentActivity
import com.guoxun.airbaba.ui.activity.mine.order.MyOrderDetailsActivity
import com.guoxun.airbaba.ui.adapter.mine.OrderAdapter
import kotlinx.android.synthetic.main.common_list.*
import java.util.*


/**
 * 我的订单
 * @auther JayGengi
 * 2019/7/23  14:53
 * @email jaygengiii@gmail.com
 */
class OrderFragment : BaseFragment(){

    private var type: Int? = 1
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { OrderAdapter( baseList) } }
//    private val mPresenter by lazy { FollowListPresenter() }

    companion object {
        fun setInstance(type: Int): OrderFragment {
            val fragment = OrderFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.type = type
            return fragment
        }
    }
    override fun lazyLoad() {
        CURRENT_PAGE =1
        loadData()
    }

    override fun getLayoutId(): Int= R.layout.common_list

    override fun initView() {
//        mPresenter.attachView(this)
        mLayoutStatusView = multipleStatusView

        refreshLayout.setOnRefreshListener {
            CURRENT_PAGE =1
            loadData()
        }
        refreshLayout.setOnLoadMoreListener {
            CURRENT_PAGE++
            loadData()
        }
        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }
        baseList.clear()
        baseList.add("1")
        baseList.add("2")
        baseList.add("3")
        mAdapter!!.setNewData(baseList)


        mAdapter!!.setOnItemClickListener { adapter, view, position ->
            //            val item : FollowListEntity.ListsBean = adapter.getItem(position) as FollowListEntity.ListsBean
            if(6 == type){
                startActivity(Intent(context, MyOrderAfterSalesActivity::class.java))
            }else{
                startActivity(Intent(context, MyOrderDetailsActivity::class.java))
            }
        }
        /**
         * OnItemClickListener
         * */
        mAdapter!!.setOnItemChildClickListener { adapter, view, position ->
//            val item : FollowListEntity.ListsBean = adapter.getItem(position) as FollowListEntity.ListsBean
            when(view.id){
                R.id.btn1 ->{
                    openPop()
                }
                R.id.btn2 ->{
                    startActivity(Intent(context, MyOrderCommentActivity::class.java))
                }
                R.id.btn3 ->{
                    startActivity(Intent(context, ApplyAfterSalesActivity::class.java))
                }

            }
        }

    }

    private fun loadData(){
//        val map = HashMap<String, Any>()
//        map["user_follow_userid"] = LitePal.findFirst(User::class.java).user_id
//        map["p"] = CURRENT_PAGE
//        map["pnum"] = PAGE_CAPACITY
//        map["types"] = type.toString()
//        mPresenter.requestFollowListInfo(map)
    }

    /** 弹出底部对话框 */
    private fun openPop(){
        val popView : View = LayoutInflater . from (context).inflate(
                R.layout.window_order_cancel, null)
        val rootView : View = popView.findViewById (R.id.goods_bottom) // 當前頁面的根佈局
        val cancel : TextView = popView.findViewById (R.id.cancel)
        val confirm : Button = popView.findViewById (R.id.confirm)
        val popupWindow  = PopupWindow (popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        activity?.let { setBackgroundAlpha(it, 0.5f) }//设置屏幕透明度
        popupWindow.setBackgroundDrawable(ColorDrawable())
        popupWindow.isFocusable = true// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM , 0,0)
        popupWindow.setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            activity?.let { setBackgroundAlpha(it, 1f) }//设置屏幕透明度
        }
        cancel.setOnClickListener {
            popupWindow.dismiss()
        }

        confirm.setOnClickListener {
            popupWindow.dismiss()
        }
    }
//
//    override fun showFollowListInfo(dataInfo: FollowListEntity) {
//        multipleStatusView?.showContent()
//        mAdapter?.run {
//            if ((dataInfo.lists!=null && dataInfo.lists!!.isNotEmpty()) || CURRENT_PAGE>1) {
//                if (CURRENT_PAGE == 1) {
//                    baseList.clear()
//                }
//                refreshLayout.isEnableLoadMore = dataInfo.lists!!.size == PAGE_CAPACITY
//
//                baseList.addAll(dataInfo.lists!!)
//                setNewData(baseList)
//            } else {
//                multipleStatusView?.showEmpty()
//            }
//        }
//    }
//
//    override fun showError(msg: String, errorCode: Int) {
//        mLayoutStatusView?.dismiss()
//        if (errorCode == ErrorStatus.NETWORK_ERROR) {
//            multipleStatusView?.showNoNetwork()
//        } else {
//            showToast(msg)
//        }
//    }
//
//    /**
//     * 显示 Loading （下拉刷新的时候不需要显示 Loading）
//     */
//    override fun showLoading() {
//        mLayoutStatusView?.showLoading()
//    }
//    /**
//     * 隐藏 Loading
//     */
//    override fun dismissLoading() {
//        multipleStatusView?.showContent()
//        if(refreshLayout!=null && refreshLayout.isRefreshing){
//            refreshLayout.finishRefresh()
//        }
//        if(refreshLayout!=null && refreshLayout.isLoading){
//            refreshLayout.finishLoadMore()
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter.detachView()
//    }

}