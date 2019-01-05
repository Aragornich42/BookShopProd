package Client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Registration2 extends JFrame {

    private final JTextField F = new JTextField();
    private final JTextField I = new JTextField();
    private final JTextField O = new JTextField();
    private final JTextField City = new JTextField();
    private final JTextField Address = new JTextField();
    private final JTextField Phone = new JTextField();
    private final JTextField Email = new JTextField();

    public Registration2(DataInputStream dis, DataOutputStream dos, Socket server) {
        super("Registration");
        setLayout(new BorderLayout());
        setSize(700,355);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel fl = new JLabel("Введите фамилию");
        fl.setBounds(15, 15, 150, 20);
        F.setBounds(170, 15, 500, 20);
        JLabel il = new JLabel("Введите имя");
        il.setBounds(15, 50, 150, 20);
        I.setBounds(170, 50, 500, 20);
        JLabel ol = new JLabel("Введите отчество");
        ol.setBounds(15, 85, 150,20);
        O.setBounds(170, 85, 500,20);
        JLabel cityl = new JLabel("Введите город");
        cityl.setBounds(15, 120, 150, 20);
        City.setBounds(170, 120, 500, 20);
        JLabel addressl = new JLabel("Введите адрес");
        addressl.setBounds(15, 155, 150, 20);
        Address.setBounds(170, 155, 500, 20);
        JLabel phonel = new JLabel("Введите телефон");
        phonel.setBounds(15, 190, 150, 20);
        Phone.setBounds(170, 190, 500, 20);
        JLabel emaill = new JLabel("Введите email");
        emaill.setBounds(15, 225, 150, 20);
        Email.setBounds(170, 225, 500, 20);
        JButton regButton = new JButton("Зарегистрироваться");
        regButton.setBounds(15, 260, 660, 20);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0, 685, 295);

        panel.add(F);
        panel.add(I);
        panel.add(O);
        panel.add(City);
        panel.add(Address);
        panel.add(Phone);
        panel.add(Email);
        panel.add(regButton);
        panel.add(fl);
        panel.add(il);
        panel.add(ol);
        panel.add(cityl);
        panel.add(addressl);
        panel.add(phonel);
        panel.add(emaill);
        setContentPane(panel);
        panel.setVisible(true);

        setVisible(true);

        regButton.addActionListener(e -> {
            try {
                dos.writeUTF("ADDC");
                dos.writeUTF(getInfo());
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
                new Operations2(dis, dos, F.getText() + " " + I.getText() + " " + O.getText(),
                        Address.getText(), server);
                setVisible(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private String getInfo() {
        return F.getText() + " " + I.getText() + " " + O.getText() + "|" + City.getText() + " "
                + Address.getText() + ";" + Phone.getText() + ";" + Email.getText() + "| ";
    }

}
