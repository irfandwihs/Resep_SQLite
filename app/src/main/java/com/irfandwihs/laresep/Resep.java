package com.irfandwihs.laresep;

public class Resep {
    private String _id, _judul, _kategori, _bahan, _intruksi;

    public Resep (String id, String judul, String kategori, String bahan, String intruksi){
        this._id = id;
        this._judul = judul;
        this._kategori = kategori;
        this._bahan = bahan;
        this._intruksi = intruksi;
    }

    public Resep(){

    }

    public void set_id(String id) {
        this._id = id;
    }

    public String get_id() {
        return this._id;
    }

    public void set_judul(String judul) {
        this._judul = judul;
    }

    public String get_judul() {
        return this._judul;
    }

    public void set_kategori(String kategori) {
        this._kategori = kategori;
    }

    public String get_kategori() {
        return this._kategori;
    }

    public void set_bahan(String bahan) {
        this._bahan = bahan;
    }

    public String get_bahan() {
        return this._bahan;
    }

    public void set_intruksi(String intruksi) {
        this._intruksi = intruksi;
    }

    public String get_intruksi() {
        return this._intruksi;
    }
}
