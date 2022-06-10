package banking.application;
import java.sql.*;
public class connectionn{
Connection c;
Statement s,s1;
public connectionn(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql:///project1","root","");
        s=c.createStatement();
        s1=c.createStatement();
    }
    catch (ClassNotFoundException | SQLException e){
        System.out.println(e);
    }
  }
}