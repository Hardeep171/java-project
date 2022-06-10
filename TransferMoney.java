
package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class TransferMoney extends JFrame  implements ActionListener{

    JLabel l1,l2,l3,l4,l5;
    JTextField tf1,tf2,tf3;
    JPasswordField pf1;
    JButton b1,b2,b3,b4,b5,b6,b7;   
    String a,b,c,Accountno;
    double bal;
    TransferMoney(){
     

        
        super("MoneyTransfer");

         l1=new JLabel("Money Transfer");
      l1.setFont(new Font("Raleway",Font.BOLD,38));
      
            l2=new JLabel("Debit A/c NO:");
      l2.setFont(new Font("Raleway",Font.BOLD,28));
      
            l3=new JLabel("PIN:");
      l3.setFont(new Font("Raleway",Font.BOLD,28));
      
      l4=new JLabel("Credit A/c NO:");
      l4.setFont(new Font("Raleway",Font.BOLD,28));
      
    l5=new JLabel("Amount:");
      l5.setFont(new Font("Raleway",Font.BOLD,28));
      
    
      
      tf1=new JTextField(15);
     
      
      tf2=new JTextField(15);
    
     tf3= new JTextField();
tf3.setFont(new Font("Raleway",Font.BOLD,27));
      
      pf1=new JPasswordField(15);
     
      
      b1=new JButton("CLEAR1");
      b1.setBackground(Color.black);
      b1.setForeground(Color.white);
      
      
      
      b2=new JButton("CLEAR2");
      b2.setBackground(Color.black);
      b2.setForeground(Color.white); 
      
   
      
      b3=new JButton("Transfer");
      b3.setBackground(Color.black);
      b3.setForeground(Color.white);
     
      
            b4=new JButton("BACK1");
      b4.setBackground(Color.black);
      b4.setForeground(Color.white);
     
                
      
      b5=new JButton("EXIT");
      b5.setBackground(Color.black);
      b5.setForeground(Color.white);
     
      setLayout(null);
      
      l1.setBounds(255,0,450,200);
      add(l1);
      
      l2.setBounds(130,80,375,200);
     add(l2);
      
      
      l3.setBounds(130,140,375,200);
      add(l3);
    
      l4.setBounds(130,250,375,200);
add(l4);
      l5.setBounds(130,300,375,200);
    add(l5);
    
    tf3.setBounds(350,390,230,30);add(tf3);
      
      tf2.setFont(new Font("Arial",Font.BOLD,14));
    tf2.setBounds(350,337,230,30);
  add(tf2);
      
    
    tf1.setFont(new Font("Arial",Font.BOLD,14));
    tf1.setBounds(350,167,230,30);
    add(tf1);
    
    
    pf1.setBounds(350,227,230,30);
   add(pf1);
    
  
   b1.setBounds(600,335,100,30);
  add(b1);
  
 

    
    
    b2.setBounds(430,270,100,30);
    add(b2);
    

    b4.setBounds(340,490,100,30);
    add(b4);
   
 b3.setBounds(470,490,100,30);
      add(b3);
  
            
    b5.setBounds(400,590,130,50);
    add(b5);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    
    
 
    
    getContentPane().setBackground(Color.WHITE);
    setSize(780,800);
    setLocation(400,200);
    setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
                try{
            
           a = tf1.getText();
           b = pf1.getText();
           c= tf2.getText();
         String  cc=tf3.getText();
          
          
            connectionn con= new connectionn();
             ResultSet r=con.s.executeQuery("select balance from bank where accountno='"+c+"' ");
             while(r.next()){
        
         bal= r.getDouble("balance");
             }
                        if(e.getSource()==b3) {
                            if(tf1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER THE ALL REQUIRED FIELDS");
                }
                            
                else{
                 
                    ResultSet rs= con.s.executeQuery("select * from bank where accountno = '"+a+"' and pin ='"+b+"' ");
                   
                    double balance;
                  
                    
                    if(rs.next()){
                      // String pin=rs.getString("pin");
                        balance= rs.getDouble("balance");
                       
                         double d= Double.parseDouble(cc);
                         
                         if(balance>d){
                         
                             balance-=d;
                         bal +=d;
                           String cr="";
                         String db="Debitted";
                         String crr="credited";
                         String dbb="";
                         String q1=  " update bank  set deposit='"+cr+"',withdrawl='"+db+"',balance='"+balance+"' where pin ='"+b+"' ";
                         String q2=" update bank  set deposit='"+crr+"',withdrawl='"+dbb+"',balance='"+bal+"' where accountno='"+c+"' ";
                         con.s.executeUpdate(q1);
                         con.s.executeUpdate(q2);
                    
                    JOptionPane.showMessageDialog(null,"Rs."+cc+" Transfer Sucessfully:");
                    new Transactions().setVisible(true);
                    setVisible(false);
                    
                         }else{
                             JOptionPane.showMessageDialog(null,"INSUFFICENT BALANCE");
                             tf3.setText("");
                         }
                    
                    }
            
                    else{
                         JOptionPane.showMessageDialog(null,"Wrong Pin Number Or Debit A/c Number :"); 
                    }
                            
              }
                        }
         
                        else if(e.getSource()==b2){
                               tf1.setText("");
                               pf1.setText("");
                        }
                         else if(e.getSource()==b1){
                            tf2.setText("");
                        }
                         else if(e.getSource()==b4){
                            new Transactions().setVisible(true);
                  setVisible(false);
                        }
                         else if(e.getSource()==b5){
                            System.exit(0);
                        }
          
                }
                catch(Exception ae){
                 ae.printStackTrace();
                }
    }
        public static void main(String[] args){
              new TransferMoney();
  }  
}
    
    
