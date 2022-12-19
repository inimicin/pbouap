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
    private int dayaTahan;

    public Makanan(int dayaTahan, String id, String nama_produk, double harga, int jumlah, double diskon) {
        super(id, nama_produk, harga, jumlah, diskon);
        this.dayaTahan = dayaTahan;
    }
    
    public boolean isSpoiled() {
        return true;
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
