# web-start-app
网页吊起app案例
最近做的工作有个需求，通过网页链接点击吊起app，由于以前没有做过所以百度了一下，还是不少介绍的，这里只是简单自己记录下。

想要打开app吊起页面，需要给activity配置intentfilter如下：

```
<activity
 android:name=".MainActivity"
 android:label="@string/app_name" >
<intent-filter>
 <action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
<intent-filter>
<action android:name="android.intent.action.VIEW"/>
<category android:name="android.intent.category.DEFAULT"/>
<category  android:name="android.intent.category.BROWSABLE"/>
<data   android:host="www.test.com" android:scheme="test"/>
</intent-filter>
```
使用的测试地址为：test://www.test.com?name=zhangsan&id=001
配置的intent-filter 中scheme为协议，如http,https ，host为主机地址
？后面为携带数据，mainActivity中代码如下

```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null){
            String name = data.getQueryParameter("name");
            String id = data.getQueryParameter("id");
            Toast.makeText(this,"name="+name+"-------id="+id,Toast.LENGTH_LONG).show();
        }
    }
```
这样获取到的name =zhansan ,id=001
贴下网页代码

```
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试</title>
</head>
<body>
<br/>
<a href="test://www.test.com?name=zhangsan&id=001">启动app</a><br/>
<br/>
</html>
