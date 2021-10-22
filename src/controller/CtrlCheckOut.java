/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import backend.Uuid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import threads.Threads;
import views.CheckOut;

/**
 *
 * @author A Little Shit
 */
public class CtrlCheckOut {
    private final CheckOut checkout;
    public CtrlCheckOut(CheckOut c){
        this.checkout = c;
    }
    public void add(){
        mirror();
    }
    public void save(){
        DB.getInstance().exec(sqlinsert);
        DB.getInstance().exec(sqlupdate);  
        DB.getInstance().exec(sqlupdatetrans);  
//        DB.getInstance().exec(sqldelete); 
        table(inv);
    }
    public void exit(){
        Threads.get("CheckOut").exit();
    }
    public void fetchData(){
        if(checkout.getCbNomorKamar().getSelectedItem().toString().equals("-- Pilih Kamar --"))
        {
            checkout.getTxtInvoice().setText("");
            checkout.getTxtNamaTamu().setText("");
            checkout.getTxtDewasa().setText("");
            checkout.getTxtAnak().setText("");
            checkout.getTxtTanggalCheckIn().setText("");
            checkout.getTxtWaktuCheckIn().setText("");
            checkout.getTxtTanggalCheckOut().setText("");
            checkout.getTxtWaktuCheckOut().setText("");
            checkout.getLblTipeKamar().setText("Tipe Kamar (0) :");
        }
        else
        {
        String sql = 
            "SELECT " + 
            "tipe_kamar.nama_tipe_kamar, tipe_kamar.harga_per_malam, tipe_kamar.harga_per_orang, transaksi_kamar.nomor_invoice, tamu.id_tamu, tamu.nama_tamu, transaksi_kamar.id_transaksi_kamar, transaksi_kamar.jumlah_dewasa, " + 
            "transaksi_kamar.jumlah_anak, transaksi_kamar.tanggal_checkin, transaksi_kamar.waktu_checkin, " + 
            "transaksi_kamar.tanggal_checkout, transaksi_kamar.waktu_checkout, transaksi_kamar.total_biaya, kamar.id_kamar " + 
            "FROM " + 
            "transaksi_kamar " + 
            "INNER JOIN " + 
            "tamu " + 
            "ON " + 
            "transaksi_kamar.id_tamu=tamu.id_tamu " + 
            "INNER JOIN " + 
            "kamar " +
            "ON " + 
            "transaksi_kamar.id_kamar=kamar.id_kamar " + 
            "INNER JOIN " + 
            "tipe_kamar " + 
            "ON " + 
            "kamar.id_tipe_kamar=tipe_kamar.id_tipe_kamar " + 
            "WHERE " + 
            "kamar.nomor_kamar = '"+ checkout.getCbNomorKamar().getSelectedItem().toString() +"'";
        ResultSet fetchTransaksi = DB.getInstance().get(sql);
        try {
            String total = "", idkamar = "", idtamu = "";
            int harga = 0;
            while(fetchTransaksi.next())
            {
                checkout.getTxtInvoice().setText(fetchTransaksi.getString("nomor_invoice"));
                checkout.getTxtNamaTamu().setText(fetchTransaksi.getString("nama_tamu"));
                checkout.getTxtDewasa().setText(fetchTransaksi.getString("jumlah_dewasa") + " Dewasa");
                checkout.getTxtAnak().setText(fetchTransaksi.getString("jumlah_anak") + " Anak");
                checkout.getTxtTanggalCheckIn().setText(fetchTransaksi.getString("tanggal_checkin"));
                checkout.getTxtWaktuCheckIn().setText(fetchTransaksi.getString("waktu_checkin"));
                checkout.getTxtTanggalCheckOut().setText(fetchTransaksi.getString("tanggal_checkout"));
                checkout.getTxtWaktuCheckOut().setText(fetchTransaksi.getString("waktu_checkout"));
                checkout.getLblTipeKamar().setText("Tipe Kamar ("+ checkout.getCbNomorKamar().getSelectedItem().toString() +") : " + fetchTransaksi.getString("nama_tipe_kamar"));
                inv = fetchTransaksi.getString("nomor_invoice");
                total = fetchTransaksi.getString("total_biaya");
                idkamar = fetchTransaksi.getString("id_kamar");
                harga = fetchTransaksi.getInt("harga_per_malam") + fetchTransaksi.getInt("harga_per_orang");
                idtamu = fetchTransaksi.getString("id_tamu");
                idtrans = fetchTransaksi.getString("id_transaksi_kamar");
            }
            sqlinsert = "INSERT INTO pemasukan (id_pemasukan, nomor_invoice, jenis_pemasukan, jumlah_pemasukan, tanggal_pembayaran, harga_pemasukan, total_pemasukan) VALUES ('"+Uuid.generate()+"', '"+inv+"','Kamar', 1, now(), "+String.valueOf(harga)+", "+total+")";
            
            sqlupdate = "UPDATE kamar SET status = 'TERSEDIA' WHERE id_kamar = '" + idkamar + "'";
            
            sqlupdatetrans = "UPDATE transaksi_kamar SET status = 'Check Out' WHERE id_transaksi_kamar = '"+ idtrans +"'";
            
//            sqldelete = "DELETE FROM tamu WHERE id_tamu = '" + idtamu + "'";
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    private void mirror()
    {
        try {
            String sql = "SELECT nomor_kamar FROM kamar WHERE status = 'TERPAKAI'";
            ResultSet result = DB.getInstance().get(sql);
//            String[] nomor = new String[result.];
            while(result.next())
            {
                checkout.getCbNomorKamar().addItem(result.getString("nomor_kamar"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    private void table(String inv)
    {
        String[] title = new String[]{"No.", "Keterangan", "Harga", "Qty", "Total"};
        String sql = "SELECT * FROM pemasukan WHERE nomor_invoice = '" + inv + "'";
        String sql_trans = "SELECT deposit FROM transaksi_kamar WHERE nomor_invoice = '"+inv+"'";
        String sql_layanan = "SELECT * FROM transaksi_layanan WHERE nomor_invoice = '" + inv + "'";
        int no = 0;
        int total = 0;
        int deposit = 0;
        makeLine();
        makeTextLine(title);
        try {
            ResultSet result = DB.getInstance().get(sql);
            while(result.next()){
                ++no;
                total+=result.getInt("total_pemasukan");
                String[] detail = new String[]{String.valueOf(no), result.getString("jenis_pemasukan"), result.getString("harga_pemasukan"), result.getString("jumlah_pemasukan"), result.getString("total_pemasukan"), };
                makeTextLine(detail);
                ResultSet re = DB.getInstance().get(sql_layanan);
                while(re.next()){
                    String[] det = new String[]{String.valueOf(no), "Layanan( "+re.getString("nama_layanan")+" )", re.getString("harga_satuan"), re.getString("jumlah"), re.getString("total_harga")};
                    makeTextLine(det);
                    total+=re.getInt("total_harga");
                }
            }
            ResultSet r = DB.getInstance().get(sql_trans);
            while(r.next()){
                deposit+=r.getInt("deposit");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        deposit = deposit - total;
        checkout.getTxtTagihan().append("   Total :\t" + total);
        checkout.getTxtTagihan().append("\n");
        checkout.getTxtTagihan().append("   Sisa Deposit:\t" + deposit);
        checkout.getTxtTagihan().append("\n");
        makeLine();
    }
    private void makeLine()
    {
        for(int i = 0;i < 98; i++)
        {
            checkout.getTxtTagihan().append("-");
        }
        checkout.getTxtTagihan().append("\n");
    }
    private void makeTextLine(String[] node)
    {
        int j = 0, sumNode = 0;
        while(j < node.length)
        {
            sumNode += node[j].length();
            j++;
        }
        for(int i = 0;i < 98 - sumNode; i++)
        {
            if(i < 5){
                if(i == 0)
                    checkout.getTxtTagihan().append(node[0]);
                else
                    checkout.getTxtTagihan().append(" ");
            }
            else if(i < 31)
            {
                if(i == 5)
                    checkout.getTxtTagihan().append(node[1]);
                else
                    checkout.getTxtTagihan().append(" ");
            }
            else if(i < 46)
            {
                if(i == 31)
                    checkout.getTxtTagihan().append(node[2]);
                else
                    checkout.getTxtTagihan().append(" ");
            }
            else if(i < 61)
            {
                if(i == 46)
                    checkout.getTxtTagihan().append(node[3]);
                else
                    checkout.getTxtTagihan().append(" ");
            }
            else if(i < 78)
            {
                if(i == 61)
                    checkout.getTxtTagihan().append(node[4]);
                else
                    checkout.getTxtTagihan().append(" ");
            }
        }
        checkout.getTxtTagihan().append("\n");
    }
    Timer delay;
    private int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    private String sqlinsert,sqlupdate, inv, sqldelete, sqlupdatetrans, idtrans;
}
