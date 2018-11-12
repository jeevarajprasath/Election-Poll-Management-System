import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class thank extends JFrame implements ActionListener
{

JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,tn;
JButton b1,b2,b3;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,ln,lt;
JTextArea a1,a2;
Color c;


thank()
 {

 Icon exit=new ImageIcon("cancel.jpg");
 Color c=new Color(206,255,255);
  getContentPane().setBackground(c);
     setSize(650,700);
     show();
     
     lt=new JLabel("THANK YOU FOR VOTING");
  

        setLayout(null);
        
   lt.setFont(new Font("RockWell",Font.BOLD,30));
   lt.setBounds(105,80,500,50);
   lt.setForeground(Color.red);
   add(lt);
   
 	

       Icon thank=new ImageIcon("thank.gif");
		l5=new JLabel(thank);
    		l5.setBounds(10,160,624,552);
    		add(l5);		

   b3=new JButton();
   b3.setBounds(600,5,50,40);
   b3.setToolTipText("Exit");
   b3.setBackground(Color.white);
   b3.setIcon(exit);
   add(b3);

   b3.addActionListener(this);
									
   
 
 
 }

    public void actionPerformed(ActionEvent ae)
    {
      new home().show();
      dispose();
 

    }	
	
	
public static void main(String arg[])
{
thank t=new thank();
}
	
		
}
