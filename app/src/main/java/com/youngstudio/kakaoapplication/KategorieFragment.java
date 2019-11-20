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

    Button digital,gagu,child,life,woman,beauty,man,sport,game;

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


        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent(getActivity(), MainActivity.class);
                //intent.putExtra("kt","디지털/가전");
                //MainFragmentAdapter.n=100;
                MainActivity.kt="디지털/가전";
                MainActivity.pager.setCurrentItem(0);
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
                MainActivity.pager.setCurrentItem(0);
                MainFragment.btn.performClick();

            }
        });

        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.kt="유아동/유아도서";
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
                //intent.addFlags(Intent.FLAG)



            }
        });

        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
            }
        });

        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
            }
        });

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(0);
                //MainFragmentAdapter.n=100;
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
