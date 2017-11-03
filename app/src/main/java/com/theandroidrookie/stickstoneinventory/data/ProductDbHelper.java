package com.theandroidrookie.stickstoneinventory.data;

/**
 * Created by jeff on 11/3/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Database helper. Manages database creation and version control.
 */
public class ProductDbHelper extends SQLiteOpenHelper {
    private static final String TAG = ProductDbHelper.class.getSimpleName();

    //Name of the database file
    private static final String DATABASE_NAME = "inventory.db";
    //Database version
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs new instance of {@link ProductDbHelper}
     *
     * @param context of the app
     */
    public ProductDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creates database if it doesn't exist
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Query string to create table
        String SQL_CREATE_PRODUCTS_TABLE = "CREATE TABLE " + ProductContract.ProductEntry.TABLE_NAME + "(" +
                ProductContract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_BRAND + " TEXT NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_CATEGORY + " INTEGER NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_PRICE + " REAL NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_PRICE_DISCOUNT + " REAL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_STOCK + " INTEGER NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_IMAGE + " TEXT NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME + " TEXT NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_EMAIL + " TEXT NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_PHONE + " TEXT NOT NULL" +
                ");";
        //Execute query
        sqLiteDatabase.execSQL(SQL_CREATE_PRODUCTS_TABLE);

        //Log the query to double-check
        Log.d(TAG, SQL_CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
