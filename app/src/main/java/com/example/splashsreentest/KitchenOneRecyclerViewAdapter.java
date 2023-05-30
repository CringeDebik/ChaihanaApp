package com.example.splashsreentest;

import static com.example.splashsreentest.KitchenOneCardProductDetailed.KITCHEN_ONE_PRODUCT_ID;

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

public class KitchenOneRecyclerViewAdapter extends RecyclerView.Adapter<KitchenOneRecyclerViewAdapter.KitchenOneViewHolder> {

    private ArrayList<KitchenOneCardProduct> KitchenOneItems = new ArrayList<>();
    private Context mContext;

    public KitchenOneRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public KitchenOneRecyclerViewAdapter.KitchenOneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_catalog_kitchen_one, parent, false);
        return new KitchenOneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenOneViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.KitchenOneTitle.setText(KitchenOneItems.get(position).getKitchenOneName());
        holder.KitchenOnePrice.setText(KitchenOneItems.get(position).getKitchenOnePrice());
        Glide.with(mContext)
                .asBitmap()
                .load(KitchenOneItems.get(position).getKitchenOneImage())
                .into(holder.KitchenOneImage);

        holder.KitchenOneParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, KitchenOneCardProductDetailed.class);
                intent.putExtra(KITCHEN_ONE_PRODUCT_ID, KitchenOneItems.get(position).getKitchenOneId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return KitchenOneItems.size();
    }

    public void setKitchenOneItems(ArrayList<KitchenOneCardProduct> kitchenOneItems) {
        this.KitchenOneItems = kitchenOneItems;
        notifyDataSetChanged();
    }

    public class KitchenOneViewHolder extends RecyclerView.ViewHolder {
        private CardView KitchenOneParent;
        private ImageView KitchenOneImage;
        private TextView KitchenOneTitle, KitchenOnePrice;
        public KitchenOneViewHolder(View itemView) {
            super(itemView);
            KitchenOneParent = itemView.findViewById(R.id.KitchenOneparent);
            KitchenOneImage = itemView.findViewById(R.id.KitchenOneItemImg);
            KitchenOneTitle = itemView.findViewById(R.id.KitchenItemTitle);
            KitchenOnePrice = itemView.findViewById(R.id.KitchenOnePrice);

       }
    }
}
