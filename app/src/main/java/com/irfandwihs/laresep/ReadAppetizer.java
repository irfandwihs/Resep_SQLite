package com.irfandwihs.laresep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReadAppetizer extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DBHandler db;
    private List<Resep> ListResep = new ArrayList<Resep>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_appetizer);

        db = new DBHandler(this);

        adapter_off = new CustomListAdapter(this, ListResep );
        mListView = (ListView) findViewById(R.id.listAppetizer);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListResep.clear();

        List<Resep> contacts = db.ReadResep1();
        for (Resep cn : contacts) {
            Resep judulModel = new Resep();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_kategori(cn.get_kategori());
            judulModel.set_kategori(cn.get_bahan());
            judulModel.set_kategori(cn.get_intruksi());
            ListResep.add(judulModel);

            if ((ListResep.isEmpty()))
                Toast.makeText(ReadAppetizer.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object o = mListView.getItemAtPosition(position);
        Resep obj_itemDetails = (Resep) o;

        String Sid = obj_itemDetails.get_id();
        String Sjudul = obj_itemDetails.get_judul();
        String Skategori = obj_itemDetails.get_kategori();
        String Sbahan = obj_itemDetails.get_bahan();
        String Sintruksi = obj_itemDetails.get_intruksi();

        Intent goUpdel = new Intent(ReadAppetizer.this, UpDelAppetizer.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijudul", Sjudul);
        goUpdel.putExtra("Ikategori", Skategori);
        goUpdel.putExtra("Ibahan", Sbahan);
        goUpdel.putExtra("Iintruksi", Sintruksi);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListView.setAdapter(adapter_off);
        ListResep.clear();

        List<Resep> contacts = db.ReadResep1();
        for (Resep cn : contacts) {
            Resep judulModel = new Resep();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_kategori(cn.get_kategori());
            judulModel.set_kategori(cn.get_bahan());
            judulModel.set_kategori(cn.get_intruksi());
            ListResep.add(judulModel);

            if ((ListResep.isEmpty()))
                Toast.makeText(ReadAppetizer.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
