import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class StudRegForm extends JFrame
{
	JLabel lblTitle,lblstate, lbldis, lblname, lblF_name,lblM_name,lblStud_ID,lblReligion,lblDOB,lblNation,lblAdd,lblTeleNo,lblMobile,lblGander,lblcategory,lblpincode,message;
	JTextField txtstate, txtdis, txtname, txtF_name,txtM_name,txtStud_ID,txtReligion,txtDOB,txtcategory,txtNation,txtAddress,txtTeleNo,txtMobile,txtpincode;
	JButton Save;
	Choice chCat;

	//constructor to initialize the components...
	public StudRegForm()
	{
         lblTitle=new JLabel("Student Registration Form");
		 lblTitle.setFont(new Font("Algerian",Font.BOLD,22));
		 lblTitle.setBounds(20,15,380,50);
		 add(lblTitle);

		 lblstate=new JLabel("State :");
		 add(lblstate);
		 txtstate=new JTextField(20);
		 add(txtstate);

		 lbldis=new JLabel("District : ");
		 add(lbldis);
		 txtdis=new JTextField(20);
		 add(txtdis);

		 lblname=new JLabel("Name of Student :");
		 add(lblname);
		 txtname=new JTextField(20);
		 add(txtname);

		 lblF_name=new JLabel("Father's Name : ");
		 add(lblF_name);
		 txtF_name=new JTextField(20);
		 add(txtF_name);

		 lblM_name=new JLabel("Mother's Name : ");
		 add(lblM_name);
		 txtM_name=new JTextField(20);
		 add(txtM_name);

		 lblStud_ID=new JLabel("Student ID: ");
		 add(lblStud_ID);
		 txtStud_ID=new JTextField(20);
		 add(txtStud_ID);

		 lblReligion=new JLabel("Religion:");
		 add(lblReligion);
		 txtReligion=new JTextField(20);
		 add(txtReligion);

		 lblDOB=new JLabel("Date of Birth: ");
		 add(lblDOB);
		 txtDOB=new JTextField(20);
		 add(txtDOB);

		 lblNation=new JLabel("Nationality: ");
		 add(lblNation);
		 txtNation=new JTextField(20);
		 add(txtNation);

		 lblAdd=new JLabel("Address:");
		 add(lblAdd);
		 txtAddress=new JTextField(20);
		 add(txtAddress);

		 lblTeleNo=new JLabel("Telephone Number :");
		 add(lblTeleNo);
		 txtTeleNo=new JTextField(20);
		 add(txtTeleNo);

		 lblMobile=new JLabel("Mobile Number : ");
		 add(lblMobile);
		 txtMobile=new JTextField(20);
		 add(txtMobile);

		 lblcategory =new JLabel("Category:");
		 add(lblcategory);
		 txtcategory=new JTextField(20);
		 add(txtcategory);

		 lblpincode=new JLabel("Pincode");
		 add(lblpincode);
		 txtpincode=new JTextField(20);
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

		 Save=new JButton("Save");
		 add(Save);

		 setLayout(null);

		// Set Bounds...
        int X,Y,X2;
		X=20;
		Y=80;
		X2=X+140;
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
		lblStud_ID.setBounds(X,Y,100,30);
		txtStud_ID.setBounds(X2,Y,200,25);

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
		Save.setBounds(X2,Y,120,30);


		 setSize(410,650);
		 setTitle("Student Registration Form");
		 setVisible(true);

		//ActionListener for Submit:
		Save.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent ae)
		 {
			String State=txtstate.getText();
			String District=txtdis.getText();
            String Name=txtname.getText();
			String FatherName=txtF_name.getText();
			String MotherName=txtM_name.getText();
			int StudentId=Integer.parseInt(txtStud_ID.getText());
			String Religion=txtReligion.getText();
			String DOB=txtDOB.getText();
			String Nationality=txtNation.getText();
			String Address=txtAddress.getText();
			long Telephone=Long.parseLong(txtTeleNo.getText());
			long MobileNo=Long.parseLong(txtMobile.getText());
			String chCat=txtcategory.getText();
			int Pincode=Integer.parseInt(txtpincode.getText());

			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
				PreparedStatement st=con.prepareStatement("insert into StudentDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				st.setString(1,State);
				st.setString(2,District);
				st.setString(3,Name);
				st.setString(4,FatherName);
				st.setString(5,MotherName);
				st.setInt(6,StudentId);
				st.setString(7,Religion);
				st.setString(8,DOB);
				st.setString(9,Nationality);
				st.setString(10,Address);
				st.setLong(11,Telephone);
				st.setLong(12,MobileNo);
				st.setString(13,chCat);
				st.setInt(14,Pincode);
				int rs=st.executeUpdate();
				if(rs==1)
				{
					txtstate.setText("");
					txtdis.setText("");
					txtname.setText("");
					txtF_name.setText("");
					txtM_name.setText("");
					txtStud_ID.setText("");
					txtReligion.setText("");
					txtDOB.setText("");
					txtNation.setText("");
					txtAddress.setText("");
					txtTeleNo.setText("");
					txtMobile.setText("");
					txtcategory.setText("");
					txtpincode.setText("");
					message.setVisible(false);
					JOptionPane.showMessageDialog(null,"Student Registration form successfully Saved....");
				}
				else
				{
					message.setText("Try again!");
					message.setVisible(true);
				}
			}
		  catch(Exception e){System.out.println(e);}
		 }
	  });

	}

}


