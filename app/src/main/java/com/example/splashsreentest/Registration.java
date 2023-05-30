package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {


    // Импорт элементов
    public EditText RegistrationName, RegistrationEmail, RegistrationPassword, RegistrationPhoneNumber;
    public TextView WarningRegistrationName, WarningRegistrationEmail, WarningRegistrationPassword, WarningRegistrationPhoneNumber, RegistrationAccountExists;

    public Button btnRegister;

    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        // Функция иницилизирующая все элементы экрана регистрации
        initViews();

        // Устанавливаем кнопке регистрации ActionListener
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Внутри отдельная функция выполняющая валидацию
                initRegistration();
            }
        });

        // Устанавливаем на кнопку аккаунт уже существует ActionListener
        RegistrationAccountExists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent метод посылает на страницу входа LoginInPage
                Intent intent = new Intent(Registration.this, LoginInPage.class);
                startActivity(intent);
            }
        });

    }

    // Функция выполняющая валидацию
    private void initRegistration() {
        // ValidData валидирует
        if(validData()){
            // Если условие выполняется то метод Intent отправляет пользователся в каталог
            Intent intent = new Intent(Registration.this, MainCatalog.class);
            startActivity(intent);
        } else {
            // В ином случае всплывает сообщение с помощью метода Toast
            Toast.makeText(Registration.this, "Пожалуйста,заполните все поля", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validData() {
        // Если поле пустое, выводится текст, и так на каждое поле регистрации
        if(RegistrationName.getText().toString().equals("")){
            WarningRegistrationName.setVisibility(View.VISIBLE);
            WarningRegistrationName.setText("Пожалуйста, укажите имя");
            return false;
        }

        if(RegistrationEmail.getText().toString().equals("")){
            WarningRegistrationEmail.setVisibility(View.VISIBLE);
            WarningRegistrationEmail.setText("Пожалуйста, укажите почту");
            return false;
        }

        if(RegistrationPhoneNumber.getText().toString().equals("")){
            WarningRegistrationPhoneNumber.setVisibility(View.VISIBLE);
            WarningRegistrationPhoneNumber.setText("Пожалуйста, укажите номер телефона");
            return false;
        }

        if(RegistrationPassword.getText().toString().equals("")){
            WarningRegistrationPassword.setVisibility(View.VISIBLE);
            WarningRegistrationPassword.setText("Пожалуйста, придумайте пароль");
            return false;
        }
    return true;
    }

    private void initViews() {
        RegistrationName = findViewById(R.id.RegistrationName);
        RegistrationEmail = findViewById(R.id.RegistrationEmail);
        RegistrationPassword = findViewById(R.id.RegistrationPassword);
        RegistrationPhoneNumber = findViewById(R.id.RegistrationPhoneNumber);
        WarningRegistrationName = findViewById(R.id.WarningRegistrationName);
        WarningRegistrationEmail = findViewById(R.id.WarningRegistrationEmail);
        WarningRegistrationPassword = findViewById(R.id.WarningRegistrationPassword);
        WarningRegistrationPhoneNumber = findViewById(R.id.WarningRegistrationPhoneNumber);
        btnRegister = findViewById(R.id.btnRegister);
        RegistrationAccountExists = findViewById(R.id.RegistrationAccountExists);
    }

    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(Registration.this, UserCabinet.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}