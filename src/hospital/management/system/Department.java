package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    JTable table;
    Department(){

        JPanel panel =  new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        table = new JTable();
        table.setBounds(5,40,700,350);
        table.setBackground(new Color(90,156,163));  // all bg colour
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            String query = " select * from department;";
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(12,15,100,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone No.");
        label2.setBounds(350,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JButton back =  new JButton("BACK");
        back.setBounds(400,410,130,30);
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
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
