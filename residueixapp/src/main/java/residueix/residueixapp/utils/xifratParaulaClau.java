package residueix.residueixapp.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * Classe per gestionar el xifrat de la paraula clau.
 * @author Daniel Garcia Ruiz
 * @version 02/05/2023
 */
public class xifratParaulaClau {
    
    /**
     * Constructor  xifratParaulaClau buit.
     */
    public xifratParaulaClau(){}
    
    private static final String ALGORITHM = "AES";
    private static final String KEY = "R3s1d831XK3yX1fr4t32Byt3sS3c8r1t";
    
    /**
     * Mètode per generar el encrypt
     * @param value (String) paraula a encriptar
     * @return String amb paraula encripdata
     * @throws Exception Excepció de xifrat
     */
    public static String encrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    /**
     * Mètode per generar el decrypt
     * @param value (String) paraula encriptada
     * @return String a paraula desdencriptada
     * @throws Exception Excepció de xifrat
     */
    public static String decrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByteValue = cipher.doFinal(Base64.getDecoder().decode(value));
        return new String(decryptedByteValue,"utf-8");
    }

    private static Key generateKey() throws Exception {
        return new SecretKeySpec(KEY.getBytes(), ALGORITHM);
    }
}
