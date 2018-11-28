
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

public class Login extends JFrame {
    
    private JPanel contentPane;
    private final int paneWidth = 340;
    private final int paneHeight = 380;
    private final String title = "Login Page";
    private JTextField pass;
    private JTextField user;
    
    private Login login;
    private TTTWebService proxy;

    public Login() {
        login = this;
        
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
	
        JLabel lblLoginPage = new JLabel(title);
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
                login();
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
    
    public void login() {
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
                    Mainmenu mainmenu = new Mainmenu(result,user.getText());
                    login.dispose();
                    mainmenu.setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
