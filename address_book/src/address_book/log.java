package address_book;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class log extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static log frame;

	public log() {
		setTitle("Address Book");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewUsername.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewUsername.setBounds(38, 36, 152, 25);
		contentPane.add(lblNewUsername);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int res=0;
				try
				{
					Connection conn=null;
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
					String w1=textField.getText();
					String w2=textField_1.getText();	
					PreparedStatement tc=(PreparedStatement) conn.prepareStatement("UPDATE address_book.log_in SET Username=?, Password=? where id=1");
					tc.setString(1, w1);
					tc.setString(2, w2);
					res=tc.executeUpdate();
				JOptionPane.showMessageDialog(frame, "Updated Successfully");
				
			}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				dispose();
			}
		});
		btnSave.setBounds(168, 207, 97, 33);
		contentPane.add(btnSave);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewPassword.setBounds(38, 130, 152, 25);
		contentPane.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(220, 36, 188, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setColumns(10);
		textField_1.setBounds(220, 130, 188, 26);
		contentPane.add(textField_1);
	}
}