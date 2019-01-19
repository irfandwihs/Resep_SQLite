package com.irfandwihs.laresep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpDelAppetizer extends AppCompatActivity {

    private DBHandler db;
    private String Sid, Sjudul, Skategori, Sbahan, Sintruksi;
    EditText ed_judul_1, ed_kategori_1, ed_bahan_1, ed_intruksi_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_del_appetizer);

        db = new DBHandler(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Skategori = i.getStringExtra("Ikategori");
        Sbahan = i.getStringExtra("Ibahan");
        Sintruksi = i.getStringExtra("Iintruksi");

        ed_judul_1 = (EditText) findViewById(R.id.edt_judul_1);
        ed_kategori_1 = (EditText) findViewById(R.id.edt_kategori_1);
        ed_bahan_1 = (EditText) findViewById(R.id.edt_bahan_1);
        ed_intruksi_1 = (EditText) findViewById(R.id.edt_intruksi_1);

        ed_judul_1.setText(Sjudul);
        ed_kategori_1.setText(Skategori);
        ed_bahan_1.setText(Sbahan);
        ed_intruksi_1.setText(Sintruksi);

        Button btnUpdate = (Button) findViewById(R.id.btn_update_1);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(ed_judul_1.getText());
                Skategori = String.valueOf(ed_kategori_1.getText());
                Sbahan = String.valueOf(ed_bahan_1.getText());
                Sintruksi = String.valueOf(ed_intruksi_1.getText());
                if (Sjudul.equals("")){
                    ed_judul_1.requestFocus();
                    Toast.makeText(UpDelAppetizer.this, "Silahkan isi judul", Toast.LENGTH_SHORT).show();
                } else if (Skategori.equals("")){
                    ed_kategori_1.requestFocus();
                    Toast.makeText(UpDelAppetizer.this, "Silahkan isi kategori", Toast.LENGTH_SHORT).show();
                } else if (Sbahan.equals("")){
                    ed_bahan_1.requestFocus();
                    Toast.makeText(UpDelAppetizer.this, "Silahkan isi bahan", Toast.LENGTH_SHORT).show();
                } else if (Sintruksi.equals("")){
                    ed_intruksi_1.requestFocus();
                    Toast.makeText(UpDelAppetizer.this, "Silahkan isi intruksi", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateResep(new Resep(Sid, Sjudul, Skategori, Sbahan, Sintruksi));
                    Toast.makeText(UpDelAppetizer.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteResep(new Resep(Sid, Sjudul, Skategori, Sbahan, Sintruksi));
                Toast.makeText(UpDelAppetizer.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
