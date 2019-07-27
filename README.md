# 空气巴巴

#### 项目介绍
空气巴巴

#### 软件架构
软件架构说明

#### 目录结构
├── .gradle
├── .idea
├── app.main.java.package
│   ├── api                 配置请求地址
│   ├── base                base基类封装
│   ├── glide               图片加载框架
│   ├── net                 网络请求框架配置
│   ├── rx                  rxjava配置
│   ├── mvp
│   │    └── contract       view和presenter实现方法接口
│   │    └── model          数据加载层
│   │    └── presenter      逻辑处理层（数据加载页面显示）
│   ├── ui
│   │    └── activity       activity
│   │    └── adapter        适配器
│   │    └── fragment       fragment
│   ├── utils               工具类
│   ├── view                view控件
│   ├── Constants.kt        全局常量
│   ├── Extensions.kt       扩展函数
│   ├── MyApplication.kt    Application
├── build
├── gradle
├── build.gradle



#### 使用说明
TODO [lazy,loading,placeholder]
1.添加屏幕适配方案（smallestWidth 限定符适配方案）[res/values-sw***dp]

2.添加 BRVAH BaseQuickAdapter 官方简述地址：<a href="#">https://www.jianshu.com/p/b343fcff51b0</a>

3.普通列表请求后的逻辑判断[暂无封装(包含刷新、加载更多、空数据页面、异常页面)] ps:multiple-status-view

4.添加blankj 常用Utils库[比如：ToastUtils] github：<a href="#">https://github.com/Blankj/AndroidUtilCode</a>
        工具类介绍用法大全：https://github.com/Blankj/AndroidUtilCode/blob/master/lib/utilcode/README-CN.md

5.添加仿IOS侧滑关闭 TODO

6.列表关于page rows 使用基类的 {[CURRENT_PAGE] [PAGE_CAPACITY]}

7.整理gradle依赖，config.gradle,各lib引用版本统一管理[ps:目前没有多lib,需要管理sdk和support版本号] [TODO]

8.普通列表请求view使用IView Interface

9.加载框已在multiple-status-view中添加 [从QMUI中抽离的]

BaseQuickAdapter item点击事件
                                sample:

                /**
                 * OnItemClickListener
                 * */
                mAdpater!!.setOnItemClickListener { adapter, view, position ->
                    TODO sthing
                }

                item 子控件点击事件
                1.先在适配器中[LiveAdapter]添加控件点击Listener
                 helper.addOnClickListener(R.id.iv_cover)
                2.接着在[LiveFragment]中实现监听事件
                 /**
                 * tOnItemChildClickListener
                 * */
                mAdpater!!.setOnItemChildClickListener{ adapter, view, position ->
                    when(view.id ){
                        R.id.id -> TODO sthing
                    }
                }

10.ZXing (https://www.jianshu.com/p/73e2a0eeaa44)
    生成二维码图片方式，createImage()方法最后一个参数传图片就让二维码带有图标。
        String codeStr = etInput.getText().toString();
        Bitmap bitmap = CodeUtils.createImage(codeStr,200,200,null);
        ivShow.setImageBitmap(bitmap);

    启动默认扫描界面，启动库自带CaptureActivity类：(自定义扫描界面 MyCaptureActivity)
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent,REQUEST_CODE);

    在Activity的onActivityResult方法中接收扫描结果
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == REQUEST_CODE){
                if(null != data){
                    Bundle bundle = data.getExtras();
                    if(bundle == null){
                        return;
                    }

                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

11. 金额过滤器

        val filters = arrayOf<InputFilter>(CashierInputFilter())
        editText.filters = filters

12.限制输入框的输入字数 过滤器
        editText.filters = arrayOf<InputFilter>(EditTextLengthFilter(8, context))

13.[Bugly集成]
    手动集成添加lib包和so库
    在appliction中初始化即可
    //Bugly初始化
    CrashReport.initCrashReport(context, BUGLY_APP_ID, false)

14.[JPush集成]
    jar包：jcore-android.1.x.x.jar（极光开发者服务的核心包）
           jpush-android-3.x.y.jar（JPush SDK 开发包）
    so包：libjcore1xx.so（各种 CPU 类型的 native 开发包）

    配置 AndroidManifest.xml
        JPushRequired标记部分

    混淆
    -dontoptimize
    -dontpreverify
    -dontwarn cn.jpush.**
    -keep class cn.jpush.** { *; }
    -keep class * extends cn.jpush.android.helpers.JPushMessageReceiver { *; }
    -dontwarn cn.jiguang.**
    -keep class cn.jiguang.** { *; }

    代码(utils/jpush)
    init 初始化 SDK (Application)
    JPushInterface.setDebugMode(true)  设置调试模式
    JPushInterface.init(this)

    别名与标签设置
    // 这是来自 JPush Example 的设置别名的 Activity 里的代码。一般 App 的设置的调用入口，在任何方便的地方调用都可以。
    ·设置成功时，往 SharePreference 里写状态，以后不必再设置
    ·遇到 6002 超时，则稍延迟重试。
    /**
         * 使用uid设置标签
         */
        private fun setAlias(){

            if(userId != tagAlias){
                mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS))
            }
        }

        private var mHandler: Handler = Handler {
            if(it.what == MSG_SET_ALIAS){
                // 调用 JPush 接口来设置别名。
                JPushInterface.setAliasAndTags(applicationContext,userId.toString(),null, TagAliasCallback { code, alias, mutableSet ->

                    when(code){
                        0 -> {
                            // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                            tagAlias = userId
                        }
                        6002 -> {
                            // 延迟 30 秒来调用 Handler 设置别名
                            delayRest()
                        }
                    }

                })
            }
            false
        }

        private fun delayRest(){
            mHandler.sendEmptyMessageDelayed(MSG_SET_ALIAS,1000*30)
        }