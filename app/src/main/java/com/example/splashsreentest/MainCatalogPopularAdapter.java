package com.example.splashsreentest;

import static androidx.core.content.ContextCompat.startActivity;

import static com.example.splashsreentest.PopularCardProductDetailed.POPULAR_CARD_PRODUCT_DETAILED;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainCatalogPopularAdapter extends RecyclerView.Adapter<MainCatalogPopularAdapter.ViewHolder> {

    private ArrayList<PopularCardProduct> PopularItems = new ArrayList<>();
    private Context mcontext;

    public MainCatalogPopularAdapter(Context mcontext) {

        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_catalog_popular, parent, false);
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.PopularItemTitle.setText(PopularItems.get(position).getNameTitle());
        Glide.with(mcontext)
                .asBitmap()
                .load(PopularItems.get(position).getItemImage())
                .into(holder.PopularItemImg);
        holder.PopularItemProductPrice.setText(PopularItems.get(position).getPrice());

        holder.Popularparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, PopularCardProductDetailed.class);
                intent.putExtra(POPULAR_CARD_PRODUCT_DETAILED, PopularItems.get(position).getId());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return PopularItems.size();
    }

    public void setPopularItems(ArrayList<PopularCardProduct> popularItems) {
        this.PopularItems = popularItems;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView Popularparent;
        private ImageView PopularItemImg;
        private TextView PopularItemTitle, PopularItemProductPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Popularparent = itemView.findViewById(R.id.Popularparent);
            PopularItemImg = itemView.findViewById(R.id.PopularItemImg);
            PopularItemTitle = itemView.findViewById(R.id.PopularItemTitle);
            PopularItemProductPrice = itemView.findViewById(R.id.PopularCardProductPrice);
        }
    }
}
