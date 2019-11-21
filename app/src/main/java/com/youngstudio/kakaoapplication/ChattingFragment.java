package com.youngstudio.kakaoapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {

    RecyclerView recyclerView;
    ChattingFragmentAdapter adapter;
    ArrayList<Item> datas = new ArrayList<>();

    public FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference databaseReference = firebaseDatabase.getReference();

    public static ListView chat_list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        datas.add(new Item("당근이", "행당동 ~ 9월 18일", "파이님 지금이 바로 집 정리할 타이밍~!", R.drawable.one_ace));
//        datas.add(new Item("양파야", "중구 약수동 ~ 3일전", "무료나눔합니당", R.drawable.bg_one01));
//        datas.add(new Item("오이야", "성수1가제2동 ~ 7일전", "115,000원에 삽니다", R.drawable.bg_one02));
//        datas.add(new Item("가지야", "황학동 ~ 10월8일", "얼마에 파시나요?", R.drawable.bg_one03));
//        datas.add(new Item("당근이", "행당동 ~ 9월 18일", "파이님 지금이 바로 집 정리할 타이밍~!", R.drawable.one_ace));
//        datas.add(new Item("양파야", "중구 약수동 ~ 3일전", "무료나눔합니당", R.drawable.bg_one01));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_chatting, container, false);

        chat_list = view.findViewById(R.id.chat_list);

        showChatList();

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swiperefresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                showChatList();
                Toast.makeText(getActivity(), "새로고침", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        chat_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });


        //recyclerView = view.findViewById(R.id.recycler_chatting);
        //adapter = new ChattingFragmentAdapter(datas, getActivity());
        //recyclerView.setAdapter(adapter);

        //리사이클러뷰 구분선 추가
        //DividerItemDecoration dividerItemDecoration =
        //        new DividerItemDecoration(recyclerView.getContext(), new LinearLayoutManager(getActivity()).getOrientation());
        //recyclerView.addItemDecoration(dividerItemDecoration);

        //setHasOptionsMenu(true);


        return view;


    }

    public void showChatList() {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1);
        chat_list.setAdapter(adapter);

        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        databaseReference.child("chat").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Log.e("LOG", "dataSnapshot.getKey() : " + dataSnapshot.getKey());
                adapter.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }





}//Page1Fragmane