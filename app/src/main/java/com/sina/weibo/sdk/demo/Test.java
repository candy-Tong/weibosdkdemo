package com.sina.weibo.sdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by candyTong on 2017/4/22.
 */

public class Test extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myself);
        LineItem item=(LineItem) findViewById(R.id.line_item);

        ImageView image = (ImageView) findViewById(R.id.myPicture);
        Glide.with(this).load(R.drawable.picture).transform(new GlideCircleTransform(this)).into(image);
    }
}
