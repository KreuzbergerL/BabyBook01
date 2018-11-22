package com.example.lukas.bottom_navigation5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DiaryFragment extends Fragment implements View.OnClickListener {

    public int calenderDay;
    public int calenderMonth;
    public int calenderYear;
    public CalendarView calender;
    public EditText txt_Tagebucheintrag;
    public Button btn_tagebucheintragerstellen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

///////////// Heutiges Datum ermitteln ////////////////////////
        final Calendar kalendar = Calendar.getInstance();
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");


        calenderDay = Integer.parseInt( sdfDay.format(kalendar.getTime()));
        calenderMonth = Integer.parseInt( sdfMonth.format(kalendar.getTime()));
        calenderYear = Integer.parseInt( sdfYear.format(kalendar.getTime()));


        calender = (CalendarView) view.findViewById(R.id.calendarView3);
        txt_Tagebucheintrag = (EditText) view.findViewById(R.id.txt_Tagebucheintrag);
        btn_tagebucheintragerstellen = (Button) view.findViewById(R.id.btn_Tagebucheintrag_erstellen);

        btn_tagebucheintragerstellen.setOnClickListener(this);

        String stringiEintrag = new PrefManager(this).getEintrag(calenderDay, calenderMonth, calenderYear);
        txt_Tagebucheintrag.setText(stringiEintrag);

        if(txt_Tagebucheintrag.getText().toString().matches("")){
            txt_Tagebucheintrag.setHint("Hier Tagebucheintrag für den "+ calenderDay + "." + calenderMonth + "." + calenderYear + " erstellen.");
        }

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                    calenderDay = dayOfMonth;
                    calenderMonth = month + 1;
                    calenderYear = year;

                String stringiEintrag = new PrefManager(DiaryFragment.this).getEintrag(calenderDay, calenderMonth, calenderYear);
                txt_Tagebucheintrag.setText(stringiEintrag);

                if(txt_Tagebucheintrag.getText().toString().matches("")){
                    txt_Tagebucheintrag.setHint("Hier Tagebucheintrag für den "+ calenderDay + "." + calenderMonth + "." + calenderYear + " erstellen.");
                }



            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {

        if(!txt_Tagebucheintrag.getText().toString().matches("")) {

            if(txt_Tagebucheintrag.getText().toString().matches( new PrefManager(DiaryFragment.this).getEintrag(calenderDay, calenderMonth, calenderYear)))
            {
                Toast msg = Toast.makeText(getContext(), "Zunächst Tagebucheintrag für den " + calenderDay + "." + calenderMonth + "." + calenderYear + " bearbeiten.", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
                msg.show();
            }else {

                new PrefManager(this).SaveTagebucheinträge(txt_Tagebucheintrag.getText().toString(), calenderDay, calenderMonth, calenderYear);

                Toast msg = Toast.makeText(getContext(), "Tagebucheintrag für den " + calenderDay + "." + calenderMonth + "." + calenderYear + " erstellt oder bearbeitet.", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
                msg.show();
            }

        }else {

            Toast msg = Toast.makeText(getContext(), "Zunächst Tagebucheintrag erstellen.", Toast.LENGTH_SHORT);
            msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
            msg.show();

            //Was passiert, wenn kein Tagebucheintrag vorhanden ist aber trotzdem auf den Button geklickt wird
        }
    }
}
