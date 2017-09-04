package org.work.web.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.naming.NamingException;

import org.springframework.beans.factory.FactoryBean;

/* 
 * @author ThinkPad 
 * date : Jul 19, 2010 9:32:48 AM 
 */
public class C3p0encode implements FactoryBean {
	private static final String PROP_PASSWORD = "password";
	private static final String DEFAULT_SECURE_KEY = "secure key";
	private Properties properties;
	public Object getObject() throws Exception {
		return getProperties();
	}
	public Class getObjectType() {
		return java.util.Properties.class;
	}
	public boolean isSingleton() {
		return true;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties inProperties) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
		this.properties = inProperties;
		String originalUsername = properties.getProperty("user");
		String originalPassword = properties.getProperty("password");
		if (originalUsername != null) {
			String newUsername = decode(originalUsername);
			properties.put("user", newUsername);
		}
		if (originalPassword != null) {
			String newPassword = decode(originalPassword);
			properties.put("password", newPassword);
		}
	}
	private static String encode(String secret) throws NamingException,
			NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, BadPaddingException,
			IllegalBlockSizeException {
		byte[] kbytes = DEFAULT_SECURE_KEY.getBytes();
		SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

		Cipher cipher;
		cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encoding = cipher.doFinal(secret.getBytes());
		BigInteger n = new BigInteger(encoding);
		return n.toString(16);
	}

	private static String decode(String secret) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException {
		byte[] kbytes = DEFAULT_SECURE_KEY.getBytes();
		SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

		BigInteger n = new BigInteger(secret, 16);
		byte[] encoding = n.toByteArray();
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decode = cipher.doFinal(encoding);
		return new String(decode);
	}
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, NamingException {
		/*System.out.println(C3p0encode.encode("workuser"));
		System.out.println(C3p0encode.decode(C3p0encode.encode("workuser")));
		System.out.println(C3p0encode.encode("work1202"));
		System.out.println(C3p0encode.decode(C3p0encode.encode("work1202")));*/
		System.out.println(C3p0encode.decode("671abf7cf795b0c3125c218bb9954cc9")+"/"+
				C3p0encode.decode("28a7d74de0ae912b"));
		System.out.println(C3p0encode.encode("workdb"));
		System.out.println(C3p0encode.decode(C3p0encode.encode("workdb")));
	}
	
	
}
