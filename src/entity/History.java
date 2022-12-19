/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author adiha
 */
public class History {
    private int id;
    private double total_harga;

    public History(int id, double total_harga) {
        this.id = id;
        this.total_harga = total_harga;
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
     * @return the total_harga
     */
    public double getTotal_harga() {
        return total_harga;
    }

    /**
     * @param total_harga the total_harga to set
     */
    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }
    
    
}
