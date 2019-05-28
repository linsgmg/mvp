package com.lin.mvp.simple03.base;

import com.lin.mvp.simple03.LoginView03;

/**
 * @author lin
 * 创建日期：2019/5/28 16
 * 描述：BasePresenter03
 */
public abstract class BasePresenter03 {

    private LoginView03 loginView;

    public LoginView03 getLoginView() {
        return loginView;
    }

    public void attachView(LoginView03 loginView) {
        this.loginView = loginView;
    }

    public void detachView() {
        this.loginView = null;
        //终止请求
    }
}
