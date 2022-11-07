package com.example.appsantander.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appsantander.R;
import com.example.appsantander.adapters.MenuItemAdapter;
import com.example.appsantander.ui.MenuItemButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelAssuranceActivity extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_assurance);

        recyclerView1 = findViewById(R.id.recycler_view_1);
        recyclerView2 = findViewById(R.id.recycler_view_2);
        recyclerView3 = findViewById(R.id.recycler_view_3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_dark);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadContentRecyclerView1();
        loadContentRecyclerView2();
        loadContentRecyclerView3();
    }

    protected void loadContentRecyclerView3() {
        List<MenuItemButton> buttons3 = new ArrayList<>();
        buttons3.add(new MenuItemButton("Central de atendimento", R.drawable.ic_hands_heart, null
                , "Para dúvidas e transações", R.drawable.ic_down));
        buttons3.add(new MenuItemButton("SAC", R.drawable.ic_hands_heart, null,
                "Sugestões, reclamações e elogios", R.drawable.ic_down));
        buttons3.add(new MenuItemButton("Ouvidoria", R.drawable.ic_hands_heart, null,
                "Cheque reclamações feitas no SAC", R.drawable.ic_down));

        recyclerView3.setAdapter(new MenuItemAdapter(buttons3));
    }

    private void loadContentRecyclerView2() {
        List<MenuItemButton> buttons2 = new ArrayList<>();
        buttons2.add(new MenuItemButton("Dúvidas frequentesl", R.drawable.ic_hands_heart, null
                , "Tire suas dúvidas", null));

        recyclerView2.setAdapter(new MenuItemAdapter(buttons2));
    }

    private void loadContentRecyclerView1() {
        List<MenuItemButton> buttons = new ArrayList<>();
        buttons.add(new MenuItemButton("Cobertura nacional", R.drawable.ic_hands_heart, null
                , null, null));
        buttons.add(new MenuItemButton("Emergência 24h", R.drawable.ic_hands_heart, null,
                null, null));
        buttons.add(new MenuItemButton("Desconto em farmácias", R.drawable.ic_hands_heart, null,
                null, null));

        recyclerView1.setAdapter(new MenuItemAdapter(buttons));
    }
}