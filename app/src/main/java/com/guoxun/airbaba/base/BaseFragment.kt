package com.guoxun.airbaba.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.classic.common.MultipleStatusView
import com.hwangjr.rxbus.RxBus
import com.guoxun.airbaba.MyApplication
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
   * @description: Fragment基类
   * @author JayGengi
   * @date  2018/11/13 0013 上午 10:35
   * @email jaygengiii@gmail.com
   */

 abstract class BaseFragment: Fragment(){
    /**
     * 当前页数
     */
    var CURRENT_PAGE = 1
    /**
     * 每页容量- 每页有多少条记录
     */
    val PAGE_CAPACITY = 10
    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据是否加载过了
     */
    var hasLoadData = false
    /**
     * 多种状态的 View 的切换
     */
    protected var mLayoutStatusView: MultipleStatusView? = null

    private var mCompositeDisposable: CompositeDisposable? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),null)
    }



    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxBus.get().register(this)
        isViewPrepare = true
        initView()
        lazyLoadDataIfPrepared()
        //多种状态切换的view 重试点击事件
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    private fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        when {
            MultipleStatusView.STATUS_EMPTY == mLayoutStatusView?.viewStatus
                    || MultipleStatusView.STATUS_ERROR == mLayoutStatusView?.viewStatus
                    || MultipleStatusView.STATUS_NO_NETWORK == mLayoutStatusView?.viewStatus -> lazyLoad()
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
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId():Int

    /**
     * 初始化 ViewI
     */
    abstract fun initView()

    /**
     * 懒加载
     */
    abstract fun lazyLoad()

    override fun onDestroy() {
        super.onDestroy()
        RxBus.get().unregister(this)
        activity?.let { MyApplication.getRefWatcher(it)?.watch(activity) }
        unSubscribe()
    }


}
