/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author A Little Shit
 */
public class Data{

/*  KAMAR   */
    public static String tambahKamar(Input input)
    {
        String[] in = input.toStringArray();
        String sIn = "'" + String.join("', '", in) + "'";
        String sql = 
            "INSERT INTO kamar VALUES (" + sIn + ")"
        ;
        return sql;
    }
    public static ResultSet[] fetchUpdateKamar(Input input)
    {
        /**
        * TABEL Kamar 
        */
        String sql = "SELECT * FROM kamar WHERE id_kamar = '"+ input.get("kamar") +"'";
        ResultSet[] result = new ResultSet[2];
        result[0] = DB.getInstance().get(sql);
        /**
        * TABEL Tipe Kamar 
        */
        sql = "SELECT tipe_kamar.id_tipe_kamar, tipe_kamar.nama_tipe_kamar FROM kamar INNER JOIN tipe_kamar ON kamar.id_tipe_kamar = tipe_kamar.id_tipe_kamar WHERE tipe_kamar.nama_tipe_kamar='"+input.get("tipe_kamar")+"'";
        result[1] = DB.getInstance().get(sql);
        return result;
    }
    public static String fetchIdTipeKamar(String namaTipeKamar)
    {
        String sql = "SELECT id_tipe_kamar from tipe_kamar WHERE nama_tipe_kamar = '"+namaTipeKamar+"'";
        ResultSet result = DB.getInstance().get(sql);
        try {
            result.next();        
            return result.getString("id_tipe_kamar");
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void updateKamar(Input input)
    {
        String[] updateCol = new String[]{"id_kamar", "nomor_kamar", "id_tipe_kamar", "max_dewasa", "max_anak", "status"};
        String colVal = input.join(updateCol, input.toStringArray());
        String sql = "UPDATE kamar set "+colVal+" WHERE id_kamar = '"+input.get(0)+"'";
        DB.getInstance().exec(sql);
    }
    

/*  USERS   */    
    public static String tambahUser(Input input)
    {
        String[] in = input.toStringArray();
        String sIn = "'" + String.join("', '", in) + "'";
        String sql = 
            "INSERT INTO users VALUES (" + sIn + ")"
        ;
        return sql;
    }
    
    public static String tambahTamu(Input input)
    {
        String[] in = input.toStringArray();
        String sIn = "'" + String.join("', '", in) + "'";
        String sql = 
            "INSERT INTO tamu VALUES (" + sIn + ")"
        ;
        return sql;
    }
    
    public static String tambahLayanan(Input input)
    {
        String[] in = input.toStringArray();
        String sIn = "'" + String.join("', '", in) + "'";
        String sql = 
            "INSERT INTO layanan VALUES (" + sIn + ")"
        ;
        return sql;
    }
    
    public static String tambahPegawai(Input input)
    {
        String[] in = input.toStringArray();
        String sIn = "'" + String.join("', '", in) + "'";
        String sql = 
            "INSERT INTO pegawai VALUES (" + sIn + ")"
        ;
        return sql;
    }
}
