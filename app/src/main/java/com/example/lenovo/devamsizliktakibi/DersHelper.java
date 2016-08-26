package com.example.lenovo.devamsizliktakibi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 16.8.2016.
 */
public class DersHelper {
    DBHelper dbHelper;
    private Context context;
    private android.database.sqlite.SQLiteDatabase db;

    public DersHelper(Context context) {
        this.context = context;
    }

    public List<String> GetAllDersName() {
        List<Derslerim> lst = GetAllDers();
        List<String> rtnList = new ArrayList<String>();

        for (Derslerim item : lst) {
            rtnList.add(item.getDersAd());
        }

        return rtnList;
    }

    public List<DersDevamsizlik> GetDevamsizlikInfo() {
        dbHelper = new DBHelper(context);

        List<DersDevamsizlik> lstReturn = new ArrayList<DersDevamsizlik>();
        try {
            // bu alanaa join ile sorgu yap
            final String query = "SELECT * FROM derslerim  INNER JOIN  devamsizlik ON derslerim.ders_id=devamsizlik.devamsizlik_id";
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery(query, new String[]{});


            //cursordakini lstreturn içine at

            if (cursor.moveToFirst()) {
                do {


                    lstReturn.add(new DersDevamsizlik(
                            cursor.getInt(cursor.getColumnIndex("ders_id")),
                            cursor.getInt(cursor.getColumnIndex("devamsizlik_id")),
                            cursor.getString(cursor.getColumnIndex("ders_adi")),
                            cursor.getInt(cursor.getColumnIndex("max_devamsizlik")),
                            cursor.getInt(cursor.getColumnIndex("devmiktar")),
                            cursor.getString(cursor.getColumnIndex("devtarih")),
                            cursor.getInt(cursor.getColumnIndex("checkbox")) > 0));

                    //  ListeleFragment listeleFragment = new ListeleFragment();
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lstReturn;
    }

    public List<Derslerim> GetAllDers() {
        dbHelper = new DBHelper(context);
        List<Derslerim> lstReturn = new ArrayList<Derslerim>();

        final String TABLE_DERSLER = "derslerim";

        String selectQuery = "SELECT  * FROM " + TABLE_DERSLER;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);




        if (cursor.moveToFirst()) {
            do {

                Log.w("xs", cursor.getString(cursor.getColumnIndex("ders_adi")));
                Log.w("xs", cursor.getString(cursor.getColumnIndex("max_devamsizlik")));
                Log.w("xs", "-");


                lstReturn.add(new Derslerim(cursor.getInt(cursor.getColumnIndex("ders_id")),cursor.getString(cursor.getColumnIndex("ders_adi")), cursor.getInt(cursor.getColumnIndex("max_devamsizlik"))));
                //  ListeleFragment listeleFragment = new ListeleFragment();
            } while (cursor.moveToNext());
        }
        cursor.close();


        return lstReturn;
    }

    public int UpdateList(String _devMiktar, String _devTarih, int pk) {
        dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("devmiktar", _devMiktar);
        values.put("devtarih", _devTarih);


        return db.update("devamsizlik", values, "devamsizlik_id = ?", new String[]{ Integer.toString(pk)});
    }

    private SQLiteDatabase getWritableDatabase() {
    return null;
    }

    public int GetDersCount() {
        dbHelper = new DBHelper(context);


        String selectQuery = "SELECT  * FROM derslerim";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor.getCount();
    }

    public int GetDevamsizlikCount() {
        dbHelper = new DBHelper(context);


        String selectQuery = "SELECT  * FROM devamsizlik";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor.getCount();
    }

    public Devamsizlik GetDevamsizlikById(int pk){
        String sql="";

        Devamsizlik dObj = new Devamsizlik();
        //burda sql e bağlan ve objeyi cursor ile doldur

        return  dObj;
    }


}










