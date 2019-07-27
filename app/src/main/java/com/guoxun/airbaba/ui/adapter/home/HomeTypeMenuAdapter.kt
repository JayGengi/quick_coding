package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.CategoryTEntity
import com.guoxun.airbaba.mvp.model.bean.MenuEntity
import com.guoxun.airbaba.utils.glide.GlideUtils

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class HomeTypeMenuAdapter(data: List<CategoryTEntity.CatesBean>?)
    : BaseQuickAdapter<CategoryTEntity.CatesBean, BaseViewHolder>
(R.layout.item_home_menu, data) {

    override fun convert(helper: BaseViewHolder, item: CategoryTEntity.CatesBean?) {
        item ?: return
        helper.setText(R.id.title, item.name)
        GlideUtils.showImageView(mContext, R.mipmap.ic_placeholder_1_1, item.picture_url, helper.getView(R.id.img))
    }
}