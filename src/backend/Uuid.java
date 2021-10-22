/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.UUID;

/**
 *
 * @author A Little Shit
 */
public class Uuid {
    public static String generate()
    {
        StringBuilder str = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for(int i = 0; i < uuid.length(); i++)
        {
            if( (i > 0) && (i % 4 == 0) )
            {
                str.append('-');
                str.append(uuid.charAt(i));
            }
            else
            {
                str.append(uuid.charAt(i));
            }
        }
        if(str.toString().length() == 39) 
        {
            return str.toString().toUpperCase();
        }
        return Uuid.generate();
    }
}
