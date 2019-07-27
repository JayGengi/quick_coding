package com.guoxun.airbaba.ui.adapter.home

import android.graphics.Paint
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.NewRetailEntity
import com.guoxun.airbaba.utils.glide.GlideUtils

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class HomeMenuMainAdapter(data: List<NewRetailEntity.ResultsBean>?)
    : BaseQuickAdapter<NewRetailEntity.ResultsBean, BaseViewHolder>
(R.layout.item_home_menu_main, data) {

    override fun convert(helper: BaseViewHolder, item: NewRetailEntity.ResultsBean?) {
        item ?: return
        helper.setText(R.id.title, item.name)
                .setText(R.id.red_price,"￥${item.first_price}")
                .setText(R.id.grey_price,"￥${item.original_price}")

        val oldPrice : TextView = helper.getView(R.id.grey_price)
        oldPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG //中划线
        GlideUtils.showImageView(mContext, R.mipmap.ic_placeholder_1_1, item.picture, helper.getView(R.id.img))

    }
}