/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;

/**
 *
 * @author A Little Shit
 */
public interface sql {
    public ResultSet get();
    public void insert();
    public void update();
    public void delete();
    
}
