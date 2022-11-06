package com.example.appsantander;

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

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView cardButtonRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        cardButtonRecyclerView = findViewById(R.id.card_button_recycler_view);

        List<CardButton> buttons = new ArrayList<>();
        buttons.add(new CardButton("Pix", null, view -> {}));
        buttons.add(new CardButton("Pagar", null, view -> {}));
        buttons.add(new CardButton("Transferir", null, view -> {}));
        cardButtonRecyclerView.setAdapter(new CardItemAdapter(buttons, R.layout.card_item_white));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_activity_menu, menu);
        return true;
    }
}