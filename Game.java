/*
 * Author: Zakaria HAMMAL
 * email: hammalzakaria06@gmail.com
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Game implements ActionListener{

    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JLabel label;
    JButton[] button = new JButton[9];
    JButton r;
    int[] A = new int[5];
    int k = 0;
    int[] B = new int[5];
    int l = 0;
    boolean inA;
    boolean a = true;
    int[] t = new int[9];
    boolean winA = false;
    boolean winB = false;
    boolean draw = false;

    public Game() {

        for (int i = 0; i < A.length; i++) {
            A[i] = -1;
            B[i] = -1;
        }

        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }

        frame = new JFrame();
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 750, 150);
        panel1.setLayout(null);
        panel1.setPreferredSize(new Dimension(750, 150));

        panel2 = new JPanel();
        panel2.setBounds(0, 150, 750, 750);
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(750, 750));

        label = new JLabel();
        label.setSize(new Dimension(500, 150));
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.RIGHT);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label.setText("Player 1 :");

        r = new JButton("Reset");
        r.setBounds(500, 0, 250, 150);
        r.setFont(new Font("MV Boli", Font.PLAIN, 50));
        r.addActionListener(this);
        r.setFocusable(false);

        panel1.add(label);
        panel1.add(r);
        
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton();
            button[i].addActionListener(this);
            button[i].setFocusable(false);
            button[i].setFont(new Font("MV Boli", Font.PLAIN, 250));
            button[i].setBackground(Color.white);
            
        }

        button[0].setBounds(0, 0, 250, 250);
        button[1].setBounds(250, 0, 250, 250);
        button[2].setBounds(500, 0, 250, 250);
        button[3].setBounds(0, 250, 250, 250);
        button[4].setBounds(250, 250, 250, 250);
        button[5].setBounds(500, 250, 250, 250);
        button[6].setBounds(0, 500, 250, 250);
        button[7].setBounds(250, 500, 250, 250);
        button[8].setBounds(500, 500, 250, 250);


        for (int i = 0; i < button.length; i++) {
            panel2.add(button[i]);
        }

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setSize(750, 938);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!winA && ! winB && !draw ) {
        inA = false;
        if (a) {
            for (int index = 0; index < button.length; index++) {
                if (e.getSource() == button[index]) {
                    for (int i = 0; i < A.length; i++) {
                        if (index == A[i]) {
                            inA = true;
                            break;
                        }
                    }

                    for (int i = 0; i < B.length; i++) {
                        if (index == B[i]) {
                            inA = true;
                            break;
                        }
                    }

                    if (!inA) {
                        button[index].setText("X");    
                        button[index].setForeground(Color.red);
                        label.setText("Player 2 :");
                        t[index] = 1;
                        
                        a = false;
                        A[k] = index;
                        k++;
                    }
                    
                    break;
                }
            }
        }
        else {
            for (int index = 0; index < button.length; index++) {
                if (e.getSource() == button[index]) {
                    for (int i = 0; i < A.length; i++) {
                        if (index == A[i]) {
                            inA = true;
                            break;
                        }
                    }

                    for (int i = 0; i < B.length; i++) {
                        if (index == B[i]) {
                            inA = true;
                            break;
                        }
                    }

                    if (!inA) {
                        button[index].setText("O");   
                        button[index].setForeground(Color.blue);
                        label.setText("Player 1 :");
                        t[index] = 0;
                        
                        a = true;
                        B[l] = index;
                        l++;
                    }
                    
                    break;
                }
            }
        }

        for (int i = 0; i < t.length; i++) {
            draw = true;
            if (t[i] == -1) {
                draw = false;
                break;
            }
        }
        
            if (t[0] == t[1] && t[1] == t[2] && t[2] == 1 ||
                t[3] == t[4] && t[4] == t[5] && t[5] == 1 ||
                t[6] == t[7] && t[7] == t[8] && t[8] == 1 ||
                t[0] == t[3] && t[3] == t[6] && t[6] == 1 ||
                t[1] == t[4] && t[4] == t[7] && t[7] == 1 ||
                t[2] == t[5] && t[5] == t[8] && t[8] == 1 ||
                t[0] == t[4] && t[4] == t[8] && t[8] == 1 ||
                t[2] == t[4] && t[4] == t[6] && t[6] == 1 
                ) {
                    winA = true;
                    label.setText("Player 1 won !!!");

                    if (t[0] == t[1] && t[1] == t[2] && t[2] == 1) {
                        button[0].setForeground(Color.yellow);
                        button[1].setForeground(Color.yellow);
                        button[2].setForeground(Color.yellow);
                    }
                    else if (t[3] == t[4] && t[4] == t[5] && t[5] == 1) {
                        button[3].setForeground(Color.yellow);
                        button[4].setForeground(Color.yellow);
                        button[5].setForeground(Color.yellow);
                    }
                    else if (t[6] == t[7] && t[7] == t[8] && t[8] == 1) {
                        button[6].setForeground(Color.yellow);
                        button[7].setForeground(Color.yellow);
                        button[8].setForeground(Color.yellow);
                    }
                    else if (t[0] == t[3] && t[3] == t[6] && t[6] == 1) {
                        button[0].setForeground(Color.yellow);
                        button[3].setForeground(Color.yellow);
                        button[6].setForeground(Color.yellow);
                    }
                    else if (t[1] == t[4] && t[4] == t[7] && t[7] == 1) {
                        button[1].setForeground(Color.yellow);
                        button[4].setForeground(Color.yellow);
                        button[7].setForeground(Color.yellow);
                    }
                    else if (t[2] == t[5] && t[5] == t[8] && t[8] == 1) {
                        button[2].setForeground(Color.yellow);
                        button[5].setForeground(Color.yellow);
                        button[8].setForeground(Color.yellow);
                    }
                    else if (t[0] == t[4] && t[4] == t[8] && t[8] == 1) {
                        button[0].setForeground(Color.yellow);
                        button[4].setForeground(Color.yellow);
                        button[8].setForeground(Color.yellow);
                    }
                    else if (t[2] == t[4] && t[4] == t[6] && t[6] == 1) {
                        button[2].setForeground(Color.yellow);
                        button[4].setForeground(Color.yellow);
                        button[6].setForeground(Color.yellow);
                    }

                    draw = false;
                }

            else if (t[0] == t[1] && t[1] == t[2] && t[2] == 0 ||
                    t[3] == t[4] && t[4] == t[5] && t[5] == 0 ||
                    t[6] == t[7] && t[7] == t[8] && t[8] == 0 ||
                    t[0] == t[3] && t[3] == t[6] && t[6] == 0 ||
                    t[1] == t[4] && t[4] == t[7] && t[7] == 0 ||
                    t[2] == t[5] && t[5] == t[8] && t[8] == 0 ||
                    t[0] == t[4] && t[4] == t[8] && t[8] == 0 ||
                    t[2] == t[4] && t[4] == t[6] && t[6] == 0 
                    ) {
                        winB = true;
                        label.setText("Player 2 won !!!");
                        draw = false;

                        if (t[0] == t[1] && t[1] == t[2] && t[2] == 0) {
                            button[0].setForeground(Color.yellow);
                            button[1].setForeground(Color.yellow);
                            button[2].setForeground(Color.yellow);
                        }
                        else if (t[3] == t[4] && t[4] == t[5] && t[5] == 0) {
                            button[3].setForeground(Color.yellow);
                            button[4].setForeground(Color.yellow);
                            button[5].setForeground(Color.yellow);
                        }
                        else if (t[6] == t[7] && t[7] == t[8] && t[8] == 0) {
                            button[6].setForeground(Color.yellow);
                            button[7].setForeground(Color.yellow);
                            button[8].setForeground(Color.yellow);
                        }
                        else if (t[0] == t[3] && t[3] == t[6] && t[6] == 0) {
                            button[0].setForeground(Color.yellow);
                            button[3].setForeground(Color.yellow);
                            button[6].setForeground(Color.yellow);
                        }
                        else if (t[1] == t[4] && t[4] == t[7] && t[7] == 0) {
                            button[1].setForeground(Color.yellow);
                            button[4].setForeground(Color.yellow);
                            button[7].setForeground(Color.yellow);
                        }
                        else if (t[2] == t[5] && t[5] == t[8] && t[8] == 0) {
                            button[2].setForeground(Color.yellow);
                            button[5].setForeground(Color.yellow);
                            button[8].setForeground(Color.yellow);
                        }
                        else if (t[0] == t[4] && t[4] == t[8] && t[8] == 0) {
                            button[0].setForeground(Color.yellow);
                            button[4].setForeground(Color.yellow);
                            button[8].setForeground(Color.yellow);
                        }
                        else if (t[2] == t[4] && t[4] == t[6] && t[6] == 0) {
                            button[2].setForeground(Color.yellow);
                            button[4].setForeground(Color.yellow);
                            button[6].setForeground(Color.yellow);
                        }
                    }
            if (draw) {
                label.setText("Draw !!!");
                for (int i = 0; i < t.length; i++) {
                    button[i].setForeground(Color.yellow);
                }
            }
        }
        if (e.getSource()==r) {
            winA = false;
            winB = false;
            draw = false;
            a = true;
            k = 0;
            l = 0;
            label.setText("Player 1 :");

            for (int i = 0; i < A.length; i++) {
                A[i] = -1;
                B[i] = -1;
            }
    
            for (int i = 0; i < t.length; i++) {
                t[i] = -1;
            }

            for (int i = 0; i < 9; i++) {
                button[i].setForeground(Color.white);
                button[i].setText("");
            }

        }
        
    }
}
