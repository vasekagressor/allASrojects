package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater() .inflate (R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptiosItemSelected (MenuItem item) {
        int id = item.getItemId();
        TextView headerView = findViewById(R.id.selecteMenuItem);
        switch (id) {
            case R.id.action_settings:
                headerView.setText("настройки");
                return true;
            case R.id.open_settings:
                headerView.setText("открыть");
                return true;
            case R.id.save_settings:
                headerView.setText("сохранить");
                return true;
           }
           //headerView.setText (item.getTitle());
           return super.onOptionsItemSelected(item);
        }
    }
