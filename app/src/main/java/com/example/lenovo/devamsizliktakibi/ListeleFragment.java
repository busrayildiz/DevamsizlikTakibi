package com.example.lenovo.devamsizliktakibi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class ListeleFragment extends Fragment {
    DBHelper dbHelper;
    DersHelper dersHelper;
    View v;


    List<Derslerim> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v;
        v = inflater.inflate(R.layout.fragment_listele, container, false);


        // Inflate the layout for this fragment

        try {


            ListView listView = (ListView) v.findViewById(R.id.listView);
            dbHelper = new DBHelper(getContext());
            dersHelper = new DersHelper(getContext());

            EkranaYaz();

            List<DersDevamsizlik> lstDersler = dersHelper.GetDevamsizlikInfo();
            list = dersHelper.GetAllDers();


            MyListAdapter myListAdapter = new MyListAdapter(getActivity(), lstDersler);

            if (myListAdapter.dersAd() > 0)
                listView.setAdapter(myListAdapter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return v;
    }






     /*  private static FragmentManager getSupportFragmentManager() {
        Fragment frg = null;
        frg = getSupportFragmentManager().findFragmentByTag("ListeleFrament");
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();
        return  frg;*/


public void EkranaYaz(){
    //db helper fonksiyon yap int döndür derslerim countu getir
    // db helper fonksiyon yap int döndür devamsizlik getir

    int dersCount = dersHelper.GetDersCount();
    int devamsizlikCount = dersHelper.GetDevamsizlikCount();
    Log.w("wsd","Ders Adet:" + Integer.toString(dersCount));
    Log.w("wsd","Devamsizlik Adet:" + Integer.toString(devamsizlikCount));

}


}


