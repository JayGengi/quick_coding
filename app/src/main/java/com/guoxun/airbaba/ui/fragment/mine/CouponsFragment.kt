package com.guoxun.airbaba.ui.fragment.mine

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.adapter.mine.CouponsAdapter
import com.guoxun.airbaba.ui.adapter.mine.WalletInComeAdapter
import kotlinx.android.synthetic.main.common_list.*
import java.util.*


/**
 * 优惠券
 * @auther JayGengi
 * 2019/7/23  10:45
 * @email jaygengiii@gmail.com
 */
class CouponsFragment : BaseFragment(){

    private var type: Int? = 1
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { CouponsAdapter( baseList) } }
//    private val mPresenter by lazy { FollowListPresenter() }

    companion object {
        fun setInstance(type: Int): CouponsFragment {
            val fragment = CouponsFragment()
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

        /**
         * OnItemClickListener
         * */
//        mAdapter!!.setOnItemChildClickListener { adapter, view, position ->
//            val item : FollowListEntity.ListsBean = adapter.getItem(position) as FollowListEntity.ListsBean
//            when(view.id){
//                R.id.release_tile ->
//                    repairFollow(item)
//            }
//        }

    }

    private fun loadData(){
//        val map = HashMap<String, Any>()
//        map["user_follow_userid"] = LitePal.findFirst(User::class.java).user_id
//        map["p"] = CURRENT_PAGE
//        map["pnum"] = PAGE_CAPACITY
//        map["types"] = type.toString()
//        mPresenter.requestFollowListInfo(map)
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