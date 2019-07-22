package com.guoxun.airbaba.ui.activity.home

import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.SnackbarUtils.dismiss
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.widget.BaseEditText
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.activity_search.*


/**
   * @description: 首頁搜索頁
   * @author JayGengi
   * @date  2018/10/29 0029 上午 11:57
   * @email jaygengiii@gmail.com
   */


class SearchActivity : BaseActivity() {

    override fun layoutId(): Int {
        return R.layout.activity_search
    }

    override fun initView() {
//        mLayoutStatusView = multipleStatusView
        //TopBar定制View
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        val view = LayoutInflater.from(this).inflate(R.layout.common_topbar_search, null)
        mTopBar.setCenterView(view)
        val searchTitle = view.findViewById<BaseEditText>(R.id.srarch_title)
        searchTitle.hint = "搜索商品"

        searchTitle.setOnEditorActionListener { arg0, arg1, arg2 ->
            if (arg1 == EditorInfo.IME_ACTION_UNSPECIFIED) {
                showToast(searchTitle.text.toString())
            }
            false
        }
        mTopBar.addRightTextButton("取消",R.id.right).setOnClickListener { finish() }


        val textData = ArrayList<String>()
        textData.add("枸杞")
        textData.add("枸杞")
        textData.add("枸杞枸杞枸")
        textData.add("枸杞")
        textData.add("枸杞枸杞枸杞枸杞")
//        // 最近搜索
        flow_search!!.apply {
            adapter = object : TagAdapter<String>(textData){
                override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                    val view :View = LayoutInflater.from(context).inflate(R.layout.item_search_tag_tv, null)
                    val name: TextView = view.findViewById(R.id.name)
                    val del: ImageView = view.findViewById(R.id.del_hos)
                    name.text = textData[position]
                    return view
                }
            }
            setOnTagClickListener { _, position, _ ->
                showToast(textData[position])
                dismiss()
                context.showToast(textData[position])
                true
            }
        }

    }

    override fun start() {
    }

    override fun initData() {

    }

}
