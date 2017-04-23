package com.sina.weibo.sdk.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by candyTong on 2017/4/16.
 */

public class LineItem extends RelativeLayout{

    Context mContext;
    RelativeLayout layout;
    TextView mTextView;
    ImageView mIconImageView;
    View mDivLineView ;

    public LineItem(Context context) {
        this(context, null);
    }

    public LineItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        LayoutInflater.from(context).inflate(R.layout.item_line, this, true);
        mTextView = (TextView) findViewById(R.id.text_item);
        mIconImageView = (ImageView) findViewById(R.id.image_item);
        mDivLineView = findViewById(R.id.view_item);


        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.LineItem, defStyle, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.LineItem_text:
                    setTitle(typedArray.getString(attr));
                    break;
                case R.styleable.LineItem_rightimage:
                    setIcon(typedArray.getResourceId(attr, 0));
                    break;
                case R.styleable.LineItem_showView:
                    setDivLineVisiable(typedArray.getBoolean(attr, false));
                    break;
            }
        }

        typedArray.recycle();
    }

    public void setTitle(String title) {
        mTextView.setText(title);
    }

    public void setIcon(int resId) {
        if (resId == 0) return;
        mIconImageView.setImageResource(resId);
    }

    public void setDivLineVisiable(boolean isVisiable) {
        if (isVisiable) {
            mDivLineView.setVisibility(VISIBLE);
        } else {
            mDivLineView.setVisibility(GONE);
        }
    }

    /*    this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.layout = (RelativeLayout) this.mInflater.inflate(R.layout.item_line, this, true);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LineItem);
        MidContent = (TextView)this.layout.findViewById(R.id.tv_desc);

//        this.MidContent.setText(array.getString(R.styleable.LineItem_midcontent));
*/
 //       array.recycle();

}
