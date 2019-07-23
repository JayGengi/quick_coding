package com.guoxun.airbaba.ui.adapter.home

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity

/**
 * 首页菜单[厂家直销]
 * @auther JayGengi
 * 2019/7/19 0019 上午 10:28
 * @email jaygengiii@gmail.com
 */
class HomeFactoryOutletAdapter(data: List<ShopListEntity.ResultsBean>?)
    : BaseQuickAdapter<ShopListEntity.ResultsBean, BaseViewHolder>
(R.layout.item_home_factory_outlet, data) {

    override fun convert(helper: BaseViewHolder, item: ShopListEntity.ResultsBean?) {
        item ?: return
        helper.setText(R.id.title, item.shop_name)
                .setText(R.id.shop_num, "在售商品${item.goods_num}件")

        //Glide 加载图片简单用法
        Glide.with(mContext)
                .load(item.picture)
                .apply(RequestOptions().placeholder(R.mipmap.ic_placeholder_1_1))
                .into(helper.getView(R.id.img))

    }
}