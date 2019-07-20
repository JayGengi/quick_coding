package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.MenuEntity

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class HomeSelectAdapter(data: List<MenuEntity>?)
    : BaseQuickAdapter<MenuEntity, BaseViewHolder>
(R.layout.item_home_select, data) {

    override fun convert(helper: BaseViewHolder, item: MenuEntity?) {
        item ?: return
        helper.setText(R.id.title, item.name)
                .setImageResource(R.id.img, item.icon)

    }
}