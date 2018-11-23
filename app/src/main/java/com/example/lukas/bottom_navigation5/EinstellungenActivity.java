package com.example.lukas.bottom_navigation5;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import com.example.lukas.bottom_navigation5.MainActivity;

import java.util.Calendar;

public class EinstellungenActivity extends AppCompatActivity {


    private static final String TAG = "EinstellungenActivity";

    public TextView mDisplayDate;  // vorher ist das Datum ja bei der gleichen Textview angezeigt worden, wo man auch draufgeklickt hat
    public TextView DatumsAnzeige; //Jetzt wird das Datum an einer zweiten Textview angezeigt
    private DatePickerDialog.OnDateSetListener mDateSetListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        DatumsAnzeige = (TextView) findViewById(R.id.date_display);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);


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

                String date = month + "/" + day + "/" + year;
               DatumsAnzeige.setText(date);
                saveInfo();
            }


        };


    }


    public void saveInfo()
    {
        SharedPreferences file1 = getSharedPreferences("date_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = file1.edit();

        editor.putString("Datum", DatumsAnzeige.getText().toString());
        editor.apply();
        editor.commit();
    }



}




