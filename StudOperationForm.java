import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class StudOperationForm extends JFrame
{
	JButton StudRegForm,SearchDetails ,UpdateDetails,DeletedDetails ;
	public StudOperationForm()
	{
		StudRegForm=new JButton("StudRegForm");
		add(StudRegForm);
		StudRegForm.setFont(new Font("Courier New",Font.BOLD,20));

        SearchDetails =new JButton("SearchDetails ");
		add(SearchDetails );
		SearchDetails.setFont(new Font("Courier New",Font.BOLD,20));

		UpdateDetails=new JButton("UpdateDetails");
		add(UpdateDetails);
		UpdateDetails.setFont(new Font("Courier New",Font.BOLD,20));

		DeletedDetails=new JButton("DeletedDetails");
		add(DeletedDetails);
		DeletedDetails.setFont(new Font("Courier New",Font.BOLD,20));

		setLayout(null);

		//set Bounds...

		int X,Y;
		X=50;
		Y=40;

		StudRegForm.setBounds(X+20,Y,240,50);

		SearchDetails.setBounds(X+20,Y+135,240,50);

		UpdateDetails.setBounds(X+20,Y+270,240,50);

		DeletedDetails.setBounds(X+20,Y+415,240,50);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(420,600);
	    setTitle("Student Operation Form:");
		setVisible(true);

		//ActionListener for StudRegForm :
		StudRegForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new StudRegForm();
			}
		});

		//ActionListener for SearchStudDetails:
		SearchDetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new SearchDetails();
			}
		});


		//ActionListener for UpdateDetails:
		UpdateDetails.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
			{
				new UpdateDetails();
			}
		});

		//ActionListener for DeleteDetails:
		DeletedDetails.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
			{
				new DeletedDetails();
			}
		});
	}
public static void main(String[] args)
{
	new StudOperationForm();
}
}