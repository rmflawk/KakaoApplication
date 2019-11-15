package com.youngstudio.kakaoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView pf_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //액션바에 제목이 자동표시 되지 않도록
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        pf_iv= findViewById(R.id.pf_iv);

        pf_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionprofile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void btnBadge(View view) {
    }
}
