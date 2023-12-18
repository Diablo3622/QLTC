package com.example.quanlythuchi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.quanlythuchi.adapter.ImageAdapter;

public class ThemThuChiScreen extends Activity {

	GridView gridView;

	static final String[] TenTheLoai_OS = new String[] { 
		"Thể Loại Thu", "Thể Loại Chi" };
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_screen);

		gridView = (GridView) findViewById(R.id.gridViewMenu);

		gridView.setAdapter(new ImageAdapter(this, TenTheLoai_OS));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				switch (position) {
				case 0:
					Intent themthuchi = new Intent(ThemThuChiScreen.this,ThemLoaiThu.class);
					startActivity(themthuchi);
					break;
				case 1:
					Intent khoangthu = new Intent(ThemThuChiScreen.this,ThemLoaiChi.class);
					startActivity(khoangthu);
					break;
				
				
				}
				
//				Toast.makeText(
//				   getApplicationContext(),
//				   ((TextView) v.findViewById(R.id.grid_item_label))
//				   .getText(), Toast.LENGTH_SHORT).show();

			}
		});

	}

}
