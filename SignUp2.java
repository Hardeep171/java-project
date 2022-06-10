
package banking.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class SignUp2 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3;
    JButton b;
    JComboBox c1,c2,c3,c4,c5;
    JRadioButton r1,r2,r3,r4;
   
    
    SignUp2 ()
    { 
    super();
    
l1=new JLabel("Page2 Additional Details:");
l1.setFont(new Font("Raleway",Font.BOLD,22));
    
    l2=new JLabel("Religion:");
l2.setFont(new Font("Raleway",Font.BOLD,20));

l3=new JLabel("Category:");
l3.setFont(new Font("Raleway",Font.BOLD,20));

l4=new JLabel("Income:");
l4.setFont(new Font("Raleway",Font.BOLD,20));

l5=new JLabel("Education:");
l5.setFont(new Font("Raleway",Font.BOLD,20));

l6=new JLabel("Qualification:");
l6.setFont(new Font("Raleway",Font.BOLD,20));

l7=new JLabel("occupation:");
l7.setFont(new Font("Raleway",Font.BOLD,20));

l8=new JLabel("Pan Number:");
l8.setFont(new Font("Raleway",Font.BOLD,20));

l9=new JLabel("Aadhar Number:");
l9.setFont(new Font("Raleway",Font.BOLD,20));

l10=new JLabel("Senior Citizen:");
l10.setFont(new Font("Raleway",Font.BOLD,20));

l11=new JLabel("Exsisting Account:");
l11.setFont(new Font("Raleway",Font.BOLD,20));
    
l12=new JLabel("Form No:");
l12.setFont(new Font("Raleway",Font.BOLD,13));

b=new JButton("NEXT");
b.setFont(new Font("Raleway",Font.BOLD,14));
b.setBackground(Color.black);
b.setForeground(Color.white);

t1= new JTextField();
t1.setFont(new Font("Raleway",Font.BOLD,14));

t2= new JTextField();
t2.setFont(new Font("Raleway",Font.BOLD,14));

t3= new JTextField();
t3.setFont(new Font("Raleway",Font.BOLD,14));


r1=new JRadioButton("Yes");
r1.setFont(new Font("Raleway",Font.BOLD,14));
r1.setForeground(Color.black);


r2=new JRadioButton("No");
r2.setFont(new Font("Raleway",Font.BOLD,14));
r2.setForeground(Color.black);

r3=new JRadioButton("Yes");
r3.setFont(new Font("Raleway",Font.BOLD,14));
r3.setForeground(Color.black);

r4=new JRadioButton("No");
r4.setFont(new Font("Raleway",Font.BOLD,14));
r4.setForeground(Color.black);

String religion[]={"Hindu","Sikh","Christian","other"};
c1= new JComboBox(religion);
c1.setBackground(Color.white);
c1.setFont(new Font("Raleway",Font.BOLD,14));



String category[]={"General","Obc","Sc","St","other"};
c2= new JComboBox(category);
c2.setBackground(Color.white);
c2.setFont(new Font("Raleway",Font.BOLD,14));

String income[]={"NULL","10k","20","30k","40","50k","above 50k","above 100k","above 200k"};
c3= new JComboBox(income);
c3.setBackground(Color.white);
c3.setFont(new Font("Raleway",Font.BOLD,14));

String education[]={"Gratuate","Post-Graduate","Non-Graduate","Others"};
c4= new JComboBox(education);
c4.setBackground(Color.white);
c4.setFont(new Font("Raleway",Font.BOLD,14));

String occupation[]={"Salaried","Self-Employed","Buisness","Student","Required","Others"};
c5= new JComboBox(occupation);
c5.setBackground(Color.white);
c5.setFont(new Font("Raleway",Font.BOLD,14));

    setLayout(null);
    
l12.setBounds(700,10,60,30);add(l12);//form no
t3.setBounds(760,10,60,30);//ftf
add(t3);

l1.setBounds(280,30,600,40);add(l1);
l2.setBounds(100,120,100,30);add(l2);
c1.setBounds(350,120,100,30);
add(c1);
l3.setBounds(100,170,100,30);
add(l3);
c2.setBounds(350,170,320,30);
add(c2);

l4.setBounds(100,220,100,30);
add(l4);
c3.setBounds(350,220,320,30);
add(c3);

l5.setBounds(100,270,150,30);
add(l5);
l6.setBounds(100,300,150,30);
add(l6);

c4.setBounds(350,270,320,30);
add(c4);



l7.setBounds(100,340,150,30);
add(l7);
c5.setBounds(350,340,320,30);
add(c5);



l8.setBounds(100,390,180,30);
add(l8);
t1.setBounds(350,390,320,30);
add(t1);

l9.setBounds(100,440,180,30);
add(l9);
t2.setBounds(350,440,320,30);
add(t2);




l11.setBounds(100,540,180,30);
add(l11);
r1.setBounds(350,540,100,30);
add(r1);

r2.setBounds(460,540,100,30);
add(r2);



l10.setBounds(100,590,180,30);
add(l10);
r3.setBounds(350,590,100,30);
add(r3);

r4.setBounds(460,590,100,30);
add(r4);

b.setBounds(570,670,100,30);
add(b);
getContentPane().setBackground(Color.WHITE);

setSize(850,850);
setVisible(true);
setLocation(400,100);

b.addActionListener(this);
         }

    @Override
    public void actionPerformed(ActionEvent ae) {
     String a=(String)c1.getSelectedItem();
     String b=(String)c2.getSelectedItem();
     String c=(String)c3.getSelectedItem();
     String d=(String)c4.getSelectedItem();
     String e=(String)c5.getSelectedItem();
String f=t1.getText();
String g=t2.getText();

String h="";
if(r1.isSelected()){
    h="yes";
}else if(r2.isSelected()){
    h="no";
}
String i="";
if(r3.isSelected()){
    i="yes";
}else if(r4.isSelected()){
    i="no";
}
String j=t3.getText();


try{
    
    if(t2.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Fill All The Required Fields");
    }
    else{
       connectionn con=new connectionn();
       String q1=" insert into signUp2 values('"+j+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"' )";
       con.s.executeUpdate(q1);
       
       new SignUp3().setVisible(true);
       setVisible(false);
    }
}
catch(HeadlessException | SQLException ex){
          ex.printStackTrace();
      }
    }

public static void main(String[] args){
    new SignUp2();
}   
}
