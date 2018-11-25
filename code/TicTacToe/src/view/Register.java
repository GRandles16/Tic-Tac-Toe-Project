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

    /**
     * Create the frame.
     */
    public Register() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 366, 751);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRegisterPage = new JLabel("Register Page");
        lblRegisterPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegisterPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblRegisterPage.setBounds(12, 13, 298, 51);
        contentPane.add(lblRegisterPage);

        JLabel lblUsername = new JLabel("Enter Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(12, 50, 143, 26);
        contentPane.add(lblUsername);

        username = new JTextField();
        username.setBounds(12, 80, 298, 35);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblFirstName = new JLabel("Enter First Name:");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFirstName.setBounds(12, 130, 143, 26);
        contentPane.add(lblFirstName);

        firstName = new JTextField();
        firstName.setBounds(12, 160, 298, 35);
        contentPane.add(firstName);
        firstName.setColumns(10);

        JLabel lblSurame = new JLabel("Enter Surame:");
        lblSurame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSurame.setBounds(12, 210, 143, 26);
        contentPane.add(lblSurame);
        
        surname = new JTextField();
        surname.setBounds(12, 240, 298, 35);
        contentPane.add(surname);
        surname.setColumns(10);
        
        JLabel lblPassword1 = new JLabel("Enter Password:");
        lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword1.setBounds(12, 290, 143, 26);
        contentPane.add(lblPassword1);

        password1 = new JPasswordField();
        password1.setColumns(10);
        contentPane.add(password1);
        password1.setBounds(12, 320, 298, 35);
        
        JLabel lblPassword2 = new JLabel("Re-Enter Password:");
        lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword2.setBounds(12, 370, 143, 26);
        contentPane.add(lblPassword2);

        password2 = new JPasswordField();
        password2.setColumns(10);
        password2.setBounds(12, 400, 298, 35);
        contentPane.add(password2);


        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
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
        });
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRegister.setBounds(50, 450, 97, 25);
        contentPane.add(btnRegister);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCancel.setBounds(150, 450, 97, 25);
        contentPane.add(btnCancel);
    }
}
