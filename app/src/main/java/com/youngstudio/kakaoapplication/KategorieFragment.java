package com.youngstudio.kakaoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class KategorieFragment  extends Fragment {

    Button digital,gagu,child,life,woman,beauty,man,sport,game,book,pat,guitar,buy,car;

    String a = null;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R .layout.fragment_kategorie,container,false);
        //setHasOptionsMenu(true);


        digital= view.findViewById(R.id.digital);
        gagu= view.findViewById(R.id.gagu);
        child= view.findViewById(R.id.child);
        life= view.findViewById(R.id.life);
        woman= view.findViewById(R.id.woman);
        beauty= view.findViewById(R.id.beauty);
        man= view.findViewById(R.id.man);
        sport= view.findViewById(R.id.sport);
        game= view.findViewById(R.id.game);

        book= view.findViewById(R.id.book);
        pat= view.findViewById(R.id.pat);
        guitar= view.findViewById(R.id.guitar);
        buy= view.findViewById(R.id.buy);
        car= view.findViewById(R.id.car);


        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent(getActivity(), MainActivity.class);
                //intent.putExtra("kt","디지털/가전");
                //MainFragmentAdapter.n=100;
                MainActivity.kt="디지털/가전";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
                //startActivity(intent);
//                Fragment fragment = new MyPageFragment(); // Fragment 생성
//                Bundle bundle = new Bundle(); // 파라미터는 전달할 데이터 개수
//                bundle.putString("a", a); // key , value
//                fragment.setArguments(bundle);
            }
        });
        gagu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent(getActivity(), MainActivity.class);
                //intent.putExtra("kt","가구/인테리어");
                //MainFragmentAdapter.n=100;
                MainActivity.kt="가구/인테리어";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
                //MainFragment.btn.performClick();

            }
        });

        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="유아동/유아도서";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
                //MainFragmentAdapter.n=100;
                //intent.addFlags(Intent.FLAG)
            }
        });

        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="생활/가공식품";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="여성의류/잡화";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="뷰티미용";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="남성패션/잡화";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="스포츠/레저";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="게임/취미";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="도서/티켓/음반";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="반려동물용품";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        guitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="기타중고물품";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="중고차/오토바이";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="삽니다";
                MainActivity.i=1;
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().invalidateOptionsMenu();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        //inflater.inflate(R.menu.option2, menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



}
