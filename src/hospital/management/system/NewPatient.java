package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField textFieldNumber, textName,textFieldDisease,textFieldDeposite;

    JRadioButton r1,r2;

    Choice c1;

    JLabel date;

    JButton b1, b2;

    NewPatient(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("New PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID: ");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,15));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        //create drop down for selecting the type of ID you can select
        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter ID","Driving Licence","Passport ID"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("ID Number : ");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,15));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name : ");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,15));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,15));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 =  new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,15));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,174));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2 =  new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,174));
        r2.setBounds(380,191,80,15);
        panel.add(r2);


        JLabel labelDisease = new JLabel("Disease Name: ");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,15));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);


        JLabel labelRoom = new JLabel("Room: ");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        //create Room table pending
        c1= new Choice();
        try{
            conn c = new conn();
            ResultSet rs =  c.statement.executeQuery("select * from Room");
            while(rs.next()){
                c1.add(rs.getString("Room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,15));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);


        // system date and time
        JLabel labelDate = new JLabel("Time: ");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,15));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 =  new Date();
        date = new JLabel(""+date1);
        date.setBounds(271,316,250,15);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(date);


        JLabel labelDeposite = new JLabel("Deposite: ");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,15));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271,359,150,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        panel.add(b1);

        setUndecorated(true);
        b2 = new JButton("BACK");
        b2.setBounds(260,430,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        panel.add(b2);





        setSize(850,550);
        setLayout(null);
        setLocation(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        //adding new patient
        new NewPatient();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            conn c = new conn();
            String radioBtn = null;
            if(r1.isSelected()){
                radioBtn = "Male";
            }else if(r2.isSelected()){
                radioBtn ="Female";
            }
            String s1 = (String) comboBox.getSelectedItem();

            String s3 = textName.getText();
            String s4 = radioBtn;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();
            String s2 = textFieldNumber.getText();

            try{
                String query = "Insert into patient_info values ('"+s1+"','"+s3+"','"+s4+"', '"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s2+"')";
                String q1 =  "update Room set Availabilty = 'Occupied' where Room_no = "+s6;
                c.statement.executeUpdate(query);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            }catch (Exception e1){
                e1.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}
