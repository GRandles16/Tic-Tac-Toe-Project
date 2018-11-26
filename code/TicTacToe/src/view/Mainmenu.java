
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.Connection;
import ttt.james.server.TTTWebService;


public class Mainmenu extends JFrame {
    
    private JPanel contentPane;
    private final int paneWidth = 400;
    private final int paneHeight = 400;
    private int userID;
    
    private Login login;
    private Mainmenu mainmenu;
    private TTTWebService proxy;
    
    public Mainmenu(int uID) {
        userID = uID;
        mainmenu = this;
        
        createWindow();
    }
    
    public void createWindow() {
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(paneWidth, paneHeight);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblLoginPage = new JLabel("Main Menu");
        lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblLoginPage.setBounds(50, 10, 300, 50);
        contentPane.add(lblLoginPage);
        
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                addNewGame();
            }
        });
        newGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        newGame.setBounds(125, 70, 150, 25);
        contentPane.add(newGame);
        
        JButton myGames = new JButton("My Games");
        myGames.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showMyGames();
            }
        });
        myGames.setFont(new Font("Tahoma", Font.PLAIN, 16));
        myGames.setBounds(125, 100, 150, 25);
        contentPane.add(myGames);
        
        
        
        JButton openGames = new JButton("Open Games");
        openGames.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showOpenGames();
            }
        });
        openGames.setFont(new Font("Tahoma", Font.PLAIN, 16));
        openGames.setBounds(125, 130, 150, 25);
        contentPane.add(openGames);
        
        JButton leagueTable = new JButton("League Table");
        leagueTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showLeagueTable();
            }
        });
        leagueTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        leagueTable.setBounds(125, 160, 150, 25);
        contentPane.add(leagueTable);
        
        JButton logoutButtom = new JButton("Logout");
        logoutButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                logout();
            }
        });
        logoutButtom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        logoutButtom.setBounds(125, 190, 150, 25);
        contentPane.add(logoutButtom);
    }
    
    public void addNewGame() {
        try {
            Connection con = new Connection();
            proxy = con.getProxy();
            String result = proxy.newGame(userID);
            switch(result) {
                case "ERROR-NOTFOUND":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to find new Game");
                    break;
                case "ERROR-RETRIEVE":
                    JOptionPane.showMessageDialog(null,"ERROR: Unabe to find game table");
                    break;
                case "ERROR-INSERT":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to add new Game");
                    break;
                case "ERROR-DB":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to connect to DB");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Game " + result + " was successfully add, awaiting opponent");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void showMyGames() {
        MyGames myGames = new MyGames();
        myGames.setVisible(true);
    }
    
    public void showOpenGames() {
        OpenGames openGames = new OpenGames();
        openGames.setVisible(true);
    }
    
    public void showLeagueTable() {
        LeagueTable leagueTable = new LeagueTable();
        leagueTable.setVisible(true);
    }
    
    public void logout() {
        Login login = new Login(); 
        mainmenu.dispose();
        login.setVisible(true);
    }
   
}
