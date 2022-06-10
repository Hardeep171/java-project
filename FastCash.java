
package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField t1;
    
FastCash()
{
    super("Fast Cash");
    
    l1=new JLabel("SELECT CASH WITHDRAWL AMOUNT:");
l1.setFont(new Font("Raleway",Font.BOLD,35));

l2=new JLabel("Pin:");
l2.setFont(new Font("Raleway",Font.BOLD,13));

t1= new JTextField();
t1.setFont(new Font("Raleway",Font.BOLD,13));

   b1=new JButton("100");
        b1.setFont(new Font("System",Font.BOLD,18));  
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2=new JButton("500");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b3=new JButton("1000");
        b3.setFont(new Font("System",Font.BOLD,18));  
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        
        
        b4=new JButton("2000");
        b4.setFont(new Font("System",Font.BOLD,18)); 
        b4.setBackground(Color.black);
b4.setForeground(Color.white);
        b5=new JButton("5000");
        b5.setBackground(Color.black);
b5.setForeground(Color.white);
b5.setFont(new Font("System",Font.BOLD,18));    
        b6=new JButton("10000");
        b6.setFont(new Font("System",Font.BOLD,18));
b6.setBackground(Color.black);
b6.setForeground(Color.white);

        b7=new JButton("Exit");
        b7.setFont(new Font("System",Font.BOLD,18));  
        b7.setBackground(Color.black);
b7.setForeground(Color.white);




setLayout(null);
l2.setBounds(640,10,60,40);
add(l2);
t1.setBounds(710,10,60,40);
add(t1);

l1.setBounds(100,100,700,40);
add(l1);

b1.setBounds(40,250,300,60);
add(b1);

b2.setBounds(440,250,300,60);
add(b2);

b3.setBounds(40,360,300,60);
add(b3);

b4.setBounds(440,360,300,60);
add(b4);

b5.setBounds(40,470,300,60);
add(b5);

b6.setBounds(440,470,300,60);
add(b6);

b7.setBounds(240,600,300,60);
add(b7);

//b8.setBounds(240,600,300,60);
//add(b8);

getContentPane().setBackground(Color.white);

setSize(800,800);
setVisible(true);
setLocation(400,200);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
}


    @Override
    public void actionPerformed(ActionEvent e) {
            try{
    String a= t1.getText();
    double balance=0;
    
    
    
    
    if(e.getSource()==b1){
        connectionn con=new connectionn();
        ResultSet rs= con.s.executeQuery(" select * from bank where pin= '"+a+"'   ");
        
        if(rs.next()){
            String pin= rs.getString("pin");
            balance= rs.getDouble("balance");
            balance-=100;
             String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+a+"' ";
         
            con.s.executeUpdate(q1);
        
        JOptionPane.showMessageDialog(null,"Rs.'"+100+"' Debbited Successfully   ");
        new Transactions().setVisible(true);
        setVisible(false);
        }
        else{
             JOptionPane.showMessageDialog(null,"Wrong Pin Number:\n  Please Enter Correct Pin and then Withdraw "); 
        }
    }
    
    else    if(e.getSource()==b2){
        connectionn con=new connectionn();
        ResultSet rs= con.s.executeQuery(" select * from bank where pin= '"+a+"' ");
        
        if(rs.next()){
            String pin= rs.getString("pin");
            balance= rs.getDouble("balance");
            balance-=500;
            String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+a+"' ";
            con.s.executeUpdate(q1);
        
        JOptionPane.showMessageDialog(null,"Rs.'"+500+"' Debbited Successfully   ");
        new Transactions().setVisible(true);
        setVisible(false);
        }
        else{
             JOptionPane.showMessageDialog(null,"Wrong Pin Number:\n  Please Enter Correct Pin and then Withdraw "); 
        }
    }
    
     else   if(e.getSource()==b3){
         connectionn con=new connectionn();
        ResultSet rs= con.s.executeQuery(" select * from bank where pin= '"+a+"'   ");
        
        if(rs.next()){
            String pin= rs.getString("pin");
            balance= rs.getDouble("balance");
            balance-=1000;
            String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+a+"' ";
            con.s.executeUpdate(q1);
        
        JOptionPane.showMessageDialog(null,"Rs.'"+1000+"' Debbited Successfully   ");
        new Transactions().setVisible(true);
        setVisible(false);}
        else{
             JOptionPane.showMessageDialog(null,"Wrong Pin Number:\n   Please Enter Correct Pin and then Withdraw "); 
        }
    }
    
      else  if(e.getSource()==b4){
          connectionn con=new connectionn();
        ResultSet rs= con.s.executeQuery(" select * from bank where pin= '"+a+"'   ");
        
        if(rs.next()){
            String pin= rs.getString("pin");
            balance= rs.getDouble("balance");
            balance-=2000;
            String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+a+"' ";
            con.s.executeUpdate(q1);
        
        JOptionPane.showMessageDialog(null,"Rs.'"+2000+"' Debbited Successfully   ");
        new Transactions().setVisible(true);
        setVisible(false);
        }
        else{
             JOptionPane.showMessageDialog(null,"Wrong Pin Number:\n  Please Enter Correct Pin and then Withdraw "); 
        }
    }
     
      else  if(e.getSource()==b5){
          connectionn con=new connectionn();
        ResultSet rs= con.s.executeQuery(" select * from bank where pin= '"+a+"'   ");
        
        if(rs.next()){
            String pin= rs.getString("pin");
            balance= rs.getDouble("balance");
            balance-=5000;
            String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+a+"' ";
            con.s.executeUpdate(q1);
        
        JOptionPane.showMessageDialog(null,"Rs.'"+5000+"' Debbited Successfully   ");
        new Transactions().setVisible(true);
        setVisible(false);
        }
        else{
             JOptionPane.showMessageDialog(null,"Wrong Pin Number:\nPlease Enter Correct Pin and then Withdraw "); 
        }
    }
    
      else if(e.getSource()==b6){
          connectionn con=new connectionn();
        ResultSet rs= con.s.executeQuery(" select * from bank where pin= '"+a+"'   ");
        
        if(rs.next()){
            String pin= rs.getString("pin");
            balance= rs.getDouble("balance");
            balance-= 10000;
           String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+a+"' ";
            con.s.executeUpdate(q1);
        
        JOptionPane.showMessageDialog(null,"Rs.'"+10000+"' Debbited Successfully   ");
        new Transactions().setVisible(true);
        setVisible(false);
        }
        else{
             JOptionPane.showMessageDialog(null,"Wrong Pin Number:\n   Please Enter Correct Pin and then Withdraw"); 
        }
    }
    
    if(e.getSource()==b7){
        System.exit(0);
    }
   
}
            catch(SQLException | HeadlessException ae){
    ae.printStackTrace();
}
    }
    
    public static void main(String[] args){
        new FastCash();
    }
    
    
    
}
