package com.example.lukas.bottom_navigation5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

public class DiaryFragment extends Fragment implements View.OnClickListener {

    public EditText txt_Tagebucheintrag;
    public Button btn_tagebucheintragerstellen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        txt_Tagebucheintrag = (EditText) view.findViewById(R.id.txt_Tagebucheintrag);
        btn_tagebucheintragerstellen = (Button) view.findViewById(R.id.btn_Tagebucheintrag_erstellen);

        btn_tagebucheintragerstellen.setOnClickListener(this);

        String stringiEintrag = new PrefManager(this).getEintrag();
        txt_Tagebucheintrag.setText(stringiEintrag);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(!txt_Tagebucheintrag.getText().toString().matches("")) {
            new PrefManager(this).SaveTagebucheinträge(txt_Tagebucheintrag.getText().toString());
            Toast msg = Toast.makeText(getContext(), "Tagebucheintrag erstellt oder bearbeitet", Toast.LENGTH_SHORT);
            msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
            msg.show();
        }else {
            Toast msg = Toast.makeText(getContext(), "Zunächst Tagebucheintrag erstellen", Toast.LENGTH_SHORT);
            msg.setGravity(Gravity.BOTTOM, msg.getXOffset()/2, msg.getYOffset()/2);
            msg.show();

            //Was passiert, wenn kein Tagebucheintrag vorhanden ist aber trotzdem auf den Button geklickt wird
        }
    }
}
