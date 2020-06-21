/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ege Uzma 170503013
package proje;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author egeuzma
 */
public class Password {
    public static String getSHA512password(String passwordtoEncrypt,byte[] salt)
   {
        
        String generatedPassword =null;
        
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-512");
            md.update(salt);
            
            byte[] bytes = md.digest(passwordtoEncrypt.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<bytes.length;i++){
                sb.append(Integer.toString((bytes[i] & 0xff)+0x100,16).substring(1));
            }
            generatedPassword = sb.toString();
            
        }catch(NoSuchAlgorithmException e){
            System.err.println(e.getMessage());
        }
        return generatedPassword ;
    }
    public static byte[] getSalt() throws NoSuchAlgorithmException{
         SecureRandom sr = SecureRandom.getInstanceStrong();
         byte[] salt = new byte[16];
         sr.nextBytes(salt);
         return salt ;
    }
}

