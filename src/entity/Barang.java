/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author A S U S
 */
public class Barang extends Produk {
    private String barcode;
    private String expired;
    private ArrayList<Kategori> kategori;

    public Barang(String barcode, String expired, ArrayList<Kategori> kategori, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.kategori = kategori;
    }
    
    public boolean isExpired(){
        return true;
    }
    
    public void addKategori(){
        
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the expired
     */
    public String getExpired() {
        return expired;
    }

    /**
     * @param expired the expired to set
     */
    public void setExpired(String expired) {
        this.expired = expired;
    }

    /**
     * @return the kategori
     */
    public ArrayList<?> getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }
}
