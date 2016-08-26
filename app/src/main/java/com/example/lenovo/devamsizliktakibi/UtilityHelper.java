package com.example.lenovo.devamsizliktakibi;

import android.content.Context;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by lenovo on 24.8.2016.
 */
public class UtilityHelper {

    private static Context context;

    public UtilityHelper(Context context) {
        this.context = context;
    }

    public  void ShowMessage(String msg){
        Toast.makeText(context, msg, LENGTH_LONG).show();
    }
}
