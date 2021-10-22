/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import backend.Input;
import backend.Uuid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import threads.Threads;
import views.PesanMenu;

/**
 *
 * @author A Little Shit
 */
public class CtrlPesanMenu {
    PesanMenu menu;
    public CtrlPesanMenu(PesanMenu menu){
        this.menu = menu;
    }
    public void add(){
        mirror();
        menu.setLocationRelativeTo(null);
    }
    public void exit(){
        Threads.get("PesanMenu").exit();
    }
    public void save(){
        int crow = getModel().getRowCount();
        for(int i = 0; i < crow ; i++){
            if(Integer.parseInt(getModel().getValueAt(i, 2).toString()) > 0){
                Input in = new Input();
                in.set("id", Uuid.generate());
                in.set("invoice", getInvoice());
                String date = LocalDate.now().toString();
                date = date.replaceAll("-", "/");
                in.set("tanggal", date);
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                String time = format.format(cal.getTime());
                in.set("waktu", time);
                in.set("id_user", "");
                in.set("jumlah", getModel().getValueAt(i, 2).toString());
                in.set("harga", getModel().getValueAt(i, 1).toString());
                in.set("total", String.valueOf(Integer.parseInt(getModel().getValueAt(i, 2).toString()) * Integer.parseInt(getModel().getValueAt(i, 1).toString())));
                in.set("nama", getModel().getValueAt(i, 0).toString());
                String sql = "INSERT INTO transaksi_layanan "
                + "(id_transaksi_layanan,nomor_invoice,tanggal_transaksi,waktu_transaksi,id_user,jumlah,harga_satuan,total_harga,nama_layanan) "
                + "VALUES "
                + "('"+in.get("id")+"','"+in.get("invoice")+"','"+in.get("tanggal")+"','"+in.get("waktu")+"','"+in.get("id_user")+"','"+in.get("jumlah")+"','"+in.get("harga")+"','"+in.get("total")+"','"+in.get("nama")+"')";
                DB.getInstance().exec(sql);
                JOptionPane.showMessageDialog(null, "Berhasil");
            }
        }
    }
    public void check(){
        model = (DefaultTableModel) menu.getTableLayanan().getModel();
        getModel().setRowCount(0);
        String sql = 
            "SELECT " +
            "tamu.nama_tamu,kamar.nomor_kamar, transaksi_kamar.nomor_invoice " +
            "FROM " + 
            "transaksi_kamar " + 
            "INNER JOIN " +
            "tamu " + 
            "ON " +
            "transaksi_kamar.id_tamu = tamu.id_tamu " + 
            "INNER JOIN " + 
            "kamar " + 
            "ON " + 
            "transaksi_kamar.id_kamar = kamar.id_kamar " + 
            "WHERE " + 
            "kamar.nomor_kamar = '" + menu.getTxtNomorKamar().getText() + "' AND kamar.status = 'TERPAKAI' AND transaksi_kamar.status = 'Check In' ORDER BY transaksi_kamar.tanggal_checkin DESC LIMIT 1"
        ;

        try {
            ResultSet re = DB.getInstance().get(sql);
            if(re.next())
            {
                menu.getLblNamaPemesan().setText("- " + re.getString("nama_tamu") + " - " + re.getString("nomor_invoice"));
                invoice = re.getString("nomor_invoice");
                menu.getPaneLayanan().setVisible(true);
                menu.getBtnSubmit().setEnabled(true);

                sql = "SELECT nama_layanan, harga_layanan, harga_layanan FROM layanan";
                re = DB.getInstance().get(sql);
                while(re.next())
                {
                    String[] services = new String[]{
                        re.getString("nama_layanan"),
                        re.getString("harga_layanan"),
                        "0",
                        "0"
                    };
                    getModel().addRow(services);
                }
            } 
            else
            {
                menu.getLblNamaPemesan().setText(" Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesanMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void mirror()
    {
        menu.getPaneLayanan().setVisible(false);
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
     * @return the invoice
     */
    public String getInvoice() {
        return invoice;
    }
    
    private Timer delay;
    private int paneListKamarWidth;
    private int paneInputDataWidth;
    private int paneX;
    private int paneY;
    private DefaultTableModel model;
    private String invoice;
}
