package ejemplo00.infraestructura.seguridad;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class HashFunctionUtil {
	
	/**
	 * https://www.geeksforgeeks.org/sha-256-hash-in-java/
	 * 
	 * @param input
	 * @return
	 */
	
	private static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
 
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    private static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
 
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
    
    
	public static String convertToHas(String value) {
		try {
			return toHexString(getSHA(value));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String args[]) throws NoSuchAlgorithmException 
    { 
        System.out.println("Ejemplo de hash de contraseña \n "); 
  
        List<String> passwords = new ArrayList<String>();
        passwords.add("usr1pass");
        passwords.add("usr2pass");
        passwords.add("usr3pass");
        passwords.add("usr4pass");
        
        for (String pass: passwords) {
        	System.out.println(pass + "-> " + convertToHas(pass));
        }
       
    } 

}
