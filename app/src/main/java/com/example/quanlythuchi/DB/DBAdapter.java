package com.example.quanlythuchi.DB;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBAdapter {
	String title;
	public Activity activity;
	DatabaseHelpert data = new DatabaseHelpert(activity);
	
	/*---------------------------------Nguoi Dung--------------------------------------*/
	static final String IDnguoidung = "_id";
	static final String username = "username";
	static final String password = "password";
	static final String Tennguoidung = "Tennguoidung";

	private static final String CaNhanTable = "User";
	
	/*---------------------------Khoang Chi--------------------------------------*/
	public static final String IDKhoanChi = "_idKC";
	public static final String idloaiKhoanChi = "loaikhoanchi";
	public static final String soTienKhoanChi = "sotienchi";
	public static final String ngayChi = "ngaychi";
	public static final String ghiChuChi = "ghichuchi";
	private static final String KhoanChiTable = "KhoanChi";

	/*------------------------The Loai Chi------------------------------------*/

	public static final String IDLoaiChi = "_idLoaiChi";
	public static final String tenLoaiChi = "tenloaichi";

	private static final String LoaiChiTable = "LoaiChi";

	/*-------------------------Khoan Thu-------------------------------------------*/

	public static final String IDKhoanThu = "_idKT";
	public static final String idloaiKhoanThu = "loaikhoanthu";
	public static final String soTienKhoanThu = "sotienkt";
	public static final String ngayThu = "ngaythu";
	public static final String ghiChuThu = "ghichuthu";
	private static final String KhoanthuTable = "KhoanThu";
	/*------------------------------The Loai Thu-------------------------------------*/

	public static final String idLoaiThu = "_idLoaiThu";
	public static final String tenLoaiThu = "tenloaithu";
	
	private static final String LoaithuTable = "LoaiThu";
	
//	/*-------------------------Luong-------------------------------------------*/

	public static final String IDLuong = "_idLuong";
	public static final String idNguoiDungLuong = "idNguoiDungLuong";
	public static final String tienLuong= "tienLuong";
	public static final String ngayNhapLuong= "ngayNhapLuong";
	
	private static final String LuongTable = "Luong";


	/*---------------------Create Nguoi Dung---------------------------------*/
	private static final String DATABASE_NguoiDung = "CREATE TABLE "
			+ CaNhanTable + "(" + IDnguoidung
			+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " 
			+ username + " TEXT NOT NULL, " + password 
			+ " Text NOT NULL, " + Tennguoidung + " Text);";
	/*-----------------------Create Khoang Chi---------------------------------*/
	private static final String DATABASE_KhoanChi = "CREATE TABLE "
			+ KhoanChiTable + "(" + IDKhoanChi
			+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + idloaiKhoanChi
			+ " TEXT, " + soTienKhoanChi + " Integer, " + ngayChi
			+ " Date NOT NULL, " + ghiChuChi + " TEXT, FOREIGN KEY (" + idloaiKhoanChi + ") REFERENCES "
			+ LoaiChiTable + " (" + IDLoaiChi + "));";
	/*------------------------Create The Loai Chi--------------------------------*/
	private static final String DATABASE_TheLoaiChi = "CREATE TABLE "
			+ LoaiChiTable + " (" + IDLoaiChi
			+ " INTEGER PRIMARY KEY autoincrement, " + tenLoaiChi + " TEXT)";
	/*--------------------------Create Khoang Thu------------------------------*/
	private static final String DATABASE_KhoanThu = "CREATE TABLE "
			+ KhoanthuTable + "(" + IDKhoanThu
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + idloaiKhoanThu
			+ " TEXT, " + soTienKhoanThu + " Integer, " + ngayThu
			+ " Date NOT NULL , " + ghiChuThu + " TEXT, FOREIGN KEY (" + idloaiKhoanThu + ") REFERENCES "
			+ LoaithuTable + " (" + idLoaiThu + "));";
	/*---------------------------Create The Loai Thu----------------------------*/
	private static final String DATABASE_TheLoaiThu = "CREATE TABLE " + LoaithuTable + " (" + idLoaiThu + " INTEGER PRIMARY KEY autoincrement ,"
			+ tenLoaiThu + " TEXT)";
///*----------------------------Create Luong--------------------------------*/
	private static final String DATABASE_Luong = "CREATE TABLE " + LuongTable 
			+ "(" 
			+ IDLuong + " INTEGER PRIMARY KEY AUTOINCREMENT," 
			+ idNguoiDungLuong + " TEXT, " 
			+ tienLuong + " INTEGER, "
			+ ngayNhapLuong+ " INTEGER NOT NULL, FOREIGN KEY (" + idNguoiDungLuong + ") REFERENCES "
			+ CaNhanTable + " (" + IDnguoidung + "));";
//	
	
	private static final String DATABASE_NAME = "QL1.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TAG = "DBAdapter";
	private final Context context;

	public static  DatabaseHelpert DBHelper;
	private SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
//		DBHelper = new DatabaseHelpert(context);
	}

	public void createDB() {
		DBHelper = new DatabaseHelpert(context);
	}
	private static class DatabaseHelpert extends SQLiteOpenHelper {
		
		DatabaseHelpert(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
				Log.e("Create Table", "");	
				db.execSQL(DATABASE_NguoiDung);
				db.execSQL(DATABASE_KhoanChi);
				db.execSQL(DATABASE_TheLoaiChi);
				db.execSQL(DATABASE_KhoanThu);
				db.execSQL(DATABASE_TheLoaiThu);
				db.execSQL(DATABASE_Luong);
//				db.execSQL(DATABASE_KhoanNO);
		          
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w(TAG, oldVersion + " to " + newVersion
					+ ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS CaNhanTable");
			onCreate(db);

		}
		

	}
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		DBHelper.close();
	}
	
