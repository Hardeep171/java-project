
package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    JTextField t1,t2,t3;
    JButton b1,b2;
    JLabel l1,l2,l3,l4;
    
    PinChange()
    {
        super("PinChange");
        l1=new JLabel("CHANGE YOUR PIN:");
        l1.setFont(new Font("Raleway",Font.BOLD,35));
        
        l2=new JLabel("Current PIN:");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        
        l3=new JLabel("New Pin:");
        l3.setFont(new Font("Raleway",Font.BOLD,22));
        
        l4=new JLabel("Confirm New Pin:");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        
                t2=new JTextField();
        t2.setFont(new Font("Raleway",Font.BOLD,22));
                t3=new JTextField();
        t3.setFont(new Font("Raleway",Font.BOLD,22));
        
         b1=new JButton("Save");
        b1.setFont(new Font("System",Font.BOLD,18));  
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2=new JButton("Back");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(220,130,800,60);
        add(l1);
        
        l2.setBounds(100,240,150,40);
        add(l2);
        
        l3.setBounds(100,300,150,40);
        add(l3);
        
        l4.setBounds(100,360,200,40);
        add(l4);
        
        t1.setBounds(310,240,360,40);
        add(t1);
        t2.setBounds(310,300,360,40);
        add(t2);
        t3.setBounds(310,360,360,40);
        add(t3);
        b1.setBounds(220,460,160,50);
        add(b1);
        b2.setBounds(400,460,160,50);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,800);
        setLocation(400,200);
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       try{
           String a=t1.getText();
           String b=t2.getText();
           String c=t3.getText();
           
           if(ae.getSource()==b1){
               if(t1.getText()==""){
                   JOptionPane.showMessageDialog(null,"Please Enter Current Pin:");
               }
               if(t2.getText()==""){
                   JOptionPane.showMessageDialog(null,"Please Enter New Pin:");
               }
                if(t3.getText()==""){
                   JOptionPane.showMessageDialog(null,"Please Confirm New Pin:");
               }
                if(t2.getText().equals(t3.getText())){
                    connectionn con=new connectionn();
                    String q1="update bank set pin ='"+b+"' where pin='"+a+"' ";
                    String q2="update login set pin ='"+b+"' where pin='"+a+"' ";
                    String q3="update signup3 set pin='"+b+"' where pin='"+a+"' ";
                    con.s.executeUpdate(q1);
                    con.s.executeUpdate(q2);
                    con.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                    new Transactions().setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Pin Entered Dosen't Match");
                }
           }
           if(ae.getSource()==b2){
                                   new Transactions().setVisible(true);
                    setVisible(false);
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
      
    }
    
            public static void main(String[] args){
 new PinChange();
  }   
    
}
