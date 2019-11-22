package com.youngstudio.kakaoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import me.relex.circleindicator.CircleIndicator;

public class ClickActivity extends AppCompatActivity {

    public static ImageView iv;
    TextView name,date,price,kt,nickname,map;
    EditText mainMsg;

    FragmentPagerAdapter adapterViewPager;

    ViewPager vpPager;
    CircleIndicator indicator;

    public static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        vpPager = findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        indicator =  findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);


        name= findViewById(R.id.click_tv_name);
        nickname= findViewById(R.id.click_tv_nikname);
        date= findViewById(R.id.click_tv_date);
        price= findViewById(R.id.click_tv_price);
        mainMsg= findViewById(R.id.click_et_mainmsg);
        map= findViewById(R.id.click_tv_map);
        kt= findViewById(R.id.click_tv_kt);
        iv= findViewById(R.id.iv);

        //Toolbar toolbar= findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //액션바에 제목이 자동표시 되지 않도록
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        intent= getIntent();
        name.setText(intent.getStringExtra("name"));
        map.setText(intent.getStringExtra("address"));
        nickname.setText(intent.getStringExtra("nickname"));
        date.setText(intent.getStringExtra("date"));
        mainMsg.setText(intent.getStringExtra("mainMsg"));
        price.setText(intent.getStringExtra("price"));
        kt.setText(intent.getStringExtra("kt")+ " - ");
        //kt.setText("aaa");


        //Toast.makeText(this, intent.getStringExtra("imgPath"), Toast.LENGTH_SHORT).show();

        Glide.with(this).load(intent.getStringExtra("imgPath")).into(iv);

        //Drawable dra= iv.getDrawable();
        //ClickFragmentFirst.iv.setImageDrawable(dra);

        //ClickFragmentFirst.iv.setImageResource(R.drawable.bg_one10);




        //iv에게 Transition(전환)의 Pair를 위한 이름 부여
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            iv.setTransitionName("IMG");
//        }

        //String name= intent.getStringExtra("name");
        //String date= intent.getStringExtra("date");
        //String mainMsg= intent.getStringExtra("mainMsg");
        //String price= intent.getStringExtra("price");
        //String imgPath= intent.getStringExtra("imgPath");

        //int imgId= intent.getIntExtra("Img", R.drawable.bg_one01);

        //name을 액션바에 title로 설정
        //getSupportActionBar().setTitle(name);

        //imgId를 이미지뷰에 보여주기
        //iv= findViewById(R.id.iv);
        //Glide.with(this).load(intent.getStringExtra("imgPath")).into(iv);


    }//onCreate

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ClickFragmentFirst.newInstance(0, "Page # 1");
                case 1:
                    return ClickFragmentSecond.newInstance(1, "Page # 2");
                case 2:
                    return ClickFragmentThird.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }












    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionclick, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void clickChatting(View view) {
        Intent intent= new Intent(ClickActivity.this, FBChatActivity.class);
        //intent.putExtra("chatName",intent.getStringExtra("nickname"));
        intent.putExtra("chatName", MainActivity.chatRoomName);
        intent.putExtra("userName", MainActivity.chatUserName);
        startActivity(intent);
    }



}//ClickActivity
