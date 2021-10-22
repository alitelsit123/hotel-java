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
import javax.swing.JOptionPane;
import javax.swing.Timer;
import threads.Threads;
import views.TambahTamu;

/**
 *
 * @author A Little Shit
 */
public class CtrlTambahTamu {
    TambahTamu tamu;
    public CtrlTambahTamu(TambahTamu tamu){
        this.tamu = tamu;
    }
    public void add(){
        tamu.setLocationRelativeTo(null);
    }
    public void exit(){
        Threads.get("TambahTamu").exit();
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
        DB.getInstance().exec(Data.tambahTamu(input));
        JOptionPane.showMessageDialog(null, "Berhasil");
    }
    
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
}
