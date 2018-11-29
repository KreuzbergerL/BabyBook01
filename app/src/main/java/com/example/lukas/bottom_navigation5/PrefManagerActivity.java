package com.example.lukas.bottom_navigation5;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

public class PrefManagerActivity extends AppCompatActivity {
    Context context;
    PrefManagerActivity(Context context){
        this.context=context;

    }


    public void SaveBirthDate(String Datum)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Geburtsdatum", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putString("Date", Datum);
        editor.apply();
    }

    public String getBirthDate()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Geburtsdatum", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Date", " ");
    }
}
