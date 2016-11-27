package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {

	public static String encryptSHA256(String password){
		
		MessageDigest md = null;
		
		try {
			
			md = MessageDigest.getInstance("SHA-256");
			
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		
		md.update(password.getBytes());
		
		byte[] bytePasswd = md.digest();
		
		return new String(bytePasswd);
	}
}
