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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import threads.Threads;
import views.CheckIn;

/**
 *
 * @author A Little Shit
 */
public class CtrlCheckIn {
    private final CheckIn checkin;
    public CtrlCheckIn(CheckIn checkin){
        this.checkin = checkin;
    }
    public void add(){
        mirror();
        checkin.setLocationRelativeTo(null);
    }
    public void checkBiaya(){
        try {
            String sql;
            ResultSet result;
            in = new Input();
            in.set(Uuid.generate());
            in.set(null);
            
            sql = "SELECT id_tamu from tamu WHERE nama_tamu = '"+ checkin.getCbNamaTamu().getSelectedItem().toString() +"'";
            result = DB.getInstance().get(sql);
            result.next();
            in.set(result.getString("id_tamu"));
            idtamu = result.getString("id_tamu");
            sql = "SELECT id_kamar from kamar WHERE nomor_kamar = '"+ checkin.getCbNomorKamar().getSelectedItem().toString() +"'";
            result = DB.getInstance().get(sql);
            result.next();
            in.set(result.getString("id_kamar"));
            nkmr = checkin.getCbNomorKamar().getSelectedItem().toString();
            in.set(checkin.getTxtInvoice().getText());
            in.set(checkin.getTxtTanggalIn().getText());
            if("-- Dewasa --".equals(checkin.getCbJmlDewasa().getSelectedItem().toString()))
                in.set("0");
            else
                in.set(checkin.getCbJmlDewasa().getSelectedItem().toString());
            if("-- Anak Anak --".equals(checkin.getCbJmlAnak().getSelectedItem().toString()))
                in.set("0");
            else
                in.set(checkin.getCbJmlAnak().getSelectedItem().toString());
            
            in.set(checkin.getTxtTanggalIn().getText());
            in.set(checkin.getTxtWaktuIn().getText());
            in.set(checkin.getTxtTanggalOut().getText());
            in.set(checkin.getTxtWaktuOut().getText());
            
            String startDate = checkin.getTxtTanggalIn().getText();
            String endDate = checkin.getTxtTanggalOut().getText();
            long diff = Integer.parseInt(endDate.replaceAll("/", "")) - Integer.parseInt(startDate.replaceAll("/", ""));
            sql = "SELECT "+
                    "tipe_kamar.harga_per_malam,tipe_kamar.harga_per_orang " +
                    "FROM " +
                    "kamar INNER JOIN tipe_kamar ON kamar.id_tipe_kamar = tipe_kamar.id_tipe_kamar " +
                    "WHERE " +
                    "kamar.nomor_kamar = '"+ checkin.getCbNomorKamar().getSelectedItem().toString() +"'";
            result = DB.getInstance().get(sql);
            result.next();
            int hargapermalam = result.getInt("harga_per_malam") * Integer.parseInt(checkin.getTxtLamaMenginap().getText());
            int hargaperorang;
            if(!checkin.getCbJmlAnak().getSelectedItem().toString().equals("-- Anak Anak --"))
            {
                hargaperorang =
                        ( result.getInt("harga_per_orang") *
                        Integer.parseInt(checkin.getCbJmlDewasa().getSelectedItem().toString()) ) +
                        ( result.getInt("harga_per_orang") *
                        Integer.parseInt(checkin.getCbJmlAnak().getSelectedItem().toString()) )
                        ;
            }
            else
            {
                hargaperorang = ( result.getInt("harga_per_orang") * Integer.parseInt(checkin.getCbJmlDewasa().getSelectedItem().toString()) );
            }
            in.set(String.valueOf(hargapermalam + hargaperorang));
            checkin.getTxtBiaya().setText("Rp. " + in.get(12));
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void mirror()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        date = LocalDate.now().toString();
        checktgl = date;
        time = format.format(cal.getTime());
        date = date.replaceAll("-", "/");
        checkin.getTxtTanggalIn().setText(date);
        checkin.getTxtWaktuIn().setText(time);
        date = date.replaceAll("/", "");
        time = time.replaceAll(":", "");
        checkin.getTxtInvoice().setText("INV-" + date + time + "-" + "(Nomor Kamar)");
        
        String sql = "SELECT nomor_kamar FROM kamar WHERE status = 'TERSEDIA'";
        ResultSet reKamar = DB.getInstance().get(sql);
        try {
            while(reKamar.next())
            {
                checkin.getCbNomorKamar().addItem(reKamar.getString("nomor_kamar"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "SELECT * FROM tamu";
        ResultSet reNamaTamu = DB.getInstance().get(sql);
        try {
            while(reNamaTamu.next())
            {
                checkin.getCbNamaTamu().addItem(reNamaTamu.getString("nama_tamu"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setNomorKamar(){
        if(!checkin.getCbNomorKamar().getSelectedItem().toString().equals("-- Pilih Nomor --"))
        {
            String sql = "SELECT tipe_kamar.nama_tipe_kamar,kamar.max_dewasa,kamar.max_anak FROM kamar INNER JOIN tipe_kamar ON kamar.id_tipe_kamar = tipe_kamar.id_tipe_kamar WHERE nomor_kamar = '"+ checkin.getCbNomorKamar().getSelectedItem().toString() +"'";
            ResultSet reKamar = DB.getInstance().get(sql);
            try {
                while(reKamar.next())
                {
                    checkin.getLblJudulTipeKamar().setText("Tipe Kamar ("+ checkin.getCbNomorKamar().getSelectedItem() +") : " + reKamar.getString("nama_tipe_kamar"));
                    String[] cbJmlDewasa = new String[reKamar.getInt("max_dewasa") + 1];
                    cbJmlDewasa[0] = "-- Dewasa --";
                    String[] cbJmlAnak = new String[reKamar.getInt("max_anak") + 1];
                    cbJmlAnak[0] = "-- Anak Anak --";
                    for(int i = 1;i < cbJmlDewasa.length; i++)
                    {
                        cbJmlDewasa[i] = String.valueOf(i);
                    }
                    for(int i = 1; i < cbJmlAnak.length; i++)
                    {
                        cbJmlAnak[i] = String.valueOf(i);
                    }
                    ComboBoxModel cbModelDewasa = new DefaultComboBoxModel(cbJmlDewasa);
                    ComboBoxModel cbModelAnak = new DefaultComboBoxModel(cbJmlAnak);
                    checkin.getCbJmlDewasa().setModel(cbModelDewasa);
                    checkin.getCbJmlAnak().setModel(cbModelAnak);
                    checkin.getTxtInvoice().setText(checkin.getTxtInvoice().getText().substring(0,19) + checkin.getCbNomorKamar().getSelectedItem().toString());
                }
            } catch (SQLException ex) {
                Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else 
        {
            String[] cbJmlDewasa = {"-- Dewasa --"};
            String[] cbJmlAnak = {"-- Anak Anak --"};
            ComboBoxModel cbModelDewasa = new DefaultComboBoxModel(cbJmlDewasa);
            ComboBoxModel cbModelAnak = new DefaultComboBoxModel(cbJmlAnak);
            checkin.getCbJmlDewasa().setModel(cbModelDewasa);
            checkin.getCbJmlAnak().setModel(cbModelAnak);
            checkin.getLblJudulTipeKamar().setText("Tipe Kamar (0) : ");
            checkin.getTxtInvoice().setText(checkin.getTxtInvoice().getText().substring(0,19) + "(Nomor Kamar)");
        }
    }
    
    public void save(){
        if(helpTgl() < 1){
            in.set(checkin.getTxtDeposit().getText());
            in.set("Check In");
            String insert = "";
            String inp[] = in.toStringArray();
            sIn = "'" + String.join("', '", inp) + "'";
            String sql = "";
            sql = 
                    "INSERT INTO transaksi_kamar VALUES (" + sIn + ")"
                    ;
            boolean a = DB.getInstance().exec(sql);
            if(a){
                sql = "UPDATE kamar SET status = 'TERPAKAI' WHERE nomor_kamar = '" + checkin.getCbNomorKamar().getSelectedItem().toString() + "'";
                DB.getInstance().exec(sql);
                JOptionPane.showMessageDialog(null, "Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Check In Sekali Perkamar");
        }
        
    }
    public void parseCheckOutDate(){
        if(isInteger(checkin.getTxtLamaMenginap().getText())){
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            date = LocalDate.now().plusDays(Integer.parseInt(checkin.getTxtLamaMenginap().getText())).toString();
            time = format.format(cal.getTime());
            date = date.replaceAll("-", "/");
            checkin.getTxtTanggalOut().setText(date);
        }
    }
    public void exit(){
        Threads.get("CheckIn").exit();
    }
    public void addTamu(){
        Threads.get("CheckIn").exit();
        Threads.view("TambahTamu");
    }
    private int helpTgl(){
        String q = "SELECT COUNT(k.nomor_kamar) FROM transaksi_kamar t INNER JOIN kamar k ON t.id_kamar = k.id_kamar WHERE t.id_tamu = '"+idtamu+"' AND t.tanggal_transaksi = '"+checktgl.toString()+"' AND k.nomor_kamar = "+nkmr;
        System.out.println(checktgl + " " + nkmr);
        ResultSet r = DB.getInstance().get(q);
        try {
            while(r.next()){
                return r.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    private boolean isInteger(String str) {
        try {
            if("".equals(str)){
                return false;
            } else {
                int num = Integer.parseInt(str);
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
    private Timer delay;
    private int paneListKamarWidth;
    private int paneInputDataWidth;
    private int paneX;
    private int paneY;
    private DefaultTableModel model;
    private String date,checktgl,nkmr;
    private String time,sIn,idtamu;
    private Input in;

    /**
     * @return the checkin
     */
    public CheckIn getCheckin() {
        return checkin;
    }

    /**
     * @return the delay
     */
    public Timer getDelay() {
        return delay;
    }

    /**
     * @return the paneListKamarWidth
     */
    public int getPaneListKamarWidth() {
        return paneListKamarWidth;
    }

    /**
     * @return the paneInputDataWidth
     */
    public int getPaneInputDataWidth() {
        return paneInputDataWidth;
    }

    /**
     * @return the paneX
     */
    public int getPaneX() {
        return paneX;
    }

    /**
     * @return the paneY
     */
    public int getPaneY() {
        return paneY;
    }

    /**
     * @return the model
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }
}
