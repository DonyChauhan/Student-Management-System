import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class NewLoginFrame extends JFrame
{
	JLabel user_label,password_label,conf_pass_label,role_label,message;
	JTextField userName_text;
	JPasswordField password_text, conf_pass_text;
	JButton submit;
	JComboBox role;
	public NewLoginFrame()
	{
		//Username...
		user_label=new JLabel("User Name:");
		add(user_label);

		userName_text=new JTextField(20);
		add(userName_text);

		//Password...
		password_label=new JLabel("Password:");
		add(password_label);

		password_text=new JPasswordField(20);
		add(password_text);

		//Confirm Password...
		conf_pass_label=new JLabel("Confirm:");
		add(conf_pass_label);

		conf_pass_text=new JPasswordField(20);
		add(conf_pass_text);

		//role...
		role_label=new JLabel("Role");
		add(role_label);

		String[] roles={"admin","user"};
		role=new JComboBox(roles);
		add(role);


		//Submit...
		submit=new JButton("SAVE");
		add(submit);

		//message...
		message=new JLabel();
		message.setVisible(false);
		add(message);

		setLayout(null);

		//setBounds...
		int X,Y;
		X=20;
		Y=10;
		//ROW 1
		user_label.setBounds(X,Y,100,30);
		userName_text.setBounds(X+80,Y,200,25);
		//ROW 2
		Y+=35;
		password_label.setBounds(X,Y,100,30);
		password_text.setBounds(X+80,Y,200,25);
		//ROW 3
		Y+=35;
		conf_pass_label.setBounds(X,Y,100,30);
		conf_pass_text.setBounds(X+80,Y,200,25);

		//ROW 4
		Y+=35;
		role_label.setBounds(X,Y,100,30);
		role.setBounds(X+80,Y,200,25);

		//ROW 5
		Y+=35;
		message.setBounds(X+20,Y,260,30);

		//ROW 6
		Y+=35;
		submit.setBounds(X+160,Y,120,30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Please Login Here!");
		setSize(340,290);
		setVisible(true);

		//Focus Listener of Confirm password to match the password and confirm password
		conf_pass_text.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent fe)
			{
				message.setText("");
				message.setVisible(false);
			}
			public void focusLost(FocusEvent fe)
			{
				String pass = password_text.getText();
				String cpass = conf_pass_text.getText();
				if(!pass.equals(cpass))
				{
					conf_pass_text.setText("");
					message.setText("Password not matched");
					message.setVisible(true);
				}
			}
		});

		//ActionListener for Submit:
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				String userName=userName_text.getText();
				String password=password_text.getText();
				String userrole=(String)role.getSelectedItem();
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
					PreparedStatement st=con.prepareStatement("insert into users values(?,?,?)");
					st.setString(1,userName);
					st.setString(2,password);
					st.setString(3,userrole);
					int r=st.executeUpdate();
					if(r==1)
					{
						userName_text.setText("");
						password_text.setText("");
						conf_pass_text.setText("");
						message.setVisible(false);
						JOptionPane.showMessageDialog(null,"New User Saved successful....");
						//instantiate LoginDemo
						//this.dispose();
					}
					else
					{
						message.setText("Invalid User Name or Password, Try again!");
						message.setVisible(true);
					}
				}
				catch(Exception e){System.out.println(e);}
			}
		});

	}


	public static void main(String[] args)
	{
		new NewLoginFrame();
		new StudOperationForm();
	}
}