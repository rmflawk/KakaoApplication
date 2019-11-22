package com.youngstudio.kakaoapplication;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainFragmentAdapter extends RecyclerView.Adapter {

    ArrayList<Item> datas;
    Context context;

    public MainFragmentAdapter(ArrayList<Item> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_item_main, parent, false);

        VH vh= new VH(itemView);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


            VH vh = (VH) holder;

            Item item = datas.get(position);

            vh.tvName.setText(item.getName());
            vh.tvDate.setText(item.getDate());
            vh.tvPrice.setText(item.getPrice());

            //이미지가 너무크면 OOM(Out Of Memory)에러 발생
            //이를 방지하기 위해 Library(Picasso, Glide) 사용
            Glide.with(context).load(item.getImgPath()).into(vh.ivImg);


    }//onBindViewHolder

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //이너클래스 : 아이템뷰를 보관하는 클래스
    class VH extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDate;
        TextView tvPrice;
        ImageView ivImg;

        CardView ccc;

        LinearLayout main_layout;

        public VH(@NonNull View itemView) {
            super(itemView);

            ccc= itemView.findViewById(R.id.ccc);
            main_layout= itemView.findViewById(R.id.main_layout);
            ivImg= itemView.findViewById(R.id.main_iv);
            tvName= itemView.findViewById(R.id.main_tv_name);
            tvDate= itemView.findViewById(R.id.main_tv_date);
            tvPrice= itemView.findViewById(R.id.main_tv_price);

            //아이템뷰 클릭리스너
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= getLayoutPosition();
                    //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

                    //상세화면(DetailActivity)에 넘겨줄 데이터들

                    String name= datas.get(position).name;
                    String nickname= datas.get(position).nickname;
                    String email= datas.get(position).email;
                    String date= datas.get(position).date;
                    String mainMsg= datas.get(position).mainMsg;
                    String price= datas.get(position).price;
                    String imgPath= datas.get(position).imgPath;
                    String kt= datas.get(position).kt;
                    String address= datas.get(position).address;

                    MainActivity.chatRoomName= nickname;


                    //아이템의 상세 화면(ClickActivity)로 전환
                    Intent intent= new Intent(context, ClickActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("nickname", nickname);
                    intent.putExtra("email", email);
                    intent.putExtra("date", date);
                    intent.putExtra("mainMsg", mainMsg);
                    intent.putExtra("price", price);
                    intent.putExtra("imgPath", imgPath);
                    intent.putExtra("kt", kt);
                    intent.putExtra("address",address);


                    //액티비티 전화시 효과(api21버전 이상에서만 가능)
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

                        ActivityOptions opts= ActivityOptions.makeSceneTransitionAnimation((MainActivity)context, new Pair<View, String>(ivImg, "IMG"));
                        context.startActivity(intent, opts.toBundle());
                    }else{
                        context.startActivity(intent);
                    }
                }
            });




        }
    }

}

