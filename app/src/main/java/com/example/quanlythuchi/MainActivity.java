package com.example.quanlythuchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


    }
    public void openRegisterLayout(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}