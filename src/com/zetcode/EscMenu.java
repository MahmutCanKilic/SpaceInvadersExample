package com.zetcode;

import com.zetcode.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscMenu {
    private static JFrame menuFrame;

    public static void showEscapeMenu(Board board) {
        menuFrame = new JFrame("Pause Menu");

        JFrame frame = new JFrame("Pause Menu");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, board);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, Board board) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JPanel restartPanel = new JPanel();
        restartPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {
            board.restartGame();
            menuFrame.dispose();
        });
        restartPanel.add(restartButton);
        panel.add(restartPanel);


        JPanel quitPanel = new JPanel();
        quitPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> board.quitGame());
        quitPanel.add(quitButton);
        panel.add(quitPanel);


        JPanel resumePanel = new JPanel();
        resumePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> {
            board.resumeGame();
            menuFrame.dispose();
        });
        resumePanel.add(resumeButton);
        panel.add(resumePanel);
    }
}
