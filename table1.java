//Candidate table
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


class table1 extends JFrame implements ActionListener
{

static DefaultTableModel dtm;
	JTable ta;
	JScrollPane jp;
	JLabel l1;
        JButton b1,b4;
        Connection cn1;

	table1()
	{

            b1=new JButton("CLEAR");
            
            setLayout(null);
            b1.setBounds(380,300,100,30);
            add(b1);

            Icon exit=new ImageIcon("cancel.jpg");
			
			setLayout(null);
			String data[][]=new String[50][20];
			String heading[]={"Candidate no","Name","Locality","votes","Phone no","Email_id"};
			dtm=new DefaultTableModel(heading,0); 
			ta=new JTable(dtm);
			
			l1=new JLabel("CANDIDATE LIST");

			    l1.setFont(new Font("RockWell",Font.BOLD,30));
   				l1.setBounds(300,5,600,30);
			    add(l1);

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
	   PreparedStatement st=cn1.prepareStatement("select cno,Name,locality,vote,Phoneno,Emailid from candidate_reg");
			ResultSet rst=st.executeQuery();
			while(rst.next())
			{
				
				dtm.addRow(new String[]{rst.getString("cno"),rst.getString("Name"),rst.getString("locality"),rst.getString("vote"),rst.getString("Phoneno"),rst.getString("Emailid")});
				
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

        PreparedStatement st1=cn1.prepareStatement("truncate table candidate_reg");
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

		table1 t=new table1();
		t.setSize(1000,1200);
		t.show();
		
		
    
		
		

}

}
