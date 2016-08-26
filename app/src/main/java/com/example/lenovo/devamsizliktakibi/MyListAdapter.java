package com.example.lenovo.devamsizliktakibi;

/**
 * Created by lenovo on 9.8.2016.
 */
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MyListAdapter extends BaseAdapter {
    DBHelper dbHelper;
  Button btn_guncelle;
    Button btnSil ;
    private LayoutInflater inflater;
    private List<DersDevamsizlik>  derslerimList;
    private Activity tempActivity;
    private Context c;


    public MyListAdapter(Activity activity, List<DersDevamsizlik> derslerims) {
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       derslerimList= derslerims ;
        tempActivity =activity;
        c = activity.getApplicationContext();
    }


    public int dersAd() {
        return derslerimList.size() ;
    }

    @Override
    public int getCount() {
        return derslerimList.size();
    }

    @Override
    public DersDevamsizlik getItem(int position) {
        return derslerimList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.satir_layout, null);
        btn_guncelle =(Button)vi.findViewById(R.id.btn_guncelle);
        btnSil = (Button)vi.findViewById(R.id.btn_sil);
         dbHelper = new DBHelper(c);


        TextView textView = (TextView) vi.findViewById(R.id.txt_dersadi);
        TextView textView2 = (TextView) vi.findViewById(R.id.txt_maxdv);
        TextView textView3 = (TextView) vi.findViewById(R.id.txt_devamsizligim);
        TextView textView4 = (TextView) vi.findViewById(R.id.txt_dev_tarih);

        final DersDevamsizlik dersDevamsizlik = derslerimList.get(position);

        textView.setText((dersDevamsizlik.getDersAd()));
        textView2.setText(Integer.toString(dersDevamsizlik.getMaxDv()));
        textView3.setText(Integer.toString(dersDevamsizlik.getDevmiktar()));
        textView4.setText(dersDevamsizlik.getDevtarih());


        btn_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ((Activity) getContext()).startActivity(new Intent(this,Pop.class));

                Intent i = new Intent(tempActivity.getBaseContext(),Pop.class);
                i.putExtra("DEVAMSIZLIK_ID",dersDevamsizlik.getDevamsizlikId());


                tempActivity.startActivity(i);


                Log.w("wsd","s");

            }
        });

        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDeleted = dbHelper.sil(dersDevamsizlik.getDersId());

                derslerimList.remove(dersDevamsizlik);
                notifyDataSetChanged();


                if (isDeleted = true)
                    Toast.makeText(c, "Silindi", LENGTH_LONG).show();
                else
                    Toast.makeText(c, "Silinemedi", LENGTH_LONG).show();
            }
        });




        return vi;
    }
}