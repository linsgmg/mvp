package com.lin.mvp.simple04.base02;


/**
 * @author lin
 * 创建日期：2019/5/28 16
 * 描述：BasePresenter03
 */
public abstract class BasePresenter04<T extends BaseView> {

    private T View;

    public T getView() {
        return View;
    }

    public void attachView(T View) {
        this.View = View;
    }

    public void detachView() {
        this.View = null;
        //终止请求
    }
}
