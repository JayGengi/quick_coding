package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * 订单消息
 * @auther JayGengi
 * 2019/7/19 0019 下午 4:37
 * @email jaygengiii@gmail.com
 */
class GoodsListAdapter(layoutResId: Int,data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
        helper.addOnClickListener(R.id.share_goods)
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}