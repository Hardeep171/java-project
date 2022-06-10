package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1,b2,b3;
    
    Login()
    {
        super("ATM");
      l1=new JLabel("WELCOME TO ATM");
      l1.setFont(new Font("Osward",Font.BOLD,38));
      
            l2=new JLabel("Card NO:");
      l2.setFont(new Font("Raleway",Font.BOLD,28));
      
            l3=new JLabel("PIN:");
      l3.setFont(new Font("Raleway",Font.BOLD,28));
      
      tf1=new JTextField(15);
      pf1=new JPasswordField(15);
      
      b1=new JButton("Sign IN");
      b1.setBackground(Color.black);
      b1.setForeground(Color.white);
      
      b2=new JButton("CLEAR");
      b2.setBackground(Color.black);
      b2.setForeground(Color.white);     
      
      b3=new JButton("Sign UP");
      b3.setBackground(Color.black);
      b3.setForeground(Color.white);
      
      setLayout(null);
      
      l1.setBounds(175,50,450,200);
      add(l1);
      
      l2.setBounds(125,150,375,200);
      add(l2);
      
      
      l3.setBounds(125,225,375,200);
      add(l3);
    
    tf1.setFont(new Font("Arial",Font.BOLD,14));
    tf1.setBounds(300,235,230,30);
    add(tf1);
    
    pf1.setFont(new Font("Arial",Font.BOLD,14));
    pf1.setBounds(300,310,230,30);
    add(pf1);
    
    b1.setFont(new Font("Arial",Font.BOLD,14));
    b1.setBounds(300,400,100,30);
    add(b1);
    
    b2.setFont(new Font("Arial",Font.BOLD,14));
    b2.setBounds(430,400,100,30);
    add(b2);
    
    b3.setFont(new Font("Arial",Font.BOLD,14));
    b3.setBounds(300,450,230,30);
    add(b3);
   
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    
    getContentPane().setBackground(Color.WHITE);
    setSize(750,750);
    setLocation(400,200);
    setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
          connectionn c1=new connectionn();  
          String a = tf1.getText();
          String b = pf1.getText();
          String q = " select * from login where cardno = '"+a+"' and pin = '"+b+"' ";
          ResultSet rs= c1.s.executeQuery(q);
          
          if(ae.getSource()==b1)
          {
              if(rs.next()){
                  
                 new Transactions().setVisible(true);
                  setVisible(false);
              }
              else {
                  JOptionPane.showMessageDialog(null,"Incorrect card no OR Password:");
              }
          }
          else
           if(ae.getSource()==b2){
                      tf1.setText("");
                      pf1.setText("");
                      }
              else 
               if(ae.getSource()==b3){
                      new SignUp().setVisible(true);
                      setVisible(false);
                      }
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Error"+ex);
        }
    
}
    public static void main(String[] args){
    new Login();
}
}
