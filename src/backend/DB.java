
package backend;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DB{
    private DB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this._CONNECT = DriverManager.getConnection(
                "jdbc:mysql://" + Config.get("mysql/host") + "/" + Config.get("mysql/db"),
                Config.get("mysql/username"),
                Config.get("mysql/password")
            );
        }catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    public boolean exec(String sql){
        try {
            this._CONNECT.prepareStatement(sql).execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    public ResultSet get(String sql){
        try {
            this._RESULT = this._CONNECT.prepareStatement(sql).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return this._RESULT;
    }
    public static DB getInstance(){
        if(DB._INSTANCE == null)
            DB._INSTANCE = new DB();
        return DB._INSTANCE;
    }
    public Connection con(){
        return DB.getInstance()._CONNECT;
    }
    private static DB _INSTANCE = null;
    private Connection _CONNECT;
    private ResultSet _RESULT;
}
