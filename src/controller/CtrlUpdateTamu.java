/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import backend.Data;
import backend.Input;
import backend.Uuid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import threads.Threads;
import views.UpdateTamu;

/**
 *
 * @author A Little Shit
 */
public class CtrlUpdateTamu {
    UpdateTamu tamu;
    String id;
    public CtrlUpdateTamu(UpdateTamu tamu){
        this.tamu = tamu;
    }
    public void add(Input input){
        tamu.setLocationRelativeTo(null);
        String sql = "SELECT * FROM tamu WHERE id_tamu = '"+input.get("id")+"'";
        id = input.get("id");
        ResultSet r = DB.getInstance().get(sql);
        try {
            if(r.next()){
                tamu.getTxtNamaTamu().setText(r.getString("nama_tamu"));
                tamu.getTxtAlamat().setText(r.getString("alamat"));
                tamu.getTxtIdentitas().setText(r.getString("nomor_identitas"));
                tamu.getTxtWarga().setText(r.getString("warga_negara"));
                tamu.getTxtNomortelp0().setText(r.getString("nomor_telp").substring(0,2));
                tamu.getTxtNomortelp1().setText(r.getString("nomor_telp").substring(3));
                String[] email = r.getString("email").split("@");
                tamu.getTxtEmail0().setText(email[0]);
                tamu.getTxtEmail2().setText(email[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlUpdateTamu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exit(){
        Threads.get("UpdateTamu").exit();
    }
    public void save(){
        Input input = new Input();
        input.set(Uuid.generate());
        String[] namaTamu = tamu.getTxtNamaTamu().getText().split("\\s+");
        input.set(tamu.getCbNamaTamu().getSelectedItem().toString());
        input.set(tamu.getTxtNamaTamu().getText());
        input.set(tamu.getCbIdentitas().getSelectedItem().toString());
        input.set(tamu.getTxtIdentitas().getText());
        input.set(tamu.getTxtWarga().getText());
        input.set(tamu.getTxtNomortelp0().getText() + " " + tamu.getTxtNomortelp1().getText());
        input.set(tamu.getTxtEmail0().getText() + tamu.getTxtEmail1().getText() + tamu.getTxtEmail2().getText());
        if(!tamu.getTxtAlamat().getText().equals(null) || !tamu.getTxtAlamat().getText().equals(""))
            input.set(tamu.getTxtAlamat().getText());
        String sql = "UPDATE tamu SET prefix = '"+input.get(1)+"', nama_tamu = '"+input.get(2)+"', tipe_identitas = '"+input.get(3)+"', nomor_identitas = '"+input.get(4)+"', warga_negara = '"+input.get(5)+"', nomor_telp = '"+input.get(6)+"', email = '"+input.get(7)+"', alamat = '"+input.get(8)+"' WHERE id_tamu = '" + id + "'";
        DB.getInstance().exec(sql);
        JOptionPane.showMessageDialog(null, "Berhasil");
    }
    private void mirror(){
        
    }
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
}
