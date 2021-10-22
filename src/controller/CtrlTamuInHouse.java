/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import threads.Threads;
import views.LihatTamu;
import views.TamuInHouse;

/**
 *
 * @author A Little Shit
 */
public class CtrlTamuInHouse {
    TamuInHouse tamu;
    public CtrlTamuInHouse(TamuInHouse tamu){
        this.tamu = tamu;
    }
    public void add(){
        mirror();
        tamu.setLocationRelativeTo(null);
    }
    public void addTamu(){
        Threads.view("TambahTamu");
        Threads.get("TamuInHouse").exit();
    }
    public void exit(){
        Threads.get("TamuInHouse").exit();
    }
    
    
    private void mirror()
    {
        setTable();
    }
    private void setTable()
    {
        model = (DefaultTableModel) tamu.getTableLihatTamu().getModel();
        String sql = 
            "SELECT " + 
            "kamar.nomor_kamar, tamu.nama_tamu, transaksi_kamar.tanggal_checkin, transaksi_kamar.tanggal_checkout, transaksi_kamar.deposit, transaksi_kamar.nomor_invoice, transaksi_kamar.total_biaya " + 
            "FROM " + 
            "transaksi_kamar " + 
            "INNER JOIN " + 
            "tamu " + 
            "ON " + 
            "transaksi_kamar.id_tamu=tamu.id_tamu " + 
            "INNER JOIN " + 
            "kamar " +
            "ON " + 
            "transaksi_kamar.id_kamar=kamar.id_kamar "
                + "WHERE transaksi_kamar.status = 'Check In'";
        ResultSet fetchTamu = DB.getInstance().get(sql);
        try {
            while(fetchTamu.next())
            {
                sql = "SELECT total_harga FROM transaksi_layanan WHERE nomor_invoice = '"+fetchTamu.getString("nomor_invoice")+"'";
                ResultSet re = DB.getInstance().get(sql);
                int deposit = fetchTamu.getInt("deposit") - fetchTamu.getInt("total_biaya");
                while(re.next()){
                    deposit-=re.getInt("total_harga");
                }
                String[] dataTamu = {
                    fetchTamu.getString("nomor_kamar"),
                    fetchTamu.getString("nama_tamu"),
                    fetchTamu.getString("tanggal_checkin"),
                    fetchTamu.getString("tanggal_checkout"),
                    String.valueOf(deposit)
                };
                model.addRow(dataTamu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LihatTamu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    DefaultTableModel model;
}
