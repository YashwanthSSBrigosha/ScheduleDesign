package com.example.schedulepage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FFFFFF"));

        // Set BackgroundDrawable


        actionBar.setBackgroundDrawable(colorDrawable);

//        toolbar = findViewById(R.id.customToolBar);
//        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        createCard();
        buildRecyclerView();


    }

    public void createCard() {

        scheduleArrayList.add(new Schedule("Botany", "XII - A: Commerce", "Joel E. Rice", R.drawable.lab_offline));
        scheduleArrayList.add(new Schedule("Accountancy", "XI - A: Commerce", "Dorothy H. Allie", R.drawable.lab_broadcast));
        scheduleArrayList.add(new Schedule("Social Science", "XI - C", "Ariene J. Neely", R.drawable.lab_zoom40));
        scheduleArrayList.add(new Schedule("Social Science", "XI - C", "Dorothy h. Allie", R.drawable.lab_conference));

    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recViewForCard);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ScheduleAdapter(scheduleArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
}