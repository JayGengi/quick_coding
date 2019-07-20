package com.guoxun.airbaba.ui.adapter.home

import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.ShopLeftEntity

/**
 * 首页菜单[厂家直销]
 * @auther JayGengi
 * 2019/7/19 0019 上午 10:28
 * @email jaygengiii@gmail.com
 */
class ShopTypeLeftAdapter(data: List<ShopLeftEntity>?)
    : BaseQuickAdapter<ShopLeftEntity, BaseViewHolder>
(R.layout.item_shop_type_left, data) {

    override fun convert(helper: BaseViewHolder, item: ShopLeftEntity?) {
        item ?: return
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

        val shopLay : RelativeLayout = helper.getView(R.id.shop_lay)
        val lineFlag : View = helper.getView(R.id.line_flag)
        val title : TextView = helper.getView(R.id.title)
        title.text = item.name
        if(item.choose){
            shopLay.setBackgroundColor(ContextCompat.getColor(mContext,R.color.color_white))
            lineFlag.visibility = View.VISIBLE
            title.apply {
                setTextColor(ContextCompat.getColor(mContext, R.color.air_color_blue))
            }

        }else{
            shopLay.setBackgroundColor(ContextCompat.getColor(mContext,R.color.common_color_line))
            lineFlag.visibility = View.GONE
            title.apply {
                setTextColor(ContextCompat.getColor(mContext,R.color.color_first_text))
            }
        }

    }
}