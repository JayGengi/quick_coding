package com.guoxun.pajs.ui.fragment.mine

import android.os.Bundle
import android.view.View
import com.guoxun.pajs.R
import com.guoxun.pajs.base.BaseFragment
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * @description: 首页  Category
 * @author JayGengi
 * @date  2018/11/7 0007 下午 5:00
 * @email jaygengiii@gmail.com
 */

class MineFragment : BaseFragment(), View.OnClickListener {


    override fun getLayoutId(): Int = R.layout.fragment_mine

    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
//            fragment.mTitle = title
            return fragment
        }
    }

    override fun lazyLoad() {
        loadData()
    }

    override fun initView() {
        real_lib_lay.layoutParams.height = QMUIStatusBarHelper.getStatusbarHeight(context)
    }

    private fun loadData() {
    }
    override fun onClick(v: View?) {
    }
}
