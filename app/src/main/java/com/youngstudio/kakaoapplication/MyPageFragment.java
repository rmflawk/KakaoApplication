package com.youngstudio.kakaoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyPageFragment extends Fragment {


    LinearLayout layout;
    Button profile;
    CircleImageView circle_iv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        layout= view.findViewById(R.id.mypage_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        profile= view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        circle_iv= view.findViewById(R.id.circle_iv);
        circle_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        return view;

    }


}//MyPageFragment


//    //위 onCreateView가 실행된 후 자동 실행되는 메소드
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
////        //리스트뷰의 아이템을 클릭하면...
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
////                Toast.makeText(getActivity(), datas.get(position), Toast.LENGTH_SHORT).show();
////            }
////        });
//    }

