package com.example.lukas.bottom_navigation5;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.zip.Inflater;

public class ReferenzenFragment extends Fragment {

    double[][] groeße_Jungen = {{0, 44.5, 55.6}, {1, 48.9, 60.6}, {2, 52.4, 64.4} , {3, 55.3, 67.7} , {4, 57.6 , 70.1} , {5, 59.6 , 72.2}, {6, 61.2, 74}, {7,62.7, 75.7}, {8, 64, 77.2} , {9, 65.2, 78.7} , {10, 66.4, 80.1} ,{11, 67.7, 81.5}, {12,68.6, 82.9}, {13,69.9, 84.2}, {14, 70.6, 85.5}, {15 , 71.6 , 86.7}, {16, 72.5, 88}, {17, 73.3, 89.1} , {18, 74.2, 90.4}, {19, 75, 91.5}, {20, 75.8, 92.8} , {21 , 76.5 , 93.8}, {22, 77.2, 94.9},{23, 78, 95.9}, {24, 78, 96.3}, {25,78.6 , 97.3 }, {26 , 79.3, 98.3}, {27, 79.9, 99.3 } , {28, 80.5, 100.3} , {29, 81.1, 101.2} , {30, 81.7, 102.1} , {31, 82.3, 103} ,{32, 82.8, 103.9}, {33, 83.4, 104.8}, {34, 83.9, 105.6} , {35, 84.4, 106.4} , {36 , 85, 107.2}, {37, 85.5, 108}, {38, 86, 108.8}, {39, 86.5, 109.5} , {40, 87, 110.3}, {41, 87.5, 111}, {42, 88, 111.7}, {43, 88.4 , 112.5} , {44, 88.9, 113.2}, {45, 89.4, 113.9} , {46, 89.9, 114.6}, {47, 90.3, 115.2}, {48, 90.7, 115.7}, {49, 91.2, 116.6}, {50,91.6, 117.3} ,{51 , 92.1, 117.9}, {52, 92.5, 118.6, }, {53, 93, 119.2}, {54, 93.4, 119.9}, {55, 93.9, 120.6}, {56 , 94.3 , 121.2} , {57 , 94.7 , 121.9} , {58 , 95.2, 122.6} , {59, 95.6, 123.2} , {60, 96.1, 123.9}};
    double[][] gewicht_Jungen = {{0, 2.1, 5}, {1, 2.9, 6.6}, {2, 3.8, 8} , {3, 4.4, 9} , {4, 4.9 , 9.7} , {5, 5.3 , 10.4}, {6, 5.7, 10.9}, {7,5.9, 11.4}, {8, 6.2, 11.9} , {9, 6.4, 12.3} , {10, 6.6, 12.7} ,{11, 6.8, 13}, {12,6.9, 13.3}, {13,7.1,13.7 }, {14, 7.2, 14}, {15 , 7.4 , 14.3}, {16, 7.5, 14.6}, {17, 7.7, 14.9} , {18, 7.8, 15.3}, {19, 8, 15.6}, {20, 1.8, 15.9} , {21 , 8.2 , 16.2}, {22, 8.4, 16.5},{23, 8.5, 16.8}, {24, 8.6, 17.1}, {25, 8.8 , 17.5 }, {26 , 8.9, 17.8}, {27, 9, 18.1 } , {28, 9.1, 18.4} , {29, 9.2, 18.7} , {30,  9.4, 19} , {31, 9.5, 19.3} ,{32, 9.6, 19.6}, {33, 9.7, 19.9}, {34, 9.8, 20.2} , {35, 9.9, 20.4} , {36 , 10, 20.7}, {37, 10.1, 21}, {38, 10.2, 21.3}, {39, 10.3, 21.6} , {40, 10.4, 21.9}, {41, 10.5, 22.1}, {42, 10.6, 22.4}, {43, 10.7 , 22.7} , {44, 10.8, 23}, {45, 10.9, 23.3} , {46, 11, 23.6}, {47, 11.1, 23.9}, {48, 11.2, 24.4}, {49, 11.3, 24.6}, {50, 11.4, 24.8} ,{51 , 11.5 , 25.1}, {52, 11.6, 25.4} ,{53, 11.7, 25.7}, {54, 11.8, 26}, {55, 11.9, 26.3}, {56 , 12 , 26.6} , {57 , 12.1 , 26.9} , {58 , 12.2, 27.9} , {59, 12.3, 27.6} , {60, 12.4, 27.9}};

