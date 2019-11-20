package com.youngstudio.kakaoapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

public class WritingActivity extends AppCompatActivity {

    EditText etPrice,etName,etMsg;
    ImageView iv;

    String imgPath;

    ImageView iv_Kategorie,iv_map;
    TextView tv_Kategotie,tv_map,gallery;

    String nickName , email;


    String[] items= new String[]{"디지털/가전", "가구/인테리어", "유아동/유아도서","생활/가공식품","여성의류/잡화","남성패션/잡화",
            "뷰티미용","스포츠/레저","게임/취미","도서/티켓/음반","반려동물용품","기타중고물품","중고차/오토바이","삽니다!!"};

    String[] datas= new String[]{"강서구","양천구","구로구","영등포구","금천구","동작구","관악구","서초구","강남구","송파구","강동구",
            "마포구","용산구","성동구","광진구","서대문구","중구","동대문구","중랑구","은평구","종로구","동대문구","중랑구","성북구",
            "강북구","도봉구","노원구"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        nickName= getIntent().getStringExtra("nickname");
        email= getIntent().getStringExtra("email");

        etName= findViewById(R.id.name);
        etMsg= findViewById(R.id.msg);
        etPrice= findViewById(R.id.price);
        iv_Kategorie= findViewById(R.id.writing_iv_kategorie);
        tv_Kategotie= findViewById(R.id.writing_tv_kategotie);
        tv_map= findViewById(R.id.writing_tv_map);
        iv_map= findViewById(R.id.writing_iv_map);
        gallery= findViewById(R.id.writing_tv_gallery);

        iv= findViewById(R.id.writing_iv);


        iv_Kategorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(WritingActivity.this);

                //건축가에게 원하는 작업요청
                //builder.setTitle("다이얼로그");
                //builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        tv_Kategotie.setText(items[which]);
                        //두번째 파라미터 which : 항목의 인덱스번호[가장 위 항목이 0번 ]
                        //Toast t= Toast.makeText(WritingActivity.this, items[which], Toast.LENGTH_SHORT);
                        //t.show();
                    }


                });

                //건축가(Builder)에게 AlertDialog 만들어 달라고 요청
                AlertDialog dialog= builder.create();

                //다이얼로그의 바깥쪽을 터치하였을 때 다이얼로그가 꺼지지 않도록..
                dialog.setCanceledOnTouchOutside(true);

                //뒤로가기 버튼을 클릭해도 꺼지지 않도록 하려면..
                //dialog.setCancelable(false);

                //다이얼로그를 화면에 보이기!!
                dialog.show();
            }//onclick  writing_iv_map
        });


        iv_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(WritingActivity.this);

                //건축가에게 원하는 작업요청
                //builder.setTitle("다이얼로그");
                //builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setItems(datas, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        tv_map.setText(datas[which]);
                        //두번째 파라미터 which : 항목의 인덱스번호[가장 위 항목이 0번 ]
                        //Toast t= Toast.makeText(WritingActivity.this, items[which], Toast.LENGTH_SHORT);
                        //t.show();
                    }
                });

                //건축가(Builder)에게 AlertDialog 만들어 달라고 요청
                AlertDialog dialog= builder.create();

                //다이얼로그의 바깥쪽을 터치하였을 때 다이얼로그가 꺼지지 않도록..
                dialog.setCanceledOnTouchOutside(true);

                //뒤로가기 버튼을 클릭해도 꺼지지 않도록 하려면..
                //dialog.setCancelable(false);

                //다이얼로그를 화면에 보이기!!
                dialog.show();
            }//onclick  writing_iv_map
        });


        //액션바에 제목이 자동표시 되지 않도록
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        //업로드하려면 외부저장소 권한 필요
        //동적퍼미션 코드 필요...
        // 외부저장소 권한 동적퍼미션
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//            int permissionResult= checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//            if(permissionResult == PackageManager.PERMISSION_DENIED){
//                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},10);
//            }
//        }

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
            }
        });

    }


    public void clickCamera(View view) {
        //갤러리 or 사진 앱 실행하여 사진을 선택하도록..
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    //선택한 사진의 경로(Uri)객체 얻어오기
                    Uri uri= data.getData();
                    if(uri != null){
                        iv.setImageURI(uri);

                        //얻어온 uri는 Gallery앱의 DB번호임.
                        //업로드를 하려면 이미지의 절대경로(실제경로 : file://storage/emulated/0/Download/aaaa.png)가 필요함.
                        //uri -> 절대경로(String)로 변환
                        imgPath= getRealPathFromUri(uri);

                        //이미지 경로 Uri 확인해보기
                        //new AlertDialog.Builder(this).setMessage(uri.toString()+ "\n"+imgPath).create().show();
                    }
                }else{
                    Toast.makeText(this, "이미지 선택을 하지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }//onActivityResult

    //Uri -- > 절대경로로 바꿔서 리턴시켜주는 메소드
    String getRealPathFromUri(Uri uri){
        String[] proj= {MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(this, uri, proj, null, null, null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return  result;
    }


    public void clickUpload(View view) {
        //서버로 보낼 데이터
        String name= etName.getText().toString();
        String msg= etMsg.getText().toString();
        String kt= tv_Kategotie.getText().toString();
        int price= Integer.parseInt(etPrice.getText().toString());

        //안드로이드에서 보낼 데이터를 받을 php서버주소
        String serverUrl="http://rmflawkdk.dothome.co.kr/Android/insertDB.php";
        //Log.i("tag","a");

        //Volley plus library를 이용해서 파일전송하도록
        //Volley+는 AndroidStudio에서 검색안됨[google검색 이용]

        //파일전송요청 객체 생성[결과를 String으로 받음]
        SimpleMultiPartRequest smpr= new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                new AlertDialog.Builder(WritingActivity.this).setMessage("응답:"+response).create().show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WritingActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

        //요청객체에 보낼 데이터를 추가
        smpr.addStringParam("nickname",nickName);
        smpr.addStringParam("email", email);

        smpr.addStringParam("name", name);
        smpr.addStringParam("msg", msg);
        smpr.addStringParam("price", price+"");
        smpr.addStringParam("kt", kt);
        //이미지파일 추가
        smpr.addFile("img", imgPath);

        //요청객체를 서버로 보낼 우체통같은 객체 생성
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(smpr);
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}//class