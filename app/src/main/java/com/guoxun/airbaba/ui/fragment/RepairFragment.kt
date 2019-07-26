package com.guoxun.airbaba.ui.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.guoxun.airbaba.Constants
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.utils.picture.PictureSelectUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.fragment_repair.*
import java.util.*

/**
 * Created by xuhao on 2017/11/9.
 * 我的
 */
class RepairFragment : BaseFragment() {

    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): RepairFragment {
            val fragment = RepairFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_repair

    @SuppressLint("ResourceAsColor")
    override fun initView() {
        loadSystemImg(null)
    }

    override fun lazyLoad() {

    }

    /**
     * 描述：显示本地选择的图片
     *
     * @author JayGengi
     * @date 2018/7/19 0019 下午 3:42
     */
    private fun loadSystemImg(pathResult: ArrayList<String>?) {
        var imgCount = 0
        if (img_flexbox.childCount > 0) {
            img_flexbox.removeAllViews()
        }
        if (pathResult != null) {
            imgCount = pathResult.size
            for (i in pathResult.indices) {
                val lview = LayoutInflater.from(context).inflate(R.layout.common_choose_img_item, null)
                val img: ImageView = lview.findViewById(R.id.img)
                val del: ImageView = lview.findViewById(R.id.del)
                Glide.with(this)
                        .load(pathResult[i])
                        .into(img)
                del.setOnClickListener {
                    pathResult.removeAt(i)
                    loadSystemImg(pathResult)
                }
                img_flexbox.addView(lview)
            }
        }
        val mview = LayoutInflater.from(context).inflate(R.layout.common_choose_img_add, null)
        //图片
        if (6 != imgCount) {
            val imgAdd: RelativeLayout = mview.findViewById(R.id.choose_img)
            img_flexbox.addView(mview)
            imgAdd.setOnClickListener { v ->
                addSubscribe(RxPermissions(this)
                        .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA)
                        .subscribe {
                            var imgCount = 6
                            if (pathResult != null) {
                                imgCount -= pathResult.size
                            }
                            PictureSelectUtils.SelectSystemPhoto(activity, Constants.RESULT_CODE_1, imgCount)
                        })
            }
        }

    }



}