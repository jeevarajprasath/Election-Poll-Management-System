//voter table
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


class table extends JFrame implements ActionListener 
{

static DefaultTableModel dtm;
	JTable ta;
	JScrollPane jp;
	JLabel l1;
        JButton b1,b4;
        Connection cn1;
	table()
	{

                   
            b1=new JButton("CLEAR");
            
            
            
		

Icon exit=new ImageIcon("cancel.jpg");
setLayout(null);
String data[][]=new String[50][20];
String heading[]={"Voter no","Name","Phone no","Email_id","Locality"};
dtm=new DefaultTableModel(heading,0); 
ta=new JTable(dtm);
			
                            l1=new JLabel("VOTER LIST");

			    l1.setFont(new Font("RockWell",Font.BOLD,30));
   				l1.setBounds(360,5,600,30);
			    add(l1);
 
                            b1.setBounds(380,300,100,30);
                            add(b1);


                             b4=new JButton();
    			     b4.setBounds(950,5,50,40);
                             b4.setToolTipText("Exit");
                             b4.setBackground(Color.white);
                             b4.setIcon(exit);
                             add(b4);

	

			jp=new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			jp.setBounds(0,80,1000,1000);
			add(jp);


                      		try{
			Class.forName("com.mysql.jdbc.Driver");
	       	cn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?useSSL=false","root","riya");
	   PreparedStatement st=cn1.prepareStatement("select Voterno,Name,Phone_no,Locality,Email_id from voter_reg");
			ResultSet rst=st.executeQuery();
			while(rst.next())
			{
				String nm;
			    
				dtm.addRow(new String[]{rst.getString("Voterno"),rst.getString("Name"),rst.getString("Phone_no"),rst.getString("Email_id"),rst.getString("Locality")});
				
			}
		
		}catch(Exception e){System.out.println(e);}

 b1.addActionListener(this);
 b4.addActionListener(this);

}


       public void actionPerformed(ActionEvent ae)
       {
       
         if(ae.getSource()==b1)
          {
            try
             {

        PreparedStatement st1=cn1.prepareStatement("delete from voter_reg");
                  st1.executeUpdate();
                  DefaultTableModel model=(DefaultTableModel)ta.getModel();
                  model.setRowCount(0); 


             }catch(Exception e){System.out.println("err2"+e);}

         }



          

         if (ae.getSource()==b4)
         {
            new operation().show();
            dispose();

         }




       }

			
	


public static void main(String ar[])
{

		table t=new table();
		t.setSize(1000,1200);
		t.show();
		
		
    
		

}

}

