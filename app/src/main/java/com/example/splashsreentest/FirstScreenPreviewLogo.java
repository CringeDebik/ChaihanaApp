package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FirstScreenPreviewLogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen_preview_logo);


        // Функция отправляющая пользователя на экран регистрации
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(FirstScreenPreviewLogo.this, Registration.class));
              finish();
            }
        }, 500);
        // Задержка или через сколько пользователя переведут на следующай экран
    }
}