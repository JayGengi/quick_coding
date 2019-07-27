package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.CategoryTEntity

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class HomeTypeShopAdapter(data: List<CategoryTEntity.CatesBean>?)
    : BaseQuickAdapter<CategoryTEntity.CatesBean, BaseViewHolder>
(R.layout.item_home_type_shop, data) {

    override fun convert(helper: BaseViewHolder, item: CategoryTEntity.CatesBean?) {

        item ?: return
//        helper.setText(R.id.title, item.name)
//                .setText(R.id.subtitle,item.subtitle)
//                .setText(R.id.red_price,"￥${item.first_price}")
//                .setText(R.id.grey_price,"￥${item.original_price}")
//
//        val oldPrice : TextView = helper.getView(R.id.grey_price)
//        oldPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG //中划线
//        GlideUtils.showImageView(mContext, R.mipmap.ic_placeholder_1_1, item.picture, helper.getView(R.id.img))

    }
}