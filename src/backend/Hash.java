/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author A Little Shit
 */
public class Hash {
    private final String _CHARS = "AzByC1xDwEv2FuGtH3sIrJq4KpLoM5nNmOl6PkQjR7iShTg8UfVeW9dXcYb0Za";
    private static int _POS;
    private static char _tmpCHAR, _newCHAR;
    StringBuilder str;
    private static final Hash _HASH = new Hash();
    
    /**
     * @param s*
     * @return *********/
    public static String make(String s){
        if(_HASH.check(s)){
            _HASH.str = new StringBuilder();
            int strLen = s.length();
            int countLast;
            for(int i = 0; i < strLen; i++)
                if(strLen < 16){
                    countLast = (strLen - 8) * 2;
                    if(i >= strLen - countLast)
                        _HASH.hashTwo(s.charAt(i));
                    else 
                        _HASH.hashFour(s.charAt(i));
                } else {
                    countLast = (strLen - 16) * 2;
                    if(i >= strLen - countLast)
                        _HASH.hashSingle(s.charAt(i));
                    else 
                        _HASH.hashTwo(s.charAt(i));
                }
            return _HASH.str.toString();
        } else {
            return null;
        }
    }
    
    public static String decrypt(String s){
        return null;
    }
    /************/
    /*  HASH METHOD */
    private char roll(){
        /*  ROLL ALGORTHM   */
        
        
        /*                  */
        return 'a';
    }
    private char addit(){
        /*  ADDITION */
        Hash._tmpCHAR = _HASH.getChars(_POS + 4);
        /*           */
        char ch = Hash._tmpCHAR;
//        System.out.println("Char After: " + ch);
        return Hash._tmpCHAR;
    }
    
    /****************/
    
    /*  GET ENCRYPT CHARS    */
    private char getSubstractTwo(char c, int index){
        return _HASH._CHARS.indexOf(c) == 1 ? _HASH.getChars(index - 8): _HASH.getChars(index - 8);
    }
    private char getSubstractFour(char c, int index){
        return _HASH._CHARS.indexOf(c) == 3 ? _HASH.getChars(index - 8): _HASH.getChars(index - 8);
    }
    /*                      */
    
    /*  insert CHARS       */
    private void hashSingle(char c){
        str.append(_HASH.getPosition(c).addit());
    }
    private void hashTwo(char c){
        for(int i = 0; i < 2; i++){
            str.append(_HASH.getPosition(c, i).addit());
        }
    }
    private void hashFour(char c){
        for(int i = 0; i < 4; i++){
            str.append(_HASH.getPosition(c, i).addit());
        }
    }
    /*                      */
    
    /*  CORE FUNCTION      */
    private Hash getPosition(char c){
        Hash._tmpCHAR = c;
        Hash._POS = _HASH._CHARS.indexOf(Hash._tmpCHAR);
        return this;
    }
    private Hash getPosition(char c, int pos){
        if(pos == 0){
            Hash._tmpCHAR = c;
//            System.out.println("");
//            System.out.println("Char Before: " + c);
        }
        Hash._POS = _HASH._CHARS.indexOf(Hash._tmpCHAR);
        return this;
    }
    private char convertLast(int numSubstract){
        return (char) numSubstract;
    }
    private void setPos(char c){
        Hash._POS = _HASH._CHARS.indexOf(c);
    }
    private char getChars(int index){
        if(index > _HASH._CHARS.length() - 1)
            return _HASH._CHARS.charAt(index - _HASH._CHARS.length());
        else if(index < 0)
            return _HASH._CHARS.charAt( (_HASH._CHARS.length() - 1) + (0 + index) );
        return _HASH._CHARS.charAt(index);
    }
    /******************************************************/
    private boolean check(String s){
        return s.length() > 32 || s.length() < 8 ? false: true;
    }
}
