package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import java.util.ArrayList;

public class MainCatalog extends AppCompatActivity {


    // Импорт всех элементов страницы каталога
    private RecyclerView recyclerViewPopular;
    private  RecyclerView KitchenOneRecyclerView;

    private RecyclerView KitchenTwoRecyclerView;
    private MainCatalogPopularAdapter adapterPopular;
    private KitchenOneRecyclerViewAdapter KitchenOneAdapter;
    private KitchenTwoRecyclerViewAdapter KitchenTwoAdapter;

    private Button CartListBtn,UserCabinetBtn;

    private SearchView Catalog_Search;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_catalog);

        // Инилизация кнопки и ActionListener
        CartListBtn = findViewById(R.id.CartListBtn);
        CartListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // При нажатие переводит пользователя на страницу с заказами
                Intent intent = new Intent(MainCatalog.this, Cart.class);
                startActivity(intent);
            }
        });

        // Инилизация кноки и ActionListener
        UserCabinetBtn = findViewById(R.id.UserCabinetBtn);
        UserCabinetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // При нажатие переводит пользователя на страницу личного кабинета
                Intent intent = new Intent(MainCatalog.this, UserCabinet.class);
                startActivity(intent);
            }
        });


           // Инилизация поля поиска
           Catalog_Search = findViewById(R.id.Catalog_Search);
           Catalog_Search.clearFocus();


        // Инилизация адатеров для списков RecyclerView
        KitchenOneAdapter = new KitchenOneRecyclerViewAdapter(this);
        adapterPopular = new MainCatalogPopularAdapter(this);
        KitchenTwoAdapter = new KitchenTwoRecyclerViewAdapter(this);

        // Инилизация списков RecyclerView
        recyclerViewPopular = findViewById(R.id.recyclerViewPopular);
        KitchenOneRecyclerView = findViewById(R.id.recyclerViewKitchenOne);
        KitchenTwoRecyclerView = findViewById(R.id.recyclerViewKitchenTwo);


        // Устанавливаем адаптеры с помощью метода setAdapter
        recyclerViewPopular.setAdapter(adapterPopular);
        // setLayoutManager определяет ориентацию списка и местоположение this(тоесть на этой странице)
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Повторяем те же действия с остальными списками
        KitchenOneRecyclerView.setAdapter(KitchenOneAdapter);
        KitchenOneRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        KitchenTwoRecyclerView.setAdapter(KitchenTwoAdapter);
        KitchenTwoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        // Чтобы не прописывать различные параметры карточек списков создаем локальную базу данных - Utils Class служит хранением данных карточек
           // но отображение всего все еще будет на этой странице
        adapterPopular.setPopularItems(Utils_Database.getInstance().getPopularItems());

        KitchenOneAdapter.setKitchenOneItems(Utils_Database.getInstance().getKitchenOneItems());

        KitchenTwoAdapter.setKitchenTwoItems(Utils_Database.getInstance().getKitchenTwoItems());

        // С помошью метода getInstance получаем карточки списков
        Utils_Database.getInstance();
    }

}

