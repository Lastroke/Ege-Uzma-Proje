/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author egeuzma
 */
public class PWtester {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password ="simple";
        for(int i =0;i<5;i++){
            System.out.printf("Password %d: %s%n",i,Password.getSHA512password(password, Password.getSalt()));
        }
        
    }
}
