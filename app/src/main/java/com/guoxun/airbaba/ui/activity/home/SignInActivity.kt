package com.guoxun.airbaba.ui.activity.home

import android.view.View
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.widget.calendar.CalendarEntity
import kotlinx.android.synthetic.main.activity_sign_in.*
import java.util.ArrayList

/**
  * @des    签到
  * @auther JayGengi
  * 2019/7/24  17:16
  * @email  jaygengiii@gmail.com
  */
class SignInActivity : BaseActivity(),View.OnClickListener{


    override fun layoutId(): Int {
        return R.layout.activity_sign_in
    }

    override fun initView() {

        mTopBar.setTitle("签到")
        mTopBar.addLeftBackImageButton().setOnClickListener { finish() }

        calendar_previous.setOnClickListener(this)
        calendar_next.setOnClickListener(this)
        tv_calendar_show.setOnClickListener(this)
        calendarView!!.setDateListener { year, month ->
            tv_calendar_show!!.text = String.format("%s 年 %s 月", year, month)
        }

        var item = CalendarEntity()
        val baseList = ArrayList<CalendarEntity>()
        item.data = "2019-07-12"
        item.is_sign = 1
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-07-23"
        item.is_sign = 1
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-07-24"
        item.is_sign = 2
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-07-25"
        item.is_sign = 1
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-08-12"
        item.is_sign = 2
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-08-13"
        item.is_sign = 1
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-08-14"
        item.is_sign = 1
        baseList.add(item)
        item = CalendarEntity()
        item.data = "2019-08-15"
        item.is_sign = 2
        baseList.add(item)
        calendarView.setSignRecords(baseList)
    }

    override fun start() {
        initData()
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.calendar_previous ->{
                calendarView.showPreviousMonth()
            }
            R.id.tv_calendar_show ->{
                calendarView!!.selectMonth(2019, 9)
            }
            R.id.calendar_next ->{
                calendarView.showNextMonth()
            }
        }
    }
    override fun initData() {
    }
}














