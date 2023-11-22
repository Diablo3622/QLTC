package com.example.myapplication.DB;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.example.myapplication.R;

public class KhoanChiScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khoan_chi_screen);
		
		loadTabs();
	}
	
	
	public void loadTabs() {
		final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
		tab.setup();
		TabHost.TabSpec spec;
		spec = tab.newTabSpec("t1");
		spec.setContent(R.id.tab1kc);
		spec.setIndicator("1-Thêm Khoản Chi");
		tab.addTab(spec);
		spec = tab.newTabSpec("t2");
		spec.setContent(R.id.tab2kc);
		spec.setIndicator("2-Danh Sách Khoản Chi");
		tab.addTab(spec);
		tab.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.khoan_chi_screen, menu);
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
}
