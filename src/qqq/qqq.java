package qqq;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class qqq extends JFrame {

    static private int BOR = 10;

    public static void createGUI() {
        final JFrame frame = new JFrame("Loding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(BOR, BOR, BOR, BOR));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        JProgressBar progressBar1 = new JProgressBar();
        progressBar1.setIndeterminate(true);
        panel.add(progressBar1);

        panel.add(Box.createVerticalGlue());

        final JProgressBar progressBar2 = new JProgressBar();
        progressBar2.setStringPainted(true);
        progressBar2.setMinimum(0);
        progressBar2.setMaximum(100);
        panel.add(progressBar2);

        panel.add(Box.createVerticalGlue());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        buttonsPanel.add(Box.createHorizontalGlue());

        JButton increment = new JButton("+10%");
        increment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = progressBar2.getValue() + 10;
                int maximum = progressBar2.getMaximum();
                if(value > maximum) {
                    value = maximum;
                }
                progressBar2.setValue(value);
            }
        });
        buttonsPanel.add(increment);

        buttonsPanel.add(Box.createHorizontalGlue());

        JButton decrement = new JButton("-10%");
        decrement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = progressBar2.getValue() - 10;
                int minimum = progressBar2.getMinimum();
                if(value < minimum) {
                    value = minimum;
                }
                progressBar2.setValue(value);
            }
        });
        buttonsPanel.add(decrement);

        buttonsPanel.add(Box.createHorizontalGlue());

        panel.add(buttonsPanel);

        panel.add(Box.createVerticalGlue());

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(260, 225));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }

}