    double[][] groeße_Maedchen = {{0, 43.6, 54.7}, {1, 47.8, 59.5}, {2, 51, 63.2} , {3, 53.5, 66.1} , {4, 55.6 , 68.6} , {5, 57.4 , 70.7}, {6, 58.9, 72.5}, {7,60.3, 74.2}, {8, 61.7, 75.8} , {9, 62.9, 77.4} , {10, 64.1, 78.9} ,{11, 65.2, 80.3}, {12,66.3, 81.7}, {13,67.3, 83.1}, {14, 68.3, 84.4}, {15 , 69.3 , 85.7}, {16, 70.2, 87}, {17, 71.1, 88.2} , {18, 72, 89.4}, {19, 72.8, 90.6}, {20, 73.7, 91.7} , {21 , 74.5 , 92.9}, {22, 75.2, 94},{23, 76, 95.4}, {24, 76, 95.4}, {25,76.8 , 96.4 }, {26 , 77.5, 97.4}, {27, 78.1, 98.4 } , {28, 78.8, 99.4} , {29, 79.5, 100.3} , {30, 80.1, 101.3} , {31, 80.7, 102.2} ,{32, 81.3, 103.1}, {33, 81.9, 103.9}, {34, 82.5, 104.8} , {35, 83.1, 105.6} , {36 , 83.6, 106.5}, {37, 84.2, 107.3}, {38, 84.7, 108.1}, {39, 85.3, 108.9} , {40, 85.8, 109.7}, {41, 86.3, 110.5}, {42, 86.8, 111.2}, {43, 87.4 , 112} , {44, 87.9, 112.7}, {45, 88.4, 113.5} , {46, 88.9, 114.2}, {47, 89.3, 114.9}, {48, 89.9, 115.7}, {49, 90.3, 116.4}, {50,90.7, 117.1} ,{51 , 91.2, 117.7}, {52, 91.7, 118.4 }, {53, 92.1, 119.1}, {54, 92.6, 119.8}, {55, 93, 120.4}, {56 , 93.4 , 121.1} , {57 , 93.9 , 121.8} , {58 , 94.3, 122.4} , {59, 94.7, 123.1} , {60, 95.2, 123.7}};
    double[][] gewicht_Maedchen = {{0, 2, 4.8}, {1, 2.7, 6.2}, {2, 3.4, 7.5} , {3, 4, 8.5} , {4, 4.4 , 9.3} , {5, 4.8 , 10}, {6, 5.1, 10.6}, {7,5.3, 11.1}, {8, 5.6, 11.6} , {9, 5.8, 12} , {10, 5.9, 12.4} ,{11, 6.1, 12.8}, {12,6.3, 13.1}, {13,6.4, 13.5}, {14, 6.6, 13.8}, {15 , 6.7 , 14.1}, {16, 6.9, 14.5}, {17, 7, 14.8} , {18, 7.2, 15.1}, {19, 7.3, 15.4}, {20, 7.5, 15.7} , {21 , 7.6 , 16}, {22, 7.8, 16.4},{23, 7.9, 16.7}, {24, 8.1, 17}, {25,8.2, 17.3 }, {26 , 8.4, 17.7}, {27, 8.5, 18} , {28, 8.6, 18.3} , {29, 8.8, 18.7} , {30, 8.9, 19} , {31, 9, 19.3} ,{32, 9.1, 19.6}, {33, 9.3, 20}, {34, 9.4, 20.3} , {35, 9.5, 20.6} , {36 , 9.6, 20.9}, {37, 9.7, 21.3}, {38, 9.8, 21.6}, {39, 9.9, 22} , {40, 10.1, 22.3}, {41, 10.2, 22.7}, {42, 10.3, 23}, {43,  10.4 , 23.4} , {44, 10.5, 23.7}, {45, 10.6, 24.1} , {46, 10.7, 24.5}, {47, 10.8, 24.8}, {48, 10.9, 25.2}, {49, 11, 25.5}, {50,11.1, 25.9} ,{51 , 11.2, 26.3}, {52, 11.3, 26.6 }, {53, 11.4, 27}, {54, 11.5, 27.4}, {55, 11.6, 27.7}, {56 , 11.7 , 28.1} , {57 , 11.8 , 28.5} , {58 , 11.9, 28.8} , {59, 12, 29.2} , {60, 12.1, 29.5}};


