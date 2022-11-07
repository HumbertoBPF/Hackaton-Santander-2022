package com.example.appsantander.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsantander.R;
import com.example.appsantander.adapters.HealthAssurancePlanAdapter;
import com.example.appsantander.ui.HealthAssurancePlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HealthAssurancePlanActivity extends AppCompatActivity {

    private RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_assurance_plan);

        menuRecyclerView = findViewById(R.id.menu_recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<HealthAssurancePlan> plans = new ArrayList<>();

        plans.add(new HealthAssurancePlan("Completo", Arrays.asList(getResources().getStringArray(R.array.complete_plan_description)), "R$ 682,00"));
        plans.add(new HealthAssurancePlan("Intermediário", Arrays.asList(getResources().getStringArray(R.array.intermediate_plan_description)), "R$ 401,00"));
        plans.add(new HealthAssurancePlan("Básico", Arrays.asList(getResources().getStringArray(R.array.basic_plan_description)), "R$ 226,00"));

        menuRecyclerView.setAdapter(new HealthAssurancePlanAdapter(HealthAssurancePlanActivity.this, plans));
    }
}