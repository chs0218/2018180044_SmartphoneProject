package com.tukorea.my_crossy_road.my_crossy_road.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tukorea.my_crossy_road.R;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void onBtnStart(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}