/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author adiha
 */
public class Kategori {
    private String nama_kategori;

    /**
     * @return the nama_kategori
     */
    public String getNama_kategori() {
        return nama_kategori;
    }

    /**
     * @param nama_kategori the nama_kategori to set
     */
    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
    
    public ArrayList<Barang> getProduk(){
        return null;
    }
}
