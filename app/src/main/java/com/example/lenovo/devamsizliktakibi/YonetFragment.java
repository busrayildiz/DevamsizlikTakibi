package com.example.lenovo.devamsizliktakibi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;


public class YonetFragment extends Fragment {
    View view;
    DBHelper dbHelper;
    DersHelper dersHelper;
    EditText etxt_dersadi;
    EditText etxt_maxdv;
    Button btn_ekle;
    Button btn_sil;
    Spinner spinnerSec;
    ArrayAdapter adapter;
    ArrayList<String> secilen = new ArrayList<>();
    Cursor cursor;
    List<Derslerim> list;
    UtilityHelper util;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v;




        v = inflater.inflate(R.layout.fragment_yonet, container, false);
        dersHelper = new DersHelper(getContext());
        dbHelper = new DBHelper(getContext());
        spinnerSec = (Spinner) v.findViewById(R.id.s_DersSec);
        util = new UtilityHelper(getContext());
        btn_sil=(Button)v.findViewById(R.id.btn_sil);
        etxt_dersadi = (EditText) v.findViewById(R.id.etxt_dersadi);
        etxt_maxdv = (EditText) v.findViewById(R.id.eTxt_maxdv);
        //  Listele();
        list = dersHelper.GetAllDers();



        btn_sil.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DersSil();
            }
        });

        Button btn_ekle = (Button) v.findViewById(R.id.btn_ekle);
        btn_ekle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ValidateForSave()) {

                    boolean isInserted = dbHelper.insertDerslerim(etxt_dersadi.getText().toString(), etxt_maxdv.getText().toString());
                    if (isInserted = true)
                        Toast.makeText(getActivity(), "Eklendi", LENGTH_LONG).show();
                    else
                        Toast.makeText(getActivity(), "Eklenemedi", LENGTH_LONG).show();


                }
                else{
                    //bu alanda toast göster kaydedilmedi diye

                    util.ShowMessage("Kaydedilemedi");
                }
            }

            List<String> listDersler=new ArrayList<String>();

            {
                for (Derslerim item : list) {
                    listDersler.add(item.getDersAd());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, listDersler);

                // Drop down layout style - list view with radio button
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                spinnerSec.setAdapter(adapter);
                spinnerSec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String item = parent.getItemAtPosition(position).toString();

                        // Showing selected spinner item
                        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }


        });
        return v;
        }

    public void DersSil(){
        boolean isDeleted = dbHelper.sil(list.get(spinnerSec.getSelectedItemPosition()).getId());
        if (isDeleted = true)
            Toast.makeText(getActivity(), "Silindi", LENGTH_LONG).show();
        else
            Toast.makeText(getActivity(), "Silinemedi", LENGTH_LONG).show();
    }

    public boolean ValidateForSave(){
        boolean isValid= true;
        //büşra burayı güncelleyecek textler boşsa kaydetme


        return  isValid;
    }
/*
    private View Sil() {
        SQLiteDatabase db = this.btn_sil;
        db.delete(view);
return view;
    }*/
}





  /* public  Integer Sil(int spinnerSec){

    }

    private SQLiteDatabase getWritableDatabase() {
    }
*/




  /*  public String[] Listele() {

        final String TABLE_DERSLER = "derslerim";

        String selectQuery = "SELECT  * FROM " + TABLE_DERSLER;
        SQLiteDatabase db  = dbHelper.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String[] res      = null;

        if (cursor.moveToFirst()) {
            do {
                YonetFragment yonetFragment = new YonetFragment();
            } while (cursor.moveToNext());
        }
        cursor.close();
        return res;
*/



        /*  public String[] Listele(){
        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = dbHelper.getAllDers();
                if(res.getCount()== 0){
                    return;
                }
               StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id" + res.getString(0));
                    buffer.append("Ders Adı" + res.getString(1));
                    buffer.append("Max Devamsızlık" + res.getString(2));
                }
            }
        });*/





  //  }