//	public boolean kiemTraLogin(String acc,String mk){
//		Cursor c = db.rawQuery("select * from "+CaNhanTable+" where "+username+" = ? and "+password+" = ?", new String[] { acc,mk });
//		if(c.getCount()==1){
//			c.close();
//			return true;
//		}else{
//			c.close();
//			return false;
//		}
//	}
public boolean kiemTraLogin(String acc, String mk) {
	// Kiểm tra nếu tên đăng nhập là "admin" và mật khẩu là "admin"
	if (acc.equals("admin") && mk.equals("admin")) {
		return true;
	} else {
		// Nếu không phải là tài khoản admin, thực hiện truy vấn SQL để kiểm tra thông tin đăng nhập
		Cursor c = db.rawQuery("select * from " + CaNhanTable + " where " + username + " = ? and " + password + " = ?", new String[]{acc, mk});

		// Kiểm tra số lượng bản ghi trả về từ truy vấn
		if (c.getCount() == 1) {
			c.close();
			return true;  // Nếu có một bản ghi trả về, thông tin đăng nhập là chính xác
		} else {
			c.close();
			return false;  // Nếu không có hoặc nhiều hơn một bản ghi trả về, thông tin đăng nhập không chính xác
		}
	}
}
	/*----------------------------Thêm Người Dùng------------------------------*/
	public long createUser(String userN, String matKhau) {       
	    ContentValues cv = new ContentValues();
	    cv.put(username, userN);
	    cv.put(password, matKhau);
	    cv.put(Tennguoidung, "nodata");
	    open();
	    return db.insert(CaNhanTable, null, cv);
	}
	
	public String layIDND(String acc){
		Cursor layIDNguoiDung = db.rawQuery("select * from "+CaNhanTable + " where "+username+ " = ? ", new String[]{acc});
		String idNguoiDung = layIDNguoiDung.getString(0);
		return idNguoiDung;
	}
	public boolean kiemTraNhapLuong(String acc, String ngay){

		Cursor layLuong = db.rawQuery("select * from "+LuongTable + " where "+idNguoiDungLuong+" = ? and "+ngayNhapLuong+" = ?", new String[]{ acc, ngay });
		if(layLuong.getCount() !=0){
			layLuong.close();	
			return true;
		}
		else {
			layLuong.close();
			return false;
		}
		
	}
	/*--------------------Ham Lay luong cua nguoi dung da nhap--------------*/
	
