package com.example.food_deliver_mobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class DBHandler extends SQLiteOpenHelper {

    // Database name and version
    private static final String DB_NAME = "foodApp.db";
    private static final int DB_VERSION = 6;

    // User table name and columns
    private static final String TABLE_USERS = "users";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String EMAIL_COL = "email";
    private static final String PHONE_COL = "phone";
    private static final String PASSWORD_COL = "password";
    private static final String ADDRESS_COL = "address";
    private static final String CITY_COL = "city";
    private static final String IMAGE_COL = "image";

    // Admin table name and columns
    private static final String TABLE_ADMINS = "admins";
    private static final String ADMIN_ID_COL = "id";
    private static final String ADMIN_NAME_COL = "name";
    private static final String ADMIN_EMAIL_COL = "email";
    private static final String ADMIN_PASSWORD_COL = "password";

    // Shop table name and columns
    public static final String TABLE_SHOP = "shop";
    private static final String SHOP_ID_COL = "shop_id";
    private static final String SHOP_NAME_COL = "shop_name";
    private static final String SHOP_ADDRESS_COL = "shop_address";
    private static final String SHOP_CITY_COL = "shop_city";
    private static final String SHOP_CONTACT_COL = "shop_contact";
    private static final String SHOP_OPEN_COL = "shop_open";
    private static final String SHOP_CLOSE_COL = "shop_close";
    private static final String SHOP_IMAGE_COL = "shop_image";

    // Item table name and columns
    private static final String TABLE_ITEM = "item";
    private static final String ITEM_ID_COL = "item_id";
    private static final String ITEM_NAME_COL = "item_name";
    private static final String ITEM_DESCRIPTION_COL = "item_description";
    private static final String ITEM_PRICE_COL = "item_price";
    private static final String ITEM_IMAGE_COL = "item_image";
    private static final String ITEM_CATEGORY_COL = "item_category";
    private static final String ITEM_AVAILABILITY_COL = "item_availability";

<<<<<<< Updated upstream
=======
    private static final String ITEM_SHOP_ID_COL = "shop_id";



>>>>>>> Stashed changes
    // Promotion table name and columns
    private static final String TABLE_PROMOTION = "promotion";
    private static final String PROMOTION_ID_COL = "promotion_id";
    private static final String PROMOTION_NAME_COL = "promotion_name";
    private static final String PROMOTION_DESCRIPTION_COL = "promotion_description";
    private static final String PROMOTION_PERCENTAGE_COL = "promotion_percentage";

    // Order table name and columns
    private static final String TABLE_ORDER = "order_table"; // Changed to avoid using reserved keyword
    private static final String ORDER_ID_COL = "order_id";
    private static final String ORDER_SHOP_ID_COL = "shop_id";
    private static final String ORDER_USER_ID_COL = "user_id";
    private static final String ORDER_DATE_COL = "order_date";
    private static final String ORDER_STATES_COL = "order_states";
    private static final String ORDER_PROMOTION_ID_COL = "promotion_id";
    private static final String ORDER_QUANTITY_COL = "order_quantity";
    private static final String ORDER_AMOUNT_COL = "order_amount";
    private static final String ORDER_DISCOUNT_AMOUNT_COL = "order_discount_amount";
    private static final String ORDER_TOTAL_AMOUNT_COL = "order_total_amount";

    // Review table name and columns
    private static final String TABLE_REVIEW = "review";
    private static final String REVIEW_ID_COL = "review_id";
    private static final String REVIEW_ORDER_ID_COL = "order_id";
    private static final String REVIEW_USER_ID_COL = "user_id";
    private static final String REVIEW_SHOP_ID_COL = "shop_id";
    private static final String REVIEW_ITEM_ID_COL = "item_id";
    private static final String REVIEW_CATEGORY_COL = "review_category";
    private static final String REVIEW_MESSAGE_COL = "review_message";

    // Constructor
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTableQuery = "CREATE TABLE " + TABLE_USERS + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + CITY_COL + " TEXT,"
                + IMAGE_COL + " BLOB)";

        String createAdminsTableQuery = "CREATE TABLE " + TABLE_ADMINS + " ("
                + ADMIN_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ADMIN_NAME_COL + " TEXT,"
                + ADMIN_EMAIL_COL + " TEXT,"
                + ADMIN_PASSWORD_COL + " TEXT)";

        String createShopTableQuery = "CREATE TABLE " + TABLE_SHOP + " ("
                + SHOP_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SHOP_NAME_COL + " TEXT,"
                + SHOP_ADDRESS_COL + " TEXT,"
                + SHOP_CITY_COL + " TEXT,"
                + SHOP_CONTACT_COL + " TEXT,"
                + SHOP_OPEN_COL + " TEXT,"
                + SHOP_CLOSE_COL + " TEXT,"
                + SHOP_IMAGE_COL + " BLOB)";

        String createItemTableQuery = "CREATE TABLE " + TABLE_ITEM + " ("
                + ITEM_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ITEM_NAME_COL + " TEXT,"
                + ITEM_DESCRIPTION_COL + " TEXT,"
                + ITEM_PRICE_COL + " FLOAT,"
                + ITEM_IMAGE_COL + " BLOB,"
                + ITEM_CATEGORY_COL + " TEXT,"
<<<<<<< Updated upstream
                + ITEM_AVAILABILITY_COL + " TEXT)";
=======
                + ITEM_AVAILABILITY_COL + " TEXT,"
                + ITEM_SHOP_ID_COL + " INTEGER,"
                + "FOREIGN KEY(" + ITEM_SHOP_ID_COL + ") REFERENCES " + TABLE_SHOP + "(" + SHOP_ID_COL + "))";

>>>>>>> Stashed changes

        String createPromotionTableQuery = "CREATE TABLE " + TABLE_PROMOTION + " ("
                + PROMOTION_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PROMOTION_NAME_COL + " TEXT,"
                + PROMOTION_DESCRIPTION_COL + " TEXT,"
                + PROMOTION_PERCENTAGE_COL + " FLOAT)";

        String createOrderTableQuery = "CREATE TABLE " + TABLE_ORDER + " ("
                + ORDER_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ORDER_SHOP_ID_COL + " INTEGER,"
                + ORDER_USER_ID_COL + " INTEGER,"
                + ORDER_DATE_COL + " TEXT,"
                + ORDER_STATES_COL + " TEXT,"
                + ORDER_PROMOTION_ID_COL + " INTEGER,"
                + ORDER_QUANTITY_COL + " INTEGER,"
                + ORDER_AMOUNT_COL + " FLOAT,"
                + ORDER_DISCOUNT_AMOUNT_COL + " FLOAT,"
                + ORDER_TOTAL_AMOUNT_COL + " FLOAT,"
                + "FOREIGN KEY (" + ORDER_SHOP_ID_COL + ") REFERENCES " + TABLE_SHOP + " (" + SHOP_ID_COL + "),"
                + "FOREIGN KEY (" + ORDER_USER_ID_COL + ") REFERENCES " + TABLE_USERS + " (" + ID_COL + "),"
                + "FOREIGN KEY (" + ORDER_PROMOTION_ID_COL + ") REFERENCES " + TABLE_PROMOTION + " (" + PROMOTION_ID_COL + "))";

        String createReviewTableQuery = "CREATE TABLE " + TABLE_REVIEW + " ("
                + REVIEW_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + REVIEW_ORDER_ID_COL + " INTEGER,"
                + REVIEW_USER_ID_COL + " INTEGER,"
                + REVIEW_SHOP_ID_COL + " INTEGER,"
                + REVIEW_ITEM_ID_COL + " INTEGER,"
                + REVIEW_CATEGORY_COL + " TEXT,"
                + REVIEW_MESSAGE_COL + " TEXT,"
                + "FOREIGN KEY (" + REVIEW_ORDER_ID_COL + ") REFERENCES " + TABLE_ORDER + " (" + ORDER_ID_COL + "),"
                + "FOREIGN KEY (" + REVIEW_USER_ID_COL + ") REFERENCES " + TABLE_USERS + " (" + ID_COL + "),"
                + "FOREIGN KEY (" + REVIEW_SHOP_ID_COL + ") REFERENCES " + TABLE_SHOP + " (" + SHOP_ID_COL + "),"
                + "FOREIGN KEY (" + REVIEW_ITEM_ID_COL + ") REFERENCES " + TABLE_ITEM + " (" + ITEM_ID_COL + "))";

        db.execSQL(createUsersTableQuery);
        db.execSQL(createAdminsTableQuery);
        db.execSQL(createShopTableQuery);
        db.execSQL(createItemTableQuery);
        db.execSQL(createPromotionTableQuery);
        db.execSQL(createOrderTableQuery);
        db.execSQL(createReviewTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMINS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROMOTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEW);
        onCreate(db);
    }

    // Methods for user data
    public void addNewUser(String name, String email, String phone, String password, String address, String city, Bitmap image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(EMAIL_COL, email);
        values.put(PHONE_COL, phone);
        values.put(PASSWORD_COL, password);
        values.put(ADDRESS_COL, address);
        values.put(CITY_COL, city);

        if (image != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            values.put(IMAGE_COL, imageBytes);
        }

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + EMAIL_COL + " = ? AND " + PASSWORD_COL + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        boolean userExists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return userExists;
    }

    public Cursor getUserByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + EMAIL_COL + " = ?";
        return db.rawQuery(query, new String[]{email});
    }

    public void updateUser(String name, String phone, String address, String city, Bitmap image, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(PHONE_COL, phone);
        values.put(ADDRESS_COL, address);
        values.put(CITY_COL, city);

        if (image != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            values.put(IMAGE_COL, imageBytes);
        }

        db.update(TABLE_USERS, values, EMAIL_COL + " = ?", new String[]{email});
        db.close();
    }

    // Methods for admin data
    public void addNewAdmin(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ADMIN_NAME_COL, name);
        values.put(ADMIN_EMAIL_COL, email);
        values.put(ADMIN_PASSWORD_COL, password);
        db.insert(TABLE_ADMINS, null, values);
        db.close();
    }

    public boolean checkAdmin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_ADMINS + " WHERE " + ADMIN_EMAIL_COL + " = ? AND " + ADMIN_PASSWORD_COL + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        boolean adminExists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return adminExists;
    }

    public Cursor getAdminByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_ADMINS + " WHERE " + ADMIN_EMAIL_COL + " = ?";
        return db.rawQuery(query, new String[]{email});
    }

    public Bitmap getUserImage(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + IMAGE_COL + " FROM " + TABLE_USERS + " WHERE " + EMAIL_COL + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email});
        if (cursor != null && cursor.moveToFirst()) {
            byte[] imageBytes = cursor.getBlob(0);
            cursor.close();
            return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        }
        return null;
    }


    public void addNewShop(String shopName, String shopAddress, String shopCity, String shopContact, String shopEmail, String shopOpen, String shopClose, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", shopName);
        values.put("address", shopAddress);
        values.put("city", shopCity);
        values.put("contact", shopContact);
        values.put("email", shopEmail);
        values.put("open", shopOpen);
        values.put("close", shopClose);
        values.put("image", image);

        db.insert(TABLE_SHOP, null, values);
        db.close();
    }

    public Cursor getAllShops() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_SHOP,null);
    }

    public Cursor getItemsByCategory(String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ITEM,
                null,
                ITEM_CATEGORY_COL + " = ?",
                new String[]{category},
                null,
                null,
                null);
    }

}
