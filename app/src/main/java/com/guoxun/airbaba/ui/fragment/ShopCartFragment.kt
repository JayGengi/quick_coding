package com.guoxun.airbaba.ui.fragment

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.ui.activity.home.HomeFactoryOutletActivity
import com.guoxun.airbaba.ui.activity.mine.SettlementActivity
import com.guoxun.airbaba.ui.adapter.home.ShopCartAdapter
import kotlinx.android.synthetic.main.fragment_shop_car.*
import java.util.ArrayList

/**
  * @des    购物车
  * @auther JayGengi
  * 2019/7/24  16:21
  * @email  jaygengiii@gmail.com
  */
class ShopCartFragment : BaseFragment(), View.OnClickListener {

    private var isEditStatus : Boolean = false
    private var baseList = ArrayList<String>()
    private val mAdapter by lazy { activity?.let { ShopCartAdapter( baseList) } }
    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): ShopCartFragment {
            val fragment = ShopCartFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_shop_car

    override fun initView() {

        mLayoutStatusView = multipleStatusView

        refreshLayout.setOnRefreshListener {
            CURRENT_PAGE =1
            lazyLoad()
        }
        refreshLayout.setOnLoadMoreListener {
            CURRENT_PAGE++
            lazyLoad()
        }
        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }
        baseList.clear()
        baseList.add("1")
        baseList.add("2")
        baseList.add("3")
        mAdapter!!.setNewData(baseList)

        edit.setOnClickListener(this)
        settlement.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.edit ->{
                if(isEditStatus){
                    isEditStatus= false
                    settlement_lay.visibility = View.VISIBLE
                    go_pay_lay.visibility = View.GONE
                    edit.text = "编辑"
                }else{
                    isEditStatus = true
                    settlement_lay.visibility = View.GONE
                    go_pay_lay.visibility = View.VISIBLE
                    edit.text = "完成"
                }
            }
            R.id.settlement ->{
                openPop()
            }
        }

    }
    override fun lazyLoad() {

    }
    /** 弹出底部对话框 */
    private fun openPop(){
        val popView : View = LayoutInflater.from (context).inflate(
                R.layout.window_pay_way, null)
        val rootView : View = popView.findViewById (R.id.goods_bottom) // 當前頁面的根佈局
        val cancel : TextView = popView.findViewById (R.id.cancel)
        val confirm : TextView = popView.findViewById (R.id.confirm)
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
            startActivity(Intent(context, SettlementActivity::class.java))

        }
    }




}