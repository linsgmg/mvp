package com.lin.mvp.simple04;

import com.lin.mvp.simple04.base02.BaseView;
import com.lin.mvp.simple04.base02.BaseView02;

import java.io.IOException;

import okhttp3.Call;

/**
 * @author lin
 * 创建日期：2019/5/28 15
 * 描述：LoginView
 */

//UI层回调接口
public interface LoginView04 extends BaseView {
    void onLoginCallbackFail(Call call, IOException e);
    void onLoginCallbackSuccess(Call call, String response);
}
