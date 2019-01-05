package Client;

import javax.swing.*;
import java.awt.*;

class InfoFrame extends JFrame {

    public  InfoFrame(String info) {
        super("InfoFrame");
        setLayout(new BorderLayout());
        setSize(645, 325);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(15, 15, 600, 200);
        JButton button = new JButton("Закрыть окно");
        button.setBounds(15, 230, 600, 20);
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 630, 265);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(textArea);
        panel.add(scrollPane);
        panel.add(button);
        setContentPane(panel);
        panel.setVisible(true);

        setVisible(true);

        textArea.setText(info);

        button.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
    }

}
