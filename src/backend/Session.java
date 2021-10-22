/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import com.sun.corba.se.spi.activation._ActivatorStub;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A Little Shit
 */
public class Session {
    private Map<String, ArrayList<String>> _SESSION;
    private String _USER_SESSION;
    private static Session _INSTANCE = null;
    public Session()
    {
        this._SESSION = new HashMap<>();
        try {
            String sql = "SELECT * FROM session";
            ResultSet result = DB.getInstance().get(sql);
            while(result.next())
            {
                String id_session = Uuid.generate();
                this._SESSION.put(result.getString("nama_session"), new ArrayList<>());
                String[] value_session = new String[]{id_session, result.getString("username"), result.getString("token")};
                for(int i = 0; i < 3; i++)
                {
                    (this._SESSION.get(result.getString("nama_session"))).add(value_session[i]);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void SessionStart()
    {
        if(Session._INSTANCE == null)
            Session._INSTANCE = new Session();
    }
    public static Session getInstance()
    {
        return Session._INSTANCE;
    }
    public static void set(String path)
    {
        String[] bit = path.replaceAll("\\s+", "").split("=>");
        String id_session = Uuid.generate();
        String token = null;
        Session.getInstance()._SESSION.put(bit[0], new ArrayList<>());
        token = id_session.replaceAll("-", "").toLowerCase();
        String[] value_session = new String[]{id_session, bit[1], Hash.make(token)};
        for(int i = 0; i < 3; i++) {   
            (Session.getInstance()._SESSION.get(bit[0])).add(value_session[i]);
        }
    }
    
    public static void print()
    {
        for(Map.Entry<String, ArrayList<String>> en: Session.getInstance()._SESSION.entrySet())
        {
            System.out.println(en.getKey() + " : " + en.getValue().get(0) + ", " + en.getValue().get(1) + ", " + en.getValue().get(2));
        }
    }
    
    public static String get(String username)
    {
        
        return null;
    }
}
