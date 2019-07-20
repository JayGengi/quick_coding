@file:Suppress("UNCHECKED_CAST")

package com.guoxun.airbaba.ui.adapter.home

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.MySection

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class SectionAdapter(layoutResId: Int, sectionHeadResId: Int, data: List<*>)
    : BaseSectionQuickAdapter<MySection, BaseViewHolder>(layoutResId, sectionHeadResId, data as MutableList<MySection>?) {

    override fun convertHead(helper: BaseViewHolder, item: MySection) {
        val header : TextView = helper.getView(R.id.title)
        header.text = item.header
    }

    override fun convert(helper: BaseViewHolder, item: MySection) {
        val vSTitle = item.t
        val title : TextView = helper.getView(R.id.title)
        val img : ImageView = helper.getView(R.id.img)
        title.text = vSTitle.name
        img.setImageResource(vSTitle.icon)

    }
}
