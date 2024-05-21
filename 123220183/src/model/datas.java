/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class datas {
    private String Nama;
    private String NamaBuku;
    private String JenisBuku;
    private String Telepon;
    private Integer Durasi;
    private Integer Total;

    public String getNama() {
        return Nama;
    }

    public String getNamaBuku() {
        return NamaBuku;
    }

    public String getJenisBuku() {
        return JenisBuku;
    }
    
    public String getTelepon() {
        return Telepon;
    }

    public Integer getDurasi() {
        return Durasi;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setNamaBuku(String NamaBuku) {
        this.NamaBuku = NamaBuku;
    }

    public void setJenisBuku(String JenisBuku) {
        this.JenisBuku = JenisBuku;
    }
    
    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public void setDurasi(Integer Durasi) {
        this.Durasi = Durasi;
    }

    public void setTotal(Integer Total) {
        this.Total = Total;
    } 
}
