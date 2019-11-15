package com.youngstudio.kakaoapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {

    RecyclerView recyclerView;
    ChattingAdapter adapter;
    ArrayList<Item> datas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        datas.add(new Item("당근이", "행당동 ~ 9월 18일", "파이님 지금이 바로 집 정리할 타이밍~!", R.drawable.one_ace));
        datas.add(new Item("양파야", "중구 약수동 ~ 3일전", "무료나눔합니당", R.drawable.bg_one01));
        datas.add(new Item("오이야", "성수1가제2동 ~ 7일전", "115,000원에 삽니다", R.drawable.bg_one02));
        datas.add(new Item("가지야", "황학동 ~ 10월8일", "얼마에 파시나요?", R.drawable.bg_one03));
        datas.add(new Item("당근이", "행당동 ~ 9월 18일", "파이님 지금이 바로 집 정리할 타이밍~!", R.drawable.one_ace));
        datas.add(new Item("양파야", "중구 약수동 ~ 3일전", "무료나눔합니당", R.drawable.bg_one01));
        datas.add(new Item("오이야", "성수1가제2동 ~ 7일전", "115,000원에 삽니다", R.drawable.bg_one02));
        datas.add(new Item("가지야", "황학동 ~ 10월8일", "얼마에 파시나요?", R.drawable.bg_one03));
        datas.add(new Item("당근이", "행당동 ~ 9월 18일", "파이님 지금이 바로 집 정리할 타이밍~!", R.drawable.one_ace));
        datas.add(new Item("양파야", "중구 약수동 ~ 3일전", "무료나눔합니당", R.drawable.bg_one01));
        datas.add(new Item("오이야", "성수1가제2동 ~ 7일전", "115,000원에 삽니다", R.drawable.bg_one02));
        datas.add(new Item("가지야", "황학동 ~ 10월8일", "얼마에 파시나요?", R.drawable.bg_one03));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_chatting, container, false);

        recyclerView = view.findViewById(R.id.recycler_chatting);
        adapter = new ChattingAdapter(datas, getActivity());
        recyclerView.setAdapter(adapter);

        //리사이클러뷰 구분선 추가
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerView.getContext(), new LinearLayoutManager(getActivity()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //setHasOptionsMenu(true);


        return view;
    }

}//Page1Fragmane