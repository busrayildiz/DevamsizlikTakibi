package com.example.lenovo.devamsizliktakibi;

import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Created by lenovo on 19.8.2016.
 */
public class DersDevamsizlik {

    private String dersAd;
    private int maxDv;
    private String devtarih;
    private int devmiktar;
    private boolean raporlu;
    private int devamsizlikId;
   private int dersId;

    public DersDevamsizlik(int _dersId,int dvmsizlikId,String dersAd, Integer maxDv, Integer devmiktar, String devtarih, boolean checkbox) {
        super();
        this.dersAd = dersAd;
        this.maxDv = maxDv;
        this.devmiktar = devmiktar;
        this.devtarih = devtarih;
        this.raporlu = checkbox;
        this.devamsizlikId = dvmsizlikId;
        this.dersId = _dersId;
    }

    public DersDevamsizlik() {
        super();
    }


    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public int getMaxDv() {return maxDv;}

    public void setMaxDv(Integer maxDv) {
        this.maxDv = maxDv;
    }

    public String getDevtarih() {return devtarih;}

    public void setDevtarih(String devtarih) {this.devtarih = devtarih;}

    public Integer getDevmiktar() {return devmiktar;}

    public void setDevmiktar(Integer devmiktar) {this.devmiktar = devmiktar;}

    public boolean isRaporlu(int ınt) {return raporlu;}

    public void setRaporlu(boolean checkbox) {this.raporlu = raporlu;}

    public int getDevamsizlikId(){return this.devamsizlikId;}

    public int getDersId(){return this.dersId;}














}