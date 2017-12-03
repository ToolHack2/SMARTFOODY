package com.example.user.smartfoody;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.example.user.smartfoody.Fragment.FoodEDay;
import com.example.user.smartfoody.Fragment.Home;
import com.example.user.smartfoody.Fragment.Shop;

public class MainActivity extends AppCompatActivity  {

    private BottomNavigationView bottomview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home home = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, home).commit();

        bottomview = (BottomNavigationView)findViewById(R.id.menubottom);
        bottomview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home)
                {
                    Home home = new Home();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, home).commit();
                    return  true;
                }
                if (item.getItemId() == R.id.shop)
                {
                    Shop shop = new Shop();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, shop).commit();
                    return  true;
                }
                if (item.getItemId() == R.id.food)
                {
                    FoodEDay foodEDay = new FoodEDay();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, foodEDay).commit();
                    return  true;
                }
                return true;
            }
        });
    }

}
