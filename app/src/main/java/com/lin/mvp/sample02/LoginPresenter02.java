package com.lin.mvp.sample02;

import com.lin.mvp.sample01.LoginModule;
import com.lin.mvp.sample01.LoginView;

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
public class LoginPresenter02 {

    private LoginModule02 loginModule;
    private LoginView02 loginView;

    public LoginPresenter02() {
        this.loginModule = new LoginModule02();
    }

    public void attachView(LoginView02 loginView){
        this.loginView = loginView;
    }
    public void detachView(){
        this.loginView = null;
        //终止请求
    }

    public void login(String userName,String passWord){
        loginModule.login(userName, passWord, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                loginView.onLoginCallbackFail(call,e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                loginView.onLoginCallbackSuccess(call,response.body().string());
            }
        });
    }
}
