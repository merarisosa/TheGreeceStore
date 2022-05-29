/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author MagicPOS
 */
public final class Util {
  public static String generarFolio(String sufijo, String numReg){
    String num = "00000";
    int pos = num.length() - numReg.length();
    
    return sufijo+"-"+num.substring(0,pos) + numReg;
  }
  
  public static String encriptar(String pwd){
    try {
       MessageDigest md = MessageDigest.getInstance("SHA-1");
       byte[] messageDigest = md.digest(pwd.getBytes());
       BigInteger no = new BigInteger(1, messageDigest);
       String hashtext = no.toString(16);
       while (hashtext.length() < 32) {
           hashtext = "0" + hashtext;
       }
       return hashtext;
   }
   catch (NoSuchAlgorithmException e) {
       throw new RuntimeException(e);
    }
  }
  
  public static boolean validarRegex(String cadena, String regex){
    return true;
  }
}
