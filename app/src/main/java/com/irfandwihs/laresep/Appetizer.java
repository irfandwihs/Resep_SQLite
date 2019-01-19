package com.irfandwihs.laresep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Appetizer extends AppCompatActivity {

    private DBHandler db;
    private EditText edtJudul, edtKategori, edtBahan, edtIntruksi;
    private String strJudul, strKategori, strBahan, strIntruksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer);

        db = new DBHandler(this);

        edtJudul = findViewById(R.id.edt_judul_1) ;
        edtKategori = findViewById(R.id.edt_kategori_1);
        edtBahan = findViewById(R.id.edt_bahan_1);
        edtIntruksi = findViewById(R.id.edt_intruksi_1);

        Button btnCreate1 = (Button) findViewById(R.id.create1);
        Button btnBack1 = findViewById(R.id.back1);
        btnCreate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strJudul = String.valueOf(edtJudul.getText());
                strKategori = String.valueOf(edtKategori.getText());
                strBahan = String.valueOf(edtBahan.getText());
                strIntruksi = String.valueOf(edtIntruksi.getText());

                if (strJudul.equals("")){
                    edtJudul.requestFocus();
                    Toast.makeText(Appetizer.this, "Silahkan isi judul", Toast.LENGTH_SHORT).show();
                } else if (strKategori.equals("")){
                    edtKategori.requestFocus();
                    Toast.makeText(Appetizer.this, "Silahkan isi kategori", Toast.LENGTH_SHORT).show();
                } else if (strBahan.equals("")){
                    edtBahan.requestFocus();
                    Toast.makeText(Appetizer.this, "Silahkan isi bahan", Toast.LENGTH_SHORT).show();
                } else if (strIntruksi.equals("")){
                    edtIntruksi.requestFocus();
                    Toast.makeText(Appetizer.this, "Silahkan isi intruksi", Toast.LENGTH_SHORT).show();
                } else {
                    edtJudul.setText("");
                    edtKategori.setText("");
                    edtBahan.setText("");
                    edtIntruksi.setText("");
                    Toast.makeText(Appetizer.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateResep(new Resep(null, strJudul, strKategori, strBahan, strIntruksi));
                }

            }
        });

        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
