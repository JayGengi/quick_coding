package com.guoxun.airbaba.ui.fragment

import android.os.Bundle
import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by xuhao on 2017/11/9.
 * 我的
 */
class MineFragment : BaseFragment(), View.OnClickListener {


    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_mine

    override fun initView() {
    }

    override fun lazyLoad() {

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
//            R.id.smartRefreshLayout_url -> {
//                val intent = Intent(context, WebViewActivity::class.java)
//                intent.putExtra("title","SmartRefreshLayout")
//                intent.putExtra("url", "https://github.com/scwang90/SmartRefreshLayout")
//                startActivity(intent)
//            }
        }
    }




}