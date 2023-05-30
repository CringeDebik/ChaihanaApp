package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class UserCabinet extends AppCompatActivity {


    // Импорт элементов страницы личного кабинета
    private Button UserCabinetChangePfpBtn,UserCabinetOrdersBtn,PersData;
    private TextView UserCabinetInfoPhone;
    private ImageView profile_pic;
    private EditText Login_In_PhoneNumber;
    String string;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cabinet);

        PersData = findViewById(R.id.PersData);
        PersData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserCabinet.this,PersonalDataPage.class);
                startActivity(intent);
            }
        });

        // Кнопка отправлющая пользователя на страницу заказов
        UserCabinetOrdersBtn = findViewById(R.id.UserCabinetOrdersBtn);
        UserCabinetOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent в котором указать откуда куда перевести пользователя
                Intent intent = new Intent(UserCabinet.this, Cart.class);
                startActivity(intent);
            }
        });

        // Кнопка при нажатие переводит пользоваетля в галерею для выбора фото для профиля
        UserCabinetChangePfpBtn = findViewById(R.id.UserCabinetChangePfpBtn);
        UserCabinetChangePfpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
    }
    // Функция onActivityResult получает фото и устаналивает его в ImageView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data!= null && data.getData()!= null) {
            ImageView profile_pic = findViewById(R.id.profile_pic);
            profile_pic.setImageURI(data.getData());
        }
    }

    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(UserCabinet.this, MainCatalog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}