    public SeekBar seekbar;

    public ImageView icon;

    public Switch switch_Geschlecht;

    public TextView text_gewicht;
    public TextView text_groeße;
    public TextView text_alter;
    public TextView text_maedcchen;

    int progress = 0;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_references, container, false);



        switch_Geschlecht = (Switch) view.findViewById(R.id.switch_geschlecht);

        seekbar = (SeekBar) view.findViewById(R.id.seekBar);



        text_gewicht = (TextView) view.findViewById(R.id.txt_Gewicht);
        text_groeße = (TextView) view.findViewById(R.id.txt_Größe);
        text_alter = (TextView) view.findViewById(R.id.txt_alter);
        text_maedcchen = (TextView) view.findViewById(R.id.txt_maedchen);

        icon = (ImageView) view.findViewById(R.id.baby_icon);


        seekbar.setMax(60);             // Das Maximum der SeekBar sind 60 Monate
        seekbar.setProgress(progress);
        seekbar.setX(0);
        // Startwert is bei 0

        text_gewicht.setText(gewicht_Jungen[progress][1] + " - " + gewicht_Jungen[progress][2] + " kg");
        text_groeße.setText(groeße_Jungen[progress][1] + " - " + groeße_Jungen[progress][2] + " cm");

        text_maedcchen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        switch_Geschlecht.setTextColor(getResources().getColor(R.color.green));

        icon.getLayoutParams().height =  300;
        icon.getLayoutParams().width =  300;


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {              //Ändert sich was an der Seekbar?
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progress = i;

                if (progress == 0) {
                    text_alter.setText("Geburt");
                } else {
                    text_alter.setText(progress + " Monate");
                }

                //Welcher der beiden RadioButton ist momentan aktiv
                if(switch_Geschlecht.isChecked()) {
                    text_gewicht.setText(gewicht_Maedchen[progress][1] + " - " + gewicht_Maedchen[progress][2] + " kg");
                    text_groeße.setText(groeße_Maedchen[progress][1] + " - " + groeße_Maedchen[progress][2] + " cm");

                    text_maedcchen.setTextColor(getResources().getColor(R.color.green));
                    switch_Geschlecht.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }

                else{
                    text_gewicht.setText(gewicht_Jungen[progress][1] + " - " + gewicht_Jungen[progress][2] + " kg");
                    text_groeße.setText(groeße_Jungen[progress][1] + " - " + groeße_Jungen[progress][2] + " cm");

                    text_maedcchen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    switch_Geschlecht.setTextColor(getResources().getColor(R.color.green));
                }

                icon.getLayoutParams().height = ( 3 * i ) + 300;
                icon.getLayoutParams().width = ( 3 * i ) + 300;
                icon.requestLayout();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switch_Geschlecht.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(switch_Geschlecht.isChecked()) {
                    text_gewicht.setText(gewicht_Maedchen[progress][1] + " - " + gewicht_Maedchen[progress][2] + " kg");
                    text_groeße.setText(groeße_Maedchen[progress][1] + " - " + groeße_Maedchen[progress][2] + " cm");

                    text_maedcchen.setTextColor(getResources().getColor(R.color.green));
                    switch_Geschlecht.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }

                else{
                    text_gewicht.setText(gewicht_Jungen[progress][1] + " - " + gewicht_Jungen[progress][2] + " kg");
                    text_groeße.setText(groeße_Jungen[progress][1] + " - " + groeße_Jungen[progress][2] + " cm");

                    text_maedcchen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    switch_Geschlecht.setTextColor(getResources().getColor(R.color.green));
                }

            }
        });

        return view;

    }


}

