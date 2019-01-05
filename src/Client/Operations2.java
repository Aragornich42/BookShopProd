package Client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Operations2 extends JFrame {

    public Operations2(DataInputStream dis, DataOutputStream dos, String fullName, String address, Socket server) {
        super("Operations");
        setLayout(new BorderLayout());
        setSize(545, 525);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton ADDO = new JButton("Добавить заказ");
        ADDO.setBounds(15, 15, 500, 20);
        JButton ADDB = new JButton("Добавить книгу");
        ADDB.setBounds(15, 50, 500, 20);
        JButton DELB = new JButton("Удалить книгу");
        DELB.setBounds(15, 85, 500,20);
        JButton DELC = new JButton("Удалить пользователя");
        DELC.setBounds(15, 120, 500, 20);
        JButton CHAB = new JButton("Изменить данные по книге");
        CHAB.setBounds(15, 155, 500, 20);
        JButton CHAC = new JButton("Изменить данные по клиенту");
        CHAC.setBounds(15, 190, 500, 20);
        JButton CHEST = new JButton("Проверить статус заказа");
        CHEST.setBounds(15, 225, 500, 20);
        JButton CHAST = new JButton("Изменить статус заказа");
        CHAST.setBounds(15, 260, 500, 20);
        JButton CHEB = new JButton("Получить список книг");
        CHEB.setBounds(15, 295, 500, 20);
        JButton END = new JButton("Завершить работу");
        END.setBounds(15, 330, 500, 20);
        JButton LISTB = new JButton("Вывести список книг");
        LISTB.setBounds(15, 365, 500, 20);
        JButton LISTC = new JButton("Вывести список клиентов");
        LISTC.setBounds(15, 400, 500, 20);
        JButton LISTO = new JButton("Вывести список заказов");
        LISTO.setBounds(15, 435, 500, 20);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0, 530, 465);

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
        panel.add(LISTB);
        panel.add(LISTC);
        panel.add(LISTO);
        setContentPane(panel);
        panel.setVisible(true);

        setVisible(true);

        ADDO.addActionListener(e -> new ADDO2(dis, dos, fullName, address));

        ADDB.addActionListener(e -> new ADDB2(dis, dos));

        DELB.addActionListener(e -> {
            String tmp = JOptionPane.showInputDialog(new JFrame(), "Введите название книги:");
            while(true) {
                if (tmp == null) {
                    tmp = JOptionPane.showInputDialog(new JFrame(), "Вы не ввели название книги. Введите его:");
                } else {
                    break;
                }
            }
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
            while(true) {
                if (tmp == null) {
                    tmp = JOptionPane.showInputDialog(new JFrame(), "Вы не ввели ФИО. Введите его:");
                } else {
                    break;
                }
            }
            try {
                dos.writeUTF("DELC");
                dos.writeUTF(tmp);
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        CHAB.addActionListener(e -> new CHAB2(dis, dos));

        CHAC.addActionListener(e -> new CHAC2(dis, dos));

        CHEST.addActionListener(e -> {
            String tmp = JOptionPane.showInputDialog(new JFrame(), "Введите ФИО заказчика:");
            while(true) {
                if (tmp == null) {
                    tmp = JOptionPane.showInputDialog(new JFrame(), "Вы не ввели ФИО. Введите его:");
                } else {
                    break;
                }
            }
            try {
                dos.writeUTF("CHEST");
                dos.writeUTF(tmp);
                JOptionPane.showMessageDialog(new JFrame(), dis.readUTF(), "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        CHAST.addActionListener(e -> new CHAST2(dis, dos));

        CHEB.addActionListener(e -> new CHEB2(dis, dos));

        END.addActionListener(e -> {
            try {
                dos.writeUTF("END");
                dis.close();
                dos.close();
                server.close();
                System.exit(0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            setVisible(false);
        });

        LISTB.addActionListener(e -> {
            try {
                dos.writeUTF("LISTB");
                dos.writeUTF("");
                new InfoFrame(dis.readUTF());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        LISTC.addActionListener(e -> {
            try {
                dos.writeUTF("LISTC");
                dos.writeUTF("");
                new InfoFrame(dis.readUTF());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        LISTO.addActionListener(e -> {
            try {
                dos.writeUTF("LISTO");
                dos.writeUTF("");
                new InfoFrame(dis.readUTF());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

}
