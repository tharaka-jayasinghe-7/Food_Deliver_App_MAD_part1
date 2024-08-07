package com.example.food_deliver_mobileapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final Context context;
    private final List<com.example.food_deliver_mobileapp.Item> itemList;

    public ItemAdapter(Context context, List<com.example.food_deliver_mobileapp.Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        com.example.food_deliver_mobileapp.Item  currentItem = itemList.get(position);

        holder.itemNameTextView.setText(currentItem.getName());
        holder.itemDescriptionTextView.setText(currentItem.getDescription());
        holder.itemRatingTextView.setText(String.valueOf(currentItem.getRating()));
        holder.itemPriceTextView.setText(String.valueOf(currentItem.getPrice()));

        // Set item image if available
        byte[] itemImage = currentItem.getImage();
        if (itemImage != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(itemImage, 0, itemImage.length);
            holder.itemImageView.setImageBitmap(bitmap);
        }

        // Use the category if needed
        String category = currentItem.getCategory();
        // Additional logic can be added here if needed
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView itemDescriptionTextView;
        TextView itemRatingTextView;
        TextView itemPriceTextView;
        ImageView itemImageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.item_name);
            itemDescriptionTextView = itemView.findViewById(R.id.item_description);
            itemRatingTextView = itemView.findViewById(R.id.item_rating);
            itemPriceTextView = itemView.findViewById(R.id.item_price);
            itemImageView = itemView.findViewById(R.id.item_image);
        }
    }
}
