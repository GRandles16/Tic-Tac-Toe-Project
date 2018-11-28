
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

public class MyStats extends JFrame {
    private JPanel contentPane;
    private final int paneWidth = 400;
    private final int paneHeight = 400;
    private final String title = "My Stats";
    
    private int userID;
    private String username;
    private String games;
    private String wins;
    private String draws;
    private String loses;
    private String leagueTable;
            
    private TTTWebService proxy;
    
    public MyStats(int uID, String name) {
        userID = uID;
        username = name;
        calculateStats();
        createWindow();
    }
    
    //Window shows current users stats
    
    public void createWindow() {
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        lblLoginPage.setBounds(50, 10, 300, 50);
        contentPane.add(lblLoginPage);
        
        JLabel lblUsername = new JLabel(username);
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblUsername.setBounds(50, 60, 300, 25);
        contentPane.add(lblUsername);
        
        JLabel lblGames = new JLabel(games);
        lblGames.setHorizontalAlignment(SwingConstants.CENTER);
        lblGames.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblGames.setBounds(50, 100, 300, 35);
        contentPane.add(lblGames);
        
        JLabel lblWins = new JLabel(wins);
        lblWins.setHorizontalAlignment(SwingConstants.CENTER);
        lblWins.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblWins.setBounds(50, 130, 300, 25);
        contentPane.add(lblWins);
        
        JLabel lblDraws = new JLabel(draws);
        lblDraws.setHorizontalAlignment(SwingConstants.CENTER);
        lblDraws.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblDraws.setBounds(50, 160, 300, 25);
        contentPane.add(lblDraws);
        
        JLabel lblLoses = new JLabel(loses);
        lblLoses.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoses.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblLoses.setBounds(50, 190, 300, 25);
        contentPane.add(lblLoses);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnClose.setBounds(75, 220, 100, 25);
        contentPane.add(btnClose);
    }
    
    //Method looks at all games and calculates stats
    
    public void calculateStats() {
        getLeagueTable();
        
        int gameCount = 0, winCount = 0, drawCount = 0, lossCount = 0, status;
        
        String[] results = leagueTable.split("\n");
        
        for (String result : results) {
            String[] game = result.split(",");
            status = Integer.parseInt(game[3]);
            
            if (game[1].equals(username) && status != 0) {
                switch (status) {
                    case 1:
                        gameCount++;
                        winCount++;
                        break;
                    case 2:
                        gameCount++;
                        lossCount++;
                        break;
                    case 3:
                        gameCount++;
                        drawCount++;
                        break;
                    default:
                }
            }
            
            else if (game[2].equals(username) && status != 0) {
                switch (status) {
                    case 1:
                        gameCount++;
                        winCount++;
                        break;
                    case 2:
                        gameCount++;
                        lossCount++;
                        break;
                    case 3:
                        gameCount++;
                        drawCount++;
                        break;
                    default:
                }
            }            
        }
        
        games = "Games:\t" + gameCount;
        wins = "Wins:\t" + winCount;
        draws = "Draws:\t" + drawCount;
        loses = "Loses:\t" + lossCount;
    }
    
    //gets league table stats
    
    public void getLeagueTable() {
        try {
            Connection con = new Connection();
            proxy = con.getProxy();
            String result = proxy.leagueTable();
            switch(result) {
                case "ERROR-NOGAMES":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to find new Game");
                    break;
                case "ERROR-DB":
                    JOptionPane.showMessageDialog(null,"ERROR: Unable to connect to DB");
                    break;
                default:
                    leagueTable = result;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
