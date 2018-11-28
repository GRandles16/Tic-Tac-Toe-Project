
package view;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.Connection;
import ttt.james.server.TTTWebService;

public class OpenGames extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private final int paneWidth = 400;
    private final int paneHeight = 400;
    private final String title = "Open Games";
    private int userID;
    
    private TTTWebService proxy;
    
    public void OpenGames(int uID) {
        userID = uID;
        
        createWindow();
    }
    
    public void createWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        table = new JTable();
        setResizable(false);
        setSize(paneWidth, paneHeight);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(table, BorderLayout.CENTER);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel(title);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitle.setBounds(50, 10, 300, 50);
        contentPane.add(lblTitle);
        
        
    }
}