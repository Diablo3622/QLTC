package com.example.qltc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.qltc.adapter.ImageAdapter;

public class MenuScreen extends Activity {

    GridView gridView;

    static final String[] MOBILE_OS = new String[] {
            "Thể Loại Thu/Chi", "Khoản Thu", "Khoản Chi","Thống Kê", "Lương" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        gridView = (GridView) findViewById(R.id.gridViewMenu);

        gridView.setAdapter(new ImageAdapter(this, MOBILE_OS));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                switch (position) {
                    case 0:
                        Intent themthuchi = new Intent(MenuScreen.this,ThemThuChiScreen.class);
                        startActivity(themthuchi);
                        break;
                    case 1:
                        Intent khoangthu = new Intent(MenuScreen.this,KhoanThuScreen.class);
                        startActivity(khoangthu);
                        break;
                    case 2:
                        Intent khoangchi = new Intent(MenuScreen.this,
                                KhoanChiScreen.class);
                        startActivity(khoangchi);
                        break;
                    case 3:
                        Intent thongke = new Intent(MenuScreen.this,
                                ThongKeScreen.class);
                        startActivity(thongke);
                        break;
                    case 4:
                        Intent luong = new Intent(MenuScreen.this,
                                LuongScreen.class);
                        startActivity(luong);
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
