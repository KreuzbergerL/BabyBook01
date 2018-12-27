package com.example.lukas.bottom_navigation5;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.mipmap.punkt_done_begin, "11.10.2018 - 11.11.2018", "Ultraschalluntersuchung"));  //Line 1 und Line 2 sind dann Datum und Untersuchung
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "11.10.2018 - 11.11.2018", "Ultraschalluntersuchung"));  //Line 1 und Line 2 sind dann Datum und Untersuchung
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_done, "11.10.2018 - 11.11.2018", "Ultraschalluntersuchung"));  //Line 1 und Line 2 sind dann Datum und Untersuchung
        exampleList.add(new ExampleItem(R.mipmap.punkt_progress, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, "11.10.2018 - 11.11.2018", "Ultraschalluntersuchung"));  //Line 1 und Line 2 sind dann Datum und Untersuchung
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));
        exampleList.add(new ExampleItem(R.mipmap.punkt_undone_end, "18.1.2019 - 4.3.2019", "Hüftuntersuchung"));

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);        //extra für Fragments so
        mRecyclerView.setHasFixedSize((true));
        mLayoutManager = new LinearLayoutManager(context);      //Da hab ich herumpfuscht, vorher is this dagestanden, hat aber nicht funktioniert
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}

