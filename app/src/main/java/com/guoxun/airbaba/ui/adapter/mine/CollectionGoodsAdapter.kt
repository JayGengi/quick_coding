package com.guoxun.airbaba.ui.adapter.mine

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
  * 收藏--商品
  * @auther JayGengi
  * 2019/7/23  14:35
  * @email jaygengiii@gmail.com
  */
class CollectionGoodsAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_collection_goods, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}