import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class evm extends Frame implements ActionListener
{

JLabel l[]=new JLabel[5];
JButton b[]=new JButton[5];
int i;
Connection con;
PreparedStatement ps;
String vname;


  evm(String vname)
  {
  this.vname=vname;
setLayout(new FlowLayout());
  Panel p1=new Panel();
     p1.setLayout(new GridLayout(5,2,18,18));
     for(i=0;i<5;i++)
     {
       l[i]=new JLabel();
       b[i]=new JButton("VOTE");
     }        

    try
   {
	Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
    

        
   }

    catch(Exception e){ System.out.println("err1"+e); }


    i=0;

    try
    {
    
    Statement ps=con.createStatement();
    ResultSet rs=ps.executeQuery("select * from candidate_reg");
    
    while(rs.next())
    {

    l[i].setText(rs.getString("Name"));
    Font f1=new Font("Arial",Font.BOLD,20);
	l[i].setFont(f1);
    p1.add(l[i]);
	b[i].setFont(f1);
    p1.add(b[i]);
    
    b[i].addActionListener(this);

    i++;

    }

   }catch(Exception e){System.out.println("Error"+e);}
 	add(p1);

    }

    public void actionPerformed(ActionEvent ae)
    {  
for(int i=0;i<5;i++)
{
      if(ae.getSource()==b[i])
     {

     try
   {
        String m=l[i].getText();
   	ps=con.prepareStatement("update candidate_reg set vote=vote+1 where Name=?");
        ps.setString(1,m);
	ps.executeUpdate();

        PreparedStatement ps1=con.prepareStatement("update voter_reg set status=1 where username=?");
	ps1.setString(1,vname);
	ps1.executeUpdate();
	

        b[i].setBackground(Color.red);
        JOptionPane.showMessageDialog(null,"Your vote has been successfully recorded!!");
        new thank().show();
        this.dispose();
      
   }catch(Exception e1){System.out.println("Error"+e1);}

    }

}
  
}


    


  
 public static void main(String ar[])
  
 {

   evm e=new evm("");
   e.setSize(500,600);
   e.show();

 }


}




