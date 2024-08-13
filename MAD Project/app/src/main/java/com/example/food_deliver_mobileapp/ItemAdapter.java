package com.example.food_deliver_mobileapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final Context context;
    private final List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList) {
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
        Item currentItem = itemList.get(position);

        holder.itemNameTextView.setText(currentItem.getName());
        holder.itemDescriptionTextView.setText(currentItem.getDescription());
        holder.itemPriceTextView.setText(String.valueOf(currentItem.getPrice()));

        // Set item image if available
        byte[] itemImage = currentItem.getImage();
        if (itemImage != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(itemImage, 0, itemImage.length);
            holder.itemImageView.setImageBitmap(bitmap);
        }

        // Set up the Order Now button
        holder.orderNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send the notification when the button is clicked
                NotificationUtils.createNotificationChannel(context);
                NotificationUtils.sendNotification(
                        context,
                        "Order Placed",
                        "Your order has been placed successfully."
                );
            }
        });

        // Use the category if needed
        String itemCategory = currentItem.getCategory();
        // Additional logic can be added here if needed
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView itemDescriptionTextView;
        TextView itemPriceTextView;
        ImageView itemImageView;
        Button orderNowButton;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.item_name);
            itemDescriptionTextView = itemView.findViewById(R.id.item_description);
            itemPriceTextView = itemView.findViewById(R.id.item_price);
            itemImageView = itemView.findViewById(R.id.item_image);
            orderNowButton = itemView.findViewById(R.id.orderNowButton); // Add the button reference
        }
    }
}
