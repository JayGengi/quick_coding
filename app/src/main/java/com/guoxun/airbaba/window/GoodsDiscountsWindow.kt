package com.guoxun.airbaba.window

import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.ui.adapter.home.DiscountsActAdapter

/**
 *   商品列表筛选popWindow
 * @auther JayGengi
 * 2019/7/21  9:54
 * @email jaygengiii@gmail.com
 */
class GoodsDiscountsWindow (var act: Activity,var context: Context): PopupWindow(context){


//    private var flowLayout: TagFlowLayout? = null
    private var cancel: TextView? = null
    private var recycler: RecyclerView? = null

    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { DiscountsActAdapter(baseList) }
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.window_goods_discounts_act, null)

        contentView = view
//        flowLayout = view.findViewById(R.id.flow_layout)
        cancel = view.findViewById(R.id.cancel)
        recycler = view.findViewById(R.id.recycler)
        //设置PopupWindow的背景
//        setBackgroundDrawable(ColorDrawable(context.resources.getColor(R.color.common_color_line)))
        setBackgroundDrawable(ColorDrawable())
        showAtLocation(contentView, Gravity.BOTTOM , 0,0)
        setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            setBackgroundAlpha(act,1.0f)
        }
        height = ViewGroup.LayoutParams.MATCH_PARENT
        width = ViewGroup.LayoutParams.MATCH_PARENT
        isOutsideTouchable = true
        isFocusable = true

        initViews(view)
    }

    private fun initViews(view: View) {
        cancel?.setOnClickListener {
            dismiss()
        }
        recycler!!.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            //android自带分割线
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }
        baseList.clear()
        baseList.add("￥40")
        baseList.add("￥50")
        baseList.add("￥60")
        mAdapter.setNewData(baseList)
    }

}