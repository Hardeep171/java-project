
package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JTextField t1;
    
    
    
    SignUp3(){
    super("Application form 3");
        l1=new JLabel("Page3 Account Details:");
l1.setFont(new Font("Raleway",Font.BOLD,22));
    
    l2=new JLabel("Account Type:");
l2.setFont(new Font("Raleway",Font.BOLD,20));

l3=new JLabel("Card No:");
l3.setFont(new Font("Raleway",Font.BOLD,20));

l4=new JLabel("XXXX-XXXX-XXXX-9192");
l4.setFont(new Font("Raleway",Font.BOLD,20));

l5=new JLabel("Your 16 Digit Card Number:");
l5.setFont(new Font("Raleway",Font.BOLD,12));

l6=new JLabel("It would Appear On ATM Card/Cheque Book And Statements.");
l6.setFont(new Font("Raleway",Font.BOLD,12));

l7=new JLabel("PIN:");
l7.setFont(new Font("Raleway",Font.BOLD,20));

l8=new JLabel("XXXX");
l8.setFont(new Font("Raleway",Font.BOLD,20));

l9=new JLabel("4-Digit Password:");
l9.setFont(new Font("Raleway",Font.BOLD,20));

l10=new JLabel("Services Required:");
l10.setFont(new Font("Raleway",Font.BOLD,20));

l11=new JLabel("Form No:");
l11.setFont(new Font("Raleway",Font.BOLD,15));
        
b1=new JButton("Submit");
b1.setFont(new Font("Raleway",Font.BOLD,14));
b1.setBackground(Color.black);
b1.setForeground(Color.white);
        
b2=new JButton("Cancel");
b2.setFont(new Font("Raleway",Font.BOLD,14));
b2.setBackground(Color.black);
b2.setForeground(Color.white);

t1= new JTextField();
t1.setFont(new Font("Raleway",Font.BOLD,12));

c1= new JCheckBox("ATM Card");
c1.setBackground(Color.white);
c1.setFont(new Font("Raleway",Font.BOLD,16));

c2= new JCheckBox("InterNet Banking");
c2.setBackground(Color.white);
c2.setFont(new Font("Raleway",Font.BOLD,16));

c3= new JCheckBox("Mobile Banking");
c3.setBackground(Color.white);
c3.setFont(new Font("Raleway",Font.BOLD,16));

c4= new JCheckBox("E-Mail Alerts");
c4.setBackground(Color.white);
c4.setFont(new Font("Raleway",Font.BOLD,16));

c5= new JCheckBox("Cheque BOOK");
c5.setBackground(Color.white);
c5.setFont(new Font("Raleway",Font.BOLD,16));

c6= new JCheckBox("E-Statement");
c6.setBackground(Color.white);
c6.setFont(new Font("Raleway",Font.BOLD,16));

c7= new JCheckBox("I here by declare that the above statements correct to the best of ,y knowledge.",true);
c7.setBackground(Color.white);
c7.setFont(new Font("Raleway",Font.BOLD,12));

r1=new JRadioButton("Saving Account");
r1.setFont(new Font("Raleway",Font.BOLD,16));
r1.setForeground(Color.black);

r2=new JRadioButton("Fixed Deposit Account");
r2.setFont(new Font("Raleway",Font.BOLD,16));
r2.setForeground(Color.black);

r3=new JRadioButton("Current Account");
r3.setFont(new Font("Raleway",Font.BOLD,16));
r3.setForeground(Color.black);

r4=new JRadioButton("Recurring Deposit Account");
r4.setFont(new Font("Raleway",Font.BOLD,16));
r4.setForeground(Color.black);

setLayout(null);

l11.setBounds(700,10,110,30);
add(l11);

t1.setBounds(770,10,40,30);
add(t1);

l1.setBounds(280,50,400,40);add(l1);
l2.setBounds(100,140,200,30);add(l2);

r1.setBounds(100,180,200,30);
add(r1);

r2.setBounds(350,180,250,30);
add(r2);

r3.setBounds(100,220,200,30);
add(r3);

r4.setBounds(350,220,250,30);
add(r4);

l3.setBounds(100,300,200,30);
add(l3);

l4.setBounds(330,300,250,30);
add(l4);

l5.setBounds(100,330,180,18);
add(l5);

l6.setBounds(330,330,400,18);
add(l6);

l7.setBounds(100,370,200,30);
add(l7);

l8.setBounds(330,385,200,30);
add(l8);

l9.setBounds(100,400,200,20);
add(l9);

l10.setBounds(100,450,200,30);
add(l10);

c1.setBounds(100,500,200,30);
add(c1);

c2.setBounds(350,500,200,30);
add(c2);

c3.setBounds(100,550,200,30);
add(c3);

c4.setBounds(350,550,200,30);
add(c4);

c5.setBounds(100,600,200,30);
add(c5);

c6.setBounds(350,600,200,30);
add(c6);
c7.setBounds(100,680,200,20);
add(c7);

b1.setBounds(300,720,100,30);add(b1);
b2.setBounds(420,720,100,30);add(b2);

getContentPane().setBackground(Color.white);
 
setSize(850,850);
setVisible(true);
setLocation(400,200);
b1.addActionListener(this);
b2.addActionListener(this);
}
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
       String a=null;
      
       
       if(r1.isSelected()){
           a="Saving Accout";
       }
       else if(r2.isSelected())
       {
           a="Fixed Deposit Account";
       }
       else if(r3.isSelected()){
           a="Current Account";
       }
       else if(r4.isSelected()){
           a="Recurring Deposit Account";
       }
       
       
       Random ran=new Random();
       long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L ;
       long first8=  Math.abs(first7);
       
       long first3= (ran.nextLong()%9000L)+1000L;
       long first4=Math.abs(first3);
       
       String b="";
       if(c1.isSelected()){
           b= b+"ATM Card";
       }
        if(c2.isSelected()){
           b= b+"Internet Banking";
       }
        if(c3.isSelected()){
           b= b+"Mobile Banking";
       }
         if(c4.isSelected()){
           b= b+"E-Mail Alert";
       }
          if(c5.isSelected()){
           b= b+"Cheque Book";
       }
           if(c6.isSelected()){
           b= b+"E-Statement";
       }
       
       String c=t1.getText();
       try{
           if(e.getSource()==b1){
               if(b.equals("")){
               JOptionPane.showMessageDialog(null, "Fill All Required Fields");
               }else{
           connectionn con=new connectionn();
           String q1=  "insert into signup3 values ('"+c+"','"+a+"','"+first8+"','"+first4+"','"+b+"')";
           String q2=  "insert into login values ('"+first8+"','"+first4+"')";
           String q3= "insert into bank values('"+first4+"',null,null,null,'"+first8+"')";
           con.s.executeUpdate(q1);
           con.s.executeUpdate(q2);
           con.s.executeUpdate(q3);
           JOptionPane.showMessageDialog(null, "Card No:"+first8+"\nPin"+first4);
          
           
           new Deposit().setVisible(true);
           setVisible(false);
         
         
       }
           }
           if(e.getSource()==b2){
               System.exit(0);
           }
           
           
       }catch(HeadlessException | SQLException ae){
           ae.printStackTrace();
       }  
    }
public static void main(String[] args){
    new SignUp3();
  }   
}
