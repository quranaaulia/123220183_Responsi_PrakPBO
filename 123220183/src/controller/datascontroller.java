/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdatas.datasDAO;
import model.*;
import view.MainView;
import javax.swing.*;
import DAOImplement.dataimplement;

/**
 *
 * @author Lab Informatika
 */
public class datascontroller {

    MainView frame;
    dataimplement impldatas;
    List<datas> ds;

    public datascontroller(MainView frame) {
        this.frame = frame;
        impldatas = new datasDAO();
        ds = impldatas.getAll();

    }

    public void isitabel() {
        ds = impldatas.getAll();
        modeltabeldatas ms = new modeltabeldatas(ds);
        frame.getTableDatas().setModel(ms);

    }

    public void insert() {
        // Mendapatkan nilai dari JTextField
        String nama = frame.getJTxtNama().getText();
        String namabuku = frame.getJTxtNamaBuku().getText();
        String jenisbuku = frame.getJTxtJenisBuku().getText();
        String telepon = frame.getJTxtTelepon().getText();
        String durasiText = frame.getJTxtDurasi().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (nama.isEmpty() || namabuku.isEmpty() || jenisbuku.isEmpty() || telepon.isEmpty() || durasiText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        try {
            // Mengonversi nilai durasi ke dalam tipe data integer
            int durasi = Integer.parseInt(durasiText);

            // Jika semua nilai dapat dikonversi dengan benar, maka data dimasukkan ke dalam objek datap
            datas ds = new datas();
            ds.setNama(nama);
            ds.setNamaBuku(namabuku);
            ds.setJenisBuku(jenisbuku);
            ds.setTelepon(telepon);
            ds.setDurasi(durasi);
            impldatas.insert(ds);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            // Mengosongkan field setelah data berhasil ditambahkan
            frame.getJTxtNama().setText("");
            frame.getJTxtNamaBuku().setText("");
            frame.getJTxtJenisBuku().setText("");
            frame.getJTxtTelepon().setText("");
            frame.getJTxtDurasi().setText("");

        } catch (NumberFormatException e) {
            // Menangani jika input dari pengguna tidak bisa diubah menjadi tipe data integer
            JOptionPane.showMessageDialog(frame, "Durasi harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update() {
        String nama = frame.getJTxtNama().getText();
        String namabuku = frame.getJTxtNamaBuku().getText();
        String jenisbuku = frame.getJTxtJenisBuku().getText();
        String telepon = frame.getJTxtTelepon().getText();
        String durasiText = frame.getJTxtDurasi().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (nama.isEmpty() || namabuku.isEmpty() || jenisbuku.isEmpty() || telepon.isEmpty() || durasiText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        try {
            // Mengonversi nilai durasi ke dalam tipe data integer
            int durasi = Integer.parseInt(durasiText);

            // Jika semua nilai dapat dikonversi dengan benar, maka data dimasukkan ke dalam objek datap
            datas ds = new datas();
            ds.setNama(nama);
            ds.setNamaBuku(namabuku);
            ds.setJenisBuku(jenisbuku);
            ds.setTelepon(telepon);
            ds.setDurasi(durasi);
            impldatas.update(ds);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

            // Mengosongkan field setelah data berhasil ditambahkan
            frame.getJTxtNama().setText("");
            frame.getJTxtNamaBuku().setText("");
            frame.getJTxtJenisBuku().setText("");
            frame.getJTxtTelepon().setText("");
            frame.getJTxtDurasi().setText("");

        } catch (NumberFormatException e) {
            // Menangani jika input dari pengguna tidak bisa diubah menjadi tipe data integer
            JOptionPane.showMessageDialog(frame, "Durasi harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
        String namabuku = frame.getJTxtNamaBuku().getText();
        impldatas.delete(namabuku);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        frame.getJTxtNama().setText("");
        frame.getJTxtNamaBuku().setText("");
        frame.getJTxtJenisBuku().setText("");
        frame.getJTxtTelepon().setText("");
        frame.getJTxtDurasi().setText("");
    }

    public void clear() {
        frame.getJTxtNama().setText("");
        frame.getJTxtNamaBuku().setText("");
        frame.getJTxtJenisBuku().setText("");
        frame.getJTxtTelepon().setText("");
        frame.getJTxtDurasi().setText("");
    }
}
