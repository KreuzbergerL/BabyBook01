package com.example.lukas.bottom_navigation5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar01);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.navigation);     //Von mir hinzugefügt
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
//---------------------Aufmachen des Einstellungen Buttons beim anklicken
    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu1);
        return super.onCreateOptionsMenu(menu1);
    }
//--------------------------------------Aktion beim anklicken von Einstellungen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       Intent einstellungen = new Intent(this, EinstellungenActivity.class); //neuer Intent
       startActivity(einstellungen); //activity aufmachen
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId())
            {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_referenzen:
                    selectedFragment = new ReferenzenFragment();
                    break;
                case R.id.nav_tagebuch:
                    selectedFragment = new DiaryFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

}
