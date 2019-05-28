package com.lin.mvp.simple05;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lin
 * 创建日期：2019/5/28 15
 * 描述：LoginModule
 */
public class LoginModule05 {
//    public static final String URL_LOGIN = "http://192.168.10.210:3000/users";
    public static final String URL_LOGIN = "http://www.baidu.com";

    public void login(String userName, String passWord, final Callback callback){

        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(URL_LOGIN)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                //json数据格式解析, 数据库操作, 文件操作
                callback.onResponse(call,response);
            }
        });
    }
}
