
package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Withdrawl extends JFrame implements ActionListener{

  JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    
    Withdrawl()
    {
       super("Withdrawl");
       
       l1=new JLabel("Daily Withdrawl Limit Is Rs.10,000:");
l1.setFont(new Font("Raleway",Font.BOLD,35));
    
    l2=new JLabel("Please Enter Money For Withdrawl:");
l2.setFont(new Font("Raleway",Font.BOLD,15));

l3=new JLabel("Pin:");
l3.setFont(new Font("Raleway",Font.BOLD,14));

t1= new JTextField();
t1.setFont(new Font("Raleway",Font.BOLD,27));

t2= new JTextField();
t2.setFont(new Font("Raleway",Font.BOLD,14));

        b1=new JButton("Withdrawl");
        b1.setFont(new Font("System",Font.BOLD,18));  
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2=new JButton("Back");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b3=new JButton("Exit");
        b3.setFont(new Font("System",Font.BOLD,18));  
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
       
        setLayout(null);
        l3.setBounds(620,10,150,30);
        add(l3);
        t2.setBounds(700,10,40,30);
        add(t2);
        
        l1.setBounds(150,150,800,60);
        add(l1);
        
        l2.setBounds(280,220,800,60);
        add(l2);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        b1.setBounds(260,380,125,50);
        add(b1);
        
                b2.setBounds(415,380,125,50);
        add(b2);
        
                b3.setBounds(300,550,200,50);
        add(b3);
       
        setSize(800,800);
        setVisible(true);
        setLocation(400,200);
        getContentPane().setBackground(Color.white);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String a=t1.getText();
            String b=t2.getText();
            
            if(e.getSource()==b1){
                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER THE AMAUNT TO Withdrawl:");
                }
                else{
                    connectionn con= new connectionn();
                    ResultSet rs= con.s.executeQuery("select * from bank where pin ='"+b+"' ");
                    double balance;
                    if(rs.next()){
                        String pin= rs.getString("pin");
                        balance= rs.getDouble("balance");
                         double d= Double.parseDouble(a);
                         balance-=d;
                           String cr="";
                         String db="Debitted";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+b+"' ";
                     //    String q1="insert into bank values ('"+pin+"',null,'"+d+"','"+balance+"')";
                         con.s.executeUpdate(q1);
                    
                    JOptionPane.showMessageDialog(null,"Rs."+a+" Debbited Sucessfully:");
                    new Transactions().setVisible(true);
                    setVisible(false);
                    }
                    else{
                         JOptionPane.showMessageDialog(null,"Wrong Pin Number:"); 
                    }

                }
            }
            else if(e.getSource()==b2){
                new Transactions().setVisible(true);
                setVisible(false);
            }
            else if(e.getSource()==b3){
                System.exit(0);
            }
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }
        public static void main(String[] args){
 new Withdrawl();
  }   
}
