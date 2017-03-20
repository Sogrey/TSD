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

Or download aar [![Download](https://api.bintray.com/packages/sogrey/maven/TSD/images/download.svg) ](https://bintray.com/sogrey/maven/download_file?file_path=org%2Fsogrey%2FTSD%2F0.0.1%2Flock9view-0.0.1.aar)

> 其中：{lastVersion} 用上面 Download 徽章后面的版本号替换。

## Parts

### Toast管理 - T
### SnackBar管理 - S
### Dialog管理 - D
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

以上方法中出L.json(String)方法以外，还有两参方法，以`L.v()`为例：

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

