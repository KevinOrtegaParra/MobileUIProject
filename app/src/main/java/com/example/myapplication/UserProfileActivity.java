package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.database.SQLiteHelper;
import com.example.myapplication.modelo.User;

import java.text.BreakIterator;

public class UserProfileActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private SQLiteHelper dbHelper;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);

        dbHelper = new SQLiteHelper(this);
        userEmail = getIntent().getStringExtra("USER_EMAIL");
        userEmail = getIntent().getStringExtra("USER_EMAIL");

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        loadUserData(userEmail);

    }

    public void logout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void updates(View view){
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();

        User user = new User(0, name, userEmail, password);

        if (dbHelper.updateUser(user)) {
            Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view){
        if (dbHelper.deleteUser(userEmail)) {
            Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish(); // Regresar a LoginActivity
        } else {
            Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadUserData(String email) {
        User user = dbHelper.getUserByEmail(email);
        if (user != null) {
            etName.setText(user.getName());
            etEmail.setText(user.getEmail());
            etPassword.setText(user.getPassword());
        }
    }
}