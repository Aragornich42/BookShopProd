package Client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class ADDB2 extends JFrame {

    private final JTextField textField1 = new JTextField();
    private final JTextField textField2 = new JTextField();
    private final JTextField textField3 = new JTextField();
    private final JTextField textField4 = new JTextField();
    private final JTextField textField5 = new JTextField();
    private final JTextField textField6 = new JTextField();
    private final JTextField textField7 = new JTextField();
    private final JTextField textField8 = new JTextField();
    private final JTextField textField9 = new JTextField();
    private final JTextField textField10 = new JTextField();

    public ADDB2(DataInputStream dis, DataOutputStream dos) {
        super("Add book");
        setLayout(new BorderLayout());
        setSize(700, 405);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Название");
        l1.setBounds(15, 15, 150, 20);
        textField1.setBounds(170, 15, 500, 20);
        JLabel l2 = new JLabel("Автор(ы)");
        l2.setBounds(15, 50, 150, 20);
        textField2.setBounds(170, 50, 500, 20);
        JLabel l3 = new JLabel("Жанр");
        l3.setBounds(15, 85, 150,20);
        textField3.setBounds(170, 85, 500,20);
        JLabel l4 = new JLabel("Издательство");
        l4.setBounds(15, 120, 150, 20);
        textField4.setBounds(170, 120, 500, 20);
        JLabel l5 = new JLabel("Год издания");
        l5.setBounds(15, 155, 150, 20);
        textField5.setBounds(170, 155, 500, 20);
        JLabel l6 = new JLabel("Количество страниц");
        l6.setBounds(15, 190, 150, 20);
        textField6.setBounds(170, 190, 500, 20);
        JLabel l7 = new JLabel("Тип обложки");
        l7.setBounds(15, 225, 150, 20);
        textField7.setBounds(170, 225, 500, 20);
        JLabel l9 = new JLabel("Цена");
        l9.setBounds(15, 260, 150, 20);
        textField9.setBounds(170, 260, 215, 20);
        JLabel l10 = new JLabel("руб.");
        l10.setBounds(390, 260, 30, 20);
        textField10.setBounds(425, 260, 215, 20);
        JLabel l11 = new JLabel("коп.");
        l11.setBounds(640, 260, 30, 20);
        JLabel l8 = new JLabel("Количество");
        l8.setBounds(15, 295, 150, 20);
        textField8.setBounds(170, 295, 500, 20);
        JButton button2 = new JButton("Ввод");
        button2.setBounds(15, 330, 660, 20);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0, 685, 345);

        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(textField4);
        panel.add(textField5);
        panel.add(textField6);
        panel.add(textField7);
        panel.add(textField8);
        panel.add(textField9);
        panel.add(textField10);
        panel.add(button2);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(l7);
        panel.add(l8);
        panel.add(l9);
        panel.add(l10);
        panel.add(l11);

        setContentPane(panel);
        panel.setVisible(true);

        setVisible(true);

        button2.addActionListener(e -> {
            try {
                dos.writeUTF("ADDB");
                dos.writeUTF(getText());
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private String getText() {
        return textField1.getText() + "|" + textField2.getText() + "|" + textField3.getText() + "|"
                + textField4.getText() + "," + textField5.getText() + "," + textField6.getText() + ","
                + textField7.getText() + "|" + textField9.getText() + "." + textField10.getText() + "|"
                + textField8.getText();
    }

}
