import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class voter extends JFrame implements ActionListener
{

JTextField t1,t3,t4,t5,t6,t7,t8,t9,t10,tn;
JButton b1,b2,b3;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,ln,lt;
JPasswordField p;
String a,b,c;
Boolean z1,z2,z3,z4;
Connection con;


   voter()
 {
    // super("MyApp");
     getContentPane().setBackground(Color.darkGray);
     setSize(900,640);
     show();

    lt=new JLabel("VOTER LOGIN");
    l1=new JLabel("Username");
    l2=new JLabel("Password");
    l3=new JLabel();
    //l4=new JLabel("Create account");

    Icon addnew=new ImageIcon("addnew.jpg");
    Icon ok=new ImageIcon("ok.jpg");
    Icon exit=new ImageIcon("cancel.jpg");


    t1=new JTextField();
    p=new JPasswordField();
    
    setLayout(null);

    Icon vtr=new ImageIcon("vtr.png");   
    l5=new JLabel(vtr);
    //l5.setForeground(Color.darkGray);
    l5.setBounds(520,140,400,300);
    add(l5);


 
   lt.setFont(new Font("RockWell",Font.BOLD,30));
   lt.setBounds(100,80,500,50);
   lt.setForeground(Color.white);
   add(lt);

   l1.setFont(new Font("TimesRoman",Font.PLAIN,20));
   l1.setBounds(60,200,180,50);
   l1.setForeground(Color.white);
   add(l1);

   t1.setFont(new Font("TimesRoman",Font.BOLD,18));
   t1.setBounds(240,215,135,25);
   add(t1);
 
   l2.setFont(new Font("TimesRoman",Font.PLAIN,20));
   l2.setBounds(60,245,180,50);
   l2.setForeground(Color.white);
   add(l2);

   p.setBounds(240,260,135,25);
   add(p);

  /* b1=new JButton("NEW");
   b1.setBounds(60,340,100,40);
   b1.setIcon(addnew);
   add(b1);*/

   b2=new JButton("OK");
   b2.setBounds(80,340,100,40);
   b2.setIcon(ok);
   add(b2);

   b3=new JButton("EXIT");
   b3.setBounds(240,340,100,40);
   b3.setIcon(exit);
   add(b3);
   


   //b1.addActionListener(this);
   b2.addActionListener(this); 
   b3.addActionListener(this); 

   l3.setBounds(173,380,500,25);
   l3.setForeground(Color.yellow);
   add(l3);

 //l4.setBounds(183,385,500,25);
 //add(l4);
   try
   {
	Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
    

   }

    catch(Exception e){e.printStackTrace();  System.out.println("err1"+e);}


 }

  public void actionPerformed(ActionEvent ae)
  {

       /* if(ae.getSource()==b1)
        {
		new register1().show();

        }*/

        if(ae.getSource()==b2)
         {

	try
    {
    
    String un=t1.getText();
    String pw=p.getText();
    ResultSet rs;
    PreparedStatement ps=con.prepareStatement("select * from voter_reg where username=? and password=? and status=0");
	ps.setString(1,un);
	ps.setString(2,pw);
     rs=ps.executeQuery();//records with condition are fetched
    
        if(rs.next())//if record is fetched in the result set
       {

    
        JOptionPane.showMessageDialog(null,"Your login is succesfull!!");
        new instruct(un).show();
        this.dispose();
//        new evm(un).show();

       }

       else
       {
          JOptionPane.showMessageDialog(null,"Your vote has already been registered or try with valid input!!");
          t1.setText("");
          p.setText("");     

       }

 
 
    
    
   }catch(Exception e){System.out.println("Error"+e);}

         
       } 

        if(ae.getSource()==b3)
        {
                new home().show();
		this.dispose();
        }
	

     } 


   public static void main(String ar[])
  {
    voter r=new voter();
  }

}   
