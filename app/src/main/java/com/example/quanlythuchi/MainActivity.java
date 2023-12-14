package com.example.quanlythuchi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlythuchi.DB.DBAdapter;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn,btnSignUp;
    //LoginDataBaseAdapter loginDataBaseAdapter;

    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
        //loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        //loginDataBaseAdapter=loginDataBaseAdapter.open();

        //new test=================================================
        dbAdapter = new DBAdapter(this);
        dbAdapter.createDB();
        dbAdapter = dbAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),Signup.class);
                startActivity(intentSignUP);
            }
        });
    }
    // Methos to handleClick Event of Sign In Button
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.login_layout);
        dialog.setTitle("Login");

        // get the Refferences of views
        final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.edtUserNameToLogin);
        final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.edtPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.btnSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();


                Boolean ktDangNhap = dbAdapter.kiemTraLogin(userName, password);
                if(ktDangNhap){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    Calendar c = Calendar.getInstance();
                    String mm = String.valueOf(c.get(Calendar.MONTH) + 1);
                    System.out.println(mm);

                    //bat man hinh nhap luong
                    String acc = dbAdapter.layIDND(userName);
                    Boolean luong = dbAdapter.kiemTraNhapLuong(acc, mm);
                    if(luong){
                        Intent intentNhapLuong=new Intent(getApplicationContext(),Luong.class);
                        startActivity(intentNhapLuong);
                    }
                    else{
                        //Goi man hinh menu
                        Intent intentMenu = new Intent(getApplicationContext(), MenuScreen.class);
                        intentMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intentMenu);
                        //finish();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}