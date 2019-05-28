package com.lin.mvp.simple03;


import com.lin.mvp.simple03.base.BasePresenter03;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author lin
 * 创建日期：2019/5/28 15
 * 描述：LoginPresenter
 */

//特点一 :持有M层引用
//特点一 :持有V层引用
//特点一 :对M层和V层进行关联
public class LoginPresenter03 extends BasePresenter03 {

    private LoginModule03 loginModule;

    public LoginPresenter03() {
        this.loginModule = new LoginModule03();
    }


    public void login(String userName, String passWord) {
        loginModule.login(userName, passWord, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (getLoginView() != null) {
                    getLoginView().onLoginCallbackFail(call, e);
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (getLoginView() != null) {
                    getLoginView().onLoginCallbackSuccess(call, response.body().string());
                }
            }
        });
    }
}
