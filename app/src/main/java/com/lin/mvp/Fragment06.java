package com.lin.mvp;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lin.mvp.simple05.LoginPresenter05;
import com.lin.mvp.simple05.LoginView05;

import java.io.IOException;

import okhttp3.Call;

public class Fragment06 extends BaseFragment06<LoginView05, LoginPresenter05> implements LoginView05{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().login("lin", "123");
            }
        });
    }

    @Override
    public LoginPresenter05 createPresenter() {
        return new LoginPresenter05();
    }

    @Override
    public LoginView05 createView() {
        return this;
    }

    @Override
    public void onLoginCallbackFail(Call call, IOException e) {
        Log.d("---------lin---------", "onLoginCallbackFail");
    }

    @Override
    public void onLoginCallbackSuccess(Call call, String response) {
        Log.d("---------lin---------", "onLoginCallbackSuccess : " + response);
        Looper.prepare();
        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }
}
