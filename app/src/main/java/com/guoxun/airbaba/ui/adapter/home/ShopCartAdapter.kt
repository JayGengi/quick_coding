package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
  * 钱包收入
  * @auther JayGengi
  * 2019/7/23  11:02
  * @email jaygengiii@gmail.com
  */
class ShopCartAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_shop_cart, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}