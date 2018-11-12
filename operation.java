import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class operation extends JFrame implements ActionListener
{

JTextField t1,t3,t4,t5,t6,t7,t8,t9,t10,tn;
JButton b1,b2,b3,b4,b5;
Font f1,f2;
JLabel l1;
JButton bx;
Connection con;
int cnt;

operation()
{
     Color c=new Color(208,213,225);
     getContentPane().setBackground(Color.white);
     setSize(1200,800);
     show();

  
     b1=new JButton("VOTER LIST");
     b2=new JButton("CANDIDATE LIST");
     b3=new JButton("RESULT");
     b4=new JButton("CANDIDATE REG");
     b5=new JButton("VOTER REG");
     Icon exit=new ImageIcon("cancel.jpg");
               
     f1=new Font("Arial Narrow",Font.BOLD,18);    
     f2=new Font("Rockwell",Font.BOLD,50);
     

     //Icon table=new ImageIcon("table.jpg");


     setLayout(null);
     Icon list=new ImageIcon("list.jpg");
     		Icon table=new ImageIcon("table.PNG");
     l1=new JLabel(list);
     l1.setBounds(50,50,800,622);
     add(l1);
     
     
     b1.setBounds(60,700,220,50);
     b1.setBackground(c);
     b1.setForeground(Color.darkGray);
     b1.setFont(f1);
    // b1.setIcon(table);		
     add(b1);

     b2.setBounds(420,700,300,50);
     b2.setBackground(c);
     b2.setForeground(Color.darkGray);
     b2.setFont(f1);
     //b2.setIcon(table);
     add(b2);

     b3.setBounds(850,700,220,50);
     b3.setBackground(c);
     b3.setForeground(Color.darkGray);
     b3.setFont(f1);
     //b3.setIcon(table);
     add(b3);

     b4.setBounds(850,400,220,50);
     b4.setBackground(c);
     b4.setForeground(Color.darkGray);
     //b4.setIcon(table);
     b4.setFont(f1);
     add(b4);

     b5.setBounds(850,550,220,50);
     b5.setBackground(c);
     b5.setForeground(Color.darkGray);
     //b5.setIcon(table);
     b5.setFont(f1);
     add(b5);

     bx=new JButton();
     bx.setBounds(1150,5,50,40);
     bx.setToolTipText("Exit");
     bx.setBackground(Color.white);
     bx.setIcon(exit);
     add(bx);

	


    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    bx.addActionListener(this);
   

   try
   {
	Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
    
  Statement st=con.createStatement();
   ResultSet rs3 = st.executeQuery("select count(*) from candidate_reg");
	if(rs3.next())
	{
	   cnt=rs3.getInt(1);
	  
   }
   
   }catch (Exception e) { }

}

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==b1)
       {
       //new table().show();
       table t=new table();
		t.setSize(1000,1200);
		t.show();
		dispose();

       }

      if(ae.getSource()==b2)
       {
       //new table().show();
       table1 t=new table1();
		t.setSize(1000,1200);
		t.show();
		dispose();

       }

      if(ae.getSource()==b3)
       {
             new result().show();
             dispose();

    
       }

      if(ae.getSource()==b4)//candidate
       {
         
		// new can_new().show();
         //dispose();

		 if(cnt>=5)
		{
			JOptionPane.showMessageDialog(null,"Sorry !!! 5 candidate already registered");
			new officer().show();
			dispose();
			//System.exit(0);
		}
		else
		{
			new can_new().show();
			dispose();
		}
	
       }

      if(ae.getSource()==b5)//voter
       {
         new re().show();
         dispose();

       }

       if(ae.getSource()==bx)//cancel
       {
         new officer().show();
         dispose();

       }


  }


   public static void main(String ar[])
  {
    operation op=new operation();
  }

}   
