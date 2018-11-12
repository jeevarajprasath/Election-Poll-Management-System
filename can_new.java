//Candidate Registration Form
//Phone no,adhar card and pincode length validation 

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JScrollPane.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class can_new extends JFrame implements ActionListener,KeyListener

{

JTextField t2,t3,t6,t7,t8,t9,t10;
JButton b1,b2,b3;
JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,t4,tn,t5,
l15,l16,ln,lt,lb,lr1,lr2,lr3,lr4,lr5,lr6,lr7,lr8,lr9,lr10,lr11,lr12,lr13,lr14,lman;
JTextArea a1,a2;
ButtonGroup group;
int cno;
//Checkbox g1,g2;
//CheckboxGroup cg;
JComboBox c1,c2,c3,c4;
Connection con;

Border border=BorderFactory.createLineBorder(Color.BLACK);


JRadioButton r1,r2;

  can_new()
 {
    // super("MyApp");

      /*     try
   {
	Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
    
  Statement st=con.createStatement();
   ResultSet rs3 = st.executeQuery("select count(*) from candidate_reg");
	if(rs3.next())
	{
	  int c=rs3.getInt(1);
	  if(c>=5)
		{
			JOptionPane.showMessageDialog(null,"Sorry !!! 5 candidate already registered");
			//dispose();
			new officer().show();
			System.exit(0);
		}
	}*/

  try{
	  
	  try
	  {
	  Class.forName("com.mysql.jdbc.Driver");   
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
	  }catch (Exception e) { System.out.println("No connection established!!");}
	  
   Statement st=con.createStatement();
   ResultSet rs2 = st.executeQuery("select max(cno) from candidate_reg");
      cno=1;
  
	if(rs2.next())
	{
          cno=rs2.getInt(1)+1; 
          //t1.setText(cno);     
	
      }	

        
   }

    catch(Exception e){ System.out.println("err1"+e);}

        
  
     Color c=new Color(241,169,160);
     getContentPane().setBackground(c);
     setSize(896,2000);
     show();
    //JScrollPane pane=new JScrollPane//(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     //setContentPane(pane);

    Icon exit=new ImageIcon("cancel.jpg");

    a1=new JTextArea();
    a2=new JTextArea();

    r1=new JRadioButton("Male",false);
    r2=new JRadioButton("Female",false);
    group=new ButtonGroup();
    

    lt=new JLabel("CANDIDATE REGISTRATION FORM");    			//Textbox admission form
    l1=new JLabel("Candidate  no");				//Labels
    l2=new JLabel("Name ");
    l3=new JLabel("Gender");
    l4=new JLabel("Date of Birth");
    l5=new JLabel("Birth Place");
    l6=new JLabel("Ward Number");
    l7=new JLabel("Name of Municipality");
    ln=new JLabel("Ward");
    l8=new JLabel("Address");
    l9=new JLabel("Street Address");
    l10=new JLabel("Locality");
    l11=new JLabel("City");
    l12=new JLabel("Pincode");
    l13=new JLabel("Phone no");
    l14=new JLabel("Email-id");
    l15=new JLabel("Aadhar card no"); 
    lb=new JLabel("Nashik");
    t4=new JLabel("20");
    tn=new JLabel("College Road");
    t5=new JLabel("Nashik");
    t1=new JLabel(cno+"");
   /* lr1=new JLabel("*");
    lr2=new JLabel("*");
    lr3=new JLabel("*");
    lr4=new JLabel("*");
    lr5=new JLabel("*");
    lr6=new JLabel("*");
    lr7=new JLabel("*");
    lr8=new JLabel("*");
    lr9=new JLabel("*");
    lr10=new JLabel("*");
    lr11=new JLabel("*");
    lr12=new JLabel("*");
    lr13=new JLabel("*");
    lr14=new JLabel("*");*/
    lman=new JLabel("(All fields are mandatory!!)");
   

    //t1=new JTextField();
    t2=new JTextField();
    t3=new JTextField();
    
    
    t6=new JTextField();
    t7=new JTextField(10);
    t8=new JTextField();
    t9=new JTextField();
    t10=new JTextField();
    

/*    cg=new CheckboxGroup();				//Radio buttons
    g1=new Checkbox("Male",cg,false);
    g2=new Checkbox("Female",cg,false); */


   b1=new JButton("REGISTER");
   b2=new JButton("CLEAR");

   c1=new JComboBox();
   c2=new JComboBox();
   c3=new JComboBox();
   c4=new JComboBox();

   setLayout(null);

    Icon register=new ImageIcon("register.png");   
    l16=new JLabel(register);
    l16.setBounds(550,330,250,200);
    add(l16);


   lt.setFont(new Font("RockWell",Font.BOLD,30));
   lt.setBounds(158,5,600,30);
   add(lt);
  
   lman.setFont(new Font("TimesRoman",Font.BOLD,13));
   lman.setBounds(270,40,250,20);
   lman.setForeground(Color.red);
   add(lman);

   l1.setFont(new Font("TimesRoman",Font.BOLD,16));
   //lr1.setBounds(10,90,90,20);    
   //add(lr1);
   //lr1.setForeground(Color.red);
   l1.setBounds(30,90,160,20);      
   add(l1);

   t1.setFont(new Font("TimesRoman",Font.BOLD,16));
   t1.setBounds(180,90,30,25);
   t1.setBorder(border);
   add(t1);

   l2.setFont(new Font("TimesRoman",Font.BOLD,16));
   //lr2.setBounds(10,150,90,20);    
   //add(lr2);
   //lr2.setForeground(Color.red);
   l2.setBounds(30,150,100,20);
   add(l2);

  t2.setFont(new Font("TimesRoman",Font.BOLD,16));
  t2.setBounds(100,150,200,25);
  t2.setBorder(border);
  add(t2);

  l3.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr3.setBounds(10,210,90,20);    
  //add(lr3);
  //lr3.setForeground(Color.red);
  l3.setBounds(30,210,70,20);
  add(l3);

  r1.setFont(new Font("TimesRoman",Font.BOLD,16));
  r1.setBounds(105,210,100,20);
  group.add(r1);
  add(r1);

  r2.setFont(new Font("TimesRoman",Font.BOLD,16));
  r2.setBounds(105,230,100,20);
  group.add(r2);
  add(r2);

  
  l4.setFont(new Font("TimesRoman",Font.BOLD,16));
 // lr4.setBounds(255,210,90,20);    
 // add(lr4);
 // lr4.setForeground(Color.red);
  l4.setBounds(270,210,200,20);
  add(l4);

   c1.addItem("1");
   c1.addItem("2");
   c1.addItem("3");
   c1.addItem("4");
   c1.addItem("5");
   c1.addItem("6");
   c1.addItem("7");
   c1.addItem("8");
   c1.addItem("9");
   c1.addItem("10");
   c1.addItem("11");
   c1.addItem("12");
   c1.addItem("13");
   c1.addItem("14");
   c1.addItem("15");
   c1.addItem("16");
   c1.addItem("17");
   c1.addItem("18");
   c1.addItem("19");
   c1.addItem("20");
   c1.addItem("21");
   c1.addItem("22");
   c1.addItem("23");
   c1.addItem("24");
   c1.addItem("25");
   c1.addItem("26");
   c1.addItem("27");
   c1.addItem("28");
   c1.addItem("29");
   c1.addItem("30");
   c1.addItem("31");

  
  c2.addItem("01");
  c2.addItem("02");
  c2.addItem("03");
  c2.addItem("04");
  c2.addItem("05");
  c2.addItem("06");
  c2.addItem("07");
  c2.addItem("08");
  c2.addItem("09");
  c2.addItem("10");
  c2.addItem("11");
  c2.addItem("12");

   
   c3.addItem("1996");
   c3.addItem("1995");
   c3.addItem("1994");
   c3.addItem("1993");
   c3.addItem("1992");
   c3.addItem("1991");
   c3.addItem("1990");
   c3.addItem("1989");
   c3.addItem("1988");
   c3.addItem("1987");
   c3.addItem("1986");
   c3.addItem("1985");
   c3.addItem("1984");
   c3.addItem("1983");
   c3.addItem("1982");
   c3.addItem("1981");
   c3.addItem("1980");
   c3.addItem("1979");
   c3.addItem("1978");
   c3.addItem("1976");
   c3.addItem("1975");
   c3.addItem("1974"); 
 
  
  c1.setBounds(400,210,50,22);
 // c1.setBorder(border);
 add(c1); 

  c2.setBounds(451,210,50,22);
  //c2.setBorder(border);
 add(c2); 

  c3.setBounds(502,210,80,22);
  //c3.setBorder(border);
 add(c3); 

  l5.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr5.setBounds(10,280,90,20);    
  //add(lr5);
  //lr5.setForeground(Color.red);
  l5.setBounds(30,280,120,20);
  add(l5);

  t3.setFont(new Font("TimesRoman",Font.BOLD,16));
  t3.setBounds(148,280,100,20);
  t3.setBorder(border);
  add(t3);

  ln.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr6.setBounds(255,280,90,20);    
  //add(lr6);
  //lr6.setForeground(Color.red);
  ln.setBounds(270,330,150,20);
  add(ln);

  tn.setFont(new Font("TimesRoman",Font.BOLD,16));
  tn.setBounds(270,360,200,25);
  tn.setBorder(border);
  add(tn);

  l6.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr7.setBounds(10,330,90,20);    
  //add(lr7);
  //lr7.setForeground(Color.red);
  l6.setBounds(30,330,250,20);
  add(l6);
   
  t4.setFont(new Font("TimesRoman",Font.BOLD,16));
  t4.setBounds(30,360,80,25);
  t4.setBorder(border);
  add(t4);

  l7.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr8.setBounds(10,400,90,20);    
  //add(lr8);
  //lr8.setForeground(Color.red);
  l7.setBounds(30,400,350,20);
  add(l7);

  t5.setFont(new Font("TimesRoman",Font.BOLD,16));
  t5.setBounds(30,430,200,25);
  t5.setBorder(border);
  add(t5);

  l8.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr9.setBounds(10,470,90,20);    
  //add(lr9);
  //lr9.setForeground(Color.red); 
  l8.setBounds(30,470,100,20);
  add(l8);

  a1.setFont(new Font("TimesRoman",Font.BOLD,16));
  a1.setBorder(border);
  a1.setBounds(30,500,200,70);
  add(a1);

  l9.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr10.setBounds(2300,470,90,20);    
  //add(lr10);
  //lr10.setForeground(Color.red);
  l9.setBounds(250,470,200,20);
  add(l9);

  a2.setFont(new Font("TimesRoman",Font.BOLD,16));
  a2.setBorder(border);
  a2.setBounds(250,500,200,70);
  add(a2);
  
  l10.setFont(new Font("TimesRoman",Font.BOLD,16));
  //lr11.setBounds(10,590,90,20);    
  //add(lr11);
  //lr11.setForeground(Color.red);
  l10.setBounds(30,590,100,20);
  add(l10);
  
  t6.setFont(new Font("TimesRoman",Font.BOLD,16));
  t6.setBounds(130,590,150,20);
  t6.setBorder(border);
  add(t6);  

  l11.setFont(new Font("TimesRoman",Font.BOLD,16));
  l11.setBounds(30,640,70,20);
  add(l11);

  lb.setFont(new Font("TimesRoman",Font.BOLD,16));
  lb.setBounds(130,640,150,20);
 //c4.setBorder(border);
 add(lb);

 l12.setFont(new Font("TimesRoman",Font.BOLD,16));
 //lr12.setBounds(10,690,90,20);    
 //add(lr12);
 //lr12.setForeground(Color.red);
 l12.setBounds(30,690,100,20);
 add(l12);

 t8.setFont(new Font("TimesRoman",Font.BOLD,16));
 t8.setBounds(130,690,100,20);
 t8.setBorder(border);
 add(t8);

 l13.setFont(new Font("TimesRoman",Font.BOLD,16));
 //lr13.setBounds(10,740,90,20);    
 //add(lr13);
 //lr13.setForeground(Color.red);
 l13.setBounds(30,740,90,20);
 add(l13);

 t7.setFont(new Font("TimesRoman",Font.BOLD,16));
 t7.setBounds(130,740,150,20);
 t7.setBorder(border);
// t7.setDocument(new JTextFieldLimit(10));//Limit the textfield length
 add(t7);

 l14.setFont(new Font("TimesRoman",Font.BOLD,16));
 l14.setBounds(30,790,150,20);
 add(l14);

 t9.setFont(new Font("TimesRoman",Font.BOLD,16));
 t9.setBounds(30,820,200,25);
 t9.setBorder(border);
 add(t9);

 l15.setFont(new Font("TimesRoman",Font.BOLD,16));
 //lr14.setBounds(10,870,90,20);    
 //add(lr14);
 //lr14.setForeground(Color.red);
 l15.setBounds(30,870,150,20);
 add(l15);

 t10.setFont(new Font("TimesRoman",Font.BOLD,16));
 t10.setBounds(30,900,200,25);
 t10.setBorder(border);
 add(t10);

 b1.setBounds(200,950,100,30);
 add(b1);

 b2.setBounds(400,950,100,30);
 add(b2);

     b3=new JButton();
     b3.setBounds(830,5,50,40);
     b3.setToolTipText("Exit");
     b3.setBackground(Color.white);
     b3.setIcon(exit);
     add(b3);



 b1.addActionListener(this);
 b2.addActionListener(this);
 b3.addActionListener(this);
 t2.addKeyListener(this);
 t3.addKeyListener(this);
 tn.addKeyListener(this);
 t4.addKeyListener(this);
 t5.addKeyListener(this);
 t6.addKeyListener(this);
 t8.addKeyListener(this);
 t7.addKeyListener(this);
 t10.addKeyListener(this);
 r1.addActionListener(this);
 r2.addActionListener(this);




}

   public void keyReleased(KeyEvent a)
          {
            
          }

           public void keyTyped(KeyEvent b)
  	  {
  	  }

  	public void keyPressed(KeyEvent k)
 	{
  		if(k.getSource()==t2||k.getSource()==t3||k.getSource()==t6)//name
  		{
	if(!(k.getKeyChar()>='A' && k.getKeyChar()<='Z' || k.getKeyChar()>='a' && k.getKeyChar()<='z'||(k.getKeyCode()==KeyEvent.VK_SPACE)||(k.getKeyCode()==KeyEvent.VK_SHIFT)||(k.getKeyCode()==KeyEvent.VK_CAPS_LOCK)||(k.getKeyCode()==KeyEvent.VK_BACK_SPACE)))
		{
	    JOptionPane.showMessageDialog(this,"Cannot contain digits or special symbols!!","Please Enter Correct Input",JOptionPane.ERROR_MESSAGE);
            k.setKeyChar((char)8);
            t2.setText("");
            t3.setText("");
            //t5.setText("");
            t6.setText("");
           // break;
               }

	      }
        
      if(k.getSource()==t8||k.getSource()==t7||k.getSource()==t9||k.getSource()==t10)
              {
if((k.getKeyChar()>='A' && k.getKeyChar()<='Z') || (k.getKeyChar()>='a' && k.getKeyChar()<='z'))
                  {
	    JOptionPane.showMessageDialog(this,"Cannot contain alphabets or special symbols!!","Please Enter Correct Input",JOptionPane.ERROR_MESSAGE);
            k.setKeyChar((char)8);
            
	    t8.setText("");
            t7.setText("");
            t9.setText("");
            t10.setText("");
            
//t2.setText("");
           // break;
                  }

                 if(t8.getText().length()>6)
                 {
         JOptionPane.showMessageDialog(this,"Pincode should be less than 6","Error in input",JOptionPane.ERROR_MESSAGE);
            

                 }
                
                if(t10.getText().length()>12)
                 {
         JOptionPane.showMessageDialog(this,"Adharcard no should be less than 12","Error ",JOptionPane.ERROR_MESSAGE);
            

                 }
                
               

	     }
            

}//function 
     
     public void actionPerformed(ActionEvent ae)
  {
     
       String tf2,tf3,tf5,tfn,tf6,tf9,tf7,tf10;
       String af1,af2,rmale="",fmale=""; 
       int tf1,tf8,tf4;
 
    ButtonModel bm=group.getSelection();

       
     /* JOptionPane.showMessageDialog(null,"Your information has been successfully recorded");
      new instruct().show();
       dispose();*/


       

        if(ae.getSource()==b1)
    {

       if(t1.getText().equals("") || t2.getText().equals("")|| t3.getText().equals("")|| tn.getText().equals("")|| t4.getText().equals("")||bm==null|| t5.getText().equals("")||a1.getText().equals("")||a2.getText().equals("")||t6.getText().equals("")||t7.getText().equals("") ||
           t8.getText().equals("")||t9.getText().equals("")||t10.getText().equals(""))

     {

        JOptionPane.showMessageDialog(null,"Please fill all the fields!!");
     }

        else

       {

      /* JOptionPane.showMessageDialog(null,"Your information has been successfully recorded");
       new officer().show();
       dispose();

       }
*/
      
      try
      {
      //tf1=Integer.parseInt(t1.getText());
      tf2=t2.getText();//name

       if(r1.isSelected()==true)//Gender
        {
        
          rmale=r1.getLabel();
          //System.out.println("Male:"+rmale);     

        }

        else
        {
              
          rmale=r2.getLabel();
         // System.out.println("FeMale:"+rmale);

        }
    
       //"DOB"
          
      //fmale
      tf3=t3.getText();//Birth_Place
      //tfn=tn.getText();//ward
      //tf4=Integer.parseInt(t4.getText());//ward no
      //tf5=t5.getText();//Name of Municipality
      af1=a1.getText();//Address
      af2=a2.getText();//Street Address
      tf6=t6.getText();//Locality
      //"Nashik"
      tf8=Integer.parseInt(t8.getText());//Pincode
      tf7=t7.getText();//Phone no
      tf9=t9.getText();//Email-id
      tf10=t10.getText();//Adhar no.
 String dob=c3.getSelectedItem()+"-"+c2.getSelectedItem()+"-"+c1.getSelectedItem();

     JOptionPane.showMessageDialog(null,"Your information has been successfully recorded!!");
       new home().show();
       dispose();



   PreparedStatement ps=con.prepareStatement("insert into candidate_reg values(?,?,?,?,?,null,null,null,?,?,?,null,?,?,?,?,0)");
        ps.setInt(1,cno);
        ps.setString(2,tf2.toLowerCase());
        ps.setString(3,rmale.toLowerCase());
        ps.setString(4,dob.toLowerCase());
        ps.setString(5,tf3.toLowerCase());
        //ps.setInt(5,tf4);
        //ps.setString(5,tf5.toLowerCase());
	//ps.setString(6,tfn.toLowerCase());
        ps.setString(6,af1.toLowerCase());
        ps.setString(7,af2.toLowerCase());
        ps.setString(8,tf6.toLowerCase());
        ps.setInt(9,tf8); 
        ps.setString(10,tf7.toLowerCase());
        ps.setString(11,tf9.toLowerCase());
        ps.setString(12,tf10.toLowerCase());
        
        
        ps.executeUpdate();

       
      
      



     }





   catch(Exception e){System.out.println("err1"+e);}
}
}
       if(ae.getSource()==b2)
       {

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        a1.setText("");
        a2.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        tn.setText("");




       }

       if(ae.getSource()==b3)
       {
	 new operation().show();
         dispose();
       }

          

  } 



    public static void main(String ar[])
  {
    can_new c=new can_new();
    
  }

}                     
