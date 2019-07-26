package com.guoxun.airbaba.ui.adapter.mine

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.guoxun.airbaba.R

/**
 * @des    报修管理
 * @auther JayGengi
 * 2019/7/26  11:25
 * @email  jaygengiii@gmail.com
 */
class MyRepairAdapter(data: List<String>?)
    : BaseQuickAdapter<String, BaseViewHolder>
(R.layout.item_my_repair, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        item ?: return

        helper.addOnClickListener(R.id.btn)
//        helper.setText(R.id.title, item)
//                .setImageResource(R.id.img, item.img)

    }
}