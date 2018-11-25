/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import util.Connection;
import ttt.james.server.TTTWebService;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField pass;
    private JTextField user;
    
    private Login login;
    private TTTWebService proxy;

    /**
     * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
    */
    public Login() {
        login = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 382);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
	
        JLabel lblLoginPage = new JLabel("Login Page");
        lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblLoginPage.setBounds(12, 13, 298, 51);
        contentPane.add(lblLoginPage);
	
        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(12, 99, 94, 26);
        contentPane.add(lblUsername);
        
        user = new JTextField();
        user.setBounds(12, 128, 298, 35);
        contentPane.add(user);
        user.setColumns(10);
	
        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(12, 197, 94, 26);
        contentPane.add(lblPassword);
        
        pass = new JPasswordField();
        pass.setBounds(12, 222, 298, 35);
        contentPane.add(pass);
	
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Connection con = new Connection();
                    proxy = con.getProxy();
                    int result = proxy.login(user.getText(), pass.getText());
                    switch(result) {
                        case -1:
                            JOptionPane.showMessageDialog(null,"ERROR: Unable to connect to DB");
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(null,"Incorrect Login details");
                            break;
                        default:
                            Mainmenu mainmenu = new Mainmenu(result);
                            login.dispose();
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginButton.setBounds(50, 281, 97, 25);
        contentPane.add(loginButton);
        
        JButton regButton = new JButton("Register");
        regButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Register reg = new Register();
                    reg.setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        regButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        regButton.setBounds(150, 281, 97, 25);
        contentPane.add(regButton);
    }
}
