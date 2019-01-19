package com.irfandwihs.laresep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class JenisActivity extends AppCompatActivity {
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis);

        close = findViewById(R.id.ic_tutup);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void icAppetizer(View view) {
        Intent readAppetizer = new Intent(JenisActivity.this, ReadAppetizer.class);
        startActivity(readAppetizer);
    }

    public void icSoup(View view) {
        Intent readSoup = new Intent(JenisActivity.this, ReadAppetizer.class);
        startActivity(readSoup);
    }

    public void icMaincourse(View view) {
        Intent readMaincourse = new Intent(JenisActivity.this, ReadAppetizer.class);
        startActivity(readMaincourse);
    }

    public void icDessert(View view) {
        Intent readDessert = new Intent(JenisActivity.this, ReadAppetizer.class);
        startActivity(readDessert);
    }

    public void tambah(View view) {
        Intent menu = new Intent(JenisActivity.this, Appetizer.class);
        startActivity(menu);
    }

}
