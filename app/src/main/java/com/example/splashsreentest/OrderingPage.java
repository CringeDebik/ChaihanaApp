package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderingPage extends AppCompatActivity {

    EditText OrderingName,OrderingPhone,OrderingAdress;
    TextView WarningOrderingName,WarningOrderingPhone,WarningOrderingAdress;
    Button SubmitOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_page);

        initViews();

        SubmitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Внутри отдельная функция выполняющая валидацию
                initRegistration();
            }
        });
    }

    private void initRegistration() {
        // ValidData валидирует
        if(validData()){
            // Если условие выполняется то метод Intent отправляет пользователся в каталог
            Toast.makeText(OrderingPage.this, "ЗАКАЗ БЫЛ ОФОРМЛЕН", Toast.LENGTH_SHORT).show();
        } else {
            // В ином случае всплывает сообщение с помощью метода Toast
            Toast.makeText(OrderingPage.this, "Пожалуйста,заполните все поля", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validData() {
        // Если поле пустое, выводится текст, и так на каждое поле регистрации
        if(OrderingName.getText().toString().equals("")){
            WarningOrderingName.setVisibility(View.VISIBLE);
            WarningOrderingName.setText("Пожалуйста, укажите ФИО");
            return false;
        }

        if(OrderingPhone.getText().toString().equals("")){
            WarningOrderingPhone.setVisibility(View.VISIBLE);
            WarningOrderingPhone.setText("Пожалуйста, укажите номер телефона");
            return false;
        }

        if(OrderingAdress.getText().toString().equals("")){
            WarningOrderingAdress.setVisibility(View.VISIBLE);
            WarningOrderingAdress.setText("Пожалуйста, укажите адресс доставки");
            return false;
        }
        return true;
    }
    private void initViews() {
        OrderingName = findViewById(R.id.OrderingName);
        OrderingPhone = findViewById(R.id.OrderingPhone);
        OrderingAdress = findViewById(R.id.OrderingAdress);
        WarningOrderingName = findViewById(R.id.WarningOrderingName);
        WarningOrderingPhone = findViewById(R.id.WarningOrderingPhone);
        WarningOrderingAdress = findViewById(R.id.WarningOrderingAdress);
        SubmitOrder = findViewById(R.id.SubmitOrder);
    }
    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(OrderingPage.this, Cart.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}