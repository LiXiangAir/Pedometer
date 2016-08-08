package com.example.lixiang.pedometer;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private LinearLayout ll_home;
    private LinearLayout ll_address;
    private LinearLayout ll_friend;
    private LinearLayout ll_setting;

    private ImageView iv_home;
    private ImageView iv_address;
    private ImageView iv_friend;
    private ImageView iv_setting;

    private TextView tv_home;
    private TextView tv_address;
    private TextView tv_friend;
    private TextView tv_setting;

    private ViewPager viewPager;

    private ContentAdapter adapter;

    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
    }

    private void initEvent() {
        ll_home.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_setting.setOnClickListener(this);

        viewPager.setOnPageChangeListener(this);
    }

    private void initView(){
        this.ll_home = (LinearLayout)findViewById(R.id.ll_home);
        this.ll_address = (LinearLayout)findViewById(R.id.ll_address);
        this.ll_friend = (LinearLayout)findViewById(R.id.ll_friend);
        this.ll_setting = (LinearLayout)findViewById(R.id.ll_setting);

        this.iv_home = (ImageView)findViewById(R.id.iv_home);
        this.iv_address = (ImageView)findViewById(R.id.iv_address);
        this.iv_friend = (ImageView)findViewById(R.id.iv_friend);
        this.iv_setting = (ImageView)findViewById(R.id.iv_setting);

        this.tv_home = (TextView)findViewById(R.id.tv_home);
        this.tv_address = (TextView)findViewById(R.id.tv_address);
        this.tv_friend = (TextView)findViewById(R.id.tv_friend);
        this.tv_setting = (TextView)findViewById(R.id.tv_setting);

        this.viewPager = (ViewPager)findViewById(R.id.vp_content);

        View page_01 = View.inflate(MainActivity.this, R.layout.page_01, null);
        View page_02 = View.inflate(MainActivity.this, R.layout.page_02, null);
        View page_03 = View.inflate(MainActivity.this, R.layout.page_03, null);
        View page_04 = View.inflate(MainActivity.this, R.layout.page_04, null);

        this.views = new ArrayList<View>();
        views.add(page_01);
        views.add(page_02);
        views.add(page_03);
        views.add(page_04);

        this.adapter = new ContentAdapter(this.views);
        viewPager.setAdapter(this.adapter);
    }

    @Override
    public void onClick(View v) {
        restartButton();
        switch (v.getId())
        {
            case R.id.ll_home:
                tv_home.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_address:
                tv_address.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_friend:
                tv_friend.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_setting:
                tv_setting.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    private void restartButton() {
        tv_home.setTextColor(0xffffffff);
        tv_address.setTextColor(0xffffffff);
        tv_friend.setTextColor(0xffffffff);
        tv_setting.setTextColor(0xffffffff);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        restartButton();
        switch (position)
        {
            case 0:
                tv_home.setTextColor(0xff1B940A);
                break;
            case 1:
                tv_address.setTextColor(0xff1B940A);
                break;
            case 2:
                tv_friend.setTextColor(0xff1B940A);
                break;
            case 3:
                tv_setting.setTextColor(0xff1B940A);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
