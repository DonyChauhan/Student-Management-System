import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
class DeletedDetails extends JFrame
{
	JLabel lblTitle,lblStud_ID,lblstate, lbldis, lblname, lblF_name,lblM_name,lblReligion,lblDOB,lblNation,lblAdd,lblTeleNo,lblMobile,lblGander,lblcategory,lblpincode,message;
	JTextField txtStud_ID, txtstate, txtdis, txtname, txtF_name,txtM_name,txtReligion,txtDOB,txtNation,txtAddress,txtTeleNo,txtMobile,txtpincode;
	JButton Delete,Search;
	Choice chCat;
	JRadioButton btn1,btn2;

	//constructor to initialize the components...
	public DeletedDetails()
	{
         lblTitle=new JLabel("Delete Student Details");
		 lblTitle.setFont(new Font("Algerian",Font.BOLD,22));
		 lblTitle.setBounds(20,15,380,50);
		 add(lblTitle);

		 lblStud_ID=new JLabel("Student ID: ");
		 add(lblStud_ID);
		 txtStud_ID=new JTextField(20);
		 add(txtStud_ID);

		 lblstate=new JLabel("State :");
		 add(lblstate);
		 txtstate=new JTextField(20);
		 txtstate.setEditable(false);
		 add(txtstate);

		 lbldis=new JLabel("District : ");
		 add(lbldis);
		 txtdis=new JTextField(20);
		 txtdis.setEditable(false);
		 add(txtdis);

		 lblname=new JLabel("Name of Student :");
		 add(lblname);
		 txtname=new JTextField(20);
		 txtname.setEditable(false);
		 add(txtname);

		 lblF_name=new JLabel("Father's Name : ");
		 add(lblF_name);
		 txtF_name=new JTextField(20);
		 txtF_name.setEditable(false);
		 add(txtF_name);

		 lblM_name=new JLabel("Mother's Name : ");
		 add(lblM_name);
		 txtM_name=new JTextField(20);
		 txtM_name.setEditable(false);
		 add(txtM_name);

		 lblReligion=new JLabel("Religion:");
		 add(lblReligion);
		 txtReligion=new JTextField(20);
		 txtReligion.setEditable(false);
		 add(txtReligion);

		 lblDOB=new JLabel("Date of Birth: ");
		 add(lblDOB);
		 txtDOB=new JTextField(20);
		 txtDOB.setEditable(false);
		 add(txtDOB);

		 lblNation=new JLabel("Nationality: ");
		 add(lblNation);
		 txtNation=new JTextField(20);
		 txtNation.setEditable(false);
		 add(txtNation);

		 lblAdd=new JLabel("Address:");
		 add(lblAdd);
		 txtAddress=new JTextField(20);
		 txtAddress.setEditable(false);
		 add(txtAddress);

		 lblTeleNo=new JLabel("Telephone Number :");
		 add(lblTeleNo);
		 txtTeleNo=new JTextField(20);
		 txtTeleNo.setEditable(false);
		 add(txtTeleNo);

		 lblMobile=new JLabel("Mobile Number : ");
		 add(lblMobile);
		 txtMobile=new JTextField(20);
		 txtMobile.setEditable(false);
		 add(txtMobile);

		 lblcategory =new JLabel("Category:");
		 add(lblcategory);

		 lblpincode=new JLabel("Pincode");
		 add(lblpincode);
		 txtpincode=new JTextField(20);
		 txtpincode.setEditable(false);
		 add(txtpincode);

	     //message...
		 message=new JLabel();
		 message.setVisible(false);
	     add(message);

		 chCat=new Choice();  //category
	     chCat.setBounds(960,200,250,25);
	     chCat.add("GEN");
		 chCat.add("OBC");
	     chCat.add("ST");
	     chCat.add("SC");

		 Delete=new JButton("Delete");
		 add(Delete);

		 Search=new JButton("Search");
		 add(Search);

		 setLayout(null);

		// Set Bounds...
        int X,Y,X2;
		X=20;
		Y=80;
		X2=X+140;

		lblStud_ID.setBounds(X,Y,100,30);
		txtStud_ID.setBounds(X2,Y,200,25);
		Search.setBounds(X2+230,Y,120,25);

		Y+=35;
		lblstate.setBounds(X,Y,100,30);
	    txtstate.setBounds(X2,Y,200,25);

		Y+=35;
		lbldis.setBounds(X,Y,100,30);
		txtdis.setBounds(X2,Y,200,25);

		Y+=35;
		lblname.setBounds(X,Y,100,30);
		txtname.setBounds(X2,Y,200,25);

		Y+=35;
		lblF_name.setBounds(X,Y,100,30);
		txtF_name.setBounds(X2,Y,200,25);

		Y+=35;
		lblM_name.setBounds(X,Y,100,30);
		txtM_name.setBounds(X2,Y,200,25);

		Y+=35;
		lblReligion.setBounds(X,Y,100,30);
		txtReligion.setBounds(X2,Y,200,25);

		Y+=35;
		lblDOB.setBounds(X,Y,100,30);
		txtDOB.setBounds(X2,Y,200,25);

		Y+=35;
		lblNation.setBounds(X,Y,100,30);
		txtNation.setBounds(X2,Y,200,25);

		Y+=35;
		lblAdd.setBounds(X,Y,100,30);
		txtAddress.setBounds(X2,Y,200,25);

		Y+=35;
		lblTeleNo.setBounds(X,Y,150,30);
		txtTeleNo.setBounds(X2,Y,200,25);

		Y+=35;
		lblMobile.setBounds(X,Y,100,30);
		txtMobile.setBounds(X2,Y,200,25);

		Y+=35;
		lblpincode.setBounds(X,Y,100,30);
		txtpincode.setBounds(X2,Y,200,25);

		Y+=35;
		message.setBounds(X,Y,150,40);

		Y+=35;
		Delete.setBounds(X2,Y,120,30);


		 setSize(550,650);
		 setTitle("Delete Student Details");
		 setVisible(true);

		//ActionListener for Search,Delete:
		Delete.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent ae)
		 {

			int StudentId=Integer.parseInt(txtStud_ID.getText());

			try{
			       Class.forName("oracle.jdbc.driver.OracleDriver");
		    	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
				   PreparedStatement st=con.prepareStatement("delete from STUDENTDETAILS where studentID=?");

				   st.setInt(1,StudentId);
				   int rs=st.executeUpdate();
				   if(rs==1)
				   {
					   JOptionPane.showMessageDialog(null,"Deletion Successful");
					   txtStud_ID.setText("");
					   txtstate.setText("");
					   txtdis.setText("");
					   txtname.setText("");
					   txtF_name.setText("");
					   txtM_name.setText("");
					   txtReligion.setText("");
					   txtDOB.setText("");
					   txtNation.setText("");
					   txtAddress.setText("");
					   txtTeleNo.setText(String.valueOf(""));
					   txtMobile.setText(String.valueOf(""));
						//rs.setString(13,"GEN");
					   txtpincode.setText(String.valueOf(""));

				   }

				}
					catch(Exception e){System.out.println(e);}
		}
	});


		Search.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent ae)
		 {
			int StudentId=Integer.parseInt(txtStud_ID.getText());

			try{
		        Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");

			    PreparedStatement st=con.prepareStatement("select * from StudentDetails where studentID=?");

				st.setInt(1,StudentId);
				ResultSet rs=st.executeQuery();
				if(rs.next())
				{
					txtstate.setText(rs.getString(1));
					txtdis.setText(rs.getString(2));
					txtname.setText(rs.getString(3));
					txtF_name.setText(rs.getString(4));
					txtM_name.setText(rs.getString(5));
					txtReligion.setText(rs.getString(7));
					txtDOB.setText(rs.getString(8));
					txtNation.setText(rs.getString(9));
					txtAddress.setText(rs.getString(10));
					txtTeleNo.setText(String.valueOf(rs.getLong(11)));
					txtMobile.setText(String.valueOf(rs.getLong(12)));
					//rs.setString(13,"GEN");
					txtpincode.setText(String.valueOf(rs.getInt(14)));


    				//message.setVisible(false);
					//JOptionPane.showMessageDialog(null,"Student Registration form successfully Saved....");
				}
				else
				{
					message.setText("Try again!");
					message.setVisible(true);
				}

				}catch(Exception e){}
		 }
	  });

	}
/*	public static void main(String[] args)
	{
		new DeletedDetails();
	}
*/
}