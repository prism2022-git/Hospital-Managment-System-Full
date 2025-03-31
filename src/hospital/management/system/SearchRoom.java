package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice ch;
    JTable table;

    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(98,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setFont(new Font("Tahoma",Font.BOLD,15));
        For.setForeground(Color.white);
        panel.add(For);

        JLabel status = new JLabel("Status:");
        status.setBounds(70,70,80,20);
        status.setFont(new Font("Tahoma",Font.BOLD,13));
        status.setForeground(Color.white);
        panel.add(status);

         ch = new Choice();
        ch.setBounds(170,70,120,20);
        ch.add("Available");
        ch.add("Occupied");
        panel.add(ch);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));  // all bg colour
        table.setForeground(Color.white);
        panel.add(table);

        try{
            String query = " select * from Room";
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(10,170,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(175,170,90,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(350,170,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(530,170,100,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JButton search =  new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availabilty = '"+ch.getSelectedItem()+"' ";
                try{
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        JButton back =  new JButton("BACK");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
