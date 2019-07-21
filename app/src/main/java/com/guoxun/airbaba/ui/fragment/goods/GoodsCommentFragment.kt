package com.guoxun.airbaba.ui.fragment.goods

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.ui.adapter.home.GoodsCommentAdapter
import com.guoxun.airbaba.ui.adapter.home.HomeShopAdapter
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.fragment_goods_commont_list.*
import java.util.*

/**
 * Created by xuhao on 2017/11/9.
 * 我的
 */
class GoodsCommentFragment : BaseFragment() {


    private var mTitle: String? = null
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { GoodsCommentAdapter( baseList) } }
    companion object {
        fun getInstance(title: String): GoodsCommentFragment {
            val fragment = GoodsCommentFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_goods_commont_list

    override fun lazyLoad() {

    }
    override fun initView() {

        val proAttributeList = ArrayList<String>()
        proAttributeList.add("全部（12145）")
        proAttributeList.add("回头客（1045）")
        proAttributeList.add("实惠（55）")
        proAttributeList.add("晒图（12145）")
        proAttributeList.add("物流（22）")
        proAttribute(proAttributeList)

        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
        baseList.clear()
        baseList.add("名称")
        baseList.add("名称")
        mAdapter?.setNewData(baseList)
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


}