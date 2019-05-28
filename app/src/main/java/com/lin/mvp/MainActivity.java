package com.lin.mvp;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lin.mvp.sample01.LoginModule;
import com.lin.mvp.sample01.LoginPresenter;
import com.lin.mvp.sample01.LoginView;
import com.lin.mvp.sample02.LoginPresenter02;
import com.lin.mvp.sample02.LoginView02;
import com.lin.mvp.simple03.LoginPresenter03;
import com.lin.mvp.simple03.LoginView03;
import com.lin.mvp.simple04.LoginPresenter04;
import com.lin.mvp.simple04.LoginView04;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements LoginView04 {


    private LoginPresenter02 loginPresenter02;
    private LoginPresenter03 loginPresenter03;
    private LoginPresenter04 loginPresenter04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //mvp 第一阶段
//    public void login(View view) {
//        LoginPresenter loginPresenter = new LoginPresenter(this);
//        loginPresenter.login("lin", "123");
//    }
//
//    @Override
//    public void onLoginCallbackFail(Call call, IOException e) {
//        Log.d("---------lin---------", "onLoginCallbackFail");
//    }
//
//    @Override
//    public void onLoginCallbackSuccess(Call call, String response) {
//        Log.d("---------lin---------", "onLoginCallbackSuccess : " + response);
//        Looper.prepare();
//        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
//        Looper.loop();
//    }
//

    //mvp 第二阶段
//    public void login(View view) {
//        loginPresenter02 = new LoginPresenter02();
//        loginPresenter02.attachView(this);
//        loginPresenter02.login("lin", "123");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (loginPresenter02 != null) {
//            loginPresenter02.detachView();
//        }
//    }
//
//    @Override
//    public void onLoginCallbackFail(Call call, IOException e) {
//        Log.d("---------lin---------", "onLoginCallbackFail");
//    }
//
//    @Override
//    public void onLoginCallbackSuccess(Call call, String response) {
//        Log.d("---------lin---------", "onLoginCallbackSuccess : " + response);
//        Looper.prepare();
//        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
//        Looper.loop();
//    }


    //mvp 第三阶段
//    public void login(View view) {
//        loginPresenter03 = new LoginPresenter03();
//        loginPresenter03.attachView(this);
//        loginPresenter03.login("lin", "123");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (loginPresenter03 != null) {
//            loginPresenter03.detachView();
//        }
//    }
//
//    @Override
//    public void onLoginCallbackFail(Call call, IOException e) {
//        Log.d("---------lin---------", "onLoginCallbackFail");
//    }
//
//    @Override
//    public void onLoginCallbackSuccess(Call call, String response) {
//        Log.d("---------lin---------", "onLoginCallbackSuccess : " + response);
//        Looper.prepare();
//        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
//        Looper.loop();
//    }

    //mvp 第四阶段
    public void login(View view) {
        loginPresenter04 = new LoginPresenter04();
        loginPresenter04.attachView(this);
        loginPresenter04.login("lin", "123");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginPresenter04 != null) {
            loginPresenter04.detachView();
        }
    }

    @Override
    public void onLoginCallbackFail(Call call, IOException e) {
        Log.d("---------lin---------", "onLoginCallbackFail");
    }

    @Override
    public void onLoginCallbackSuccess(Call call, String response) {
        Log.d("---------lin---------", "onLoginCallbackSuccess : " + response);
        Looper.prepare();
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }
}
