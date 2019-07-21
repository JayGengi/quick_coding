package com.guoxun.airbaba.window

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.guoxun.airbaba.R
import com.guoxun.airbaba.mvp.model.bean.KeyValueEntity
import com.hwangjr.rxbus.RxBus
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout

/**
 *   商品列表筛选popWindow
 * @auther JayGengi
 * 2019/7/21  9:54
 * @email jaygengiii@gmail.com
 */
class GoodsScreenWindow (var context: Context): PopupWindow(context){


//    private var flowLayout: TagFlowLayout? = null
    private var reset: TextView? = null
    private var confirm: TextView? = null
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.window_good_screen, null)

        contentView = view
//        flowLayout = view.findViewById(R.id.flow_layout)
        reset = view.findViewById(R.id.reset)
        confirm = view.findViewById(R.id.confirm)
        //设置PopupWindow的背景
//        setBackgroundDrawable(ColorDrawable(context.resources.getColor(R.color.common_color_line)))
        setBackgroundDrawable(ColorDrawable())
        height = ViewGroup.LayoutParams.MATCH_PARENT
        width = ViewGroup.LayoutParams.MATCH_PARENT
        isOutsideTouchable = true
        isFocusable = true

        initViews(view)
    }

    private fun initViews(view: View) {
        confirm?.setOnClickListener {
            dismiss()
        }
//        val textData = ArrayList<KeyValueEntity>()
//        textData.add(KeyValueEntity("新品精品",true))
//        textData.add(KeyValueEntity("作品预售",true))
//        textData.add(KeyValueEntity("名家定制",true))
//        textData.add(KeyValueEntity("画廊画苑",true))
//        textData.add(KeyValueEntity("学生精品",true))
////        textData.add(KeyValueEntity("装裱店",true))
////        textData.add(KeyValueEntity("文房店",true))
//        // 一级分类
//        flowLayout!!.apply {
//            adapter = object : TagAdapter<KeyValueEntity>(textData){
//                override fun getView(parent: FlowLayout?, position: Int, t: KeyValueEntity?): View {
//                    val tv = LayoutInflater.from(context).inflate(R.layout.pop_tag_tv, parent, false) as TextView
//                    tv.text = t!!.value
//                    return tv
//                }
//            }
//            setOnTagClickListener { _, position, _ ->
//                RxBus.get().post(WrapPopWindowEvent(true,position))
//                dismiss()
////                context.showToast(textData[position].value!!)
//                true
//            }
//        }
    }

}