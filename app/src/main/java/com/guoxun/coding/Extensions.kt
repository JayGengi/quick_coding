package com.guoxun.coding

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.guoxun.coding.utils.UserSession
import java.util.HashMap
import java.util.regex.Pattern

/**
 * Created by xuhao on 2017/11/14.
 */

fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(MyApplication.context, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}


fun View.dip2px(dipValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

fun View.px2dip(pxValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun durationFormat(duration: Long?): String {
    val minute = duration!! / 60
    val second = duration % 60
    return if (minute <= 9) {
        if (second <= 9) {
            "0$minute' 0$second''"
        } else {
            "0$minute' $second''"
        }
    } else {
        if (second <= 9) {
            "$minute' 0$second''"
        } else {
            "$minute' $second''"
        }
    }
}

/**
 * 数据流量格式化
 */
fun Context.dataFormat(total: Long): String {
    var result: String
    var speedReal: Int = (total / (1024)).toInt()
    result = if (speedReal < 512) {
        speedReal.toString() + " KB"
    } else {
        val mSpeed = speedReal / 1024.0
        (Math.round(mSpeed * 100) / 100.0).toString() + " MB"
    }
    return result
}

/**
 * 设置添加屏幕的背景透明度
 * @param bgAlpha
 * 屏幕透明度0.0-1.0 1表示完全不透明
 */
fun setBackgroundAlpha(act : Activity,bgAlpha: Float) {
    val lp = (act).window?.attributes
    if (lp != null) {
        lp.alpha = bgAlpha
    }
    (act).window!!.attributes = lp
}
/**
 * @des    正则判断密码(密码长度为6到12位)
 * @auther JayGengi
 * @data 2019/2/25 11:16
 * @email JayGengi@163.com
 */
fun checkPassword(password: String): Boolean {
    val passwordPattern = Pattern.compile(Constants.REGEX4)
    val matcher = passwordPattern.matcher(password)
    return matcher.matches()
}
fun getCommonMap(baseContext : Context): HashMap<String, Any> {
    val map = HashMap<String, Any>()
    map["id"] = UserSession.instance.getUId(baseContext)
    return map
}
fun EditText.setTextChangeListener(body: (key: String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            body(s.toString())
        }
    })
}




