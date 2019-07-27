package com.guoxun.airbaba.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.CountDownTimer
import android.view.View
import com.blankj.utilcode.util.RegexUtils
import com.blankj.utilcode.util.StringUtils
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.db.User
import com.guoxun.airbaba.mvp.contract.LoginContract
import com.guoxun.airbaba.mvp.contract.SendLineContract
import com.guoxun.airbaba.mvp.presenter.LoginPresenter
import com.guoxun.airbaba.mvp.presenter.SendLinePresenter
import com.guoxun.airbaba.showToast
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.activity_login.*
import org.litepal.LitePal
import java.util.HashMap

/**
  * @des    登录
  * @auther JayGengi
  * @data   2019/7/26  15:57
  * @email  jaygengiii@gmail.com
  */
class LoginActivity : BaseActivity(),LoginContract.View, SendLineContract.View,View.OnClickListener{
    private val mPresenter by lazy { LoginPresenter() }
    private val sendLinePresenter by lazy { SendLinePresenter() }
    init {
        mPresenter.attachView(this)
        sendLinePresenter.attachView(this)
    }


    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mLayoutStatusView = multipleStatusView
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }
        get_code.setOnClickListener(this)
        call_service.setOnClickListener(this)
        login.setOnClickListener(this)
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
                if (!RegexUtils.isMobileSimple(et_phone.text.toString())) {
                    showToast("请输入正确的手机号码")
                }else {
                    val map = HashMap<String, Any>()
                    map["username"] = et_phone.text.toString()
                    sendLinePresenter.requestSendLineInfo(map)
                }
            }
            R.id.login ->{
                if(checkInfo()){
                    //登录
                    val map = HashMap<String, Any>()
                    map["username"] = et_phone.text.toString()
                    map["linecode"] = et_code.text.toString()
                    map["invitationcode"] = invite_code.text.toString()
                    map["reg_source"] = 2//	注册来源 2安卓 3苹果
                    mPresenter.requestLoginInfo(map)
                }
            }
        }
    }
    private fun checkInfo(): Boolean {
        if(StringUtils.isEmpty(et_phone.text.toString())){
            showToast("请输入11位手机号码")
            return false
        }else if(StringUtils.isEmpty(et_code.text.toString())){
            showToast("请输入验证码")
            return false
        }else if(!hide_radius_none.isChecked){
            showToast("请阅读并同意《用户协议》和《用户隐私政策》")
            return false
        }


        return true
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
    override fun showSendLineInfo(dataInfo: String) {
        showToast(dataInfo)
    }

    override fun showLoginInfo(dataInfo: User) {
        // 清除数据库
        LitePal.deleteAll(User::class.java)
        dataInfo.save()
        finish()
    }

    override fun showError(msg: String, errorCode: Int) {
        showToast(msg)
    }
    /**
     * 显示 Loading
     */
    override fun showLoading() {
        mLayoutStatusView?.showLoading()
    }
    /**
     * 隐藏 Loading
     */
    override fun dismissLoading() {
        mLayoutStatusView?.dismissLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
        sendLinePresenter.detachView()
        mTimer.cancel()
    }
}














