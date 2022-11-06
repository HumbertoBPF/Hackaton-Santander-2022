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

public class HealthSectionActivity extends AppCompatActivity {
    private RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        menuRecyclerView = findViewById(R.id.menu_recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<MenuItemButton> buttons = new ArrayList<>();
        buttons.add(new MenuItemButton("Plano saúde", null, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthSectionActivity.this, HealthAssuranceActivity.class);
                startActivity(intent);
            }
        }, null));
        buttons.add(new MenuItemButton("Seguro viagem", null, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthSectionActivity.this, TravelAssuranceActivity.class);
                startActivity(intent);
            }
        }, null));

        menuRecyclerView.setAdapter(new MenuItemAdapter(buttons));
    }
}