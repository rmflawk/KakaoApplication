package com.youngstudio.kakaoapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class ClickFragmentFirst extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    public static ImageView iv;

    // newInstance constructor for creating fragment with arguments
    public static ClickFragmentFirst newInstance(int page, String title) {
        ClickFragmentFirst fragment = new ClickFragmentFirst();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        fragment.setArguments(args);

        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        page = getArguments().getInt("someInt", 0);
//        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
//        EditText tvLabel = (EditText) view.findViewById(R.id.editText);
//        tvLabel.setText(page + " -- " + title);
        iv = view.findViewById(R.id.iv);

        Glide.with(this).load(ClickActivity.intent.getStringExtra("imgPath")).into(iv);

        //iv.setImageDrawable(ClickActivity.iv.getDrawable());


        return view;
    }
}