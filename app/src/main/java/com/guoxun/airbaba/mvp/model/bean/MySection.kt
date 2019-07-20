package com.guoxun.airbaba.mvp.model.bean

import com.chad.library.adapter.base.entity.SectionEntity

/**
 * @des    分组布局
 * @auther JayGengi
 * @data 2018/12/19 14:10
 * @email JayGengi@163.com
 */
class MySection : SectionEntity<MenuEntity> {
    var choose: Boolean = false

    constructor(isHeader: Boolean, header: String,choose:Boolean) : super(isHeader, header)

    constructor(t: MenuEntity) : super(t)
}

