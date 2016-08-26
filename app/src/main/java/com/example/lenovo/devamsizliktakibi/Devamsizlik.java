package com.example.lenovo.devamsizliktakibi;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 16.8.2016.
 */
public class Devamsizlik implements Serializable {
    private static final long serialVersionUID = 1L;
    private int devamsizlik_id;
    private int dersId;
    private String devtarih;
    private int devmiktar;
    private boolean raporlu;



    public Devamsizlik(int dersId, Integer devmiktar, String devtarih, boolean checkbox) {
        super();
        this.dersId=dersId;
        this.devmiktar = devmiktar;
        this.devtarih=devtarih;
        this.raporlu=checkbox;
    }

    public Devamsizlik() {
        super();
    }

    public Devamsizlik(String devamsizligim, String devtarih) {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return devamsizlik_id;
    }

    public void setId(int id) {
        this.devamsizlik_id = id;
    }

    public int getDersId() {
        return dersId;
    }

    public void setDersId(int spinner) {
        this.dersId = spinner;
    }

    public String getDevtarih() {
        return devtarih;
    }

    public void setDevtarih(String devtarih) {
        this.devtarih = devtarih;
    }

    public Integer getDevmiktar() {
        return devmiktar;
    }

    public void setDevmiktar(Integer devmiktar) {
        this.devmiktar = devmiktar;
    }

    public boolean isRaporlu(int ınt) {
        return raporlu;
    }

    public void setRaporlu(boolean checkbox) {
        this.raporlu = raporlu;
    }


    private SQLiteDatabase getWritableDatabase() {
        return null;
    }

    public void insertDevamsizlik(Devamsizlik devamsizlik) {

    }
}

