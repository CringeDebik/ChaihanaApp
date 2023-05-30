package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class KitchenOneCardProductDetailed extends AppCompatActivity {

    // Создание упрощения в виде специального KEY в данном случае это id карточки
    public static final String KITCHEN_ONE_PRODUCT_ID = "getKitchenOneId";

    // Импорт элементов детельной страницы
    private Button KitchenOneDetailedCartBtn,KitchenOneDetailedToOrders,btnBackToCatalog;
    private TextView KitchenOneProductNameDetailed,KitchenOnePriceDetailed,KitchenOneDetailedDescFull,KitchenOneDetailedContentsFull;
    private ImageView KitchenOneProductImageDetailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_one_card_product_detailed);

        // Функция инициализирующая все элементы
        initViews();

        // Кнопка при нажатии выводит сообщение
        KitchenOneDetailedCartBtn.setOnClickListener(v -> {
            Toast.makeText(KitchenOneCardProductDetailed.this, "Товар уже находится корзине", Toast.LENGTH_SHORT);
        });
        // Кнопка при нажатии переводит пользователя на страницу заказов
        KitchenOneDetailedToOrders.setOnClickListener(v -> {
            // Метод Intent
            Intent intent = new Intent(KitchenOneCardProductDetailed.this, Cart.class);
            startActivity(intent);
        });
        btnBackToCatalog.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenOneCardProductDetailed.this, MainCatalog.class);
            startActivity(intent);
        });


//        // TODO Get the data from recyclerview
//        KitchenOneCardProduct KitchenOneProductCardDetailed = new KitchenOneCardProduct(1,"Лагман","3500тг",
//                "https://www.gastronom.ru/binfiles/images/20221110/bf9ddb7f.jpg","Лагман лагман","Лагман лагман");

        // С помощбю метода Intent молучаем id карточки
        Intent intent = getIntent();
        if(null != intent) {
            int KitchenOneProductID = intent.getIntExtra(KITCHEN_ONE_PRODUCT_ID, -1);
            if(KitchenOneProductID!= -1) {
                KitchenOneCardProduct incomingProduct = Utils_Database.getInstance().getKitchenOneItemsDetailedID(KitchenOneProductID);
                if(null != incomingProduct){
                    // Если условие выполняется setData ставит данные incomingProduct(PopularCardProduct)
                    setData(incomingProduct);

                    handleKitchenOneDetailedCartBtn(incomingProduct);
                }
            }
        }
        Utils_Database.getInstance();
    }

    private void handleKitchenOneDetailedCartBtn(KitchenOneCardProduct incomingProduct){
        // Список уже существующих элементов в корзине
        ArrayList<KitchenOneCardProduct> AlreadyInCart = Utils_Database.getInstance().getKitchenOneInCart();

        boolean existInCart = false;

        // С помошью цикла проходимся по всем элементам, если id совпадает ExistInCart переводит в True
        for(KitchenOneCardProduct product : AlreadyInCart){
            if(product.getKitchenOneId() == incomingProduct.getKitchenOneId()){

                existInCart = true;
            }
        }
        if(existInCart){
            // Если элемент по id уже находится в корзине кнопка меняет текст говоря о том что объект уже в корзине
            KitchenOneDetailedCartBtn.setText("Уже в корзине");
        }else {
            // плюс выводится всплывающее сообщение - товар в корзине
            KitchenOneDetailedCartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils_Database.getInstance().addToOneCart(incomingProduct)){
                        Toast.makeText(KitchenOneCardProductDetailed.this, "Товар был добавлен в корзину", Toast.LENGTH_SHORT).show();
                        //TODO navigate to the cart activity

                    }else {
                        // В противном случае всплывет сообщение об неудаче с добавлением объекта в корзину
                        Toast.makeText(KitchenOneCardProductDetailed.this, "Failed to add to cart", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    // Функция устанавливающая динамически меняющиеся элементы на странице
    private void setData(KitchenOneCardProduct KitchenOneProductCardDetailed) {
        KitchenOneProductNameDetailed.setText(KitchenOneProductCardDetailed.getKitchenOneName());
        KitchenOnePriceDetailed.setText(KitchenOneProductCardDetailed.getKitchenOnePrice());
        KitchenOneDetailedDescFull.setText(KitchenOneProductCardDetailed.getKitchenOneLongDescription());
        KitchenOneDetailedContentsFull.setText(KitchenOneProductCardDetailed.getKitchenOneContentsFull());
        // Glide специльная зависимость дающая возможность добавить картинку
        Glide.with(this)
                .asBitmap()
                .load(KitchenOneProductCardDetailed.getKitchenOneImage())
                .into(KitchenOneProductImageDetailed);
    }

    // Функция инициализирующая элементы страницы
    private void initViews() {
        KitchenOneDetailedCartBtn = findViewById(R.id.KitchenOneDetailedCartBtn);
        KitchenOneDetailedToOrders = findViewById(R.id.KitchenOneDetailedToOrders);
        KitchenOneProductNameDetailed = findViewById(R.id.KitchenOneProductNameDetailed);
        KitchenOnePriceDetailed = findViewById(R.id.KitchenOnePriceDetailed);
        KitchenOneDetailedDescFull = findViewById(R.id.KitchenOneDetailedDescFull);
        KitchenOneDetailedContentsFull = findViewById(R.id.KitchenOneDetailedContentsFull);
        KitchenOneProductImageDetailed = findViewById(R.id.KitchenOneDetailedProductImg);
        btnBackToCatalog = findViewById(R.id.btnBackToCatalog);

    }

    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(KitchenOneCardProductDetailed.this, MainCatalog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}