package com.guoxun.airbaba.ui.adapter.mine

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * 优惠券
 * @auther JayGengi
 * 2019/7/23  10:45
 * @email jaygengiii@gmail.com
 */
class CouponsAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_discounts_act, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}