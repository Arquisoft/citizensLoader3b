package es.uniovi.asw.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
 
public class SHA1 {

    public static String encriptar(String password)
    {
        String passEncriptada = null;
        
        try {
        	byte[] sal = getSal();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(sal);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passEncriptada= sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return passEncriptada;
    }
    

    private static byte[] getSal() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] sal = new byte[16];
        sr.nextBytes(sal);
        return sal;
    }
     
}