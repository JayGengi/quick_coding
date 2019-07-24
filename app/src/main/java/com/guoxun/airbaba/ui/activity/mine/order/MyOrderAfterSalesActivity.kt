package com.guoxun.airbaba.ui.activity.mine.order

import android.Manifest
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.guoxun.airbaba.Constants
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.utils.picture.PictureSelectUtils
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_my_order_after_sales.*
import java.util.ArrayList

/**
  * @des    申请售后
  * @auther JayGengi
  * 2019/7/24  9:38
  * @email  jaygengiii@gmail.com
  */
class MyOrderAfterSalesActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_my_order_after_sales
    }

    override fun initView() {

        mTopBar.setTitle("申请售后")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        apply_pay_lay.setOnClickListener(this)
//        real_name_lay.setOnClickListener(this)
//        push_lay.setOnClickListener(this)
//        user_agreement_lay.setOnClickListener(this)
//        privacy_policy_lay.setOnClickListener(this)

        loadSystemImg(null)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.apply_pay_lay ->{
                showSingleChoiceDialog()
            }
        }
    }
    override fun initData() {
    }
    private fun showSingleChoiceDialog() {
        val items = arrayOf("退货", "退款","退货且退款")
        QMUIDialog.CheckableDialogBuilder(this)
//                .setCheckedIndex(checkedIndex)
                .addItems(items) { dialog, which ->
                    dialog.dismiss()
                    apply_pay.text = items[which]
                }
                .create(R.style.QMUI_Dialog).show()


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
}














