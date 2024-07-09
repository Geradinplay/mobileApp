package com.example.bk;


import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Customer customer;
//Customer customer= new Customer("Oleg olegovich", "59-43", LocalDate.of(2024, 7, 7), 1, "password");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //установка оболочки
        setContentView(R.layout.activity_main);

        TextView name = findViewById(R.id.customer_name);
        TextView index = findViewById(R.id.customer_index);
        TextView bDate = findViewById(R.id.customer_birthDay);
        TextView Ofcourse = findViewById(R.id.customer_course);

        //Выводит все элементы map в блок scroll
        ScrollView scrollMenuSubjectsScrollView=findViewById(R.id.subjects_scroll_view);
        LinearLayout scrollMenuSubjectsLinearLayout = findViewById(R.id.subjects_linear_layout);

        LinearLayout.LayoutParams layoutParams_subjects = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpValueTopSubjects = 15f; //
        int pxValueTopSubjects = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValueTopSubjects, displayMetrics);
        layoutParams_subjects.topMargin = pxValueTopSubjects;

        float dpValueLeftSubjects = 3f; //
        int pxValueLeftSubjects = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValueLeftSubjects, displayMetrics);
        layoutParams_subjects.leftMargin = pxValueLeftSubjects;


        //Проверка есть ли у приложения данные насчет предметов, если нет запрашивает с сервера
        if(customer!=null){
            if(customer.getSubjects()!=null) {
                for (Map.Entry<String, Integer> entry : customer.getSubjects().entrySet()) {
                    TextView subject = new TextView(this);
                    subject.setText(entry.getValue());
                    subject.setTextColor(ContextCompat.getColor(this, R.color.white));
                    subject.setLayoutParams(layoutParams_subjects);
                    scrollMenuSubjectsLinearLayout.addView(subject);
                }
            }else{
                TextView subject = new TextView(this);
                ApiCustomer apiCustomer = new ApiCustomer();
                //cоздает класс по образу интерфейса
                ApiService service = apiCustomer.getRetrofitInstance().create(ApiService.class);
                //Подготовка метода к вызову
                Call<HelloObject> repos = service.helloObject();

                repos.enqueue(new Callback<HelloObject>() {
                    @Override
                    public void onResponse(Call<HelloObject> call, Response<HelloObject> response) {
                        subject.setText(response.body().getHello());
                    }

                    @Override
                    public void onFailure(Call<HelloObject> call, Throwable t) {
                        subject.setText("Data failed");
                    }
                });
                subject.setTextColor(ContextCompat.getColor(this, R.color.white));
                subject.setLayoutParams(layoutParams_subjects);
                scrollMenuSubjectsLinearLayout.addView(subject);
            }
        }
        //Если на сервере нет данных о них
        if(customer==null){
            //Переключение на страницу авторизации
            setContentView(R.layout.activity_registration);
            Button buttonReg = findViewById(R.id.button_registration);
            buttonReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Получаем текст из xml
                    EditText editTextName = findViewById(R.id.editTextName);
                    EditText editTextIndex = findViewById(R.id.editTextIndex);
                    EditText editTextBirthDate = findViewById(R.id.editTextBDate);
                    EditText editTextCourse = findViewById(R.id.editTextCourse);
                    EditText editTextPassword = findViewById(R.id.editTextPassword);

                    // Получаем текст из EditText
                    String name = editTextName.getText().toString();
                    String index = editTextIndex.getText().toString();
                    String bDate = editTextBirthDate.getText().toString();
                    String course = editTextCourse.getText().toString();
                    String password = editTextPassword.getText().toString();

                    boolean dataAccess = true;

                    if (name == null || name.isEmpty() || name.contains(" ")) {
                        editTextName.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                        dataAccess = false;
                    }

                    if (index == null || index.isEmpty()) {
                        editTextIndex.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                        dataAccess = false;
                    }

                    if (bDate == null || bDate.isEmpty()) {
                        editTextBirthDate.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                        dataAccess = false;
                    }

                    if (course == null || course.isEmpty()) {
                        editTextCourse.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                        dataAccess = false;
                    }

                    if (password == null || password.isEmpty()) {
                        editTextPassword.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error_red)));
                        dataAccess = false;
                    }

                    if (dataAccess) {
                        //Отправка пост запроса

                        setContentView(R.layout.activity_main);
                    }

                    // Здесь можно добавить дальнейшую обработку, например, проверку логина и пароля
                }
            });
        }

    }
}