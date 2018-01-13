package com.example.rishabhaggarwal.barcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rishabh Aggarwal on 14-04-2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SHOP";
    public static final String TABLE_NAME = "PRODUCT";
    public static final String TABLE_NAME2 = "ADMIN";
    public static final String COLUMN_FORMAT = "FORMAT";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_CONTENT = "CONTENT";
    public static final String COLUMN_PRICE = "PRICE";
    //public static final String COLUMN_PTYPE="PTYPE";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    SQLiteDatabase db;
    Cursor a;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_FORMAT + " TEXT, " +
                COLUMN_CONTENT + " TEXT PRIMARY KEY, " +
      //          COLUMN_PTYPE + " TEXT, " +
                COLUMN_PRICE + " INTEGER " + ");";

        db.execSQL(query);
        String query2 = "CREATE TABLE " + TABLE_NAME2 + " (" +

                COLUMN_ID + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT " + ");";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);

    }

    public void adduser(information i) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_FORMAT, i.getFormat());
        values.put(COLUMN_CONTENT, i.getContent());
        values.put(COLUMN_PRICE, i.getPrice());
    //    values.put(COLUMN_PTYPE,i.getPtype());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String price(String compare) {
        try {
            String comparef = compare;
            String data = "";
            db = this.getReadableDatabase();
            String query = "SELECT  " + COLUMN_PRICE + "  FROM " + TABLE_NAME + " WHERE " + COLUMN_CONTENT + " = " + " '" + comparef + "';";
            Cursor cursor = db.rawQuery(query, null);
            cursor.moveToFirst();

            if (cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)) != null)
                data += cursor.getString(cursor.getColumnIndex(COLUMN_PRICE));
            cursor.close();
            db.close();
            return data;
        } catch (Exception e)

        {
            System.out.println(e);
        }

        System.out.println("not valid");
        String a = "null";
        return a;

    }
    public String pcontent(String compare) {
        try {
            String comparef = compare;
            String data = "";
            db = this.getReadableDatabase();
            String query = "SELECT  " + COLUMN_FORMAT + "  FROM " + TABLE_NAME + " WHERE " + COLUMN_CONTENT + " = " + " '" + comparef + "';";
            Cursor cursor = db.rawQuery(query, null);
            cursor.moveToFirst();

            if (cursor.getString(cursor.getColumnIndex(COLUMN_FORMAT)) != null)
                data += cursor.getString(cursor.getColumnIndex(COLUMN_FORMAT));
            cursor.close();
            db.close();
            return data;
        } catch (Exception e)

        {
            System.out.println(e);
        }

        System.out.println("not valid");
        String a = "null";
        return a;

    }
  /*  public String ptype(String compare) {
        try {
            String comparef = compare;
            String data = "";
            db = this.getReadableDatabase();
            String query = "SELECT  " + COLUMN_PTYPE + "  FROM " + TABLE_NAME + " WHERE " + COLUMN_CONTENT + " = " + " '" + comparef + "';";
            Cursor cursor = db.rawQuery(query, null);
            cursor.moveToFirst();

            if (cursor.getString(cursor.getColumnIndex(COLUMN_PTYPE)) != null)
                data += cursor.getString(cursor.getColumnIndex(COLUMN_PTYPE));
            cursor.close();
            db.close();
            return data;
        } catch (Exception e)

        {
            System.out.println(e);
        }

        System.out.println("not valid");
        String a = "null";
        return a;

    }*/


    public String delete(String ccompare, String price) {
        String comparef = ccompare;
        String pcompare = price;
        String data = "";
        db = this.getReadableDatabase();
        String query = "UPDATE " + TABLE_NAME + "  SET " + COLUMN_PRICE + " = " + " '" + pcompare + "' " + "WHERE " + COLUMN_CONTENT + " = " + " '" + ccompare + "';";
        Cursor cursor;
        try {
            cursor = db.rawQuery(query, null);
            cursor.moveToFirst();
            cursor.close();
        } catch (Exception e) {
            Log.d("deleted", "deleted");
        }

        db.close();
        return data;
    }

    public String delete2(String ccompare) {
        String comparef = ccompare;
        String data = "";
        db = this.getReadableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_CONTENT + " = '" + comparef + "';";
        Cursor cursor;
        cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String a = "deleted";

        cursor.close();
        return a;
    }

    public void admin(information i) {
        ContentValues a = new ContentValues();
        a.put(COLUMN_ID, i.getAid());
        a.put(COLUMN_PASSWORD, i.getPassword());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME2, null, a);
        db.close();
    }

    public String getpass(String compare) {
        try {
            String comparef = compare;
            String data = "";
            db = this.getReadableDatabase();
            String query1 = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_NAME2 + " WHERE " + COLUMN_ID + " = " + " '" + comparef + "';";
            Cursor cur=db.rawQuery(query1,null);
            cur.moveToFirst();
            if (cur.getString(cur.getColumnIndex(COLUMN_PASSWORD)) != null)
                data += cur.getString(cur.getColumnIndex(COLUMN_PASSWORD));
            cur.close();
            db.close();
            return data;

        } catch (Exception e)

       {
            System.out.println(e);
        }

        System.out.println("not valid");
        String a = "INVALID PRODUCT";
        return a;

    }
    public int count(){
        try {
            int count = 0;
            db = this.getReadableDatabase();
            String query = "SELECT COUNT(" + COLUMN_ID + ") FROM " + TABLE_NAME2 + ";";
            Cursor cur = db.rawQuery(query, null);
            cur.moveToFirst();
             count= cur.getInt(0);
            cur.close();
            db.close();
            return count;

        } catch (Exception e){
            System.out.print(e);

        }
        System.out.println("not valid");
        int a = 0;
        return a;



    }
}



