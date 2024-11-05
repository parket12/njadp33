package com.example.menu1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        if (savedInstanceState == null) {
            setFragment(new FirstFragment());
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.first_item) {
                setFragment(new FirstFragment());
                return true;
            } else if (item.getItemId() == R.id.second_item) {
                setFragment(new SecondFragment());
                return true;
            } else if (item.getItemId() == R.id.third_item) {
                setFragment(new ThirdFragment());
                return true;
            }
            return false;
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_first) {
                setFragment(new FirstFragment());
                drawerLayout.closeDrawers();
                return true;
            } else if (item.getItemId() == R.id.nav_second) {
                setFragment(new SecondFragment());
                drawerLayout.closeDrawers();
                return true;
            } else if (item.getItemId() == R.id.nav_third) {
                setFragment(new ThirdFragment());
                drawerLayout.closeDrawers();
                return true;
            }
            return false;
        });
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Все удалено, вау", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.open) {
            Toast.makeText(this, "Все создано", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.save) {
            Toast.makeText(this, "Все открыто жи ессссс", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
