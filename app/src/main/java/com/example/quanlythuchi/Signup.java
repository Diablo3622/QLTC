package com.example.quanlythuchi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlythuchi.DB.DBAdapter;

public class Signup extends Activity {
	
	EditText edtUserName,edtPassword,edtConfirmPassword;
	Button btnCreateAccount;
	//LoginDataBaseAdapter loginDataBaseAdapter;
	DBAdapter dbAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		

		//=================new test =====================
		dbAdapter = new DBAdapter(this);
		dbAdapter = dbAdapter.open();
		
		edtUserName=(EditText)findViewById(R.id.edtUserName);
		edtPassword=(EditText)findViewById(R.id.edtPassword);
		edtConfirmPassword=(EditText)findViewById(R.id.edtConfirmPassword);
		btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
	}
	


	
		public void CreateAccount(View v){
			
			String userName=edtUserName.getText().toString();
			String password=edtPassword.getText().toString();
			String confirmPassword=edtConfirmPassword.getText().toString();
			
			if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ vào các trường!", Toast.LENGTH_LONG).show();
					return;
			}
			if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
				return;
			}
			else
			{

				dbAdapter.createUser(userName, password);
			    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
			    
			    Intent intent = new Intent(this, MainActivity.class);
			    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			    startActivity(intent);
			    finish();
			}
		}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		dbAdapter.close();
	}
}
