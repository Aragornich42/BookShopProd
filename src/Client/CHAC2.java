package Client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

class CHAC2 extends JFrame {

    private final JComboBox<String> comboBox1;
    private final JTextField textField1 = new JTextField();
    private final JTextField textField2 = new JTextField();

    public CHAC2(DataInputStream dis, DataOutputStream dos) {
        super("Change customer");
        setLayout(new BorderLayout());
        setSize(700, 230);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Vector<String> items = new Vector<>();
        items.add("ФИО");
        items.add("Адрес");
        items.add("Телефон");
        items.add("email");
        items.add("Заказы(изменить целиком)");
        items.add("Заказы(добавить)");
        comboBox1 = new JComboBox<>(items);

        JLabel l1 = new JLabel("Выберите тип данных, необходимый для изменения, и затем введите новое значение.");
        l1.setBounds(15, 15, 570, 20);
        JLabel l2 = new JLabel("Выберите тип данных");
        l2.setBounds(15, 50, 150, 20);
        comboBox1.setBounds(170, 50, 500, 20);
        JLabel l3 = new JLabel("Введите искомое");
        l3.setBounds(15, 85, 150,20);
        textField1.setBounds(170, 85, 500,20);
        JLabel l4 = new JLabel("Введите значение");
        l4.setBounds(15, 120, 150, 20);
        textField2.setBounds(170, 120, 500, 20);
        JButton inpButton = new JButton("Ввод");
        inpButton.setBounds(15, 155, 660, 20);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,685,170);

        panel.add(comboBox1);
        panel.add(textField1);
        panel.add(textField2);
        panel.add(inpButton);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        setContentPane(panel);
        panel.setVisible(true);

        setVisible(true);

        inpButton.addActionListener(e -> {
            try {
                dos.writeUTF("CHAC");
                switch ((String) Objects.requireNonNull(comboBox1.getSelectedItem())) {
                    case "ФИО":
                        dos.writeUTF(getInfo("NAME"));
                        break;
                    case "Адрес":
                        dos.writeUTF(getInfo("ADDRESS"));
                        break;
                    case "Телефон":
                        dos.writeUTF(getInfo("PHONE"));
                        break;
                    case "email":
                        dos.writeUTF(getInfo("EMAIL"));
                        break;
                    case "Заказы(изменить целиком)":
                        dos.writeUTF(getInfo("ORDERS"));
                        break;
                    case "Заказы(добавить)":
                        dos.writeUTF(getInfo("COVER"));
                        break;
                }
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private String getInfo(String code) {
        return textField1.getText() + "|" + code + "|" + textField2.getText();
    }

}
