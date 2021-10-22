/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import backend.Input;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author A Little Shit
 */
public class Threads 
{
    private Map<String, Object> _WINDOWS;
    private Object _WINDOWS_SELECTED;
    private static Threads _WINDOWS_INSTANCE = new Threads();
    Threads()
    {
        _WINDOWS = new HashMap<>();
        _WINDOWS_SELECTED = new Object();
    }
    public static void view(String className, Input paramVal){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            className = "views." + className.replaceAll("\\s+", "");
            
            Class c = Class.forName(className);
            Constructor __construct = c.getConstructor(Input.class);
            boolean classFound = false;
            for(Map.Entry<String, Object> en: _WINDOWS_INSTANCE._WINDOWS.entrySet())
            {
                if(className.equals(en.getValue().getClass().getName()))
                {
                    classFound = true; 
                }
            }
            if(!classFound)
            {
                _WINDOWS_INSTANCE._WINDOWS.put(className, __construct.newInstance(paramVal));
            }
            Method m = c.getMethod("setVisible", boolean.class);
            m.invoke(_WINDOWS_INSTANCE._WINDOWS.get(className), true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void view(String className){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            className = "views." + className.replaceAll("\\s+", "");
            
            Class c = Class.forName(className);
            boolean classFound = false;
            for(Map.Entry<String, Object> en: _WINDOWS_INSTANCE._WINDOWS.entrySet())
            {
                if(className.equals(en.getValue().getClass().getName()))
                {
                    classFound = true; 
                }
            }
            if(!classFound)
            {
                _WINDOWS_INSTANCE._WINDOWS.put(className, c.newInstance());
            }
            Method m = c.getMethod("setVisible", boolean.class);
            m.invoke(_WINDOWS_INSTANCE._WINDOWS.get(className), true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static Threads get(String className)
    {
        className = "views." + className;
        _WINDOWS_INSTANCE._WINDOWS_SELECTED = _WINDOWS_INSTANCE._WINDOWS.get(className);
        return _WINDOWS_INSTANCE;
    }
    public void exit()
    {
        try {
            Class c = Class.forName(_WINDOWS_INSTANCE._WINDOWS_SELECTED.getClass().getName());
            Method m = c.getMethod("dispose");
            m.invoke(_WINDOWS_INSTANCE._WINDOWS_SELECTED);
            _WINDOWS_INSTANCE._WINDOWS.remove(_WINDOWS_INSTANCE._WINDOWS_SELECTED.getClass().getName());
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void hide()
    {
        try {
            Class c = Class.forName(_WINDOWS_INSTANCE._WINDOWS_SELECTED.getClass().getName());
            Method m = c.getMethod("setState", int.class);
            m.invoke(_WINDOWS_INSTANCE._WINDOWS_SELECTED, java.awt.Frame.ICONIFIED);
//            _WINDOWS_INSTANCE._WINDOWS.remove(_WINDOWS_INSTANCE._WINDOWS_SELECTED.getClass().getName());
            
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
