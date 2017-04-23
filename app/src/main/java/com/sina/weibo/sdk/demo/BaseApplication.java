package com.sina.weibo.sdk.demo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.bumptech.glide.request.target.ViewTarget;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;

import java.io.File;

import static android.content.ContentValues.TAG;

/**
 * Created by candyTong on 2017/4/23.
 */

public class BaseApplication extends Application {

    private static Context context;
    private static Oauth2AccessToken mAccessToken;

    public static Oauth2AccessToken getmAccessToken() {
        return mAccessToken;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
        initData();
        ViewTarget.setTagId(R.id.glide_tag);
    }

    public void initData(){
        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        Log.i(TAG, "initData: "+mAccessToken);

    }
}
