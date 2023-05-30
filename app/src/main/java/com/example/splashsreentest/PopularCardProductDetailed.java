package com.example.splashsreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularCardProductDetailed extends AppCompatActivity {

    // Создание упрощения в виде специального KEY в данном случае это id карточки
    public static final String POPULAR_CARD_PRODUCT_DETAILED = "PopularCardProductId";

    // Импорт элементов детельной страницы
    Button PopularDetailedCartBtn, PopularDetailedToOrders,btnBackToCatalog;
    TextView PopularDetailedProductName,PopularDetailedDescFull,PopularContentsFull,PopularDetailedPrice;
    ImageView PopularDetailedProductImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_card_product_detailed);

        // Функция инициализирующая все элементы
        initViews();

        // Кнопка при нажатии выводит сообщение
        PopularDetailedCartBtn.setOnClickListener(v -> {
            Toast.makeText(PopularCardProductDetailed.this, "Товар уже находится корзине", Toast.LENGTH_SHORT);
        });
        // Кнопка при нажатии переводит пользователя на страницу заказов
        PopularDetailedToOrders.setOnClickListener(v -> {
            // Метод Intent
            Intent intent = new Intent(PopularCardProductDetailed.this, Cart.class);
            startActivity(intent);
        });
        btnBackToCatalog.setOnClickListener(v -> {
            Intent intent = new Intent(PopularCardProductDetailed.this, MainCatalog.class);
            startActivity(intent);
        });



//        // TODO: Get the data from the recyclerview
//        PopularCardProduct PopularDetailedCardProduct = new PopularCardProduct(1,"Pizza de mozzarella","2500тг",
//                "https://staticcookist.akamaized.net/wp-content/uploads/sites/22/2021/09/beef-burger.jpg","Pizza pizza","Pizza pizza");
        // С помощью метода Intent молучаем id карточки
        Intent intent = getIntent();
        if(null != intent){
            int PopularCardProductID = intent.getIntExtra(POPULAR_CARD_PRODUCT_DETAILED,-1);
            if(PopularCardProductID != -1){
                PopularCardProduct incomingProduct = Utils_Database.getInstance().getPopularItemsDetailedsID(PopularCardProductID);
                if(null != incomingProduct){
                    // Если условие выполняется setData ставит данные incomingProduct(PopularCardProduct)
                    setData(incomingProduct);

                    handlePopularDetailedCartBtn(incomingProduct);
               }
            }
        }
        Utils_Database.getInstance();
    }

    private void handlePopularDetailedCartBtn(PopularCardProduct incomingProduct){
        // Список уже существующих элементов в корзине
        ArrayList<PopularCardProduct> AlreadyInCart = Utils_Database.getInstance().getPopularCart();

        boolean existInCart = false;

        // С помошью цикла проходимся по всем элементам, если id совпадает ExistInCart переводит в True
        for(PopularCardProduct product : AlreadyInCart){
            if(product.getId() == incomingProduct.getId()){
                existInCart = true;
            }
        }
        if(existInCart){
            // Если элемент по id уже находится в корзине кнопка меняет текст говоря о том что объект уже в корзине
            PopularDetailedCartBtn.setText("Уже в корзине");
        }else {
            // плюс выводится всплывающее сообщение - товар в корзине
            PopularDetailedCartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils_Database.getInstance().addToPopularCart(incomingProduct)){
                        Toast.makeText(PopularCardProductDetailed.this, "Товар был добавлен в корзину", Toast.LENGTH_SHORT).show();
                        //TODO navigate to the cart activity

                    }else {
                        // В противном случае всплывет сообщение об неудаче с добавлением объекта в корзину
                        Toast.makeText(PopularCardProductDetailed.this, "Failed to add to cart", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    // Функция устанавливающая динамически меняющиеся элементы на странице
    private void setData(PopularCardProduct PopularDetailedCardProduct) {
            PopularDetailedProductName.setText(PopularDetailedCardProduct.getNameTitle());
            PopularContentsFull.setText(PopularDetailedCardProduct.getPopularContentsFull());
            PopularDetailedPrice.setText(PopularDetailedCardProduct.getPrice());
            PopularDetailedDescFull.setText(PopularDetailedCardProduct.getPopularLongDescription());
            // Glide специльная зависимость дающая возможность добавить картинку
            Glide.with(this)
                    .asBitmap()
                    .load(PopularDetailedCardProduct.getItemImage())
                    .into(PopularDetailedProductImg);

    }

    // Функция инициализирующая элементы страницы
    void initViews(){
        PopularDetailedCartBtn = findViewById(R.id.PopularDetailedCartBtn);
        PopularDetailedToOrders = findViewById(R.id.PopularDetailedToOrders);
        PopularDetailedProductName = findViewById(R.id.PopularDetailedProductName);
        PopularDetailedDescFull = findViewById(R.id.PopularDetailedDescFull);
        PopularContentsFull = findViewById(R.id.PopularContentsFull);
        PopularDetailedProductImg = findViewById(R.id.PopularDetailedProductImg);
        PopularDetailedPrice = findViewById(R.id.PopularDetailedPrice);
        btnBackToCatalog = findViewById(R.id.btnBackToCatalog);
    }

    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(PopularCardProductDetailed.this, MainCatalog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}