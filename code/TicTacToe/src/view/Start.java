
package view;

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

import util.Connection;
import ttt.james.server.TTTWebService;

public class Start extends JFrame {
    
    private JPanel contentPane;
    private final int paneWidth = 400;
    private final int paneHeight = 200;
    private final String title = "Welcome!";
    
    private Start start;

    public Start() {
        start = this;
        
        createWindow();
    }
    
    public void createWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(paneWidth, paneHeight);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel(title);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitle.setBounds(50, 10, 300, 50);
        contentPane.add(lblTitle);
        
        JButton newGame = new JButton("Login");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                login();
            }
        });
        newGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        newGame.setBounds(125, 70, 150, 25);
        contentPane.add(newGame);
        
        JButton myGames = new JButton("Register");
        myGames.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                register();
            }
        });
        myGames.setFont(new Font("Tahoma", Font.PLAIN, 16));
        myGames.setBounds(125, 100, 150, 25);
        contentPane.add(myGames);
    }
    
    public void login() {
        try {
            Login login = new Login();
            start.dispose();
            login.setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void register() {
        try {
            Register reg = new Register();
            reg.setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
