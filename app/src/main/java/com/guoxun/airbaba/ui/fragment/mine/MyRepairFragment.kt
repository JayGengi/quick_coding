package com.guoxun.airbaba.ui.fragment.mine

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.activity.mine.order.MyOrderDetailsActivity
import com.guoxun.airbaba.ui.activity.mine.repair.MyRepairDetailsActivity
import com.guoxun.airbaba.ui.adapter.mine.MyRepairAdapter
import kotlinx.android.synthetic.main.common_list.*
import java.util.*


/**
 * @des    报修管理
 * @auther JayGengi
 * 2019/7/26  11:25
 * @email  jaygengiii@gmail.com
 */
class MyRepairFragment : BaseFragment(){

    private var type: Int? = 1
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { MyRepairAdapter( baseList) } }
//    private val mPresenter by lazy { FollowListPresenter() }

    companion object {
        fun setInstance(type: Int): MyRepairFragment {
            val fragment = MyRepairFragment()
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
                startActivity(Intent(context, MyRepairDetailsActivity::class.java))
        }
        /**
         * OnItemClickListener
         * */
        mAdapter!!.setOnItemChildClickListener { adapter, view, position ->
//            val item : FollowListEntity.ListsBean = adapter.getItem(position) as FollowListEntity.ListsBean
            when(view.id){
//                R.id.btn ->{
//                    openPop()
//                }
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
}