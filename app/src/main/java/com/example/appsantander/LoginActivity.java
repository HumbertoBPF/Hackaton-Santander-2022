package com.example.appsantander;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sp;

    private EditText cpfEditText;
    private Switch rememberCpfSwitch;
    private EditText passwordEditText;
    private Switch rememberPasswordSwitch;
    private Button loginButton;

    private Boolean rememberCpf = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cpfEditText = findViewById(R.id.cpf_edit_text);
        rememberCpfSwitch = findViewById(R.id.remember_cpf_switch);
        passwordEditText = findViewById(R.id.password_edit_text);
        rememberPasswordSwitch = findViewById(R.id.remember_password_switch);
        loginButton = findViewById(R.id.login_button);

        sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String savedCpf = sp.getString("userCpf", null);

        if (savedCpf != null){
            cpfEditText.setText(savedCpf);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rememberCpf){
                    saveStringOnSharedPref("userCpf", cpfEditText.getText().toString());
                }

                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        rememberCpfSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rememberCpf = b;
            }
        });
    }

    private void saveStringOnSharedPref(String label, String string) {
        SharedPreferences.Editor myEdit = sp.edit();
        myEdit.putString(label, string);
        myEdit.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }
}