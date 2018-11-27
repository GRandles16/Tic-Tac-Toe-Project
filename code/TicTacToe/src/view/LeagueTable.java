
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

public class LeagueTable extends JFrame {
    
    private int userID;
    
    private TTTWebService proxy;
    
    public void LeagueTable(int uID) {
        userID = uID;
        
        createWindow();
    }
    
    public void createWindow() {
        JOptionPane.showMessageDialog(null,"This will show you the league table");
    }
}
