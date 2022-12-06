package com.example.nscc_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homefragment = new HomeFragment();
    ContactFragment contactfragment = new ContactFragment();
    AddFragment addfragment = new AddFragment();
    CreditFragment creditfragment = new CreditFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomnavbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, homefragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, homefragment).commit();
                        return true;
                    case R.id.contacts:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, contactfragment).commit();
                        return true;
                    case R.id.add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, addfragment).commit();
                        return true;
                    case R.id.credit:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, creditfragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}