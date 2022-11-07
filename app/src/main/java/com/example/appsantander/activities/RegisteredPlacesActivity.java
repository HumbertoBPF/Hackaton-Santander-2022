package com.example.appsantander.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appsantander.R;
import com.example.appsantander.adapters.MenuItemAdapter;
import com.example.appsantander.ui.MenuItemButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisteredPlacesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_places);

        recyclerView = findViewById(R.id.recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<MenuItemButton> buttons = new ArrayList<>();
        buttons.add(new MenuItemButton("Consultas", null, null, null, R.drawable.ic_down));
        buttons.add(new MenuItemButton("Emergências", null, null, null, R.drawable.ic_down));

        recyclerView.setAdapter(new MenuItemAdapter(buttons));
    }
}