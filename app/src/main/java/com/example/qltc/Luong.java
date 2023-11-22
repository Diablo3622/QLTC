package com.example.qltc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Luong extends Activity {

    EditText edtLuong;
    Button btnLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luong);

        edtLuong = (EditText) findViewById(R.id.edtLuong);
        btnLuong = (Button) findViewById(R.id.btnLuong);
    }
    public void NhapLuong(View v){
        String luong = edtLuong.getText().toString();

        if(luong.length() != 0 ){
            //luu tien luong vao co so du lieu
            //TODO

            //Goi man hinh menu
            Intent intent = new Intent(this, MenuScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Vui lòng nhập lương!", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.luong, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
