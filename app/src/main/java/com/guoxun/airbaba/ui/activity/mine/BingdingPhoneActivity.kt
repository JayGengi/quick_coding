package com.guoxun.airbaba.ui.activity.mine

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.CountDownTimer
import android.view.View
import com.blankj.utilcode.util.RegexUtils
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.activity_bingding_phone.*

/**
  * @des    填写信息
  * @auther JayGengi
  * @data   2019/7/26  15:57
  * @email  jaygengiii@gmail.com
  */
class BingdingPhoneActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_bingding_phone
    }

    override fun initView() {

        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        get_code.setOnClickListener(this)
        call_service.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.call_service ->{
                showPhoneDialog()
            }
            R.id.get_code ->{
                //发送验证码
                if (!RegexUtils.isMobileExact(et_phone.text.toString())) {
                    showToast("请输入正确的手机号码")
                }else {
                    mTimer.start()
                }
            }
        }
    }
    override fun initData() {
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
                    val data = Uri.parse("tel:${13815707777}")
                    intent.data = data
                    startActivity(intent)
                }
                .addAction("返回") { dialog, index -> dialog.dismiss() }
                .create(R.style.QMUI_Dialog).show()
    }

    private val mTimer = object : CountDownTimer(60000, 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
            get_code.apply {
                text = (millisUntilFinished / 1000).toString() + "s后获取"
                isEnabled = false
                setBackgroundResource(R.drawable.common_textview_border_gray)
            }
        }

        override fun onFinish() {
            get_code.apply {
                text = "重新发送"
                isEnabled = true
                setBackgroundResource(R.drawable.common_textview_border_blue)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mTimer.cancel()
    }
}














