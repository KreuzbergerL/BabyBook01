package com.example.lukas.bottom_navigation5;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import static android.content.Context.MODE_PRIVATE;

public class PrefManager {

    Context context;

    PrefManager(Fragment context){
        this.context=context.getContext();

    }

    public void SaveTagebucheinträge(String tagebucheintrag, int day, int month, int year ){                                // Für welchen Tag wird der Eintrag "tagebucheintrag" angelegt
        SharedPreferences sharedPreferences = context.getSharedPreferences("Tagebucheinträge", MODE_PRIVATE); // MODE_PRIVAT -> Zugriff nur innerhalb der App möglich
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Eintrag" + day + "." + month + "." + year , tagebucheintrag);       // Wie heißt der angelegte String und was beinhaltet er
        editor.commit();                                                                      // Erst jetzt wird der Eintrag angelegt
    }


    public String getEintrag(int d, int m, int y){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Tagebucheinträge" , MODE_PRIVATE); // Wo ist der String abgespeichert
        return sharedPreferences.getString("Eintrag" + d + "." + m + "." + y , "");  //Wenn kein Eintrag vorhanden wird -> defValue wird zurückgegeben
    }
    ///////////////////////////////////////////////LUKI/////////////////////////////////////////////////////////////////////////////


    public void SaveBirthDate(String Datum)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Geburtsdatum", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Tag", Datum);
        editor.apply();
    }

    public int getBirthDate()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Geburtsdatum", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("Tag", 0);
    }
}
