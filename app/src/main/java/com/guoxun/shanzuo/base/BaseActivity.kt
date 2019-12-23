package com.guoxun.shanzuo.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.LinearLayout
import com.classic.common.MultipleStatusView
import com.hwangjr.rxbus.RxBus
import com.guoxun.shanzuo.MyApplication
import com.guoxun.shanzuo.R
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.qmuiteam.qmui.widget.QMUITopBar
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_base.*
import me.imid.swipebacklayout.lib.SwipeBackLayout
import me.imid.swipebacklayout.lib.Utils
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper


/**
   * @description: BaseActivity基类
   * @author JayGengi
   * @date  2018/10/29 0029 上午 11:57
   * @email jaygengiii@gmail.com
   */
abstract class BaseActivity : AppCompatActivity(), SwipeBackActivityBase {
    /**
     * 当前页数
     */
    var CURRENT_PAGE = 1
    /**
     * 每页容量- 每页有多少条记录
     */
    val PAGE_CAPACITY = 10
    private lateinit var mRootView: LinearLayout
    /**
     * 多种状态的 View 的切换
     */
    protected var mLayoutStatusView: MultipleStatusView? = null
    /**
     * 顶部标题栏
     */
    protected lateinit var mTopBar: QMUITopBar
    /**
     * 父布局
     */
    protected lateinit var mBaseLayout: LinearLayout
    private var tipDialog: QMUITipDialog? = null
    private var mCompositeDisposable: CompositeDisposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHelper = SwipeBackActivityHelper(this)
        mHelper.onActivityCreate()
        RxBus.get().register(this)
        initContentView(R.layout.activity_base)
        setContentView(layoutId())
        mTopBar = base_topbar
        mBaseLayout = base_layout
        QMUIStatusBarHelper.translucent(this)
//        QMUIStatusBarHelper.setStatusBarLightMode(this)
        //状态栏上边距 ex:先这么滴吧...
//        AppUtils.setMargins(mTopBar,0,QMUIStatusBarHelper.getStatusbarHeight(context),0,0)
        AppManager.addActivity(this)

        initView()
        initData()
//        start()
        initListener()


    }
    private lateinit var mHelper: SwipeBackActivityHelper
    /**
     * SwipeBack Enable
     */
    open fun enableSwipeBack(): Boolean = true
    /**
     * 初始化 SwipeBack
     */
    private fun initSwipeBack() {
        setSwipeBackEnable(enableSwipeBack())
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT)
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mHelper.onPostCreate()
    }

    override fun getSwipeBackLayout(): SwipeBackLayout {
        return mHelper.swipeBackLayout
    }

    override fun setSwipeBackEnable(enable: Boolean) {
        swipeBackLayout.setEnableGesture(enable)
    }

    override fun scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this)
        swipeBackLayout.scrollToFinishActivity()
    }
    private fun initContentView(@LayoutRes layoutResID: Int) {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        viewGroup.removeAllViews()
        mRootView = LinearLayout(this)
        mRootView.orientation = LinearLayout.VERTICAL
        //  ic_image_add mRoot_view in viewGroup
        viewGroup.addView(mRootView)
        //  ic_image_add the activity_home_search.layout of BaseActivity in mRoot_view
        LayoutInflater.from(this).inflate(layoutResID, mRootView, true)
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        //  added the sub-activity activity_home_search.layout id in mRoot_view
        LayoutInflater.from(this).inflate(layoutResID, mRootView, true)
    }
    private fun initListener() {
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        when {
            MultipleStatusView.STATUS_EMPTY == mLayoutStatusView?.viewStatus
                    || MultipleStatusView.STATUS_ERROR == mLayoutStatusView?.viewStatus
                    || MultipleStatusView.STATUS_NO_NETWORK == mLayoutStatusView?.viewStatus -> start()
        }

    }
    /**
     * 显示加载中视图
     */
    fun showLoading() {
        tipDialog = QMUITipDialog.Builder(this)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create()
        tipDialog!!.show()
        //        showLoading(mLoadingViewResId, DEFAULT_LAYOUT_PARAMS);
    }
    /**
     * 隐藏 Loading
     */
    public fun dismissLoading(refreshLayout : SmartRefreshLayout?) {
        dismiss()
        if (refreshLayout != null && refreshLayout.isRefreshing) {
            refreshLayout.finishRefresh()
        }
        if (refreshLayout != null && refreshLayout.isLoading) {
            refreshLayout.finishLoadMore()
        }
    }
    /**
     * dissmiss
     */
    fun dismiss() {
        if (tipDialog != null) {
            tipDialog!!.dismiss()
        }
    }
    /**
     * RxJava 添加订阅者
     */
    fun addSubscribe(subscription: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(subscription)
    }

    /**
     * RxJava 解除所有订阅者
     */
    fun unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.dispose()
            mCompositeDisposable!!.clear()
            mCompositeDisposable = CompositeDisposable()
        }
    }

    /**
     *  加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()

    /**
     * 开始请求
     */
    abstract fun start()

    override fun onDestroy() {
        super.onDestroy()
        RxBus.get().unregister(this)
        MyApplication.getRefWatcher(this)?.watch(this)
        AppManager.removeActivity(this)
        unSubscribe()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

}


