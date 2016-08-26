package com.example.lenovo.devamsizliktakibi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;


public class DevamsizlikGirFragment extends Fragment {
    Spinner spinner;
    DersHelper dersHelper;
    DBHelper dbHelper;
    EditText eTxt_devmiktar;
    EditText eTxt_devtarih;
    CheckBox checkbox;
    Button btn_kaydet;
    View v;
    List<Derslerim> lst;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_devamsizlik_gir, container, false);
        spinner = (Spinner) v.findViewById(R.id.spinner);
        dersHelper = new DersHelper(getContext());
        dbHelper = new DBHelper(getContext());
        eTxt_devmiktar = (EditText) v.findViewById(R.id.eTxt_devmiktar);
        eTxt_devtarih = (EditText) v.findViewById(R.id.eTxt_devtarih);
        checkbox = (CheckBox) v.findViewById(R.id.checkBox);
        btn_kaydet=(Button)v.findViewById(R.id.btn_kaydet) ;

        lst = dersHelper.GetAllDers();
        List<String> lstDersler=new ArrayList<String>();

        for (Derslerim item : lst)
        {
            lstDersler .add(item.getDersAd());

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, lstDersler);

        // Drop down layout style - list view with radio button
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        // Inflate the layout for this fragment


       Button btn_kaydet = (Button) v.findViewById(R.id.btn_kaydet);

           btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kaydet();
            }


            public void Kaydet() {

                boolean isInserted = dbHelper.insertDevamsizlik(lst.get(spinner.getSelectedItemPosition()).getId(), eTxt_devtarih.getText().toString(), eTxt_devmiktar.getText().toString(), checkbox.isChecked());
                if (isInserted = true)
                    Toast.makeText(getActivity(), "Kaydedildi", LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Kaydedilemedi", LENGTH_LONG).show();

            }


        });
        return v;
    }}