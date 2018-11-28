package view;

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

public class Register extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField firstName;
    private JTextField surname;
    private JTextField password1;
    private JTextField password2;
    
    private TTTWebService proxy;

    private final int paneWidth = 350;
    private final int paneHeight = 560;
    private final String title = "Register Page";

    public Register() {
        createWindow();
    }
    
    public void createWindow() {
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(paneWidth, paneHeight);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRegisterPage = new JLabel(title);
        lblRegisterPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegisterPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblRegisterPage.setBounds(12, 13, 298, 51);
        contentPane.add(lblRegisterPage);

        JLabel lblUsername = new JLabel("Enter Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(25, 60, 150, 25);
        contentPane.add(lblUsername);

        username = new JTextField();
        username.setBounds(25, 90, 300, 35);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblFirstName = new JLabel("Enter First Name:");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFirstName.setBounds(25, 140, 150, 25);
        contentPane.add(lblFirstName);

        firstName = new JTextField();
        firstName.setBounds(25, 170, 300, 35);
        contentPane.add(firstName);
        firstName.setColumns(10);

        JLabel lblSurame = new JLabel("Enter Surame:");
        lblSurame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSurame.setBounds(25, 220, 150, 25);
        contentPane.add(lblSurame);
        
        surname = new JTextField();
        surname.setBounds(25, 250, 300, 35);
        contentPane.add(surname);
        surname.setColumns(10);
        
        JLabel lblPassword1 = new JLabel("Enter Password:");
        lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword1.setBounds(25, 300, 150, 25);
        contentPane.add(lblPassword1);

        password1 = new JPasswordField();
        password1.setColumns(10);
        contentPane.add(password1);
        password1.setBounds(25, 330, 300, 35);
        
        JLabel lblPassword2 = new JLabel("Re-Enter Password:");
        lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword2.setBounds(25, 380, 150, 25);
        contentPane.add(lblPassword2);

        password2 = new JPasswordField();
        password2.setColumns(10);
        password2.setBounds(25, 410, 300, 35);
        contentPane.add(password2);


        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                registerUser();
            }
        });
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRegister.setBounds(50, 450, 100, 25);
        contentPane.add(btnRegister);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCancel.setBounds(150, 450, 100, 25);
        contentPane.add(btnCancel);
    }
    
    public void registerUser() {
        if(password1.getText().equals(password2.getText())) {
            Connection con = new Connection();
            proxy = con.getProxy();
            String result = proxy.register(username.getText(), password1.getText(), firstName.getText(), surname.getText());
            switch(result) {
                case "ERROR-REPEAT":
                    JOptionPane.showMessageDialog(null,"ERROR: Username used");
                    break;
                case "ERROR-INSERT":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to add data");
                    break;
                case "ERROR-RETRIEVE":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to retrieve data");
                    break;
                case "ERROR-DB":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to connect to DB");
                    break;
                default:
                    dispose();
            }
        } else JOptionPane.showMessageDialog(null,"Error: Passwords do no match");
    }
}
