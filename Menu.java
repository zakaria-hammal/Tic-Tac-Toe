/*
 * Author: Zakaria HAMMAL
 * email: hammalzakaria06@gmail.com
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu implements ActionListener{
    
    public JFrame frame;
    JButton button1;
    JButton button2;

    JPanel panel1;
    JPanel panel2;
    public int c;

    public Menu() {
        frame = new JFrame();

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 750, 450);
        panel1.setLayout(null);
        panel1.setPreferredSize(new Dimension(750, 450));

        panel2 = new JPanel();
        panel2.setBounds(0, 450, 750, 450);
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(750, 450));

        button1 = new JButton("1v1");
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setFont(new Font("MV Boli", Font.PLAIN, 50));
        button1.setBounds(375/2, 225/2, 375, 225);

        button2 = new JButton("<html>Against BOT <br> (Can't win)</html>");
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setFont(new Font("MV Boli", Font.PLAIN, 40));
        button2.setBounds(375/2, 225/2, 375, 225);

        panel1.add(button1);
        panel2.add(button2);

        frame.add(panel1);
        frame.add(panel2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 900);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == button1) {
            new Game();
        }
        else {
            new Auto();
        }
    }
}
