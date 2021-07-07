import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class LoginDemo extends JFrame
{
    JLabel user_label,password_label,message;
	JTextField userName_text;
	JPasswordField password_text;
	JButton submit,newuser;
	public LoginDemo()
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

		//Submit...
		submit=new JButton("SUBMIT");
		add(submit);

		//newuser...
		newuser=new JButton("New User");
		add(newuser);

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
		message.setBounds(X+20,Y,260,30);

		//ROW 4
		Y+=35;
		newuser.setBounds(X,Y,120,30);
		submit.setBounds(X+160,Y,120,30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Please Login Here!");
		setSize(340,200);
		setVisible(true);

		//ActionListener for Submit:
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				String userName=userName_text.getText();
				String password=password_text.getText();
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
					PreparedStatement st=con.prepareStatement("select * from users where username=? and password=?");
					st.setString(1,userName);
					st.setString(2,password);
					ResultSet rs=st.executeQuery();
					if(rs.next())
					{
						message.setText("Login successful....");
						message.setVisible(true);
						new StudOperationForm();
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

		//ActionListener for New User:
		newuser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new NewLoginFrame();
			}
		});
	}


public static void main(String[] args)
{
	new LoginDemo();
}
}