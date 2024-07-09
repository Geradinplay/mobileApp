package com.example.bk;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    protected void onCreate() {
        super.onResume();

        Button button = findViewById(R.id.button_registration);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из xml
                EditText editTextName= findViewById(R.id.editTextName);
                EditText editTextIndex = findViewById(R.id.editTextIndex);
                EditText editTextBirthDate= findViewById(R.id.editTextBDate);
                EditText editTextCourse = findViewById(R.id.editTextCourse);
                EditText editTextPassword = findViewById(R.id.editTextPassword);
                // Получаем текст из EditText
                String name = editTextName.getText().toString();
                String index = editTextIndex.getText().toString();
                String bDate = editTextBirthDate.getText().toString();
                String course = editTextCourse.getText().toString();
                String password = editTextPassword.getText().toString();
                boolean dataAccess=true;
                if(name!=null&&name.length()>0&&!name.contains(" ")){
                    editTextName.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                dataAccess=false;
                }
                if(index!=null&&index.length()>0){
                    editTextIndex.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                    dataAccess=false;
                }
                if(bDate!=null&&bDate.length()>0){
                    editTextBirthDate.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                    dataAccess=false;
                }
                if(course!=null&&course.length()>0){
                    editTextCourse.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                    dataAccess=false;
                }
                if(password!=null&&password.length()>0){
                    editTextPassword.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                    dataAccess=false;
                }
                if(dataAccess=true){
                    //Отправка пост запроса





                    setContentView(R.layout.activity_main);
                }

                // Здесь можно добавить дальнейшую обработку, например, проверку логина и пароля
            }
        });
    }
}
