# TSD
Toast Snackbar Dialog Log

[![Travis](https://img.shields.io/badge/License-Apache2.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Twitter](https://img.shields.io/badge/Gradle-3.3-brightgreen.svg)](https://gradle.org/releases)
[![Platform](https://img.shields.io/badge/platform-Android-green.svg?style=flat)](https://www.android.com)
[![API](https://img.shields.io/badge/API-9%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=9)
[![Download](https://api.bintray.com/packages/sogrey/maven/TSD/images/download.svg)](https://bintray.com/sogrey/maven/TSD/_latestVersion)

## JavaDoc

click me -> [Doc](https://sogrey.github.io/JavaDocs/TSD)

## How to use

Add dependency to your gradle file:

    compile 'org.sogrey:TSD:{lastVersion}'

Or maven:

    <dependency>
      <groupId>org.sogrey</groupId>
      <artifactId>TSD</artifactId>
      <version>{lastVersion}</version>
      <type>pom</type>
    </dependency>

Or download aar [![Download](https://api.bintray.com/packages/sogrey/maven/TSD/images/download.svg) ](https://bintray.com/sogrey/maven/download_file?file_path=org%2Fsogrey%2FTSD%2F0.0.2%2FTSD-0.0.2.aar)

> 其中：{lastVersion} 用上面 Download 徽章后面的版本号替换。

## Parts

### Toast管理 - T

两种创建方式：

#### plan 1 直接new

	Tt  st = new Tt(this, "Updating profile", Toast.LENGTH_LONG);
		st.setBackgroundColor(Color.parseColor("#ff5a5f"));
		st.setTextColor(Color.WHITE);
		st.setIcon(R.drawable.ic_autorenew_black_24dp);
		st.spinIcon();
		st.setMaxAlpha();
		st.show();

#### plan 2 Builder模式

	Tt stBuilder = new Tt.Builder(this, "Turn off fly mode")
		.withGravity(Gravity.TOP)
		.withBackgroundColor(Color.parseColor("#865aff"))
		.withIcon(R.drawable.ic_airplanemode_inactive_black_24dp)
		.withMaxAlpha()
		.build();
	stBuilder.show();

or

	new Tt.Builder(this, "Turn off fly mode")
		.withGravity(Gravity.TOP)
		.withBackgroundColor(Color.parseColor("#865aff"))
		.withIcon(R.drawable.ic_airplanemode_inactive_black_24dp)
		.withMaxAlpha()
		.show();

![Toast](https://github.com/Sogrey/TSD/blob/master/pics/toast/toast1.png?raw=true)
![Toast](https://github.com/Sogrey/TSD/blob/master/pics/toast/toast2.png?raw=true)
![Toast](https://github.com/Sogrey/TSD/blob/master/pics/toast/toast3.png?raw=true)
![Toast](https://github.com/Sogrey/TSD/blob/master/pics/toast/toast4.png?raw=true)


### SnackBar管理 - S

#### SnackBar

	SnackBar mSnackBar = new SnackBar.Builder(this)
		.withOnClickListener(this)
		.withMessage(message) //传参String
		//.withMessageId(messageRes) // 传参ID
		.withActionMessage("Action") //传参String 可无
		//.withActionMessageId(R.string.action) // 传参ID 可无
		.withStyle(style)
		.withBackgroundColorId(bgColor)
		.withDuration(duration)
		.show();

![MaterialDialog](https://github.com/Sogrey/TSD/blob/master/pics/dialog/snackBar1.png?raw=true)


### Dialog管理 - D

#### plan 1 -  MaterialDialog

	MaterialDialog mMaterialDialog = new MaterialDialog(this)
		.setTitle("MaterialDialog")
		.setMessage("Hello world!")
		.setPositiveButton("OK", new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMaterialDialog.dismiss();
			}
		})
		.setNegativeButton("CANCEL", new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMaterialDialog.dismiss();
			}
		});

        mMaterialDialog.show();

	// You can change the message anytime. before show
        mMaterialDialog.setTitle("提示");
        mMaterialDialog.show();
	// You can change the message anytime. after show
        mMaterialDialog.setMessage("你好，世界~");

![MaterialDialog](https://github.com/Sogrey/TSD/blob/master/pics/dialog/dialog1.png?raw=true)

#### plan 1 -  LoadingDialog

        loadingDialog = new LoadingDialog();
        loadingDialog.handlerStart(this, "", "正在加载数据...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.handlerUpdate("", "正在加载模型结构文件...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.handlerStop("");
                    }
                }, 2000);
            }
        }, 2000);


![MaterialDialog](https://github.com/Sogrey/TSD/blob/master/pics/dialog/LoadingDialog.gif?raw=true)


### Log日志管理 - L

#### steps 1. 初始化

	L.init(BuildConfig.DEBUG);

最先调用，传入参数 boolean，true允许输出日志，false则否，可传入Application Moudel的BuildConfig.DEBUG，不建议使用 Library Moudel的BuildConfig.DEBUG，因为Library Moudel编译后的BuildConfig.DEBUG恒为false。

#### steps 2. 代码使用

    L.v("测试日志");
    L.d("测试日志");
    L.i("测试日志");
    L.w("测试日志");
    L.e("测试日志");
    L.wtf("测试日志");
    String json = "{\"token\":\"XXXXXXXXXXXtokanXXXXXXXXX\",\"result\":\"1\",\"msg\":\"nulls\"}";
    L.json(json);

![log](https://github.com/Sogrey/TSD/blob/master/pics/log/log1.png?raw=true)

以上方法中除L.json(String)方法以外，还有两参方法，以`L.v()`为例：

    L.v("My name is %s","Sogrey");

![log](https://github.com/Sogrey/TSD/blob/master/pics/log/log2.png?raw=true)



## License

    Copyright 2016-2017 Sogrey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

