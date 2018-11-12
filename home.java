import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class home extends JFrame implements ActionListener
{

JTextField t1,t3,t4,t5,t6,t7,t8,t9,t10,tn;
JButton b1,b2,b3,b4;
Font f1,f2;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,ln,lt;
JPasswordField p;
String a,b,c;
Boolean z1,z2,z3,z4;
Icon people;



   home()
 {
    // super("MyApp");
     getContentPane().setBackground(Color.white);
     setSize(1200,1000);
     show();

  
     b1=new JButton("VOTER LOGIN");
    // b2=new JButton("CANDIDATE LOGIN");
     b3=new JButton("OFFICER LOGIN");
     f1=new Font("Arial Narrow",Font.BOLD,18);    
     f2=new Font("Rockwell",Font.BOLD,50);
     //l5=new JLabel();

     Icon exit=new ImageIcon("cancel.jpg");


     setLayout(null);

     Icon people=new ImageIcon("people.jpg");   
     l5=new JLabel(people);
     l5.setBounds(180,215,800,622);
     add(l5);

  
     b1.setBounds(230,900,220,50);
     b1.setBackground(Color.darkGray);
     b1.setForeground(Color.white);
     b1.setFont(f1);
     add(b1);

   /*  b2.setBounds(480,900,220,50);
     b2.setBackground(Color.darkGray);
     b2.setForeground(Color.white);
     b2.setFont(f1);
     add(b2);*/

     b3.setBounds(710,900,220,50);
     b3.setBackground(Color.darkGray);
     b3.setForeground(Color.white);
     b3.setFont(f1);
     add(b3);

     b4=new JButton();
     b4.setBounds(1147,5,50,40);
     b4.setToolTipText("Exit");
     b4.setBackground(Color.white);
     b4.setIcon(exit);
     add(b4);


     



                lt=new JLabel("WELCOME TO");
                lt.setFont(f2);
                lt.setBounds(370,30,800,50);
                lt.setForeground(Color.orange);
                add(lt);

                l1=new JLabel("ELECTION VOTING SYSTEM!!!");
                l1.setFont(f2);
                l1.setBounds(180,100,1000,50);
                l1.setForeground(Color.orange);
                add(l1);

               /* l2=new JLabel("SYSTEM!!!");
                l2.setFont(f2);
                l2.setBounds(560,140,800,50);
                l2.setForeground(Color.gray);
                add(l2); */

          b1.addActionListener(this);
          //b2.addActionListener(this);
          b3.addActionListener(this);
          b4.addActionListener(this);      


  }

     public void actionPerformed(ActionEvent ae)

     {
	if(ae.getSource()==b1)
        {
		new voter().show();
                dispose();

        }

      /*  if(ae.getSource()==b2)
        {
		new login().show();
                dispose();
        }*/
        
        if (ae.getSource()==b3)
         {
            new officer().show();
            dispose();

         }

          
        if (ae.getSource()==b4)
         {
            dispose();

         }


        
     }



   public static void main(String ar[])
  {
    home h=new home();
  }

}   
