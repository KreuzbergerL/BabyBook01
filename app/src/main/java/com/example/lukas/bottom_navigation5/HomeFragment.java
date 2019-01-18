package com.example.lukas.bottom_navigation5;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;


public class HomeFragment extends Fragment{
Context context;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
// "bridge between the arraylist and the recycler view". Lädt die Items der Reihe nach in die RecyclerView

    private RecyclerView.LayoutManager mLayoutManager;

    /* Recyclerview und LayoutManager sind schon vorgefertigt.
    Wir brauchen nur noch eine Klasse für den Adapter*/





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        int[] arr_date;

        int day = new PrefManager(this).getDay_Frag();
        int month = new PrefManager(this).getMonth_Frag();
        int year = new PrefManager(this).getYear_Frag();

        int post_day = day;         //Werte für nach dem Geburtstermin (post = nach)
        int post_month = month;
        int post_year = year;

        arr_date = calcBegin(day, month, year);

         day = arr_date[0];
         month = arr_date[1];
         year = arr_date[2];




        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.mipmap.punkt_done_begin, calcDate(day, month, year, 0, 16), "Untersuchung mit Blutuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, calcDate(day, month, year, 17, 20), "Interne Untersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, calcDate(day, month, year, 25, 28), "Untersuchung mit Blutuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, calcDate(day, month, year, 30, 34), "Routineuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, calcDate(day, month, year, 35, 38), "Routineuntersuchung"));
        ////////////////////////////////////////////////////////Geburt////////////////////////////////////////////////////////////////////////////////////
        exampleList.add(new ExampleItem(R.mipmap.punkt_progress, calcDate(post_day, post_month, post_year, 0, 1), "Untersuchung im Spital"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, calcDate(post_day, post_month, post_year, 4, 6), "Routine- und orthopädische Untersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, calcDate(post_day, post_month, post_year, 8, 21), "Routine- und Hals-Nasen-Ohren Untersuchung"));  //Line 1 und Line 2 sind dann Datum und Untersuchung
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, calcDate(post_day, post_month, post_year, 26, 39), "Routineuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone_end, calcDate(post_day, post_month, post_year, 39, 60), "Routine- und Augenuntersuchung"));


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize((true));
        mLayoutManager = new LinearLayoutManager(context);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public static String calcDate(int fday, int fmonth, int fyear, int fAnfangswoche, int fEndwoche)
    {
        int maxday = 30;		//maybe wrong
        int fAnfangstage = fAnfangswoche * 7;
        int fEndtage = fEndwoche * 7;

        int a_day = fday;
        int a_month = fmonth;
        int a_year = fyear;

        int e_day = fday;		//e_day ... Tag des Endwertes
        int e_month = fmonth;
        int e_year = fyear;


//////////////////////////////////////////////////////////// FOR Schleife für Anfangswert//////////////////////////////////////////
        for(int i = 0; i < fAnfangstage; i++) {
////////////////////////////////////////////////////////////switches/////////////////////////////////////////////////////////////////
            switch(a_month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: maxday = 31;
                    break;
            }
            switch(a_month) {
                case 4:
                case 6:
                case 9:
                case 11: maxday = 30;
                    break;
            }
            switch(a_month) {
                case 2: maxday = 28;		// Februar
                    break;
            }
            switch(a_year) {
                case 2020:
                case 2024:
                case 2028:
                case 2032:
                case 2036:
                case 2040:
                    switch(a_month) {
                        case 2: maxday = 29;		// Februar im Schaltjahr
                            break;
                    }
                    break;}
///////////////////////////////////////////////////////////IF Anweisungen//////////////////////////////////////////////////////////
            if(a_day <= maxday) a_day++;		//Raufzählen wenn der letzte Tag des Monats noch nicht erreicht ist

            if(a_day > maxday) 				//wenn der letzte Tag des Monats erreicht ist
            {
                a_month++;
                a_day = 1;
            }

            if(a_month > 12)					// Wenn das Jahr zu Ende ist
            {
                a_year++;
                a_month = 1;
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }

////////////////////////////////////////////////////////////FOR Schleife für Endwert//////////////////////////////////////////
        for(int i = 0; i < fEndtage; i++) {
////////////////////////////////////////////////////////////switches/////////////////////////////////////////////////////////////////
            switch(e_month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: maxday = 31;
                    break;
            }
            switch(e_month) {
                case 4:
                case 6:
                case 9:
                case 11: maxday = 30;
                    break;
            }
            switch(e_month) {
                case 2: maxday = 28;		// Februar
                    break;
            }
            switch(e_year) {
                case 2020:
                case 2024:
                case 2028:
                case 2032:
                case 2036:
                case 2040:
                    switch(e_month) {
                        case 2: maxday = 29;		// Februar im Schaltjahr
                            break;
                    }
                    break;}
///////////////////////////////////////////////////////////IF Anweisungen//////////////////////////////////////////////////////////
            if(e_day <= maxday) e_day++;		//Raufzählen wenn der letzte Tag des Monats noch nicht erreicht ist

            if(e_day > maxday) 				//wenn der letzte Tag des Monats erreicht ist
            {
                e_month++;
                e_day = 1;
            }

            if(e_month > 12)					// Wenn das Jahr zu Ende ist
            {
                e_year++;
                e_month = 1;
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
        String se_day = Integer.toString(e_day);			//se_ ... String Endwert (also für return)
        String se_month = Integer.toString(e_month);
        String se_year = Integer.toString(e_year);


        String sa_day = Integer.toString(a_day);		// sa_ .... String Anfangswert (also für return)
        String sa_month = Integer.toString(a_month);
        String sa_year = Integer.toString(a_year);


        String returner = sa_day + "." + sa_month + "." + sa_year + " bis " + se_day + "." + se_month + "." + se_year;
        return returner;
    }

    public static int[] calcBegin(int fday, int fmonth, int fyear)
    {
        int day = fday;
        int month = fmonth;
        int year = fyear;
        int maxday = 0;
        int[] returner = new int[3];

        for (int i = 1; i<280; i++)
        {
            switch(month) {

                case 5:
                case 7:
                case 8:
                case 10:
                case 12: maxday = 30;
                    break;
            }
            switch(month) {
                case 1:
                case 4:
                case 2:
                case 6:
                case 9:
                case 11: maxday = 31;
                    break;
            }
            switch(month) {
                case 3: maxday = 28;		// Februar
                    break;
            }
            switch(year) {
                case 2020:
                case 2024:
                case 2028:
                case 2032:
                case 2036:
                case 2040:
                    switch(month) {
                        case 3: maxday = 29;		// Februar im Schaltjahr
                            break;
                    }
                    break;}

            if(day > 0) day--;
            if(day == 0)
            {
                month --;
                day = maxday;
            }
            if(month == 0)
            {
                year--;
                month = 12;
            }
        }

        returner[0] = day;
        returner[1] = month;
        returner[2] = year;

        return returner;
    }
}

