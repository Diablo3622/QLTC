package com.example.quanlythuchi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class MenuScreen extends Activity {

    GridView gridView;

    static final String[] MOBILE_OS = new String[] {
            "Thể Loại Thu/Chi", "Khoản Thu", "Khoản Chi","Thống Kê", "Lương" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        gridView = (GridView) findViewById(R.id.gridViewMenu);



        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                switch (position) {


                }

//				Toast.makeText(
//				   getApplicationContext(),
//				   ((TextView) v.findViewById(R.id.grid_item_label))
//				   .getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
