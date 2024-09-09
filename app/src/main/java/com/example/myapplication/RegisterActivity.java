package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword, etPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.txt_name);
        etEmail = findViewById(R.id.txt_email);
        etPassword = findViewById(R.id.txt_password);
        etPassword2 = findViewById(R.id.txt_Password2);

    }

    public void singUp(View view){

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String password2 = etPassword2.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(this, "Ingrese el Nombre", Toast.LENGTH_LONG).show();
        }
        if(email.isEmpty()){
            Toast.makeText(this, "Ingrese el Email", Toast.LENGTH_LONG).show();
        }
        if(password.isEmpty()){
            Toast.makeText(this, "Ingrese la Contraseña", Toast.LENGTH_LONG).show();
        }
        if(password2.isEmpty()){
            Toast.makeText(this, "Confirma la Contraseña", Toast.LENGTH_LONG).show();
        }
        if(!(name.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty())){
            if(password.equals(password2)){
                Toast.makeText(this, "Registro Exitoso!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "La contraseña es diferente", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void LoginView(View view){
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

}