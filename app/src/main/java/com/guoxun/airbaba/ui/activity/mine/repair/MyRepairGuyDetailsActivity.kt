package com.guoxun.airbaba.ui.activity.mine.repair

import android.content.Intent
import android.net.Uri
import android.text.InputType
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction
import kotlinx.android.synthetic.main.activity_my_repair_guy_details.*

/**
  * @des    报修详情
  * @auther JayGengi
  * 2019/7/26  13:45
  * @email  jaygengiii@gmail.com
  */
class MyRepairGuyDetailsActivity : BaseActivity(),View.OnClickListener{
    override fun layoutId(): Int {
        return R.layout.activity_my_repair_guy_details
    }

    override fun initView() {
//        val bundle = intent.extras
//        if(null != bundle) {
//            position = bundle.getInt("position")
//        }
        mTopBar.setTitle("报修详情")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }

        call_phone.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun initData() {

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.call_phone ->{
                showPhoneDialog()
            }
            R.id.btn1 ->{
                showEditTextDialog()

            }
            R.id.btn2 ->{

            }
        }
    }

    /**
     * @des    QMUI消息对话框(蓝色按钮)
     * @auther JayGengi
     * @data 2018/12/18 10:40
     * @email JayGengi@163.com
     */
    private fun showPhoneDialog() {
        QMUIDialog.MessageDialogBuilder(this)
                .setTitle("提示")
                .setMessage("400-820-5200")
                .addAction("拨打") { dialog, index ->
                    dialog.dismiss()
                    intent = Intent(Intent.ACTION_DIAL)
                    val data = Uri.parse("tel:${400-820-5200}")
                    intent.data = data
                    startActivity(intent)
                }
                .addAction("返回") { dialog, index -> dialog.dismiss() }
                .create(R.style.QMUI_Dialog).show()
    }
    /**
     * 带输入框的dialog
     */
    private fun showEditTextDialog() {
        val builder = QMUIDialog.EditTextDialogBuilder(this)
        builder.setTitle("价格")
        builder.setPlaceholder("在此输入价格")
        builder.setInputType(InputType.TYPE_CLASS_TEXT)
        builder.addAction("发送") { dialog, index ->
            val inputStr = builder.editText.text.toString()
            if (!TextUtils.isEmpty(inputStr)) {

                dialog.dismiss()
            } else {
                showToast("请输入价格")
            }
        }
        builder.addAction("取消") { dialog, index -> dialog.dismiss()}
        builder.create(R.style.QMUI_Dialog).show()

    }


}
