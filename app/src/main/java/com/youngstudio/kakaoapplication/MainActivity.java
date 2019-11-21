package com.youngstudio.kakaoapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    public static ViewPager pager;
    public static MainAdapter adapter;

    public static BottomNavigationView navigationView;
    public static TextView main_tv;
    public static ImageView main_iv;
    public static AppBarLayout appBarLayout;
    public static Toolbar toolbar;
    public static String getName;
    public static String getEmail;
    public static String getProfile;
    public static String getGender;
    public static String kt="kt";
    public static String ChatRoomName;
    public static String ChatUserName;

    public static int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getName= getIntent().getStringExtra("name");
        getEmail= getIntent().getStringExtra("email");
        getProfile= getIntent().getStringExtra("profile");
        getGender= getIntent().getStringExtra("gender");

        ChatUserName = getName;
        //ChatG.profileUrl= getProfile;

        //Toast.makeText(this, ChatG.nickName + ChatG.profileUrl + getProfile + getGender , Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, getName + getEmail , Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ChatUserName + "님 환영합니다" , Toast.LENGTH_SHORT).show();


//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        main_tv= findViewById(R.id.main_tv);
        main_iv= findViewById(R.id.main_iv);
        appBarLayout= findViewById(R.id.appbarlayout);

        navigationView= findViewById(R.id.bnv);

        //액션바에 제목이 자동표시 되지 않도록
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        pager = findViewById(R.id.pager);
        adapter = new MainAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        //FragmentTransaction transaction= fragmentManager.beginTransaction();
        //transaction.replace(R.id.relativelayout,page1Fragment).commitAllowingStateLoss();

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                //Toast.makeText(MainActivity.this, position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position)
            {
                //navigationView.getMenu().getItem(position).setChecked(true);
                switch (position) {
                    case 0:
                        //MainActivity.main_tv.setText("도선동");
                        MainActivity.main_iv.setVisibility(View.VISIBLE);
                        MainActivity.appBarLayout.setVisibility(View.VISIBLE);
                        navigationView.getMenu().getItem(position).setChecked(true);
                        break;

                    case 1:
                        //MainActivity.main_tv.setText("카테고리");
                        MainActivity.main_iv.setVisibility(View.GONE);
                        MainActivity.appBarLayout.setVisibility(View.GONE);
                        navigationView.getMenu().getItem(position).setChecked(true);
                        break;

                    case 2:
                        MainActivity.main_iv.setVisibility(View.GONE);
                        MainActivity.appBarLayout.setVisibility(View.GONE);
                        navigationView.getMenu().getItem(position).setChecked(true);
                        break;
                    case 3:
                        MainActivity.main_iv.setVisibility(View.GONE);
                        MainActivity.appBarLayout.setVisibility(View.GONE);
                        navigationView.getMenu().getItem(position).setChecked(true);
                        break;
//                    case 4:
//                        MainActivity.main_iv.setVisibility(View.GONE);
//                        MainActivity.appBarLayout.setVisibility(View.GONE);
//                        navigationView.getMenu().getItem(position).setChecked(true);
//                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

        //getHashKey();

    }//onCreate


    public void clickMap(View view) {
        Intent intent= new Intent(MainActivity.this, MapActivity.class);
        startActivityForResult(intent,10);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10){
            if(resultCode == RESULT_OK){
                main_tv.setText(data.getStringExtra("array1") + " "+ data.getStringExtra("array2")); // 현재위치 구 와 동까지 나옴

            }else{
                Toast.makeText(this, "결과값이 없습니다.", Toast.LENGTH_SHORT).show();
                //MapActivity m= new MapActivity();

            }
        }

    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.bnv_aa:
                    //MainActivity.main_tv.setText("도선동");
                    MainActivity.main_iv.setVisibility(View.VISIBLE);
                    MainActivity.appBarLayout.setVisibility(View.VISIBLE);
                    //transaction.replace(R.id.relativelayout, page1Fragment).commitAllowingStateLoss();
                    pager.setCurrentItem(0,true);
                    //Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.bnv_bb:
                    //MainActivity.main_tv.setText("카테고리");
                    MainActivity.main_iv.setVisibility(View.GONE);
                    MainActivity.appBarLayout.setVisibility(View.GONE);
                    //transaction.replace(R.id.relativelayout, page2Fragment).commitAllowingStateLoss();
                    pager.setCurrentItem(1,true);
                    break;

                case R.id.bnv_cc:
                    MainActivity.main_iv.setVisibility(View.GONE);
                    MainActivity.appBarLayout.setVisibility(View.GONE);
                    pager.setCurrentItem(2,true);
                    break;
                case R.id.bnv_dd:
                    MainActivity.main_iv.setVisibility(View.GONE);
                    MainActivity.appBarLayout.setVisibility(View.GONE);
                    pager.setCurrentItem(3,true);
                    break;
                case R.id.bnv_ee:
                    MainActivity.main_iv.setVisibility(View.GONE);
                    MainActivity.appBarLayout.setVisibility(View.GONE);
                    Intent intent= new Intent(MainActivity.this, WritingActivity.class);
                    intent.putExtra("nickname",getName);
                    intent.putExtra("email",getEmail);
                    intent.putExtra("email",getProfile);
                    startActivity(intent);
                    break;
            }
            return true;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }



}//MainActivity.class





//    public void initView(){
//        pager= (ViewPager)findViewById(R.id.pager);
//        navigationView= (BottomNavigationView)findViewById(R.id.bnv);
//
//        listFragment= new ArrayList<>();
//        listFragment.add(new Page1Fragment());
//        listFragment.add(new Page2Fragment());
//        listFragment.add(new Page3Fragment());
//        adapter= new MainAdapter(getSupportFragmentManager(),this,listFragment);
//        pager.setAdapter(adapter);
//
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.bnv_aa:
//                        pager.setCurrentItem(0);
//                        return  true;
//                    case R.id.bnv_bb:
//                        pager.setCurrentItem(1);
//                        return  true;
//                    case R.id.bnv_cc:
//                        pager.setCurrentItem(2);
//                        return  true;
//                    default:
//                        break;
//                }
//
//                return false;
//            }
//        });
//
//        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                navigationView.getMenu().getItem(position).setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.option, menu);
//        return true;
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.option, menu);
//        return true;
//    }

