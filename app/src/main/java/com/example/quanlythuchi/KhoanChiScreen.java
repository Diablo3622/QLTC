package com.example.quanlythuchi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.quanlythuchi.R;

import java.util.Calendar;

public class KhoanChiScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khoan_chi_screen);

		loadTabs();
		NumberPicker yearPicker = findViewById(R.id.yearPicker);
		yearPicker.setTextSize(50);
		NumberPicker monthPicker = findViewById(R.id.monthPicker);
		monthPicker.setTextSize(50);
		NumberPicker dayPicker = findViewById(R.id.dayPicker);
		dayPicker.setTextSize(50);

		// Lấy năm hiện tại
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		// Cấu hình NumberPicker cho năm
		yearPicker.setMinValue(currentYear - 100); // Giả sử cho phạm vi từ 1923 đến nay
		yearPicker.setMaxValue(currentYear);
		yearPicker.setValue(currentYear);

		// Cấu hình NumberPicker cho tháng
		monthPicker.setMinValue(1);
		monthPicker.setMaxValue(12);
		// Lưu ý: Bạn có thể setDisplayedValues để hiển thị tên tháng thay vì số

		// Cấu hình NumberPicker cho ngày
		dayPicker.setMinValue(1);
		dayPicker.setMaxValue(31);

		// Xử lý sự kiện khi người dùng hoàn tất việc chọn giá trị trên NumberPicker
		yearPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
			// Không cần thực hiện xử lý ở đây, vì đã cập nhật trong sự kiện hoàn tất chọn
		});

		monthPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
			// Không cần thực hiện xử lý ở đây, vì đã cập nhật trong sự kiện hoàn tất chọn
		});

		dayPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
			// Không cần thực hiện xử lý ở đây, vì đã cập nhật trong sự kiện hoàn tất chọn
		});

		// Xử lý sự kiện khi người dùng hoàn tất việc chọn ngày tháng năm
		dayPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
			@Override
			public void onScrollStateChange(NumberPicker picker, int scrollState) {
				if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
					// Xử lý sau khi người dùng đã hoàn tất chọn ngày tháng năm
					updateData(yearPicker.getValue(), monthPicker.getValue(), dayPicker.getValue());
				}
			}
		});
	}

	private void updateData(int year, int month, int day) {
		// Thực hiện cập nhật dữ liệu khác dựa trên ngày tháng năm đã chọn
		String date = year + "/" + month + "/" + day;
		Toast.makeText(this, "Ngày tháng năm đã chọn: " + date, Toast.LENGTH_SHORT).show();

		// Thực hiện các xử lý khác sau khi đã chọn ngày tháng năm
		// Ví dụ: gọi hàm để cập nhật dữ liệu khác
		// updateOtherData();
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
