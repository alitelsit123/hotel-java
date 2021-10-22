/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author A Little Shit
 * @param <E>
 */
public class Input<E> extends ArrayList
{
    public Map<String, String> _MAP = new HashMap<>();
    public void set(String key, String val)
    {
        this._MAP.put(key, val);
    }
    public String get(String key)
    {
        String result = this._MAP.get(key);
        return result;
    }
    public String[] toStringArray()
    {
        return (String[]) this.toArray(new String[this.size()]);
    }
    public void set(Object o)
    {
        this.add(o);
    }
    public String join(String[] valName)
    {
        String combine = "'" + String.join("', '", valName) + "'";
        return combine;
    }
    public String join(String[] keyName, String[] valName)
    {
        String combine = "";
        for(int i = 0;i < keyName.length; i++)
        {
            combine += keyName[i] + " = " + "'" + valName[i] + "'";
            if(i < keyName.length - 1) combine += ", ";
        }
        return combine;
    }
    
}
