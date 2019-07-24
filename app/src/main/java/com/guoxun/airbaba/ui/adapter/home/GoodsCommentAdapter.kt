package com.guoxun.airbaba.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R
import com.guoxun.airbaba.widget.NineGridView
import java.util.ArrayList

/**
 * @des
 * @auther JayGengi
 * @data 2018/12/6 14:35
 * @email JayGengi@163.com
 */
class GoodsCommentAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_goods_detail_comment, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

        val nineGrid = helper.getView<NineGridView>(R.id.nine_grid)
        nineGrid!!.setIsShowAll(false)
        val baseList = ArrayList<String>()
        baseList.add("https://www.airbaba.cn/data/gallery_album/229/original_img/1556475130887604624.jpg")
        baseList.add("https://www.airbaba.cn/data/gallery_album/229/original_img/1556475159455662649.jpg")
        nineGrid.setUrlList(baseList)
    }
}