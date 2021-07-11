import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.*;
class User extends JFrame
{
	JLabel l1=new JLabel("First Name :");
	JLabel l2=new JLabel("Last Name :");
	JLabel l3=new JLabel("Email :");
	JLabel l4=new JLabel("Age :");
	JLabel l5=new JLabel("Phone No :");
	JLabel l6=new JLabel("Address :");
	JLabel l7=new JLabel("Username :");
	JLabel l8=new JLabel("Passcode :");
	JTextField t1=new JTextField(30);
	JTextField t2=new JTextField(30);
	JTextField t3=new JTextField(30);
	JTextField t4=new JTextField(30);
	JTextField t5=new JTextField(30);
	JTextField t6=new JTextField(30);
	JTextField t7=new JTextField(30);
	JTextField t8=new JTextField(30);
	JButton b1=new JButton("Apply");
	User()
	{
		super("Registration Form");
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(8,2));
		FlowLayout layout=new FlowLayout();
		JPanel p2=new JPanel();
		p2.setLayout(layout);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(t5);
		p1.add(l6);
		p1.add(t6);
		p1.add(l7);
		p1.add(t7);
		p1.add(l8);
		p1.add(t8);
		p2.add(b1);
		add(p1,"North");
		add(p2,"South");
		setSize(400,300);
		setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent p)
		{
		
		String a=t1.getText();
		String b=t2.getText();
		String c=t3.getText();
		String d=t4.getText();
		String e=t5.getText();
		String f=t6.getText();
		String i=t7.getText();
		String j=t8.getText();
		if(e.length()!=10)
		{
		JOptionPane.showMessageDialog(b1,"Invalid mobile number!");
		}
		else if(j.length()<=8)
		{
		JOptionPane.showMessageDialog(b1,"Password should be of 8 characters!");	
		}
		else
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("connection_url","username","password");
			//connection url,username,password should be replaced with your own url,password and username
			PreparedStatement st=con.prepareStatement("insert into form2 values(?,?,?,?,?,?,?,?)");
			st.setString(1,a);
			st.setString(2,b);
			st.setString(3,c);
			st.setString(4,d);
			st.setString(5,e);
			st.setString(6,f);
			st.setString(7,i);
			st.setString(8,j);
			int v=st.executeUpdate();
			if(v==0)
			{
				JOptionPane.showMessageDialog(b1,"This is an existing account!");
				
			}
			else
			{
				JOptionPane.showMessageDialog(b1,"Account created!");	
			}
			con.close();
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		}
		}
		});
	}
}
public class RegistrationForm{

    public static void main(String[] args) {
    new User();
	
}

}
