package com.lin.mvp.simple05.base05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity<V extends BaseView05,P extends BasePresenter05<V>> extends Activity {
    private V view;
    private P presenter;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (view==null){
            view=createView();
        }
        if (presenter==null){
            presenter=createPresenter();
        }
        if (view!=null&&presenter!=null){
            presenter.attachView(view);
        }
    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
        if (view!=null&&presenter!=null){
            presenter.detachView();
        }
    }

    public abstract P createPresenter();
    public abstract V createView();
}
