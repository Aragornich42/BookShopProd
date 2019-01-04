package Client;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Operations extends JFrame {
    private JButton ADDO = new JButton();
    private JButton ADDB = new JButton();
    private JButton DELB = new JButton();
    private JButton DELC = new JButton();
    private JButton CHAB = new JButton();
    private JButton CHAC = new JButton();
    private JButton CHEST = new JButton();
    private JButton CHAST = new JButton();
    private JButton CHEB = new JButton();
    private JButton END = new JButton();
    private JPanel panel = new JPanel();

    public Operations(DataInputStream dis, DataOutputStream dos, String fullName, String address) {

        super("Operations");
        panel.add(ADDO);
        panel.add(ADDB);
        panel.add(DELB);
        panel.add(DELC);
        panel.add(CHAB);
        panel.add(CHAC);
        panel.add(CHEST);
        panel.add(CHAST);
        panel.add(CHEB);
        panel.add(END);
        setContentPane(panel);
        setSize(600, 800);
        setVisible(true);


        ADDO.addActionListener(e -> new ADDO(dis, dos, fullName, address));

        ADDB.addActionListener(e -> new ADDB(dis, dos));

        DELB.addActionListener(e -> {
            String tmp = JOptionPane.showInputDialog(new JFrame(), "Введите название книги:");
            try {
                dos.writeUTF("DELB");
                dos.writeUTF(tmp);
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        DELC.addActionListener(e -> {
            String tmp = JOptionPane.showInputDialog(new JFrame(), "Введите ФИО клиента:");
            try {
                dos.writeUTF("DELC");
                dos.writeUTF(tmp);
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        CHAB.addActionListener(e -> new CHAB(dis, dos));

        CHAC.addActionListener(e -> new CHAC(dis, dos));

        CHEST.addActionListener(e -> {
            String tmp = JOptionPane.showInputDialog(new JFrame(), "Введите ФИО заказчика:");
            try {
                dos.writeUTF("CHEST");
                dos.writeUTF(tmp);
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        CHAST.addActionListener(e -> new CHAST(dis, dos));

        CHEB.addActionListener(e -> new CHEB(dis, dos));

        END.addActionListener(e -> {
            try {
                dos.writeUTF("END");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            setVisible(false);
        });

    }

}
