package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * 我的资产
 * @auther JayGengi
 * 2019/7/19 0019 下午 4:37
 * @email jaygengiii@gmail.com
 */
class AssetMessageAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_asset_message, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}