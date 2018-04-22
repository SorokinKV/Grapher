package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static void main(String[] args) {
        MyWindows myWindows = new MyWindows();
    }


}

class MyWindows extends JFrame implements ResultRun {
    JTextArea textField;
    JButton button;

    public MyWindows() {
        setTitle("Builder");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(200, 200, 600, 80);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        add(panel);

        button = new JButton("Start");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(textField.getText().equals("")) return ;
                Thrader thrader = new Thrader(textField.getText(), MyWindows.this);
            }
        });

        panel.add(button);

        textField = new JTextArea();
        textField.setPreferredSize(new Dimension(450, 25));
        textField.setFont(new Font("Serif", NORMAL, 20));
        panel.add(textField);

        setVisible(true);
    }

    @Override
    public void ResultRun() {
        Graph graph = new Graph();
    }
}

class Graph extends JFrame {
    public Graph() {
        Painter painter = new Painter();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(300, 200, Globals.rangeX, Globals.rangeY + 50);
        add(painter);
        setVisible(true);
    }
}

class Painter extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.white);
        g.setColor(Color.red);

        for (int i = 1; i < Globals.rangeX; ++i)
            g.drawLine(i - 1, (int) Globals.yarray[i - 1], i, (int) Globals.yarray[i]);
    }
}