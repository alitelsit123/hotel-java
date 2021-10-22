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
import threads.Threads;
import views.DetailHotel;

/**
 *
 * @author A Little Shit
 */
public class CtrlDetailHotel {
    DetailHotel hotel;
    public CtrlDetailHotel(DetailHotel hotel){
        this.hotel = hotel;
    }
    public void add(){
        mirror();
        hotel.setLocationRelativeTo(null);
    }
    public void exit(){
        Threads.get("DetailHotel").exit();
    }
    private void mirror()
    {
        try {
            String sql = "SELECT * FROM detail";
            ResultSet result = DB.getInstance().get(sql);
            while(result.next())
            {
                hotel.getTxtId().setText(result.getString("id_hotel"));
                hotel.getTxtNamaHotel().setText(result.getString("nama_hotel"));
                hotel.getTxtAlamat().setText(result.getString("alamat_hotel"));
                hotel.getTxtNomorTelp().setText(result.getString("nomor_telpon"));
                hotel.getTxtEmail().setText(result.getString("email"));
                hotel.getTxtFax().setText(result.getString("nomor_fax"));
                hotel.getTxtWebsite().setText(result.getString("website"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
}
