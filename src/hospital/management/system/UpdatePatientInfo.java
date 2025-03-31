package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdatePatientInfo extends JFrame {

    UpdatePatientInfo(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,60,250,250);
        panel.add(label);

        JLabel label1 = new JLabel("Updated Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,17));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,80,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice ch = new Choice();
        ch.setBounds(248,85,100,25);
        panel.add(ch);

        try{
            String query = " select * from patient_info";
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(query);
            while(rs.next()){
                ch.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,130,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        //for Room
        JTextField textField = new JTextField();
        textField.setBounds(248,129,140,20);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldInTime = new JTextField();
        textFieldInTime.setBounds(248,174,140,20);
        panel.add(textFieldInTime);


        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25,216,120,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending AMount (Rs) :");
        label6.setBounds(25,261,170,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);


        JButton check =  new JButton("CHECK");
        check.setBounds(281,378,90,24);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = ch.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"' ";

                try{
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery(q);
                    while(rs.next()){
                        textField.setText(rs.getString("Room_Number"));
                        textFieldInTime.setText(rs.getString("Time"));
                        textFieldAmount.setText(rs.getString("Deposite"));
                    }
                    String query1 = "select * from Room where Room_no= '"+textField.getText()+"'";
                    ResultSet rs1 = c.statement.executeQuery(query1);
                    while(rs1.next()){
                        String price = rs1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);

                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton update =  new JButton("Update");
        update.setBounds(56,378,90,24);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String qq = ch.getSelectedItem();
                    String room =textField.getText();
                    String time = textFieldInTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"',Time = '"+time+"', Deposite = '"+amount+"' where name = '"+qq+"'");
                    JOptionPane.showMessageDialog(null,"Updated SuccessFully");
                    setVisible(false);

                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        JButton back =  new JButton("BACK");
        back.setBounds(165,378,90,24);
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
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdatePatientInfo();
    }
}
