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
import views.LihatUsers;

/**
 *
 * @author A Little Shit
 */
public class CtrlLihatUsers {
    LihatUsers user;
    public CtrlLihatUsers(LihatUsers user){
        this.user = user;
    }
    public void add(){
        mirror();
        user.setLocationRelativeTo(null);
    }
    public void exit(){
        Threads.get("LihatUsers").exit();
    }
    
    private void mirror()
    {
        setTable();
    }
    private void setTable()
    {
        model = (DefaultTableModel) user.getTableLihatUsers().getModel();
        ResultSet fetchUsers = DB.getInstance().get(
            "SELECT " + 
            "users.username, users.permission, users.state, pegawai.jabatan " + 
            "FROM " + 
            "users ");
        try {
            while(fetchUsers.next())
            {
                String[] dataUsers = {
                    fetchUsers.getString("username"),
                    fetchUsers.getString("permission"),
                    fetchUsers.getString("jabatan"),
                    fetchUsers.getString("state")
                };
                model.addRow(dataUsers);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LihatTamu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    DefaultTableModel model;
}
