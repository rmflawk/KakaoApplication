package com.youngstudio.kakaoapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ChattingAdapter extends RecyclerView.Adapter {

    ArrayList<Item> datas;
    Context context;

    public ChattingAdapter(ArrayList<Item> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_item_chatting, parent, false);

        VH vh= new VH(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ChattingAdapter.VH vh= (ChattingAdapter.VH)holder;

        Item item= datas.get(position);

        vh.tvMsg1.setText(item.name);
        vh.tvMsg2.setText(item.date);
        vh.tvMsg3.setText(item.subName);

        //이미지가 너무크면 OOM(Out Of Memory)에러 발생
        //이를 방지하기 위해 Library(Picasso, Glide) 사용
        Glide.with(context).load(item.img).into(vh.ivImg);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //이너클래스 : 아이템뷰를 보관하는 클래스
    class VH extends RecyclerView.ViewHolder{

        TextView tvMsg1;
        TextView tvMsg2;
        TextView tvMsg3;
        ImageView ivImg;

        public VH(@NonNull View itemView) {
            super(itemView);

            ivImg= itemView.findViewById(R.id.page4_iv_img);
            tvMsg1= itemView.findViewById(R.id.page4_tv_msg1);
            tvMsg2= itemView.findViewById(R.id.page4_tv_msg2);
            tvMsg3= itemView.findViewById(R.id.page4_tv_msg3);

            //아이템뷰 클릭리스너
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= getLayoutPosition();
                    Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

                    //상세화면에 넘겨줄 데이터들
                    String msg1= datas.get(position).name;
                    String msg2= datas.get(position).date;
                    String msg3= datas.get(position).subName;
                    String imgId= datas.get(position).imgPath;

                    //채팅 상세 화면으로 전환
                    Intent intent= new Intent();
                    //intent.putExtra("msg1", msg1);
                    //intent.putExtra("msg2", msg2);
                    //intent.putExtra("msg3", msg3);
                    //intent.putExtra("Img", imgId);

                    //액티비티 전화시 효과(api21버전 이상에서만 가능)
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//                        ActivityOptions opts= ActivityOptions.makeSceneTransitionAnimation((MainActivity)context, new Pair<View, String>(ivImg, "IMG"));
//                        context.startActivity(intent, opts.toBundle());
//                    }else{
//                        context.startActivity(intent);
//                    }



                }
            });

        }
    }

}
