package com.guoxun.airbaba.ui.fragment

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseFragment
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.ui.activity.mine.*
import com.guoxun.airbaba.ui.activity.mine.setting.SettingActivity
import kotlinx.android.synthetic.main.fragment_mine.*

/**
  *   个人中心
  * @auther JayGengi
  * 2019/7/22  14:26
  * @email jaygengiii@gmail.com
  */
class MineFragment : BaseFragment(), View.OnClickListener {

    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int= R.layout.fragment_mine

    override fun initView() {

        qrcode_lay.setOnClickListener(this)
        setting_lay.setOnClickListener(this)
        wallet.setOnClickListener(this)
        point.setOnClickListener(this)
        coupon.setOnClickListener(this)
        order_lay.setOnClickListener(this)
        order_o.setOnClickListener(this)
        order_t.setOnClickListener(this)
        order_th.setOnClickListener(this)
        order_f.setOnClickListener(this)
        mine_collection.setOnClickListener(this)
        mine_team.setOnClickListener(this)
        mine_apply.setOnClickListener(this)
    }

    override fun lazyLoad() {

    }

    override fun onClick(v: View?) {
        val bundle = Bundle()
        when(v!!.id) {
            //设置
            R.id.setting_lay ->{
                startActivity(Intent(context, SettingActivity::class.java))
            }
            //邀请码
            R.id.qrcode_lay ->{
                openQRCodePop()
            }
            //钱包
            R.id.wallet ->{
                startActivity(Intent(context, WalletActivity::class.java))
            }
            //积分
            R.id.point ->{
                startActivity(Intent(context, IntegralActivity::class.java))
            }
            //优惠券
            R.id.coupon ->{
                startActivity(Intent(context, CouponsActivity::class.java))
            }
            //我的订单
            R.id.order_lay ->{
                startActivity(Intent(context, MyOrderActivity::class.java))
            }
            //待付款
            R.id.order_o ->{
                bundle.putInt("position",1)
                startActivity(Intent(activity, MyOrderActivity::class.java).putExtras(bundle))
            }
            //待发货
            R.id.order_t ->{
                bundle.putInt("position",2)
                startActivity(Intent(activity, MyOrderActivity::class.java).putExtras(bundle))
            }
            //待收货
            R.id.order_th ->{
                bundle.putInt("position",3)
                startActivity(Intent(activity, MyOrderActivity::class.java).putExtras(bundle))
            }
            //待评价
            R.id.order_f ->{
                bundle.putInt("position",4)
                startActivity(Intent(activity, MyOrderActivity::class.java).putExtras(bundle))
            }
            //收藏
            R.id.mine_collection ->{
                startActivity(Intent(context, MyCollectionActivity::class.java))
            }
            //我的团队
            R.id.mine_team ->{
                startActivity(Intent(context, MyTeamActivity::class.java))
            }
            //申请入驻
            R.id.mine_apply ->{
                startActivity(Intent(context, ApplicationInActivity::class.java))
            }
//            R.id.smartRefreshLayout_url -> {
//                val intent = Intent(context, WebViewActivity::class.java)
//                intent.putExtra("title","SmartRefreshLayout")
//                intent.putExtra("url", "https://github.com/scwang90/SmartRefreshLayout")
//                startActivity(intent)
//            }
        }
    }
    /**
      *   邀请码
      * @auther JayGengi
      * 2019/7/22  14:32
      * @email jaygengiii@gmail.com
      */
    private fun openQRCodePop(){
        val popView : View = LayoutInflater . from (context).inflate(
                R.layout.window_my_qrcode, null)
        val rootView : RelativeLayout = popView.findViewById (R.id.my_qrcode_lay) // 當前頁面的根佈局
        val cancel : ImageView = popView.findViewById (R.id.cancel)
        val shareQrcode : TextView = popView.findViewById (R.id.share_qrcode)
        val popupWindow  = PopupWindow (popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        activity?.let { setBackgroundAlpha(it, 0.5f) }//设置屏幕透明度
        popupWindow.setBackgroundDrawable(ColorDrawable())
        popupWindow.isFocusable = true// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.CENTER , 0,0)
        popupWindow.setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            activity?.let { setBackgroundAlpha(it, 1f) }//设置屏幕透明度
        }
        cancel.setOnClickListener {
            popupWindow.dismiss()
        }

        shareQrcode.setOnClickListener {
            popupWindow.dismiss()
        }
    }



}