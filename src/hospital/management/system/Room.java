package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;


    Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(98,156,163));
        panel.setLayout(null);
        add(panel);

        //adding Image for Room
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(600,200,200,250);
        panel.add(label);


        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(90,156,163));  // all bg colour
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
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(260,15,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 = new JLabel("Ward Type");
        label4.setBounds(380,15,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JButton back =  new JButton("BACK");
        back.setBounds(200,500,120,30);
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
        setSize(900,600);
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }
}
