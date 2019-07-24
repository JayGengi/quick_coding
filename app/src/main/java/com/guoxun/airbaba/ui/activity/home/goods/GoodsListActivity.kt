package com.guoxun.airbaba.ui.activity.home.goods

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.showToast
import com.guoxun.airbaba.ui.adapter.home.GoodsListAdapter
import com.guoxun.airbaba.widget.GridSpacingItemDecoration
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton
import kotlinx.android.synthetic.main.activity_home_message.multipleStatusView
import kotlinx.android.synthetic.main.activity_goods_list.*
import com.guoxun.airbaba.window.GoodsScreenWindow
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet



/**
  * 商品列表
  * @auther JayGengi
  * 2019/7/19 0019 下午 4:37
  * @email jaygengiii@gmail.com
  */
class GoodsListActivity : BaseActivity() ,View.OnClickListener{
    private var baseList = ArrayList<String>()

    private var rightButton : QMUIAlphaImageButton? = null

    //true一行两个 false 一行一个
    private var isHorizontal : Boolean = true
    private var mAdapter= GoodsListAdapter(R.layout.item_goods,baseList)

    private var popupWindow: GoodsScreenWindow? = null
//    private val mPresenter by lazy { FansListPresenter() }
//
//    init {
//        mPresenter.attachView(this)
//    }
    override fun layoutId(): Int {
        return R.layout.activity_goods_list
    }

    override fun initView() {
        mLayoutStatusView = multipleStatusView
        //目的是为了透明状态栏 ps:QMUI适配的沉浸状态栏，问题根源在这套架构找不到，死办法解决
//        mBaseLayout.visibility = View.GONE
        mTopBar.setBackgroundColor(ContextCompat.getColor(this,R.color.tl_textSelectColor))
        mTopBar.addLeftImageButton(R.mipmap.ic_back_nor,R.id.right).setOnClickListener {
            finish()
        }
        //TopBar定制View
        val view = LayoutInflater.from(this).inflate(R.layout.common_topbar_search, null)
        mTopBar.setCenterView(view)
        val searchTitle = view.findViewById<EditText>(R.id.srarch_title)
        searchTitle.hint = "唇膏"

        searchTitle.setOnEditorActionListener { arg0, arg1, arg2 ->
            if (arg1 == EditorInfo.IME_ACTION_UNSPECIFIED) {
                showToast(searchTitle.text.toString())
            }
            false
        }

        rightButton = mTopBar.addRightImageButton(R.mipmap.ic_horizontal_nor,R.id.right)
        rightButton?.apply {
            setOnClickListener {
                if(isHorizontal){
                    isHorizontal = false
                    rightButton!!.setImageResource(R.mipmap.ic_horizontal_nor)
                    mAdapter = GoodsListAdapter(R.layout.item_goods_hor,baseList)
                }else{
                    isHorizontal = true
                    rightButton!!.setImageResource(R.mipmap.ic_select_nor)
                    mAdapter = GoodsListAdapter(R.layout.item_goods,baseList)
                }
                mAdapter.notifyDataSetChanged()
            }
        }

        refreshLayout.setOnRefreshListener {
            CURRENT_PAGE = 1
            initData()
        }
        refreshLayout.setOnLoadMoreListener {
            CURRENT_PAGE++
            initData()
        }
        recycler.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(GridSpacingItemDecoration(5,5,true))
            adapter = mAdapter
        }
        baseList.clear()
        baseList.add("1")
        baseList.add("2")
        baseList.add("3")
        mAdapter.setNewData(baseList)

        /**
         * OnItemClickListener
         * */
        mAdapter.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(this, GoodsDetailsActivity::class.java))
        }
        /**
         * OnItemChildClickListener
         * */
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
//            val item : FansListEntity.ListBean = adapter.getItem(position) as FansListEntity.ListBean
            when(view.id){
                R.id.share_goods ->
                    showSimpleBottomSheetGrid()
            }
        }

        zonghe.setOnClickListener(this)
        xiaoliang.setOnClickListener(this)
        jiage.setOnClickListener(this)
        shaixuan.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }

    override fun initData() {
//        val map = HashMap<String, Any>()
//        map["user_id"] = LitePal.findFirst(User::class.java).user_id
//        map["p"] = CURRENT_PAGE
//        mPresenter.requestFansListInfo(map)
    }
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("RtlHardcoded")
    override fun onClick(v: View) {
        when(v.id){
            R.id.zonghe ->{
            }
            R.id.xiaoliang ->{
            }
            R.id.jiage ->{
            }
            R.id.shaixuan ->{
                openPop()
//                dlShow.openDrawer(Gravity.RIGHT)
//                startActivity(Intent(this, ActivityMessageActivity::class.java))
                //PopWindow只初始化
//                if (popupWindow == null) {
//                    popupWindow = GoodsScreenWindow(this)
//                }
//                popupWindow!!.setBackgroundDrawable(ColorDrawable())
//                popupWindow!!.showAsDropDown(zonghe)
//                popupWindow!!.showAsDropDown(layoutInflater.inflate(R.layout.activity_goods_list, null), Gravity.RIGHT, 0, 500)
            }
        }
    }
