/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import view.Start;
import view.Login;
import view.Register;

/**
 *
 * @author gtara
 */
public class TicTacToe extends JFrame {
    
    private JPanel contentPane;
    private final int paneWidth = 340;
    private final int paneHeight = 380;
    private final String title = "Login Page";
    
    public static void main(String[] args) {
        Start start = new Start();
        start.setVisible(true);
    }
}
