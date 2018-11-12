import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class login extends JFrame implements ActionListener
{

	
	
	String a,b,c;
	Boolean z1,z2,z3,z4;

	JTextField t1;
	JButton j,j1,j2; 
	JLabel l1,l2,lt,l5,l3;
	JPasswordField t2;

	
	login()
	{
	getContentPane().setBackground(Color.WHITE);
     setSize(900,640);
     show();

		Icon addnew=new ImageIcon("addnew.jpg");
    		Icon ok=new ImageIcon("ok.jpg");
    		Icon exit=new ImageIcon("cancel.jpg");


		 lt=new JLabel("CANDIDATE LOGIN");  
		 l1=new JLabel("Username");
		 t1=new JTextField(20);
 		 l2=new JLabel("Password");
		 t2=new JPasswordField(20);
		 j=new JButton("LOGIN");
		 j1=new JButton("NEW");
		 j2=new JButton("EXIT");	
		 l3=new JLabel(); 
		setLayout(null); 
		
		Icon login=new ImageIcon("can.jpg");
		l5=new JLabel(login);
    		l5.setBounds(500,100,424,252);
 	add(l5);											
		
		 lt.setFont(new Font("RockWell",Font.BOLD,24));
		 lt.setBounds(100,80,500,50);
		 add(lt);
 
                 l1.setFont(new Font("TimesRoman",Font.BOLD,16));
		 l1.setBounds(60,200,180,50);
		 add(l1);

  		 t1.setBounds(240,215,135,25);
  		 add(t1);

                 l2.setFont(new Font("TimesRoman",Font.BOLD,16));
	   	l2.setBounds(60,245,180,50); 
		 add(l2);
		  t2.setBounds(240,260,135,25);
		 add(t2);
		 j.setBounds(213,340,120,30);
		j.setIcon(ok);
		add(j);

		 j.addActionListener(this);
		 
j1.setBounds(80,340,120,30);
j1.setIcon(addnew);		
add(j1);
		 j1.addActionListener(this);
j2.setBounds(350,340,120,30);
j2.setIcon(exit);		
add(j2);
		 j2.addActionListener(this);





		 l3.setBounds(193,380,500,25);
   		 l3.setForeground(Color.red);
   		 add(l3);


	}


public void actionPerformed(ActionEvent ae)
  {
      
       if(ae.getSource()==j)

      {
	a=t1.getText();
        b=t2.getText();

        z1=a.equals("Riya");
        z2=b.equals("1234");
        z3=a.equals("Tanmay");
        z4=b.equals("12345");

        if(z1==true&&z2==true||z3==true&&z4==true)
        l3.setText("Login Successfull");
        else 
        {
        l3.setText("    Login failed");
        t1.setText("");
        t2.setText("");
        }
        
      

     }

     if(ae.getSource()==j1)
     {


        //  new instruct().show();
          //dispose();


     }

     if(ae.getSource()==j2)
     {

         new home().show();
         dispose();


     }





}



public static void main(String arg[])
{
login lg=new login();
}

}
