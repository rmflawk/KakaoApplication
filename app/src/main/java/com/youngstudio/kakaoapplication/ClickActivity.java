package com.youngstudio.kakaoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ClickActivity extends AppCompatActivity {

    ImageView iv;
    TextView name,date,price,kt,nickname;
    EditText mainMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        name= findViewById(R.id.click_tv_name);
        nickname= findViewById(R.id.click_tv_nikname);
        date= findViewById(R.id.click_tv_date);
        price= findViewById(R.id.click_tv_price);
        mainMsg= findViewById(R.id.click_et_mainmsg);
        kt= findViewById(R.id.click_tv_kt);
        iv= findViewById(R.id.iv);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //액션바에 제목이 자동표시 되지 않도록
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent= getIntent();
        name.setText(intent.getStringExtra("name"));

        nickname.setText(intent.getStringExtra("nickname"));
        //name.setText(intent.getStringExtra("name"));

        date.setText(intent.getStringExtra("date"));
        mainMsg.setText(intent.getStringExtra("mainMsg"));
        price.setText(intent.getStringExtra("price"));
        kt.setText(intent.getStringExtra("kt")+ " - ");
        //kt.setText("aaa");

        Glide.with(this).load(intent.getStringExtra("imgPath")).into(iv);

        //iv에게 Transition(전환)의 Pair를 위한 이름 부여
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            iv.setTransitionName("IMG");
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionclick, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void clickChatting(View view) {
        Intent intent= new Intent(ClickActivity.this, FBChatActivity.class);
        startActivity(intent);
    }



}//ClickActivity
