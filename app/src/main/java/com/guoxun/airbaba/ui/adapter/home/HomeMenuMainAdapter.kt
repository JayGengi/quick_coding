package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class HomeMenuMainAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_home_menu_main, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}