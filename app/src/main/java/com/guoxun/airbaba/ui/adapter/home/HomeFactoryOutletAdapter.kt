package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * 首页菜单[厂家直销]
 * @auther JayGengi
 * 2019/7/19 0019 上午 10:28
 * @email jaygengiii@gmail.com
 */
class HomeFactoryOutletAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_home_factory_outlet, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}