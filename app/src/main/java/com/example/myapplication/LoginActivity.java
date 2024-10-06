package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.SQLiteHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private SQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.txt_email_login);
        etPassword = findViewById(R.id.txt_password_login);

        dbHelper = new SQLiteHelper(this);
    }

    public void singUpView(View view){
        Intent sing = new Intent(this, RegisterActivity.class);
        startActivity(sing);

    }

    public void login(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        boolean userExists = dbHelper.checkUser(email, password);
        if (userExists) {
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            Intent profile = new Intent(this, UserProfileActivity.class);
            profile.putExtra("USER_EMAIL", email);
            startActivity(profile);
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}