/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import threads.Threads;
import views.LihatLayanan;
import views.LihatTamu;

/**
 *
 * @author A Little Shit
 */
public class CtrlLihatLayanan {
    private final LihatLayanan layanan;
    public CtrlLihatLayanan(LihatLayanan layanan){
        this.layanan = layanan;
    }
    public void add(){
        mirror();
        layanan.setLocationRelativeTo(null);
    }
    public void exit(){
        Threads.get("LihatLayanan").exit();
    }
    private void mirror()
    {
        setTable();
    }
    private void setTable()
    {
        dataTableId = new ArrayList<>();
        colModel = (DefaultTableColumnModel) layanan.getTableLihatLayanan().getColumnModel();
        model = (DefaultTableModel) layanan.getTableLihatLayanan().getModel();
//        colModel.removeColumn(colModel.getColumn(0));
        ResultSet fetchLayanan = DB.getInstance().get(
            "SELECT " + 
            "layanan.nama_layanan, kategori_layanan.nama_kategori_layanan, layanan.harga_layanan, layanan.satuan " + 
            "FROM " + 
            "layanan " + 
            "INNER JOIN " + 
            "kategori_layanan " + 
            "ON " + 
            "layanan.id_kategori_layanan=kategori_layanan.id_kategori_layanan"
        );
        try {
            while(fetchLayanan.next())
            {
                String[] dataLayanan = {
                    fetchLayanan.getString("nama_layanan"),
                    fetchLayanan.getString("nama_kategori_layanan"),
                    fetchLayanan.getString("harga_layanan") + " / " + fetchLayanan.getString("satuan")
                };
                model.addRow(dataLayanan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LihatTamu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    ArrayList<String> dataTableId;
    DefaultTableModel model;
    DefaultTableColumnModel colModel;
}
