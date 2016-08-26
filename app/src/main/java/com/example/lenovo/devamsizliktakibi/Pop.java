package com.example.lenovo.devamsizliktakibi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by lenovo on 24.8.2016.
 */
public class Pop extends Activity {

    DersHelper dersHelper;
    DBHelper dbHelper;
    Button btnKaydet;
    NumberPicker noPickerDV;
    DatePicker datePicker;
    View v;
    private int updDevamsizlikId;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);



         updDevamsizlikId =   getIntent().getIntExtra("DEVAMSIZLIK_ID",0);
        Log.w("wsd","Popup");
        Log.w("wsd", Integer.toString(updDevamsizlikId));

        //  View v = inflater.inflate(R.layout.fragment_devamsizlik_gir, container, false);
        dersHelper = new DersHelper(this);
        dbHelper = new DBHelper(this);
        btnKaydet = (Button) findViewById(R.id.btnPopKaydet);
        final DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker) ;



        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.densityDpi;
        int height = displayMetrics.densityDpi;

        getWindow().setLayout(width * 2, height * 3);



        final NumberPicker np2;
        np2 = (NumberPicker) findViewById(R.id.noPickerDV);
        np2.setMinValue(0);
        np2.setMaxValue(40);
        np2.setWrapSelectorWheel(false);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("wsd","buton click popup");

                String day = Integer.toString(datePicker.getDayOfMonth());
                String month = Integer.toString(datePicker.getMonth());
                String year = Integer.toString(datePicker.getYear());

                String date = day + "-"  + month + "-" + year;



             boolean result =   dersHelper.UpdateList(
                            Integer.toString(np2.getValue()),
                            date,
                            updDevamsizlikId)>0;








            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }






    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Pop Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.lenovo.devamsizliktakibi/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Pop Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.lenovo.devamsizliktakibi/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



    }

