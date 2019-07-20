package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
  *   优惠活动
  * @auther JayGengi
  * 2019/7/20  11:41
  * @email jaygengiii@gmail.com
  */
class DiscountsActAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_discounts_act, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
        helper.setText(R.id.price, item)
//                .setImageResource(R.id.img, item.img)

    }
}