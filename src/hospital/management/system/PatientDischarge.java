package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame {

    PatientDischarge(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label1 = new JLabel("Customer ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);

        //for taking Id using Drop down button
        Choice ch = new Choice();
        ch.setBounds(200,80,150,25);
        panel.add(ch);

        try{
            String query = " select * from patient_info";
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(query);
            while(rs.next()){
                ch.add(rs.getString("Number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel rno = new JLabel("Room No.");
        rno.setBounds(30,130,150,20);
        rno.setFont(new Font("Tahoma",Font.BOLD,14));
        rno.setForeground(Color.white);
        panel.add(rno);

        JLabel label3 = new JLabel();
        label3.setBounds(200,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Check In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel inTime = new JLabel();
        inTime.setBounds(200,180,250,20);
        inTime.setFont(new Font("Tahoma",Font.BOLD,14));
        inTime.setForeground(Color.white);
        panel.add(inTime);

        JLabel checkOut = new JLabel("Out Time");
        checkOut.setBounds(30,230,150,20);
        checkOut.setFont(new Font("Tahoma",Font.BOLD,14));
        checkOut.setForeground(Color.white);
        panel.add(checkOut);

        Date date = new Date();
        JLabel outTIme = new JLabel(""+date);
        outTIme.setBounds(200,230,250,20);
        outTIme.setFont(new Font("Tahoma",Font.BOLD,14));
        outTIme.setForeground(Color.white);
        panel.add(outTIme);

        JButton discharge =  new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    String q = "delete from patient_info where Number = '" + ch.getSelectedItem() + "'";
                    c.statement.executeUpdate(q);
                    String q1 = "update room set Availabilty = 'Available' where Room_no = '"+rno.getText()+"' ";
                    c.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        JButton check =  new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    String query = " select * from patient_info where Number = '"+ch.getSelectedItem()+"' ";
                    ResultSet rs = c.statement.executeQuery(query);
                    while(rs.next()){
                        rno.setText(rs.getString("Room_Number"));
                        inTime.setText(rs.getString("Time"));
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton back =  new JButton("Back");
        back.setBounds(300,300,120,30);
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
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientDischarge();
    }
}
