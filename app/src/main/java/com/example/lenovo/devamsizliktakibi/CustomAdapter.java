package com.example.lenovo.devamsizliktakibi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 8.8.2016.
 */
public class CustomAdapter extends ArrayAdapter<Derslerim>{
    public CustomAdapter(Context context, int users){super (context,0, users);}



    @Override
    public View getView(int position, View convertView, ViewGroup parent){
      /*  Derslerim itemDers = users (position);
        if(convertView==null){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.satir_layout,parent,false);
        }
        TextView tDersAdi=(TextView) convertView.findViewById(R.id.txt_dersadi);
        //TextView tMaxDevamsizlik=(TextView) convertView.findViewById(R.id.txt_maxdevamsizlik);
       // Button bGüncelle= (Button) convertView.findViewById(R.id.btn_güncelle);
        Button bSil= (Button) convertView.findViewById(R.id.btn_sil);

        tDersAdi.setText(itemDers.DersAdi);
        //tMaxDv.setText(itemDers.MaxDevamsizlik);

*/
return convertView;
    }

    private Derslerim getDers(int position) {
        return null;
    }


}
