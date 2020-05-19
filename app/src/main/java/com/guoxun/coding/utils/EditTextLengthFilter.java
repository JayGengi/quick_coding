package com.guoxun.coding.utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;

import com.blankj.utilcode.util.ToastUtils;

/**
 * @des    限制输入框的输入字数 过滤器
 * @auther JayGengi
 * @data 2019/3/14 13:51
 * @email JayGengi@163.com
 */
public class EditTextLengthFilter implements InputFilter {

    private final int mMax;
    private Context context;

    public EditTextLengthFilter(int max, Context context) {
        mMax = max;
        this.context = context;
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                               int dstart, int dend) {
        int keep = mMax - (dest.length() - (dend - dstart));
        if (keep <= 0) {
            //这里，用来给用户提示
            ToastUtils.showShort("最多只能输入" + mMax + "个字符");
            return "";
        } else if (keep >= end - start) {
            return null; // keep original
        } else {
            keep += start;
            if (Character.isHighSurrogate(source.charAt(keep - 1))) {
                --keep;
                if (keep == start) {
                    return "";
                }
            }
            return source.subSequence(start, keep);
        }
    }

    /**
     * @return the maximum length enforced by this input filter
     */
    public int getMax() {
        return mMax;
    }
}
