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

    ////////// Anlegen der globalen Variablen //////////
    public int calenderDay;
    public int calenderMonth;
    public int calenderYear;
    public CalendarView calender;
    public EditText txt_Tagebucheintrag;
    public Button btn_tagebucheintragerstellen;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        ////////// Heutiges Datum ermitteln und in Variablen schreiben //////////
        final Calendar kalendar = Calendar.getInstance();

        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

        calenderDay = Integer.parseInt( sdfDay.format(kalendar.getTime()));
        calenderMonth = Integer.parseInt( sdfMonth.format(kalendar.getTime()));
        calenderYear = Integer.parseInt( sdfYear.format(kalendar.getTime()));



        /////////// Referenzen auf die Optischen Elemente //////////
        calender = (CalendarView) view.findViewById(R.id.calendarView3);
        txt_Tagebucheintrag = (EditText) view.findViewById(R.id.txt_Tagebucheintrag);
        btn_tagebucheintragerstellen = (Button) view.findViewById(R.id.btn_Tagebucheintrag_erstellen);



        ////////// OnClickListener implementieren //////////
        btn_tagebucheintragerstellen.setOnClickListener(this);



        ////////// Beim Öffnen des Fragments soll bei einen bereits bestehenden Eintrag dieser angeszeigt...//////////
        String stringiEintrag = new PrefManager(this).getEintrag(calenderDay, calenderMonth, calenderYear);
        txt_Tagebucheintrag.setText(stringiEintrag);

        /////////// ...werden und sonst der Hint //////////
        if(txt_Tagebucheintrag.getText().toString().matches("")){
            txt_Tagebucheintrag.setHint("Hier Tagebucheintrag für den "+ calenderDay + "." + calenderMonth + "." + calenderYear + " erstellen.");
        }



        /////////// Wenn im Kalender aéin Tag ausgewählt wird //////////
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {



                ////////// Werte werden in die globalen Variablen überschrieben //////////
                calenderDay = dayOfMonth;
                calenderMonth = month + 1;
                calenderYear = year;



                ////////// Wenn für den ausgewählten Tag bereits ein Tagebucheintrag abgespeichert ist, wird dieser in die Textbox geschrieben //////////
                String stringiEintrag = new PrefManager(DiaryFragment.this).getEintrag(calenderDay, calenderMonth, calenderYear);
                txt_Tagebucheintrag.setText(stringiEintrag);



                ////////// Wenn keiner abgespeichert ist, wird der defValue ("") in die Textbox geschrieben
                ////////// Ist die Textbox daraufhin leer, wird ein Hint mit den entsprechenden Tag gesetzt //////////
                if(txt_Tagebucheintrag.getText().toString().matches("")){
                    txt_Tagebucheintrag.setHint("Hier Tagebucheintrag für den "+ calenderDay + "." + calenderMonth + "." + calenderYear + " erstellen.");
                }
            }
        });
        return view;
    }

    ////////// Wenn der Button geklickt wird //////////
    @Override
    public void onClick(View v) {



        ////////// Wenn der Inhalt der Textbox nicht leer ist, wir der IF-Weg ausgeführt //////////
        if(!txt_Tagebucheintrag.getText().toString().matches("")) {



            ////////// Wenn ein bereits bestehender Eintrag ohne jeglicher Bearbeitung  gespeichert werden soll, wirde der Benutzer zur Bearbeitung ersucht //////////
            if(txt_Tagebucheintrag.getText().toString().matches( new PrefManager(this).getEintrag(calenderDay, calenderMonth, calenderYear)))
            {
                Toast msg = Toast.makeText(getContext(), "Zunächst Tagebucheintrag für den " + calenderDay + "." + calenderMonth + "." + calenderYear + " bearbeiten.", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
                msg.show();



            ////////// Wenn der Tagebucheintrag erstellt oder bearbeitet wird //////////
            }else {

                new PrefManager(this).SaveTagebucheinträge(txt_Tagebucheintrag.getText().toString(), calenderDay, calenderMonth, calenderYear);

                Toast msg = Toast.makeText(getContext(), "Tagebucheintrag für den " + calenderDay + "." + calenderMonth + "." + calenderYear + " erstellt oder bearbeitet.", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
                msg.show();
            }



        ////////// Wenn die Textbox leer ist, wird ein Toast angezeigt, der den Benutzer zum Erstellen des Eintrags ersucht //////////
        }else {

            Toast msg = Toast.makeText(getContext(), "Zunächst Tagebucheintrag erstellen.", Toast.LENGTH_SHORT);
            msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
            msg.show();

        }
    }
}
