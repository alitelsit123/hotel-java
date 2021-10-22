package backend;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private static Map<String, String[][]> _CONFIG;
//    public static Map<String, Map<String, String>> _GLOBALS = new HashMap<String, Map<String, String>>();

    private static void setConfigArray(){
        _CONFIG = new HashMap<>();
        
/*        _GLOBALS.SETTING          */
    /*************************************************************************/
    
        _CONFIG.put(
            "mysql", new String[][]{
                {"host", "localhost"},
                {"username", "root"},
                {"password", ""},
                {"db", "hotel"}
            }  
        );
        _CONFIG.put(
            "session", new String[][]{
                {"session_name", "user"},
                {"token_name", "token"}
            }  
        );
    
    /*************************************************************************/
    }
//    public static String[][] _GLOBALS = new String[3][5];
    public static String get(String path){
        if(_CONFIG == null)
            setConfigArray();
        if(path != null) {
            Map<String, String[][]> config = Config._CONFIG;
            String[] keys;
            keys = path.split("/");
            for(Map.Entry<String, String[][]> en: config.entrySet()){
                if(en.getKey().equals(keys[0])){
                    for(String[] bit: en.getValue()){
                        if(bit[0].equals(keys[1])) {
                            return bit[1];
                        }
                    }
                }
            }
        }
        return null;
    }
}
