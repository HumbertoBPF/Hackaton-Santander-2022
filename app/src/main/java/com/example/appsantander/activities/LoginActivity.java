package com.example.appsantander.activities;

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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appsantander.R;

import java.util.HashMap;
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
                String cpfInput = cpfEditText.getText().toString();
                String passwordInput = passwordEditText.getText().toString();
                // Validate cpf
                if (!isValidCpf(cpfInput)){
                    Toast.makeText(getApplicationContext(), "CPF inválido", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Check password length
                if (passwordInput.length() < 7){
                    Toast.makeText(getApplicationContext(), "Senha inválida", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rememberCpf){
                    saveStringOnSharedPref("userCpf", cpfInput);
                }

                Intent intent = new Intent(LoginActivity.this, LoadingActivity.class);
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

    private boolean isValidCpf(String cpfInput){
        // Check length of the CPF
        if (cpfInput.length() != 11){
            return false;
        }
        // Check if all digits are equal
        HashMap<Character, Boolean> digitsMap = new HashMap<>();

        for (int i = 0;i < cpfInput.length();i++){
            Character digit = cpfInput.charAt(i);
            if (digitsMap.get(digit) == null){
                digitsMap.put(digit, true);
            }
        }

        if (digitsMap.size() == 1){
            return false;
        }
        // Check first validator digit
        int firstDigitValidator = 10*Integer.parseInt(cpfInput.charAt(0)+"") +
                9*Integer.parseInt(cpfInput.charAt(1)+"") +
                8*Integer.parseInt(cpfInput.charAt(2)+"") +
                7*Integer.parseInt(cpfInput.charAt(3)+"") +
                6*Integer.parseInt(cpfInput.charAt(4)+"") +
                5*Integer.parseInt(cpfInput.charAt(5)+"") +
                4*Integer.parseInt(cpfInput.charAt(6)+"") +
                3*Integer.parseInt(cpfInput.charAt(7)+"") +
                2*Integer.parseInt(cpfInput.charAt(8)+"");
        firstDigitValidator = (firstDigitValidator*10)%11;

        if (!Integer.toString(firstDigitValidator).equals(cpfInput.charAt(9)+"")){
            return false;
        }
        // Check second validator digit
        int secondDigitValidator = 11*Integer.parseInt(cpfInput.charAt(0)+"") +
                10*Integer.parseInt(cpfInput.charAt(1)+"") +
                9*Integer.parseInt(cpfInput.charAt(2)+"") +
                8*Integer.parseInt(cpfInput.charAt(3)+"") +
                7*Integer.parseInt(cpfInput.charAt(4)+"") +
                6*Integer.parseInt(cpfInput.charAt(5)+"") +
                5*Integer.parseInt(cpfInput.charAt(6)+"") +
                4*Integer.parseInt(cpfInput.charAt(7)+"") +
                3*Integer.parseInt(cpfInput.charAt(8)+"") +
                2*Integer.parseInt(cpfInput.charAt(9)+"");
        secondDigitValidator = (secondDigitValidator*10)%11;

        return Integer.toString(secondDigitValidator).equals(cpfInput.charAt(10) + "");
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