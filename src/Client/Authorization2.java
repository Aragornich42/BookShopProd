package Client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Authorization2 extends JFrame {

    private final JTextField authField = new JTextField();
    private String fullName;
    private String address;
    private final Socket server = new Socket("localhost", 8080);
    private final DataInputStream dis = new DataInputStream(server.getInputStream());
    private final DataOutputStream dos = new DataOutputStream(server.getOutputStream());

    public Authorization2() throws IOException {
        super("Authorization");

        setLayout(new BorderLayout());
        setSize(545, 230);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel labelAuth = new JLabel("Введите email для входа, пожалуйста:");
        labelAuth.setBounds(15, 15, 500, 20);
        authField.setBounds(15, 50, 500, 20);
        JButton authButton = new JButton("Вход");
        authButton.setBounds(15, 85, 500,20);
        JLabel labelReg = new JLabel("Если Вы здесь впервые, зарегистрируйтесь:");
        labelReg.setBounds(15, 120, 500, 20);
        JButton registButton = new JButton("Регистрация");
        registButton.setBounds(15, 155, 500, 20);
        JPanel authFrame = new JPanel(null);
        authFrame.setBounds(0,0, 530, 170);

        authFrame.add(authField);
        authFrame.add(authButton);
        authFrame.add(registButton);
        authFrame.add(labelAuth);
        authFrame.add(labelReg);
        setContentPane(authFrame);
        authFrame.setVisible(true);

        setVisible(true);

        authButton.addActionListener(e -> {
            try {
                dos.writeUTF("CHEC");
                dos.writeUTF(authField.getText());
                String tmp = dis.readUTF();
                if(tmp.equals("User found")) {
                    fullName = dis.readUTF();
                    address = dis.readUTF();
                    new Operations2(dis, dos, fullName, address, server);
                    setVisible(false);
                }
                else if(tmp.equals("User not found"))
                    JOptionPane.showMessageDialog(new JFrame(),
                            "email некорректен, введите его заново, или зарегистрируйтесь", "Result",
                            JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        registButton.addActionListener(e -> {
            new Registration2(dis, dos, server);
            setVisible(false);
        });
    }

}
