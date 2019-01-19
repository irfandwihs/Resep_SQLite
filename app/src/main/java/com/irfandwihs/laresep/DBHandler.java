package com.irfandwihs.laresep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION =1;
    private static final String  DATABASE_NAME = "resep";

    private static final String tb_resep = "tb_resep";

    private static final String tb_resep_id = "id";
    private static final String tb_resep_judul = "judul";
    private static final String tb_resep_kategori = "kategori";
    private static final String tb_resep_bahan = "bahan";
    private static final String tb_resep_intruksi = "intruksi";

    private static final String CREATE_TABLE_RESEP = "CREATE TABLE " + tb_resep + "("
            + tb_resep_id + " INTEGER PRIMARY KEY ,"
            + tb_resep_judul + " TEXT,"
            + tb_resep_kategori + " TEXT, "
            + tb_resep_bahan + " TEXT, "
            + tb_resep_intruksi + " TEXT " + ")";

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RESEP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateResep (Resep mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_resep_id, mdNotif.get_id());
        values.put(tb_resep_judul, mdNotif.get_judul());
        values.put(tb_resep_kategori, mdNotif.get_kategori());
        values.put(tb_resep_bahan, mdNotif.get_bahan());
        values.put(tb_resep_intruksi, mdNotif.get_intruksi());
        db.insert(tb_resep, null, values);
        db.close();
    }

    public List<Resep> ReadResep1() {
        List<Resep> judulModelList = new ArrayList<Resep>();
        String selectQuery = "SELECT  * FROM " + tb_resep;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Resep mdNota = new Resep();
                mdNota.set_id(cursor.getString(0));
                mdNota.set_judul(cursor.getString(1));
                mdNota.set_kategori(cursor.getString(2));
                mdNota.set_bahan(cursor.getString(3));
                mdNota.set_intruksi(cursor.getString(4));
                judulModelList.add(mdNota);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateResep (Resep mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_resep_judul, mdNotif.get_judul());
        values.put(tb_resep_kategori, mdNotif.get_kategori());
        values.put(tb_resep_bahan, mdNotif.get_bahan());
        values.put(tb_resep_intruksi, mdNotif.get_intruksi());

        return db.update(tb_resep, values, tb_resep_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteResep (Resep mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_resep, tb_resep_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }

}
