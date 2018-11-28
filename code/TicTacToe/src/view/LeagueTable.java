
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.Connection;
import ttt.james.server.TTTWebService;

public class LeagueTable extends JFrame {
    private JPanel contentPane;
    private final int paneWidth = 400;
    private final int paneHeight = 400;
    private final String title = "League Table";
    private String leagueTable;
    private String[] board = new String[10];
    
    private TTTWebService proxy;
    
    public void LeagueTable() {
        calculateLeagueTable();
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
        
        JLabel lblTitle = new JLabel(title);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitle.setBounds(50, 10, 300, 50);
        contentPane.add(lblTitle);
        
        JLabel lblFirst = new JLabel(board[0]);
        lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
        lblFirst.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblFirst.setBounds(50, 60, 300, 25);
        contentPane.add(lblFirst);
        
        JLabel lblGames = new JLabel(board[1]);
        lblGames.setHorizontalAlignment(SwingConstants.CENTER);
        lblGames.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblGames.setBounds(50, 100, 300, 35);
        contentPane.add(lblGames);
        
        JLabel lblWins = new JLabel(board[2]);
        lblWins.setHorizontalAlignment(SwingConstants.CENTER);
        lblWins.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblWins.setBounds(50, 130, 300, 25);
        contentPane.add(lblWins);
        
        JLabel lblDraws = new JLabel(board[3]);
        lblDraws.setHorizontalAlignment(SwingConstants.CENTER);
        lblDraws.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblDraws.setBounds(50, 160, 300, 25);
        contentPane.add(lblDraws);
        
        JLabel lblLoses = new JLabel(board[4]);
        lblLoses.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoses.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblLoses.setBounds(50, 190, 300, 25);
        contentPane.add(lblLoses);
    }
    
    public void calculateLeagueTable() {
        getLeagueTable();
        
        
        String[] results = leagueTable.split("\n");
        ArrayList<String> users = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        
        for (String result : results) {
            
            String[] game = result.split(",");
            int status = Integer.parseInt(game[3]);
            
            if(users.isEmpty()){
                users.add(game[1]);
                scores.add(0);
            } else if(!users.contains(game[1])) {
                users.add(game[1]);
                scores.add(0);
            } else if(!users.contains(game[2])) {
                users.add(game[2]);
                scores.add(0);
            } else {
                for(int i = 0; i < users.size(); i++) {
                    int temp;
                    if(users.get(i).equals(game[1])&& status != 0) {
                        switch (status) {
                        case 1:
                            temp = scores.get(i) + 2;
                            scores.set(i, temp);
                            break;
                        case 3:
                            temp = scores.get(i) + 1;
                            scores.set(i, temp);
                            break;
                        default:
                        }
                    } else if(users.get(i).equals(game[2])&& status != 0) {
                        switch (status) {
                        case 2:
                            temp = scores.get(i) + 2;
                            scores.set(i, temp);
                            break;
                        case 3:
                            temp = scores.get(i) + 1;
                            scores.set(i, temp);
                            break;
                        default:
                        }
                    }
                }
            }
        }
        calculateBoard(users, scores);
    }
    
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
    
    public void calculateBoard(ArrayList<String> users, ArrayList<Integer> scores) {
        
    }
}
