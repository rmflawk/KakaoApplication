package com.youngstudio.kakaoapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends BaseAdapter {

    ArrayList<ChatItem> messageItems;
    LayoutInflater layoutInflater;

    CircleImageView iv;
    TextView tvName;
    TextView tvMsg;
    TextView tvTime;



    public ChatAdapter(ArrayList<ChatItem> messageItems, LayoutInflater layoutInflater) {
        this.messageItems = messageItems;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return messageItems.size();
    }

    @Override
    public Object getItem(int position) {
        return messageItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //현재 보여줄 번째의 데이터로 뷰를 생성
        ChatItem item= messageItems.get(position);

        //재활용할 뷰는 사용하지 않음.
        View itemView=null;

        //메세지가 내 메시지인지?
        if(item.getName().equals(ChatG.nickName)){
            itemView= layoutInflater.inflate(R.layout.chat_my_msgbox,viewGroup,false);
        }else{
            itemView= layoutInflater.inflate(R.layout.chat_other_msgbox,viewGroup,false);
        }

        //만들어진 아이템뷰에 값들 설정
        iv= itemView.findViewById(R.id.iv);
        tvName= itemView.findViewById(R.id.tv_name);
        tvMsg= itemView.findViewById(R.id.tv_msg);
        tvTime= itemView.findViewById(R.id.tv_time);


        tvName.setText(item.getName());
        tvMsg.setText(item.getMessag());
        tvTime.setText(item.getTime());
        Glide.with(itemView).load(item.getProfileUrl()).into(iv);


        return itemView;
    }


}
