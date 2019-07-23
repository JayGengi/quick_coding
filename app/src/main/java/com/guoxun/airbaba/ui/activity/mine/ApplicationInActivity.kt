package com.guoxun.airbaba.ui.activity.mine

import android.annotation.SuppressLint
import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import com.blankj.utilcode.util.RegexUtils
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.showToast
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.activity_application_in.*

/**
  * 申请入驻
  * @auther JayGengi
  * 2019/7/23  13:38
  * @email jaygengiii@gmail.com
  */
class ApplicationInActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_application_in
    }

    override fun initView() {

        mTopBar.setTitle("申请入驻")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }

        get_code.setOnClickListener(this)
        showSingleChoiceDialog()
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
//            R.id.phone_lay ->{
//                startActivity(Intent(this, PersonalDataActivity::class.java))
//            }
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

    private fun showSingleChoiceDialog() {
        val items = arrayOf("分公司", "商家","维修工")
        QMUIDialog.CheckableDialogBuilder(this)
//                .setCheckedIndex(checkedIndex)
                .addItems(items) { dialog, which ->
                    dialog.dismiss()
                    repair_person.text = items[which]
                }
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














