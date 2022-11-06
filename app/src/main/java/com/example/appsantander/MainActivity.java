package com.example.appsantander;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsantander.adapters.CardItemAdapter;
import com.example.appsantander.ui.CardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView cardButtonRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardButtonRecyclerView = findViewById(R.id.card_button_recycler_view);

        List<CardButton> buttons = new ArrayList<>();
        buttons.add(new CardButton("Ajuda", null, view -> {}));
        buttons.add(new CardButton("ID Santander", null, view -> {}));
        buttons.add(new CardButton("Acessar sua\nconta", null, view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }));
        cardButtonRecyclerView.setAdapter(new CardItemAdapter(buttons, R.layout.card_item_gray));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }
}