//    override fun onBackPressed() {
//        if (popupWindow!=null && popupWindow!!.isShowing) {
//            popupWindow!!.dismiss()
//        } else {
//            super.onBackPressed()
//        }
//    }
    private fun showSimpleBottomSheetGrid() {
        val TAG_SHARE_WECHAT_FRIEND = 0
        val TAG_SHARE_WECHAT_MOMENT = 1
        val TAG_SHARE_WEIBO = 2
        val TAG_SHARE_CHAT = 3
        val TAG_SHARE_LOCAL = 4
        QMUIBottomSheet.BottomGridSheetBuilder(this)
                .addItem(R.mipmap.ic_friendsshare_nor, "分享好友", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_savethepicture_nor, "保存图片", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_copythexink_nor, "复制链接", TAG_SHARE_WEIBO, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_akeyring_nor, "一键发圈", TAG_SHARE_CHAT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
//                .addItem(R.mipmap.ic_launcher, "保存到本地", TAG_SHARE_LOCAL, QMUIBottomSheet.BottomGridSheetBuilder.SECOND_LINE)
                .setOnSheetItemClickListener { dialog, itemView ->
                    dialog.dismiss()
                    val tag = itemView.tag as Int
                    when (tag) {
                        TAG_SHARE_WECHAT_FRIEND -> Toast.makeText(this, "分享到微信", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_WECHAT_MOMENT -> Toast.makeText(this, "分享到朋友圈", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_WEIBO -> Toast.makeText(this, "分享到微博", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_CHAT -> Toast.makeText(this, "分享到私信", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_LOCAL -> Toast.makeText(this, "保存到本地", Toast.LENGTH_SHORT).show()
                    }
                }
                .build().show()
    }

    /** 弹出底部对话框 */
    private fun openPop(){
        val popView : View = LayoutInflater . from (this).inflate(
                R.layout.window_good_screen, null)
        val rootView : LinearLayout = popView.findViewById (R.id.goods_screen) // 當前頁面的根佈局
        val reset : TextView = popView.findViewById (R.id.reset)
        val confirm : TextView = popView.findViewById (R.id.confirm)
        val popupWindow  = PopupWindow (popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setBackgroundAlpha(this, 0.5f)//设置屏幕透明度
        popupWindow.setBackgroundDrawable(ColorDrawable())
        popupWindow.isFocusable = true// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.END , 0,0)
        popupWindow.setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            setBackgroundAlpha(this, 1f)//设置屏幕透明度
        }
        reset.setOnClickListener {
            popupWindow.dismiss()
        }

        confirm.setOnClickListener {
            popupWindow.dismiss()
        }
    }
    /**
     * @des    RxBus订阅事件[解耦]
     * @auther JayGengi
     * @data 2018/12/7 12:00
     * @email JayGengi@163.com
     */
//    @Subscribe
//    fun wrapPopEvent(event: WrapPopWindowEvent) {
//        if (event.choose) {
//            //根据popWindow选中的数据显示相对应的页面
//
//        } else {
//
//        }
//    }
//    override fun showFansListInfo(dataInfo: FansListEntity) {
//        multipleStatusView?.showContent()
//        mAdapter.run {
//            if ((dataInfo.lists!=null && dataInfo.lists!!.isNotEmpty()) || CURRENT_PAGE>1) {
//                if (CURRENT_PAGE == 1) {
//                    baseList.clear()
//                }
//                refreshLayout.isEnableLoadMore = dataInfo.lists!!.size == PAGE_CAPACITY
//                baseList.addAll(dataInfo.lists!!)
//                setNewData(baseList)
//            } else {
//                multipleStatusView?.showEmpty()
//            }
//        }
//    }
//    override fun showError(msg: String, errorCode: Int) {
//        mLayoutStatusView?.dismiss()
//        if (errorCode == ErrorStatus.NETWORK_ERROR) {
//            multipleStatusView?.showNoNetwork()
//        } else {
//            showToast(msg)
//        }
//    }
//    /**
//     * 显示 Loading
//     */
//    override fun showLoading() {
//        mLayoutStatusView?.showLoading()
//    }
//
//    /**
//     * 隐藏 Loading
//     */
//    override fun dismissLoading() {
//        mLayoutStatusView?.dismiss()
//        if(refreshLayout!=null && refreshLayout.isRefreshing){
//            refreshLayout.finishRefresh()
//        }
//        if(refreshLayout!=null && refreshLayout.isLoading){
//            refreshLayout.finishLoadMore()
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter.detachView()
//    }
}
