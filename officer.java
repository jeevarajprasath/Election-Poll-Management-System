import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class officer extends JFrame implements ActionListener
{

JTextField t1,t3,t4,t5,t6,t7,t8,t9,t10,tn;
JButton b1,b2,b3;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,ln,lt;
JPasswordField p;
String a,b,c;
Boolean z1,z2,z3,z4;
Connection con;



   officer()
 {
    // super("MyApp");
   
     Icon exit=new ImageIcon("cancel.jpg");
     getContentPane().setBackground(Color.white);
     setSize(900,640);
     show();

    lt=new JLabel("ELECTION OFFICER LOGIN");
    l1=new JLabel("Username");
    l2=new JLabel("Password");
    l3=new JLabel();
    //l4=new JLabel("Create account");

    t1=new JTextField();
    p=new JPasswordField();

    b1=new JButton("LOGIN");
    
    setLayout(null);

    Icon officer=new ImageIcon("officer.png");   
    l5=new JLabel(officer);
    l5.setBounds(620,140,200,300);
    add(l5);

 
   lt.setFont(new Font("RockWell",Font.BOLD,30));
   lt.setBounds(150,80,500,50);
   lt.setForeground(Color.darkGray);
   add(lt);

   l1.setFont(new Font("TimesRoman",Font.PLAIN,20));
   l1.setBounds(60,200,180,50);
   add(l1);

   t1.setFont(new Font("TimesRoman",Font.BOLD,18));
   t1.setBounds(240,215,135,25);
   add(t1);
 
   l2.setFont(new Font("TimesRoman",Font.PLAIN,20));
   l2.setBounds(60,245,180,50);
   add(l2);

   p.setBounds(240,260,135,25);
   add(p);

   b1.setBounds(213,340,80,25);
   add(b1);

   b1.addActionListener(this); 

   l3.setBounds(193,380,500,25);
   l3.setForeground(Color.red);
   add(l3);

   b3=new JButton();
   b3.setBounds(845,5,50,40);
   b3.setToolTipText("Exit");
   b3.setBackground(Color.white);
   b3.setIcon(exit);
   add(b3);

   b3.addActionListener(this);

 //l4.setBounds(183,385,500,25);
 //add(l4);

   try
   {
	Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
    

   }

    catch(Exception e){ System.out.println("err1"+e);}

 }

         public void actionPerformed(ActionEvent ae)
  {

	if(ae.getSource()==b1)
        {
        try
        {
	a=t1.getText();
        b=p.getText();
 PreparedStatement ps=con.prepareStatement("insert into officer_login values(?,?)");
        ps.setString(1,a);
        ps.setString(2,b);
        ps.executeUpdate();
      

        z1=a.equals("Riya");
        z2=b.equals("1234");
        z3=a.equals("Tanmay");
        z4=b.equals("12345");

        if(z1==true&&z2==true||z3==true&&z4==true)
        {
        l3.setText("Login Successfull");
        new operation().show();
          dispose(); 
        }
        else 
        {
        l3.setText("    Login failed");
        t1.setText("");
        p.setText("");
        }
            
             
        }
       
    
             catch(Exception e){System.out.println("err2"+e);}
	
    }   

          if(ae.getSource()==b3)
             {
               
                new home().show();
                dispose();

             } 
   
  } 


   public static void main(String ar[])throws Exception
  {
    officer r=new officer();
     //con.close();
      
  }

}   
