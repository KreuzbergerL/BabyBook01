package com.example.lukas.bottom_navigation5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

public class PrefManager {

    Context context;

    PrefManager(Fragment context){
        this.context = context.getContext();
    }

    public void SaveTagebucheinträge(String tagebucheintrag, int day, int month, int year ){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Tagebucheinträge", context.MODE_PRIVATE);   // MODE_PRIVAT -> Zugriff nur innerhalb der App möglich
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Eintrag" + day + "." + month + "." + year , tagebucheintrag);
        editor.commit();
    }


    public String getEintrag(int d, int m, int y){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Tagebucheinträge" , context.MODE_PRIVATE);
        return sharedPreferences.getString("Eintrag" + d + "." + m + "." + y , "");
    }
}
