package com.example.food_deliver_mobileapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DisplayItemsActivity extends AppCompatActivity {

    private List<Item> itemList;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_items);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        if (category != null) {
            loadData(category);
        }
    }

    private void loadData(String category) {
        DBHandler dbHandler = new DBHandler(this);
        Cursor cursor = dbHandler.getItemsByCategory(category);

        if (cursor != null) {
            Log.d("DisplayItemsActivity", "Cursor count: " + cursor.getCount());
            if (cursor.moveToFirst()) {
                int nameIndex = cursor.getColumnIndex("name");
                int descriptionIndex = cursor.getColumnIndex("description");
                int ratingIndex = cursor.getColumnIndex("rating");
                int priceIndex = cursor.getColumnIndex("price");
                int imageIndex = cursor.getColumnIndex("image");
                int categoryIndex = cursor.getColumnIndex("category");

                if (nameIndex >= 0 && descriptionIndex >= 0 && ratingIndex >= 0 &&
                        priceIndex >= 0 && imageIndex >= 0 && categoryIndex >= 0) {
                    do {
                        String itemName = cursor.getString(nameIndex);
                        String itemDescription = cursor.getString(descriptionIndex);
                        float itemRating = cursor.getFloat(ratingIndex);
                        float itemPrice = cursor.getFloat(priceIndex);
                        byte[] itemImage = cursor.getBlob(imageIndex);
                        String itemCategory = cursor.getString(categoryIndex);

                        Log.d("DisplayItemsActivity", "Item: " + itemName + ", Category: " + itemCategory);

                        Item item = new Item(itemName, itemDescription, itemRating, itemPrice, itemImage, itemCategory);
                        itemList.add(item);
                    } while (cursor.moveToNext());
                } else {
                    Log.e("DisplayItemsActivity", "One or more column indexes not found in the cursor");
                }
                cursor.close();
            } else {
                Log.e("DisplayItemsActivity", "Cursor is null or empty");
            }
        } else {
            Log.e("DisplayItemsActivity", "Cursor is null");
        }
        itemAdapter.notifyDataSetChanged(); // Notify the adapter of data changes
    }
}
