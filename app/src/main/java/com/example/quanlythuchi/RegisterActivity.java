package com.example.qlthuchi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

    }
    public void openLoginLayout(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
