package com.example.splashsreentest;

import androidx.annotation.NonNull;
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

public class KitchenTwoCardProductDetailed extends AppCompatActivity {

    public final static String KITCHEN_TWO_DETAILED = "getKitchenTwoId";

    Button KitchenTwoDetailedCartBtn,KitchenTwoDetailedToOrders;

    TextView KitchenTwoProductNameDetailed,KitchenTwoPriceDetailed,KitchenTwoDetailedDescFull,KitchenTwoDetailedContentsFull;

    ImageView KitchenTwoDetailedProductImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_two_card_product_detailed);

        initViews();

        KitchenTwoDetailedCartBtn.setOnClickListener(v ->{
            Toast.makeText(KitchenTwoCardProductDetailed.this,"Товар уже находится в корзине", Toast.LENGTH_SHORT);
        });
        KitchenTwoDetailedToOrders.setOnClickListener(v ->{
            Intent intent = new Intent(KitchenTwoCardProductDetailed.this, Cart.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        if(null != intent) {
            int KitchenTwoID = intent.getIntExtra(KITCHEN_TWO_DETAILED, -1);
            if(KitchenTwoID != -1){
                KitchenTwoCardProduct incomingProduct = Utils_Database.getInstance().getKitchenTwoItemsDetailedID(KitchenTwoID);
                if(null != incomingProduct){
                    setData(incomingProduct);

                    handleKitchenTwoDetailedCartBtn(incomingProduct);
                }
            }
        }
        Utils_Database.getInstance();
    }


        private void handleKitchenTwoDetailedCartBtn(KitchenTwoCardProduct incomingProduct){

        ArrayList<KitchenTwoCardProduct> AlreadyInCart = Utils_Database.getInstance().getKitchenTwoInCart();

        boolean ExistsInCart = false;

        for(KitchenTwoCardProduct product : AlreadyInCart) {
            if(product.getKitchenTwoId() == incomingProduct.getKitchenTwoId()){
                ExistsInCart = true;
            }
          }
        if(ExistsInCart){
            KitchenTwoDetailedCartBtn.setText("Уже в корзине");
        }else{
            KitchenTwoDetailedCartBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (Utils_Database.getInstance().addToTwoCart(incomingProduct)) {
                        Toast.makeText(KitchenTwoCardProductDetailed.this, "Товар был добавлен в корзину", Toast.LENGTH_SHORT).show();
                        //TODO navigate to the cart activity

                    } else {
                        // В противном случае всплывет сообщение об неудаче с добавлением объекта в корзину
                        Toast.makeText(KitchenTwoCardProductDetailed.this, "Failed to add to cart", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        };
        }

            private void setData(KitchenTwoCardProduct KitchenTwoCardProductDetailed) {
                KitchenTwoProductNameDetailed.setText(KitchenTwoCardProductDetailed.getKitchenTwoName());
                KitchenTwoPriceDetailed.setText(KitchenTwoCardProductDetailed.getKitchenTwoPrice());
                KitchenTwoDetailedDescFull.setText(KitchenTwoCardProductDetailed.getKitchenTwoLongDescription());
                KitchenTwoDetailedContentsFull.setText(KitchenTwoCardProductDetailed.getKitchenTwoContentsFull());
                // Glide специльная зависимость дающая возможность добавить картинку
                Glide.with(this)
                        .asBitmap()
                        .load(KitchenTwoCardProductDetailed.getKitchenTwoImage())
                        .into(KitchenTwoDetailedProductImg);
            }


        private void initViews() {
        KitchenTwoDetailedCartBtn = findViewById(R.id.KitchenTwoDetailedCartBtn);
        KitchenTwoDetailedToOrders = findViewById(R.id.KitchenTwoDetailedToOrders);
        KitchenTwoProductNameDetailed = findViewById(R.id.KitchenTwoProductNameDetailed);
        KitchenTwoPriceDetailed = findViewById(R.id.KitchenTwoPriceDetailed);
        KitchenTwoDetailedDescFull = findViewById(R.id.KitchenTwoDetailedDescFull);
        KitchenTwoDetailedContentsFull = findViewById(R.id.KitchenTwoDetailedContentsFull);
        KitchenTwoDetailedProductImg = findViewById(R.id.KitchenTwoDetailedProductImg);
        }
    @Override
    public void onBackPressed() {
        // Функция возвращающая пользователя в каталог при нажатии назад
        Intent intent = new Intent(KitchenTwoCardProductDetailed.this, MainCatalog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}




