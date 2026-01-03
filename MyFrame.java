import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JLabel answerLabel = new JLabel();
    JPanel answerPanel = new JPanel();
    JTextField field = new JTextField();
    JButton button = new JButton("Submit");
    MyFrame() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("NumToWord");
        this.setPreferredSize(new Dimension(1300, 400));

        button.setPreferredSize(new Dimension(200, 40));
        button.addActionListener(this);

        JPanel panel = new JPanel();
        field.setText("1");
        field.setPreferredSize(new Dimension(500, 50));
        field.setBackground(Color.BLACK);
        field.setFont(new Font("Arial", Font.BOLD, 40));
        field.setForeground(new Color(0, 160, 10));
        field.setCaretColor(Color.WHITE);
        field.addActionListener(this);
        JLabel fieldlabel = new JLabel();
        fieldlabel.setFont(new Font("Arial", Font.PLAIN, 40));
        fieldlabel.setText("Please enter Your number:");

        panel.setLayout(new BorderLayout());
        panel.add(fieldlabel, BorderLayout.NORTH);
        panel.add(field);
        panel.add(button, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.NORTH);
        this.add(answerPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String result = Main.NTW(Long.parseLong(field.getText()));
            answerLabel.setFont(new Font("Arial", Font.BOLD, 20));
            answerLabel.setText(result);
            answerPanel.add(answerLabel);
            this.add(answerPanel);
        }
    }
}
