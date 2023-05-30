package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginInPage extends AppCompatActivity {

    // Импорт элементов страницы входа
    private EditText Login_In_Phonenumber, Login_In_Password;
    private TextView Warning_Login_Phonenumber,Warning_Login_Password, Forgot_Password;
    private Button btnLogin_In;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in_page);

        //  Функция иницилизирующая все элементы
        initViews();

        // Устанавливаем на кнопку входа ActionListener
        btnLogin_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Функция выполняющая валидацию
                initLogin();

            }
        });


        Forgot_Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginInPage.this, "Смена пароля с несколькими способами", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        // Функция иницилизирует каждый элемент
        Login_In_Phonenumber = findViewById(R.id.Login_In_PhoneNumber);
        Login_In_Password = findViewById(R.id.Login_In_Password);
        Warning_Login_Phonenumber = findViewById(R.id.Warning_Login_PhoneNumber);
        Warning_Login_Password = findViewById(R.id.Warning_Login_Password);
        btnLogin_In = findViewById(R.id.btnLogin_In);
        Forgot_Password = findViewById(R.id.Forgot_Password);
    }

    private void initLogin() {
        if(validData()){
            // Если условие выполняется метод Intent переводит пользователя в каталог
            Intent intent = new Intent(this, MainCatalog.class);
            startActivity(intent);

        } else {
            // Если нет то всплывает сообщение об ошибке
            Toast.makeText(this, "Пожалуйста,заполните все поля", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validData(){
        // Функция валидирует, если поле пустое то выволится сообщение, и так работает со всеми полями
        if(Login_In_Phonenumber.getText().toString().equals("")){
            Warning_Login_Phonenumber.setVisibility(View.VISIBLE);
            Warning_Login_Phonenumber.setText("Введите номер телефона");
            return false;
        }

        if(Login_In_Password.getText().toString().equals("")){
            Warning_Login_Password.setVisibility(View.VISIBLE);
            Warning_Login_Password.setText("Введите пароль");
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(LoginInPage.this, UserCabinet.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}