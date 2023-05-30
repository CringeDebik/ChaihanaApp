package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cart extends AppCompatActivity {


    Button btnOrder,btn_minus,btn_plus,btn_minus2,btn_plus2;
    int counter = 0;
    int counter2 = 0;
    TextView Txtcounter,Txtcounter2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        Txtcounter = findViewById(R.id.Txtcounter);
        counter = 0;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               counter++;
               Txtcounter.setText(""  + counter);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                Txtcounter.setText(""  + counter);
                if(counter <= 1) {
                    Txtcounter.setText("1");
                }
            }
        });

        btn_plus2 = findViewById(R.id.btn_plus2);
        btn_minus2 = findViewById(R.id.btn_minus2);
        Txtcounter2 = findViewById(R.id.Txtcounter2);
        counter2 = 0;

        btn_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter2++;
                Txtcounter2.setText(""  + counter2);
            }
        });

        btn_minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter2--;
                Txtcounter2.setText(""  + counter2);
                if(counter2 <= 1) {
                    Txtcounter2.setText("1");
                }
            }
        });

        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, OrderingPage.class);
                startActivity(intent);
            }
        });

        // Инилизация 3-х карточек из 3-х списков
        RecyclerView recyclerViewCarted1 = findViewById(R.id.first);
        RecyclerView recyclerViewCarted2 = findViewById(R.id.second);
        RecyclerView recyclerViewCarted3 = findViewById(R.id.third);

        // Установка адаптеров и их размера
        recyclerViewCarted2.setHasFixedSize(true);
        KitchenOneRecyclerViewAdapter adapterOne = new KitchenOneRecyclerViewAdapter(this);
        recyclerViewCarted2.setAdapter(adapterOne);

        recyclerViewCarted2.setLayoutManager(new LinearLayoutManager(this));
        adapterOne.setKitchenOneItems(Utils_Database.getKitchenOneInCart());


        recyclerViewCarted1.setHasFixedSize(true);
        MainCatalogPopularAdapter adapter = new MainCatalogPopularAdapter(this);
        recyclerViewCarted1.setAdapter(adapter);

        recyclerViewCarted1.setLayoutManager(new LinearLayoutManager(this));
        adapter.setPopularItems(Utils_Database.getPopularCart());


        recyclerViewCarted3.setHasFixedSize(true);
        KitchenTwoRecyclerViewAdapter adapterTwo = new KitchenTwoRecyclerViewAdapter(this);
        recyclerViewCarted3.setAdapter(adapterTwo);

        recyclerViewCarted3.setLayoutManager(new LinearLayoutManager(this));
        adapterTwo.setKitchenTwoItems(Utils_Database.getKitchenTwoInCart());
        //////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(Cart.this, MainCatalog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}