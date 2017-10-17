package com.yekong.common.utils;


import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 算法 对称加密，密码学中的高级加密标准 2005年成为有效标准 
 * @author stone
 * @date 2014-03-10 06:49:19
 */
public class AESUtil {
	
	public static final String aesKey = "36AAF0685AEF14641F1F54CC853B6323";
	public static final String aesIv = "5AEF14641F1F54CC";
	
	static Cipher cipher;
	static final String KEY_ALGORITHM = "AES";
	static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
	/**
	 * 使用AES 算法 加密，默认模式 AES/CBC/PKCS5Padding
	 */
	public static String myEncrypt(String str) throws Exception {
		cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
		SecretKeySpec skeySpec = new SecretKeySpec(aesKey.getBytes(), KEY_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(aesIv.getBytes()));//使用加密模式初始化 密钥
		byte[] encrypt = cipher.doFinal(str.getBytes()); //按单部分操作加密或解密数据，或者结束一个多部分操作。
		return Base64.encodeToString(encrypt, Base64.DEFAULT);
	}
	
	/**
	 * 解密
	 * @param str
	 * @param KEY
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static String myDecoding(String str) throws Exception {
		cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
		SecretKeySpec skeySpec = new SecretKeySpec(aesKey.getBytes(), KEY_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(aesIv.getBytes()));//使用加密模式初始化 密钥
		byte[] doFinal = cipher.doFinal(Base64.decode(str, Base64.DEFAULT));
		return new String(doFinal==null?new byte[0]:doFinal);
	}
}
