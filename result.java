import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class result extends JFrame implements ActionListener
{

JLabel lt,l1,l2,l5;
Font f2;
Connection con;
JButton b3;

    result()

 {
   getContentPane().setBackground(Color.black);
   setSize(1200,640);
   show();

   Icon exit=new ImageIcon("cancel.jpg");



   f2=new Font("Calibri",Font.BOLD,50);
   
   setLayout(null);

   lt=new JLabel("WINNER");
   lt.setFont(f2);
   lt.setBounds(100,100,500,150);
   lt.setForeground(Color.white);
   add(lt);
 
   l1=new JLabel("IS");
   l1.setFont(f2);
   l1.setBounds(330,200,500,150);
   l1.setForeground(Color.white);
   add(l1);

   l2=new JLabel();
   l2.setFont(f2);
   l2.setBounds(370,320,500,150);
   l2.setForeground(Color.white);
   add(l2);


     try
   {
	Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
    

        
   }

    catch(Exception e){ System.out.println("err1"+e);}

   try
   {

    Statement ps=con.createStatement();
    ResultSet rs=ps.executeQuery("select Name from candidate_reg where vote=(select max(vote) from candidate_reg)");/*ResultSet starts from 0 but data in the result set is positioned to 1 so 
increment the pointer*/
    
    rs.next();
    l2.setText(rs.getString("Name").toUpperCase());
    add(l2);
    

   }catch(Exception e){System.out.println("err"+e);}

   b3=new JButton();
   b3.setBounds(1145,5,50,40);
   b3.setToolTipText("Exit");
   b3.setBackground(Color.white);
   b3.setIcon(exit);
   add(b3);

   b3.addActionListener(this);



Icon congo=new ImageIcon("congo.gif");
		l5=new JLabel(congo);
    		l5.setBounds(600,160,624,552);
    		add(l5);		



 }

 public void actionPerformed(ActionEvent ae)
 {

     new operation().show();
     dispose();

 }


public static void main(String ar[])
  {

      result r=new result();


  }


}
