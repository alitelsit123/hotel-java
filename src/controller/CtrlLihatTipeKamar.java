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
import views.LihatTamu;
import views.LihatTipeKamar;

/**
 *
 * @author A Little Shit
 */
public class CtrlLihatTipeKamar {
    LihatTipeKamar tipekamar;
    public CtrlLihatTipeKamar(LihatTipeKamar tipekamar){
        this.tipekamar = tipekamar;
    }
    public void add(){
        mirror();
        tipekamar.setLocationRelativeTo(null);
    }
    public void tambah(){
        Threads.get("LihatTipeKamar").exit();
        Threads.view("TambahTipeKamar");
    }
    public void exit(){
        Threads.get("LihatTipeKamar").exit();
    }
    private void mirror()
    {
        setTable();
    }
    private void setTable()
    {
        dataTableId = new ArrayList<>();
        colModel = (DefaultTableColumnModel) tipekamar.getTableLihatTipeKamar().getColumnModel();
        model = (DefaultTableModel) tipekamar.getTableLihatTipeKamar().getModel();
//        colModel.removeColumn(colModel.getColumn(0));
        ResultSet fetchTipeKamar = DB.getInstance().get("SELECT * FROM tipe_kamar");
        try {
            while(fetchTipeKamar.next())
            {
                String[] dataTamu = {
                    fetchTipeKamar.getString("nama_tipe_kamar"),
                    fetchTipeKamar.getString("harga_per_malam"),
                    fetchTipeKamar.getString("harga_per_orang"),
                    fetchTipeKamar.getString("keterangan")
                };
                model.addRow(dataTamu);
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
