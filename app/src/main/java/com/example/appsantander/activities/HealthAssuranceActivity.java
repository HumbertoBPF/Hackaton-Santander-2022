package com.example.appsantander.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsantander.R;
import com.example.appsantander.adapters.MenuItemAdapter;
import com.example.appsantander.ui.MenuItemButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HealthAssuranceActivity extends AppCompatActivity {

    private RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_assurance);

        menuRecyclerView = findViewById(R.id.menu_recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<MenuItemButton> buttons = new ArrayList<>();
        buttons.add(new MenuItemButton("Conheça nossos planos", R.drawable.ic_check, view -> {
            Intent intent = new Intent(HealthAssuranceActivity.this, HealthAssurancePlanActivity.class);
            startActivity(intent);
        }, null, R.drawable.ic_arrow_right));
        buttons.add(new MenuItemButton("Redes credenciadas", R.drawable.ic_check, view -> {
            Intent intent = new Intent(HealthAssuranceActivity.this, TravelAssuranceActivity.class);
            startActivity(intent);
        }, null, R.drawable.ic_arrow_right));

        menuRecyclerView.setAdapter(new MenuItemAdapter(buttons));
    }
}