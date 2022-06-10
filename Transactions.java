
package banking.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    Transactions()
    {
        super("TRANSACTION");
        l1=new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System",Font.BOLD,38));
        
        b1=new JButton("DEPOSIT");
        b1.setFont(new Font("System",Font.BOLD,10));  
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2=new JButton("CASH WITHDRAWL");
        b2.setFont(new Font("System",Font.BOLD,10));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b3=new JButton("FAST CASH");
        b3.setFont(new Font("System",Font.BOLD,10));  
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        
        
        b4=new JButton("Transfer");
        b4.setFont(new Font("System",Font.BOLD,10)); 
        b4.setBackground(Color.black);
b4.setForeground(Color.white);
        b5=new JButton("PIN CHANGE");
        b5.setBackground(Color.black);
b5.setForeground(Color.white);
b5.setFont(new Font("System",Font.BOLD,10));    
        b6=new JButton("BALANCE ENQUIERY");
        b6.setFont(new Font("System",Font.BOLD,10));
b6.setBackground(Color.black);
b6.setForeground(Color.white);

        b7=new JButton("EXIT");
        b7.setFont(new Font("System",Font.BOLD,10));  
        b7.setBackground(Color.black);
b7.setForeground(Color.white);

setLayout(null);
l1.setBounds(100,80,700,40);
add(l1);
b1.setBounds(170,180,150,50);
add(b1);
b2.setBounds(440,180,150,50);
add(b2);
b3.setBounds(170,280,150,50);
add(b3);
b4.setBounds(440,280,150,50);
add(b4);
b5.setBounds(170,380,150,50);
add(b5);
b6.setBounds(440,380,150,50);
add(b6);
b7.setBounds(305,480,150,50);
add(b7);

getContentPane().setBackground(Color.white);
setSize(750,750);
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
   if(e.getSource()==b1){
       new Deposit().setVisible(true);
       setVisible(false);
   }
   else if(e.getSource()==b2)
   {
       new Withdrawl().setVisible(true);
       setVisible(false);
   }
   else if(e.getSource()==b3){
       new FastCash().setVisible(true);
       setVisible(false);
   }
   else if(e.getSource()==b4){
       new TransferMoney().setVisible(true);
       setVisible(false);
   }
   else if(e.getSource()==b5){
      new PinChange().setVisible(true);
       setVisible(false);
   }
   else if(e.getSource()==b6){
       String pinn=JOptionPane.showInputDialog("Enter Pin");
       connectionn c1=new connectionn();
       try{
           ResultSet rs=c1.s.executeQuery("select balance from bank where pin ='"+pinn+"' ");
          
           if(rs.next()){
              
           String balance=rs.getString("balance");
           JOptionPane.showMessageDialog(null,"YOUR ACCOUNT BALANCE IS Rs:"+balance);
           }
           
           else{
               JOptionPane.showMessageDialog(null,"Wrong Pin Number");
           }
       }catch(Exception ae){
           ae.printStackTrace();
       }
   }
   else if(e.getSource()==b7){
       System.exit(0);
   }
   
    }
    public static void main(String[] args){
 new Transactions();
  }   
}
