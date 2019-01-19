package com.irfandwihs.laresep;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Resep> movieItems;

    public CustomListAdapter(Activity activity, List<Resep> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list_1, null);

        TextView judul = (TextView) convertView.findViewById(R.id.text_nama);
        TextView kategori = (TextView) convertView.findViewById(R.id.text_akun);
        TextView bahan = (TextView) convertView.findViewById(R.id.bahan);
        TextView intruksi = (TextView) convertView.findViewById(R.id.intruksi);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);

        Resep rs = movieItems.get(position);

//		imageView.setImageResource(R.drawable.ImageView);
//		} else {
//			imageView.setImageResource(R.drawable.ic_person_red_24dp);
//		}

        judul.setText("Judul : "+ rs.get_judul());
        kategori.setText("Kategori : "+ rs.get_kategori());
        bahan.setText("Bahan : "+ rs.get_bahan());
        intruksi.setText("Intruksi : "+ rs.get_intruksi());

        return convertView;
    }
}
