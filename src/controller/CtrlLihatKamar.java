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
import javax.swing.Timer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import threads.Threads;
import views.LihatKamar;

/**
 *
 * @author A Little Shit
 */
public class CtrlLihatKamar {
    private LihatKamar kamar;
    public CtrlLihatKamar(LihatKamar kamar){
        this.kamar = kamar;
    }
    public void add(){
        mirror();
        kamar.setLocationRelativeTo(null);
    }
    public void save(){
        Input input = new Input();
        int selected = kamar.getTableLihatKamar().getSelectedRow();
        input.set("kamar", dataTableId.get(selected));        
        input.set("tipe_kamar", kamar.getTableLihatKamar().getValueAt(selected, 1).toString());
        Threads.get("LihatKamar").exit();
        Threads.view("UpdateKamar", input);
    }
    public void open(){
        Threads.get("LihatKamar").exit();
    }
    public void addKamar(){
        Threads.get("LihatKamar").exit();
        Threads.view("TambahKamar");
    }
    
    
    private void mirror()
    {
        setTable();
    }
    private void setTable()
    {
        dataTableId = new ArrayList<>();
        colModel = (DefaultTableColumnModel) kamar.getTableLihatKamar().getColumnModel();
        model = (DefaultTableModel) kamar.getTableLihatKamar().getModel();
//        colModel.removeColumn(colModel.getColumn(0));
        
        ResultSet fetchKamar = DB.getInstance().get(
            "SELECT " + 
            "kamar.id_kamar, kamar.nomor_kamar,tipe_kamar.nama_tipe_kamar,tipe_kamar.harga_per_malam,tipe_kamar.harga_per_orang,kamar.max_dewasa,kamar.max_anak,kamar.status " + 
            "FROM " + 
            "kamar " +
            "INNER JOIN " + 
            "tipe_kamar " + 
            "ON " +
            "kamar.id_tipe_kamar = tipe_kamar.id_tipe_kamar"
        );
        try {
            while(fetchKamar.next())
            {
                String[] dataKamar = {
                    fetchKamar.getString("id_kamar"),
                    fetchKamar.getString("nomor_kamar"),
                    fetchKamar.getString("nama_tipe_kamar"),
                    fetchKamar.getString("harga_per_malam"),
                    fetchKamar.getString("harga_per_orang"),
                    fetchKamar.getString("max_dewasa"),
                    fetchKamar.getString("max_anak"),
                    fetchKamar.getString("status")
                };
                model.addRow(dataKamar);
                dataTableId.add(dataKamar[0]);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LihatKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
//        tableLihatKamar.valueChanged(e);
    }

    
    
    
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    ArrayList<String> dataTableId;
    DefaultTableModel model;
    DefaultTableColumnModel colModel;
}