/*------------------------thêm thể loại chi-----------------*/
	public long insertLoaiChi(String tenLC) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(tenLoaiChi, tenLC);
		open();
		return db.insert(LoaiChiTable, null, initialValues);
	}

	/*------------------------thêm thể loại thu-----------------*/
	public long insertLoaiThu(String tenLT) 
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(tenLoaiThu, tenLT);
		
		return db.insert(LoaithuTable, null, initialValues);
	}

	/*-------------------------Thêm Khoản Chi----------------------------*/
public long insertKhoanChi(String idLoaiKC,int soTien, String ngaychi) {
		
		ContentValues initialValues = new ContentValues();
		initialValues.put(idloaiKhoanChi, idLoaiKC);
		initialValues.put(soTienKhoanChi, soTien);
		initialValues.put(ngayChi, ngaychi);
		open();
		return db.insert(KhoanChiTable, null, initialValues);
	}

/*-------------------------Thêm Khoản Thu---------------------------*/
public long insertKhoanThu(String idLoaiKT,int sotienkt, String ngaythu) {
		
		ContentValues initialValues = new ContentValues();
		initialValues.put(idloaiKhoanThu, idLoaiKT);
		initialValues.put(soTienKhoanThu, sotienkt);
		initialValues.put(ngayThu, ngaythu);
		open();
		return db.insert(KhoanthuTable, null, initialValues);
	}

/*----------Xóa tất cả thể loại chi------------------------*/
	public int deleteAllLoaiChi() {

		return db.delete(LoaiChiTable, null, null);

	}
	/*----------Xóa tất cả thể loại thu------------------------*/
	public int deleteAllLoaiThu() {

		return db.delete(LoaithuTable, null, null);

	}

	/*----------Xóa tất cả Khoan Thu------------------------*/
	public int deleteAllKhoanThu() {

		return db.delete(KhoanthuTable, null, null);

	}
	/*----------------------Xóa id Khoan Chi----------------------*/

	public boolean deletekc(long rowId) {
		return db.delete(KhoanChiTable, IDKhoanChi + "=" + rowId, null) > 0;
	}
	/*----------------------Xóa id Khoan Thu----------------------*/

	public boolean deletekt(long rowId) {
		return db.delete(KhoanthuTable, IDKhoanThu + "=" + rowId, null) > 0;
	}
	/*----------------------Xóa id the loai chi----------------------*/

	public boolean deleteLoaiChi(long rowId) {
		return db.delete(LoaiChiTable, IDLoaiChi + "=" + rowId, null) > 0;
	}
	/*----------------------Xóa id the loai thu----------------------*/

	public boolean deleteLoaiThu(long rowId) {
		return db.delete(LoaithuTable, idLoaiThu + "=" + rowId, null) > 0;
	}


/*-----------------------------liệt kê tất cả người dung----------------------*/
	 public String getDatandung() {
	        String[] columns = new String[] {IDnguoidung,username,password,Tennguoidung};
	        Cursor c = db.query(CaNhanTable, columns, null, null, null, null, null);
	        /*if(c==null)
	            Log.v("Cursor", "C is NULL");*/
	        String result="";
	        int iRow = c.getColumnIndex(IDnguoidung);
	        int iN = c.getColumnIndex(username);
	        int iMK = c.getColumnIndex(password);
	        int iHoTen = c.getColumnIndex(Tennguoidung);
	        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){           
	            result = result +" "+ c.getString(iRow)
	                    + " - id:" + c.getString(iN)
	                    + " - pw:" + c.getString(iMK)
	                    + " - ten:" + c.getString(iHoTen) + "\n";
	        }
	        c.close();
	        return result;
	    }
