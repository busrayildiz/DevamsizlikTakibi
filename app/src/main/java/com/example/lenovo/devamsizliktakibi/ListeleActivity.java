package com.example.lenovo.devamsizliktakibi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by lenovo on 8.8.2016.
 */
public class ListeleActivity extends AppCompatActivity {
    TextView dersAdi;
    TextView maxDevamsizlik;
    TextView devamsizligim;
    TextView devtarih;

    Button Güncelle;
    Button Sil;
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    CustomAdapter customAdapter;
    Derslerim derslerim;
    Devamsizlik devamsizlik;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        listView = (ListView) findViewById(R.id.listView);
        customAdapter = new CustomAdapter(getApplicationContext(), R.layout.satir_layout);
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = dbHelper.getInformations(sqLiteDatabase);
        if (cursor.moveToNext()) do {
            String dersAdi,  devamsizligim, devtarih;
            Integer maxDevamsizlik;
            dersAdi = cursor.getString(0);
            maxDevamsizlik = cursor.getInt(1);
            devamsizligim = cursor.getString(2);
            devtarih = cursor.getString(3);

            Derslerim derslerim = new Derslerim(0,dersAdi, maxDevamsizlik);
            Devamsizlik devamsizlik1 = new Devamsizlik(devamsizligim, devtarih);
        } while (cursor.moveToNext());
        dersAdi = (TextView) findViewById(R.id.etxt_dersadi);
        maxDevamsizlik = (TextView) findViewById(R.id.eTxt_maxdv);
        devamsizligim = (TextView) findViewById(R.id.eTxt_devmiktar);
        devtarih = (TextView) findViewById(R.id.eTxt_devtarih);
        Güncelle = (Button) findViewById(R.id.btn_guncelle);
        Sil = (Button) findViewById(R.id.btn_sil);

        Intent i = getIntent();
        Derslerim gelenDers = (Derslerim) i.getSerializableExtra("xValue");
        Derslerim gelenMaxDev = (Derslerim) i.getSerializableExtra("xValue");
     //   Derslerim gelenDevamsizligim = (Devamsizlik) i.getSerializableExtra("xValue");
     //   Derslerim gelenDevTarih = (Devamsizlik) i.getSerializableExtra("xValue");

        dersAdi.setText(gelenDers.getDersAd());
        maxDevamsizlik.setText(gelenMaxDev.getMaxDv());


        Güncelle.setText(gelenDers.getDersAd());
        Sil.setText(gelenDers.getDersAd());
         Listele();







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
                "Listele Page", // TODO: Define a title for the content shown.
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
                "Listele Page", // TODO: Define a title for the content shown.
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
  public String[] Listele() {

        final String TABLE_DERSLER = "derslerim";

        String selectQuery = "SELECT  * FROM " + TABLE_DERSLER;
       String db  = DBHelper.TABLE_DERSLER;
        Cursor cursor      = sqLiteDatabase.rawQuery(selectQuery, null);
        String[] res      = null;

        if (cursor.moveToFirst()) {
            do {
                cursor.getString(cursor.getColumnIndex("Ders"));
                cursor.getString(cursor.getColumnIndex("Devamsizlik"));
                ListeleActivity listeleActivity = new ListeleActivity();
            } while (cursor.moveToNext());
        }
        cursor.close();

        return res;

    }
}