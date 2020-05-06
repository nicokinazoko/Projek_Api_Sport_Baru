package com.example.projek_api_sport.VIew.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.projek_api_sport.R;
import com.example.projek_api_sport.VIew.Fragment.PersonFragment;
import com.example.projek_api_sport.VIew.Fragment.TeamFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //deklarasi BottomNav
    private BottomNavigationView bottomNavigationView;

    //deklarasi untuk fragment yang akan dipilih
    private Fragment selectedFragment                           =   new TeamFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Memanggil BottomNav dari activity_main
        bottomNavigationView                                    =   findViewById(R.id.activitymain_bottomnav);

        //agar bisa di klik bottom nav nya
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //kondisi dengan dua id akan dipilih salah satu jika di klik
        switch (menuItem.getItemId())
        {
            case R.id.menu_bottomnav_team:
                selectedFragment                                =   new TeamFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_person:
                selectedFragment                                =   new PersonFragment();
                loadFragment(selectedFragment);
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activiymain_fragmentcontainer,selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}