/*----------------------------liệt kê tất cả thể loại chi----------------------*/
	public Cursor getAllLoaiChi() {
		return db.query(LoaiChiTable, new String[] { IDLoaiChi,
				tenLoaiChi }, null, null, null, null, null);
	}
	/*----------------------------liệt kê tất cả Khoan Chi----------------------*/
	public Cursor getAllKhoanChi() {
		return db.query(KhoanChiTable, new String[] { IDKhoanChi,idloaiKhoanChi,soTienKhoanChi,
				ngayChi, ghiChuChi }, null, null, null, null, null);
	}
	
    public List<String> getAllLabelsKhoanChi(){
        List<String> labels = new ArrayList<String>();
         
        // Select All Query
        String selectQuery = "SELECT  * FROM " + LoaiChiTable;
      
       
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
         
        // closing connection
        cursor.close();
        db.close();
         
        // returning lables
        return labels;
    }
	/*----------------------------liệt kê tất cả Khoan Thu---------------------*/
	public Cursor getAllKhoanThu() {
		return db.query(KhoanthuTable, new String[] { IDKhoanThu,idloaiKhoanThu,soTienKhoanThu,
				ngayThu, ghiChuThu }, null, null, null, null, null);
	}
	
	public List<String> getAllLabelsKhoanThu(){
        List<String> labels = new ArrayList<String>();
         
        // Select All Query
        String selectQuery = "SELECT  * FROM " + LoaithuTable;
      
       
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
         
        // closing connection
        cursor.close();
        db.close();
         
        // returning lables
        return labels;
    }
	/*----------------------------liệt kê tất cả thể loại thu----------------------*/
	public Cursor getAllLoaiThu() {
		
		return db.query(LoaithuTable, new String[] { 
				idLoaiThu, tenLoaiThu}, null, null, null, null, null);
	}

	/*----------------------------liệt kê _id Khoan Chi----------------------*/
	public Cursor laysotien (long sType)
    {
       return db.rawQuery("select coltentheloaic from KhoanChiTable where mathloaichi =\""+sType+"\"", null);
    }
	/*--------------Liệt kê _id thể loại thu----------------------------*/
	public Cursor gettlt (long rowId) throws SQLException {
		Cursor mCursor = db.query(true, LoaithuTable, new String[] {
				idLoaiThu, tenLoaiThu }, idLoaiThu + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	/*--------------Liệt kê _id thể loại chi----------------------------*/
	public Cursor gettlc(long rowId) throws SQLException {
		Cursor mCursor = db.query(true, LoaiChiTable, new String[] {
				IDLoaiChi, tenLoaiChi }, IDLoaiChi + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	/*--------------Liệt kê _id Khoản Chi----------------------------*/
	public Cursor getKhoanChi(long rowId) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		String colngaychi = sdf.format(new Date());
		Cursor mCursor = db.query(true, KhoanChiTable, new String[] {
				IDKhoanChi, idloaiKhoanChi,soTienKhoanChi,colngaychi }, IDKhoanChi + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	
	}
/*--------------------Updater thể Loại chi----------------------------*/
	public boolean updatetlc(long rowId, String name) {
		ContentValues args = new ContentValues();
		args.put(tenLoaiChi, name);
		return db.update(LoaiChiTable, args, IDLoaiChi + "=" + rowId, null) > 0;
	}
	/*--------------------Updater thể Loại thu----------------------------*/
	public boolean updatetlt (long rowId, String name) {
		ContentValues args = new ContentValues();
		args.put(tenLoaiThu, name);
		return db.update(LoaithuTable, args, idLoaiThu + "=" + rowId, null) > 0;
	}

	/*--------------------Updater Khoan Chi----------------------------*/
	public boolean updatekhoanchi(long rowId, String name,int sotien,String ngaychi) {
		
		
		ContentValues args = new ContentValues();
		args.put(idloaiKhoanChi, name);
		args.put(soTienKhoanChi, sotien);
		args.put(ngayChi, ngaychi);
		return db.update(KhoanChiTable, args, IDKhoanChi + "=" + rowId, null) > 0;
	}
	/*--------------------Updater Khoan Thu----------------------------*/
	public boolean updatekhoanthu(long rowId, String name,int sotienkt,String ngaythu) {
		
		
		ContentValues args = new ContentValues();
		args.put(idloaiKhoanThu, name);
		args.put(soTienKhoanThu, sotienkt);
		args.put(ngayThu, ngaythu);
		return db.update(KhoanthuTable, args, IDKhoanThu + "=" + rowId, null) > 0;
	}
	

    
}

