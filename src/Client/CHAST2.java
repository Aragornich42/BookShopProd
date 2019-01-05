package Client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

class CHAST2 extends JFrame {

    private final JTextField textField1 = new JTextField();
    private final JComboBox<String> comboBox1;

    public CHAST2(DataInputStream dis, DataOutputStream dos) {
        super("Change status");
        setLayout(new BorderLayout());
        setSize(700, 160);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Vector<String> items = new Vector<>();
        items.add("В обработке");
        items.add("Собран");
        items.add("Поставлен");
        comboBox1 = new JComboBox<>(items);

        JLabel l1 = new JLabel("ФИО заказчика");
        l1.setBounds(15, 15, 150, 20);
        textField1.setBounds(170, 15, 500, 20);
        JLabel l2 = new JLabel("Новый статус");
        l2.setBounds(15, 50, 150, 20);
        comboBox1.setBounds(170, 50, 500, 20);
        JButton inpButton = new JButton("Ввод");
        inpButton.setBounds(15, 85, 660,20);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,685,100);

        panel.add(textField1);
        panel.add(comboBox1);
        panel.add(inpButton);
        panel.add(l1);
        panel.add(l2);
        setContentPane(panel);
        panel.setVisible(true);

        setVisible(true);

        inpButton.addActionListener(e -> {
            try {
                dos.writeUTF("CHAST");
                dos.writeUTF(getInfo());
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private String getInfo() {
        return textField1.getText() + "|" + comboBox1.getSelectedItem();
    }

}
