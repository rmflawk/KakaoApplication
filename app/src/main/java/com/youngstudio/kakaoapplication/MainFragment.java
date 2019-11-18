package com.youngstudio.kakaoapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainFragment extends Fragment {//implements View.OnClickListener {


    RecyclerView recyclerView;
    MainFragmentAdapter adapter;
    ArrayList<Item> datas = new ArrayList<>();

    Button btn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 외부저장소 권한 동적퍼미션
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int permissionResult= getActivity().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if(permissionResult == PackageManager.PERMISSION_DENIED){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},10);
            }
        }

    }//onCreate


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = view.findViewById(R.id.recycler_main);
        adapter = new MainFragmentAdapter(datas, getActivity());
        recyclerView.setAdapter(adapter);

        //리사이클러뷰 구분선 추가
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerView.getContext(), new LinearLayoutManager(getActivity()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //setHasOptionsMenu(true);


        btn= view.findViewById(R.id.btn);

        //btn.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Toast.makeText(getActivity(), "UpLoad", Toast.LENGTH_SHORT).show();

                //서버주소
                String serverUrl="http://rmflawkdk.dothome.co.kr/Android/loadDBtoJson.php";

                //결과를 JsonArray받을 것이므로...
                //StringRequest가 아니라...
                //JsonArrayRequest를 이용할 것임
                JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.POST, serverUrl, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                        //파라미터로 응답받은 결과 JsonArray를 분석

                        datas.clear();
                        adapter.notifyDataSetChanged();

                        try {
                            for(int i=0; i<response.length(); i++){
                                JSONObject jsonObject= response.getJSONObject(i);

                                int no= Integer.parseInt( jsonObject.getString("no") );

                                String nickname= jsonObject.getString("nickname");
                                String email= jsonObject.getString("email");

                                String name= jsonObject.getString("name");
                                String msg= jsonObject.getString("message");
                                String price= jsonObject.getString("price");
                                String kt= jsonObject.getString("kt");
                                String imgPath= jsonObject.getString("imgPath");
                                String date= jsonObject.getString("date");


                                //이미지 경로의 경우 서버IP가 제외된 주소이므로(uploads/xxxxx.jpg) 바로 사용 불가.
                                imgPath = "http://rmflawkdk.dothome.co.kr/Android/"+imgPath;

                                datas.add( 0 , new Item(no, nickname, email, name, price, kt, date, msg, imgPath) );
                                adapter.notifyItemInserted(0);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                    }
                });

                //실제 요청작업을 수행해주는 요청큐 객체 생성
                RequestQueue requestQueue= Volley.newRequestQueue(getActivity());

                //요청큐에 요청객체 추가
                requestQueue.add(jsonArrayRequest);
            }
        });

        final SwipeRefreshLayout swipeRefreshLayout= view.findViewById(R.id.swiperefresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                btn.performClick();
                Toast.makeText(getActivity(), "새로고침", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        btn.performClick();
        return view;
    }

//    @Override
//    public void onClick(View view) {
//
//        Toast.makeText(getActivity(), "aaa", Toast.LENGTH_SHORT).show();
//    }


}//MainFragmane



//        bnv = view.findViewById(R.id.bnv);
//        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                //원래는 보통 아이템을 클릭할 때마다
//                //Fragment는 변경하는 것이 일반적임.
//                switch (item.getItemId()) {
//                    case R.id.bnv_aa:
//                        Toast.makeText(getActivity(), "aa", Toast.LENGTH_SHORT).show();
//                        //findViewById(R.id.recycler).setBackgroundColor(Color.CYAN);
//                        break;
//                    case R.id.bnv_bb:
//                        Toast.makeText(getActivity(), "bb", Toast.LENGTH_SHORT).show();
//                        //findViewById(R.id.recycler).setBackgroundColor(Color.MAGENTA);
//                        break;
//                    case R.id.bnv_cc:
//                        Toast.makeText(getActivity(), "cc", Toast.LENGTH_SHORT).show();
//                        //findViewById(R.id.recycler).setBackgroundColor(Color.GREEN);
//                        break;
//                    case R.id.bnv_dd:
//                        Toast.makeText(getActivity(), "dd", Toast.LENGTH_SHORT).show();
//                        //findViewById(R.id.recycler).setBackgroundColor(Color.BLACK);
//                        break;
//                }
//                //리턴값이 true가 아니면 동작하지 않음
//                return true;
//            }
//        });



//    //위 onCreateView가 실행된 후 자동 실행되는 메소드
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        getActivity().invalidateOptionsMenu();
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.option, menu);
//
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu_a:
//                Toast.makeText(getActivity(), "menu aa", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menu_b:
//                Toast.makeText(getActivity(), "menu bb", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menu_c:
//                Toast.makeText(getActivity(), "menu cc", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }




//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        super.onOptionsItemSelected(item);
//        return false;
//    }
//
//
//    @Override
//    public void onPrepareOptionsMenu(@NonNull Menu menu) {
//        super.onPrepareOptionsMenu(menu);
//    }

//        datas.add(new Item("망가진 우산 삽니다", "행당동 ~ 9월 18일", "10,000원", R.drawable.one_ace));
//        datas.add(new Item("삼성 c타입 충전기 케이블", "중구 약수동 ~ 3일전", "무료나눔", R.drawable.bg_one01));
//        datas.add(new Item("100만원으로 본체 2개삽니다", "성수1가제2동 ~ 7일전", "115,000원", R.drawable.bg_one02));
//        datas.add(new Item("커피머신기 패키지로 삽니다", "황학동 ~ 10월8일", "", R.drawable.bg_one03));
//        datas.add(new Item("버즈 화이트 삽니다", "금호동4가 ~ 9월26일", "40,000원", R.drawable.bg_one04));
//        datas.add(new Item("서울 왕십리 버즈 실버 삽니다", "용두동 ~ 9월25일", "250,000원", R.drawable.bg_one05));
//        datas.add(new Item("온누리 상품권 삽니다", "동대문구 전농동 ~ 9월24일", "", R.drawable.bg_one06));
//        datas.add(new Item("모니터 어댑터 사요", "왕십리동 ~ 9월 20일", "180,000원", R.drawable.bg_one07));
//        datas.add(new Item("망가진 우산 삽니다", "행당동 ~ 9월 18일", "10,000원", R.drawable.bg_one08));








