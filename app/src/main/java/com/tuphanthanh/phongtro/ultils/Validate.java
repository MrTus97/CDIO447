package com.tuphanthanh.phongtro.ultils;


public class Validate {
    public static boolean isPatternPasswordLength(String string){
        if (string.length() >=6){
            return true;
        }
        return false;
    }
}
