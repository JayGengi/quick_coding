package com.guoxun.airbaba.ui.adapter.home.vlayout

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.blankj.utilcode.util.BarUtils
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * 描述：
 *
 * @author JayGengi
 * @date 2018/12/3
 */
class HomeTopSearchAdapter(layoutHelper: LayoutHelper, layoutResId: Int, data: List<String>?) : BaseVlayoutAdapter<String>(layoutHelper, layoutResId, data, VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)) {

    override fun convert(helper: BaseViewHolder, item: String?, position: Int, offsetTotal: Int) {
        val space = helper.getView<Space>(R.id.bar_space)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            space.visibility = View.VISIBLE
            val layoutParams = space.layoutParams
            layoutParams.height = BarUtils.getStatusBarHeight()
            space.layoutParams = layoutParams
        }
//        if(item != null) {
//            val qrcodeLay = helper.getView<RelativeLayout>(R.id.qrcode_lay)
//            val searchLay = helper.getView<LinearLayout>(R.id.search_lay)
//            val homeTypeLay = helper.getView<RelativeLayout>(R.id.home_type_lay)
//        }
    }

    override fun getItemCount(): Int {
        return 1
    }

}
