package com.example.splashsreentest;

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

public class KitchenTwoRecyclerViewAdapter  extends RecyclerView.Adapter<KitchenTwoRecyclerViewAdapter.KitchenTwoViewHolder> {

    private ArrayList<KitchenTwoCardProduct> KitchenTwoItems = new ArrayList<>();
    private Context context;

    public KitchenTwoRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public KitchenTwoRecyclerViewAdapter.KitchenTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_catalog_kitchen_two, parent, false);
        return new KitchenTwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenTwoViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.KitchenTwoItemTitle.setText(KitchenTwoItems.get(position).getKitchenTwoName());
        holder.KitchenTwoPrice.setText(KitchenTwoItems.get(position).getKitchenTwoPrice());
        Glide.with(context)
                .asBitmap()
                .load(KitchenTwoItems.get(position).getKitchenTwoImage())
                .into(holder.KitchenTwoItemImg);

        holder.KitchenTwoparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, KitchenOneCardProductDetailed.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return KitchenTwoItems.size();
    }

    public void setKitchenTwoItems(ArrayList<KitchenTwoCardProduct> kitchenTwoItems) {
        KitchenTwoItems = kitchenTwoItems;
        notifyDataSetChanged();
    }

    public class KitchenTwoViewHolder extends RecyclerView.ViewHolder {
        private CardView KitchenTwoparent;
        private ImageView KitchenTwoItemImg;
        private TextView KitchenTwoItemTitle, KitchenTwoPrice;

        public KitchenTwoViewHolder(View itemView) {
            super(itemView);
            KitchenTwoparent = itemView.findViewById(R.id.KitchenTwoparent);
            KitchenTwoItemImg = itemView.findViewById(R.id.KitchenTwoItemImg);
            KitchenTwoItemTitle = itemView.findViewById(R.id.KitchenTwoItemTitle);
            KitchenTwoPrice = itemView.findViewById(R.id.KitchenTwoPrice);
        }
    }
}
