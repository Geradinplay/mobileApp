package com.example.bk;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginIn extends AppCompatActivity {
    protected void onResume() {
        super.onResume();

        Button button = findViewById(R.id.button_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из xml
                EditText editTextIndex = findViewById(R.id.editTextIndex);
                EditText editTextPassword = findViewById(R.id.editTextPassword);
                // Получаем текст из EditText
                String index = editTextIndex.getText().toString();
                String password = editTextPassword.getText().toString();

                // Делаем что-то с полученными значениями, например, выводим их в Toast
                String message = "Index: " + index + ", Password: " + password;
                Toast.makeText(LoginIn.this, message, Toast.LENGTH_SHORT).show();

                // Здесь можно добавить дальнейшую обработку, например, проверку логина и пароля
            }
        });
    }
}
