package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.mvp.model.bean.SelectGoodsEntity
import com.guoxun.airbaba.utils.glide.GlideUtils

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class HomeSelectAdapter(data: List<SelectGoodsEntity.ResultsBean>?)
    : BaseQuickAdapter<SelectGoodsEntity.ResultsBean, BaseViewHolder>
(R.layout.item_home_select, data) {

    override fun convert(helper: BaseViewHolder, item: SelectGoodsEntity.ResultsBean?) {
        item ?: return
        helper.setText(R.id.title, item.name)
                .setText(R.id.price, "￥${item.first_price}")
        GlideUtils.showImageView(mContext, R.mipmap.ic_placeholder_1_1, item.picture, helper.getView(R.id.img))
    }
}