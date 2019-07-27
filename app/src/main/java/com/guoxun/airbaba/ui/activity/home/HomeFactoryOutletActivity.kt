package com.guoxun.airbaba.ui.activity.home

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.mvp.contract.ShopListContract
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity
import com.guoxun.airbaba.mvp.presenter.ShopListPresenter
import com.guoxun.airbaba.net.exception.ErrorStatus
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.adapter.home.HomeFactoryOutletAdapter
import kotlinx.android.synthetic.main.common_list.*
import java.util.*

/**
  * 首页菜单[厂家直销]
  * @auther JayGengi
  * 2019/7/19 0019 上午 10:28
  * @email jaygengiii@gmail.com
  */
class HomeFactoryOutletActivity : BaseActivity(),ShopListContract.View{

    private var baseList = ArrayList<ShopListEntity.ResultsBean>()
    private val mAdapter by lazy { HomeFactoryOutletAdapter(baseList) }
    private val mPresenter by lazy { ShopListPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun layoutId(): Int {
        return R.layout.common_list
    }

    override fun initView() {
//        val bundle = intent.extras
//        val title = bundle.getString("title")
        mTopBar.setTitle("厂家直销")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
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
            layoutManager = LinearLayoutManager(context)
            //android自带分割线
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }
        /**
         * OnItemClickListener
         * */
//        mAdapter.setOnItemChildClickListener { adapter, view, position ->
//            clickIndex = position
////            val item : FansListEntity.ListBean = adapter.getItem(position) as FansListEntity.ListBean
//            when(view.id){
//                R.id.release_tile ->
//                repairFollow()
//            }
//        }

    }


    override fun start() {
        initData()
    }

    override fun initData() {
        mPresenter.requestShopListInfo(CURRENT_PAGE)
    }

    override fun showShopListInfo(dataInfo: List<ShopListEntity.ResultsBean>) {
        multipleStatusView?.showContent()
        mAdapter.run {
            if ((dataInfo.isNotEmpty()) || CURRENT_PAGE>1) {
                if (CURRENT_PAGE == 1) {
                    baseList.clear()
                }
                refreshLayout.isEnableLoadMore = dataInfo.size == PAGE_CAPACITY
                baseList.addAll(dataInfo)
                setNewData(baseList)
            } else {
                multipleStatusView?.showEmpty()
            }
        }
    }
    override fun showError(msg: String, errorCode: Int) {
        if (errorCode == ErrorStatus.NETWORK_ERROR) {
            multipleStatusView?.showNoNetwork()
        } else {
            multipleStatusView?.showError()
        }
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
    }
}
