package com.example.lukas.bottom_navigation5;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class EinstellungenActivity extends AppCompatActivity {

    ////////////////////////////////////////////////////////////////////SharedPreferences//////////////////////////////////////////////
    Activity context = this;
   public SharedPreferences sharedPrefdatum;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String TAG = "EinstellungenActivity";

    public TextView mDisplayDate;  // vorher ist das Datum ja bei der gleichen Textview angezeigt worden, wo man auch draufgeklickt hat
    public TextView DatumsAnzeige; //Jetzt wird das Datum an einer zweiten Textview angezeigt
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    public String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

///////////////////////////////////////////////////////Letzte Eingabe anzeigen//////////////////////////////////////////////
        int day = new PrefManagerActivity(context).getDay_Act();
        String d = Integer.toString(day);
        int month = new PrefManagerActivity(this).getMonth_Act();
        String m = Integer.toString(month);
        int year = new PrefManagerActivity(this).getYear_Act();
        String y = Integer.toString(year);
        String AusgabeDatum = d + "." + m + "." + y;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        DatumsAnzeige = (TextView) findViewById(R.id.date_display);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        sharedPrefdatum = context.getSharedPreferences("name_datum", MODE_PRIVATE);

DatumsAnzeige.setText(AusgabeDatum);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EinstellungenActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                date = day + "." + month + "." + year;
               save(day, month, year);
               DatumsAnzeige.setText(date);
                startActivity(new Intent(EinstellungenActivity.this, MainActivity.class));
            }


        };


    }

public void save(int day, int month, int year)
{
    new PrefManagerActivity(this).SaveBirthDate(day, month, year);
}


}








