/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import backend.Input;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import threads.Threads;
import views.LihatTamu;

/**
 *
 * @author A Little Shit
 */
public class CtrlLihatTamu {
    LihatTamu tamu;
    public CtrlLihatTamu(LihatTamu tamu){
        this.tamu = tamu;
    }
    public void add(){
        mirror();
        tamu.setLocationRelativeTo(null);
    }
    public void exit(){
        Threads.get("LihatTamu").exit();
    }
    public void delete(){
        String sql = "DELETE FROM tamu WHERE id_tamu = '"+model.getValueAt(tamu.getTableLihatTamu().getSelectedRow(), 0).toString()+"'";
        DB.getInstance().exec(sql);
        JOptionPane.showMessageDialog(null, "Hapus Berhasil");
        setTable();
    }
    public void addTamu(){
        Threads.get("LihatTamu").exit();
        Threads.view("TambahTamu");
    }
    public void update(){
        Input in = new Input();
        in.set("id", model.getValueAt(tamu.getTableLihatTamu().getSelectedRow(), 0).toString());
        Threads.get("LihatTamu").exit();
        Threads.view("UpdateTamu", in);
    }
    
    private void mirror()
    {
        setTable();
    }
    private void setTable()
    {
        
        dataTableId = new ArrayList<>();
        colModel = (DefaultTableColumnModel) tamu.getTableLihatTamu().getColumnModel();
        model = (DefaultTableModel) tamu.getTableLihatTamu().getModel();
        model.setRowCount(0);
//        colModel.removeColumn(colModel.getColumn(0));
        
        ResultSet fetchTamu = DB.getInstance().get("SELECT * FROM tamu");
        try {
            while(fetchTamu.next())
            {
                String[] dataTamu = {
                    fetchTamu.getString("id_tamu"),
                    fetchTamu.getString("nama_tamu"),
                    fetchTamu.getString("warga_negara"),
                    fetchTamu.getString("nomor_telp"),
                    fetchTamu.getString("email")
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
