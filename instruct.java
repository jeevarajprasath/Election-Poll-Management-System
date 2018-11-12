import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class instruct extends JFrame implements ActionListener
{

    JLabel lt,ln,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f1,f2;
    JButton b1,b4;
	String un;

   instruct(String un)
   {
    this.un=un;
    
     getContentPane().setBackground(Color.white);
     setSize(1200,540);
     show();

    Icon exit=new ImageIcon("cancel.jpg");

    lt=new JLabel("VOTING PROCEDURE INSTRUCTIONS");    			
    l1=new JLabel("Step 1:Press the blue candidate button on the EVM machine against the candidate name.");				//Labels
    l2=new JLabel("Step 2:Press the button only once.");
    l3=new JLabel("Step 3:The button will turn red after it is pressed.");
    l4=new JLabel("Step 4:The message will pop up after your vote is succesfully recorded.");
    l5=new JLabel("Step 5:The same process will be repeated for all the voters.");

    f1=new Font("Arial Narrow",Font.BOLD,20);    
    f2=new Font("Rockwell",Font.BOLD,35);

    b1=new JButton("Click to vote");
   
    setLayout(null);

    lt.setBounds(200,50,1200,45);
    lt.setForeground(Color.red);
    lt.setFont(f2);
    add(lt);

     
   l1.setBounds(30,150,1200,30);  
   l1.setForeground(Color.blue);
   l1.setFont(f1);  
   add(l1);
 
   l2.setBounds(30,200,1200,30);  
   l2.setForeground(Color.blue);
   l2.setFont(f1);  
   add(l2);

   l3.setBounds(30,250,1200,30);  
   l3.setForeground(Color.blue);
   l3.setFont(f1);  
   add(l3);

   l4.setBounds(30,300,1200,30);  
   l4.setForeground(Color.blue);
   l4.setFont(f1);  
   add(l4);

   l5.setBounds(30,350,1200,30);  
   l5.setForeground(Color.blue);
   l5.setFont(f1);  
   add(l5);

   b1.setBounds(400,450,220,50);
   b1.setBackground(Color.cyan);
   b1.setForeground(Color.darkGray);
   b1.setFont(f1);
   add(b1);

   b4=new JButton();
   b4.setBounds(1135,5,50,40);
   b4.setToolTipText("Exit");
   b4.setBackground(Color.white);
   b4.setIcon(exit);
   add(b4);
 
   
   b1.addActionListener(this);
   b4.addActionListener(this);

   }

   public void actionPerformed(ActionEvent ae)
   {

   	  if(ae.getSource()==b1)
   	  {
		//System.out.println(un);
   	  	evm ee=new evm(un);
		 ee.setSize(500,600);
  		ee.show();
   	  	dispose();
   	  }

   	  if(ae.getSource()==b4)
   	  {
   	  	new home().show();
   	  	this.dispose();
   	  }
   }


public static void main(String ar[])
{
	//instruct i=new instruct();
}

}
