package com.lin.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.lin.mvp.simple05.base05.BasePresenter05;
import com.lin.mvp.simple05.base05.BaseView05;

public abstract class BaseFragment06<V extends BaseView05,P extends BasePresenter05<V>> extends Fragment {
    private V view;
    private P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "111", Toast.LENGTH_SHORT).show();
        if (view!=null&&presenter!=null){
            presenter.detachView();
        }
    }

    public abstract P createPresenter();
    public abstract V createView();
}
