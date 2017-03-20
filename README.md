# TSD
Toast Snackbar Dialog Log





## Parts

### Log日志管理 - L

#### steps 1. 初始化

	L.init(BuildConfig.DEBUG);//最先调用，传入参数 boolean，true允许输出日志，false则否，可传入Application Moudel的BuildConfig.DEBUG，不建议使用 Library Moudel的BuildConfig.DEBUG，因为Library Moudel编译后的BuildConfig.DEBUG恒为false。

#### steps 2. 代码使用

    L.v("测试日志");
    L.d("测试日志");
    L.i("测试日志");
    L.w("测试日志");
    L.e("测试日志");
    L.wtf("测试日志");
    String json = "{\"token\":\"XXXXXXXXXXXtokanXXXXXXXXX\",\"result\":\"1\",\"msg\":\"nulls\"}";
    L.json(json);

![log](pic/log/log1.png)

以上方法中出L.json(String)方法以外，还有两参方法，以`L.v()`为例：

    L.v("My name is %s","Sogrey");

![log](pic/log/log2.png)

