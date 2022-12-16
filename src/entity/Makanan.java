/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author A S U S
 */
public class Makanan extends Produk{
    private int id;
    private int dayaTahan;

    public Makanan(String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
    }
    
    public boolean isSpoiled() {
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the dayaTahan
     */
    public int getDayaTahan() {
        return dayaTahan;
    }

    /**
     * @param dayaTahan the dayaTahan to set
     */
    public void setDayaTahan(int dayaTahan) {
        this.dayaTahan = dayaTahan;
    }
}
