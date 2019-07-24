package com.guoxun.airbaba.ui.activity.mine.order

import android.Manifest
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.guoxun.airbaba.Constants
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.utils.picture.PictureSelectUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.activity_my_order_comment.*
import kotlinx.android.synthetic.main.activity_my_order_comment.img_flexbox
import kotlinx.android.synthetic.main.fragment_repair.*
import java.util.ArrayList

/**
  * @des    评价
  * @auther JayGengi
  * 2019/7/24  10:23
  * @email  jaygengiii@gmail.com
  */
class MyOrderCommentActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_my_order_comment
    }

    override fun initView() {

        mTopBar.setTitle("订单详情")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
//        phone_lay.setOnClickListener(this)
//        real_name_lay.setOnClickListener(this)
//        push_lay.setOnClickListener(this)
//        user_agreement_lay.setOnClickListener(this)
//        privacy_policy_lay.setOnClickListener(this)
        val proAttributeList = ArrayList<String>()
        proAttributeList.add("晒图")
        proAttributeList.add("回头客")
        proAttributeList.add("质量好")
        proAttributeList.add("物流")
        proAttribute(proAttributeList)
        star_bar.setIntegerMark(true)
        loadSystemImg(null)
    }

    override fun start() {
        initData()
    }

    override fun onClick(v: View) {
        when(v.id){
//            R.id.phone_lay ->{
//                startActivity(Intent(this, ModifyPhoneActivity::class.java))
//            }
        }
    }
    override fun initData() {
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
                val lview = LayoutInflater.from(this).inflate(R.layout.common_choose_img_item, null)
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
        val mview = LayoutInflater.from(this).inflate(R.layout.common_choose_img_add, null)
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
                            PictureSelectUtils.SelectSystemPhoto(this, Constants.RESULT_CODE_1, imgCount)
                        })
            }
        }

    }
    /**
     *   评价标签
     * @auther JayGengi
     * 2019/7/21  14:26
     * @email jaygengiii@gmail.com
     */
    private fun proAttribute(proAttributeList: List<String>) {
        flow_layout!!.apply {
            adapter = object : TagAdapter<String>(proAttributeList) {
                override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                    val tv = LayoutInflater.from(context).inflate(R.layout.pop_tag_comment, parent, false) as TextView
                    tv.text = t
                    return tv
                }
            }
        }
    }
}














