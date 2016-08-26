package com.example.lenovo.devamsizliktakibi;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

/**
 * Created by lenovo on 9.8.2016.
 */
public class Derslerim implements Serializable {private static final long serialVersionUID = 1L;
    private int ders_id;
    private String dersAd;
    private int maxDv;

    public Derslerim(){

    }

    public Derslerim(Integer dersId,String dersAdi, Integer maxDevamsizlik) {
        this.ders_id = dersId;
        this.dersAd = dersAdi;
        this.maxDv = maxDevamsizlik;
    }


           

/*
    public Derslerim(String dersAdi, String maxDevamsizlik, String devamsizligim, String devtarih) {
        super();
    }

    public Derslerim() {
        super();
        this.dersAd = ders_adi;
        this.maxDv = max_devamsizlik;
    }*/

    public int getMaxDv() {return maxDv;}

    public void setMaxDv(Integer maxDv) {
        this.maxDv = maxDv;
    }

    public int getId() {
        return ders_id;
    }

    public void setId(int id) {
        this.ders_id = id;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }


}
