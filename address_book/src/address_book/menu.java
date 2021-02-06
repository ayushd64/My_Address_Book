package address_book;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class menu extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

		public menu()
		{
			setTitle("Address Book");
			setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u00A9ayushd");
		label.setBounds(386, 247, 56, 16);
		contentPane.add(label);
		
		textField = new JTextField(15);
		textField.setBounds(232, 63, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Lucida Calligraphy", Font.BOLD, 18));
		lblUsername.setBounds(33, 63, 116, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Calligraphy", Font.BOLD, 18));
		lblPassword.setBounds(33, 152, 116, 22);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField(15);
		passwordField.setBounds(232, 154, 116, 22);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 215, 97, 25);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(menu.class.getResource("/address_book/olpa.jpg")));
		lblNewLabel.setBounds(0, 0, 450, 284);
		contentPane.add(lblNewLabel);
		
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				String uname = textField.getText();
				char ch[] = passwordField.getPassword();
				String paswd=String.copyValueOf(ch);
				int flag=0;
				try
				{
					
				Connection conn=null;
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
				Statement stm=conn.createStatement();
				String query="select * from log_in where Username=? and Password=?";
				java.sql.PreparedStatement ps=conn.prepareStatement(query);
				ps.setString(1, uname);
				ps.setString(2, paswd);
				ResultSet res=ps.executeQuery();
				 while(res.next())
				{
					 if(res.getString(1).equals(uname)&&res.getString(2).equals(paswd))
					 {
					flag=1;
					break;
					 }
				}
				}	
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
			if(flag==1) 
			{
			mainwindow mw = null;
			try
			{
				mw = new mainwindow();
			} catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			mw.setVisible(true);
			dispose();
			} 
			else 
			{
				JOptionPane.showMessageDialog(passwordField, "Invalid Password/Username", "ERROR", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
				textField.requestFocusInWindow();
			}}
			
			});
		}

}