package com.example.lenovo.devamsizliktakibi;

import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by lenovo on 9.8.2016.
 */
public class DBHelper extends SQLiteOpenHelper {


        public static final String DATABASE_NAME   = "DB";
        public static final String TABLE_DERSLER = "derslerim";
        public static final String COL_1 = "ID";
        public static final String COL_2 = "ders_adi";
        public static final String COL_3 = "max_devamsizlik";
    public static final String COL_8 = "s_DersSec";

    public static final String TABLE_DEVAMSİZLİK = "devamsizlik";
    public static final String COL_4 = "spinner";
    public static final String COL_5 = "devtarih";
    public static final String COL_6 = "devmiktar";
    public static final String COL_7 = "checkbox";

    public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE " + TABLE_DERSLER + "(ders_id INTEGER PRIMARY KEY AUTOINCREMENT,ders_adi TEXT,max_devamsizlik INTEGER" + ")";
            String sql2 = "CREATE TABLE " + TABLE_DEVAMSİZLİK+ "(devamsizlik_id INTEGER PRIMARY KEY AUTOINCREMENT,spinner INTEGER,devtarih TEXT,devmiktar TEXT,checkbox BOOLEAN" + ")";

            Log.d("DBHelper", "SQL : " + sql);
            Log.d("DBHelper", "SQL : " + sql2);
            db.execSQL(sql);
            db.execSQL(sql2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DERSLER);
            onCreate(db);

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEVAMSİZLİK);
            onCreate(db);
    }

  public void insertDerslerim(Derslerim derslerim) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ders_ad", derslerim.getDersAd());
        values.put("max_devamsizlik", derslerim.getMaxDv());

        db.insert(TABLE_DERSLER, null, values);
        db.close();
    }
    public List<Derslerim> getAllDerslerim() {
        List<Derslerim> derslerims = new ArrayList<Derslerim>();
        SQLiteDatabase db = this.getWritableDatabase();

        // String sqlQuery = "SELECT  * FROM " + TABLE_DERSLER;
        // Cursor cursor = db.rawQuery(sqlQuery, null);

        Cursor cursor = db.query(TABLE_DERSLER, new String[]{"ders_id", "ders_adi", "max_devamsizlik"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Derslerim derslerim = new Derslerim();
            derslerim.setId(cursor.getInt(0));
            derslerim.setDersAd(cursor.getString(1));
            derslerim.setMaxDv(cursor.getInt(2));
            derslerims.add(derslerim);
        }

        return derslerims;
    }

    public boolean insertDerslerim(String ders_adi, String max_devamsizlik) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       // contentValues.put(COL_1,ders_ıd);
        contentValues.put(COL_2,ders_adi);
        contentValues.put(COL_3,max_devamsizlik);
        long result = database.insert(TABLE_DERSLER, null, contentValues);
        if(result == -1)
            return false;
        else
             return true;


    }


    public Cursor getInformations(SQLiteDatabase sqLiteDatabase) {
        return null;
    }


    /* public Cursor getAllDers()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from" + TABLE_DERSLER);
        return ;
    }*/






    public void insertDevamsizlik(Devamsizlik devamsizlik) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("spinner", devamsizlik.getDersId());
        values.put("devtarih", devamsizlik.getDevtarih());
        values.put("devmiktar", devamsizlik.getDevmiktar());
        values.put("checkbox", devamsizlik.isRaporlu(1));

        db.insert(TABLE_DERSLER, null, values);
        db.close();
    }
    public List<Devamsizlik> getAllDevamsizlik() {
        List<Devamsizlik> devamsizlikList = new ArrayList<Devamsizlik>();
        SQLiteDatabase db = this.getWritableDatabase();

        // String sqlQuery = "SELECT  * FROM " + TABLE_DERSLER;
        // Cursor cursor = db.rawQuery(sqlQuery, null);




        Cursor cursor = db.query(TABLE_DEVAMSİZLİK, new String[]{"devamsizlik_id", "spinner", "devtarih", "devmiktar", "checkbox"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Devamsizlik devamsizlik = new Devamsizlik();
            devamsizlik.setId(cursor.getInt(0));
            devamsizlik.setDersId(cursor.getInt(1));
            devamsizlik.setDevtarih(cursor.getString(2));
            devamsizlik.setDevmiktar(cursor.getInt(3));
            devamsizlik.isRaporlu(cursor.getInt(4));
            devamsizlik.insertDevamsizlik(devamsizlik);
        }

        return devamsizlikList;
    }

  /*  public void DeleteAllRows(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_DERSLER, null, null);
    }
*/
    public boolean sil(int pk) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_DERSLER, "ders_id = ?", new String[]{Integer.toString(pk)})>0;

    }

    public void guncelle(Integer max_dv,Integer new_maxdv, String devamsizligim,String new_devamsizligim ,String dev_tarih,String new_devtarih,SQLiteDatabase sqLiteDatabase){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_3,new_maxdv.intValue());
        contentValues.put(DBHelper.COL_6,new_devamsizligim.toString());
        contentValues.put(DBHelper.COL_5,new_devtarih.toString());
//github test

    }

    public boolean insertDevamsizlik(int spinner, String devmiktar, String devtarih, boolean checkbox) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues.put(COL_1,ıd);
        contentValues.put(COL_4, spinner);
        contentValues.put(COL_5, devtarih);
        contentValues.put(COL_6, devmiktar);

        long result = database.insert(TABLE_DEVAMSİZLİK, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


}





















