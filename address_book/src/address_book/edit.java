package address_book;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class edit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public edit(String sel,DefaultListModel lm,JList nameList,JLabel label_11) 
	{
		setTitle("Address Book");
		setBounds(100, 100, 1012, 697);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("NAME");
		textPane.setForeground(SystemColor.controlDkShadow);
		textPane.setFont(new Font("Times New Roman", Font.BOLD, 40));
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.controlHighlight);
		textPane.setBounds(12, 13, 228, 59);
		contentPane.add(textPane);
		
		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setText("AGE");
		txtpnAge.setForeground(SystemColor.controlDkShadow);
		txtpnAge.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnAge.setEnabled(false);
		txtpnAge.setEditable(false);
		txtpnAge.setBackground(SystemColor.controlHighlight);
		txtpnAge.setBounds(12, 85, 228, 59);
		contentPane.add(txtpnAge);
		
		JTextPane txtpnGender = new JTextPane();
		txtpnGender.setText("GENDER");
		txtpnGender.setForeground(SystemColor.controlDkShadow);
		txtpnGender.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnGender.setEnabled(false);
		txtpnGender.setEditable(false);
		txtpnGender.setBackground(SystemColor.controlHighlight);
		txtpnGender.setBounds(12, 157, 228, 59);
		contentPane.add(txtpnGender);
		
		JTextPane txtpnDob = new JTextPane();
		txtpnDob.setText("D.O.B");
		txtpnDob.setForeground(SystemColor.controlDkShadow);
		txtpnDob.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnDob.setEnabled(false);
		txtpnDob.setEditable(false);
		txtpnDob.setBackground(SystemColor.controlHighlight);
		txtpnDob.setBounds(12, 229, 228, 59);
		contentPane.add(txtpnDob);
		
		JTextPane txtpnPhone = new JTextPane();
		txtpnPhone.setText("PHONE");
		txtpnPhone.setForeground(SystemColor.controlDkShadow);
		txtpnPhone.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnPhone.setEnabled(false);
		txtpnPhone.setEditable(false);
		txtpnPhone.setBackground(SystemColor.controlHighlight);
		txtpnPhone.setBounds(12, 301, 228, 59);
		contentPane.add(txtpnPhone);
		
		JTextPane txtpnMobile = new JTextPane();
		txtpnMobile.setText("MOBILE");
		txtpnMobile.setForeground(SystemColor.controlDkShadow);
		txtpnMobile.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnMobile.setEnabled(false);
		txtpnMobile.setEditable(false);
		txtpnMobile.setBackground(SystemColor.controlHighlight);
		txtpnMobile.setBounds(12, 373, 228, 59);
		contentPane.add(txtpnMobile);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("E-MAIL");
		txtpnEmail.setForeground(SystemColor.controlDkShadow);
		txtpnEmail.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnEmail.setEnabled(false);
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(SystemColor.controlHighlight);
		txtpnEmail.setBounds(12, 445, 228, 59);
		contentPane.add(txtpnEmail);
		
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setText("ADDRESS");
		txtpnAddress.setForeground(SystemColor.controlDkShadow);
		txtpnAddress.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnAddress.setEnabled(false);
		txtpnAddress.setEditable(false);
		txtpnAddress.setBackground(SystemColor.controlHighlight);
		txtpnAddress.setBounds(12, 517, 228, 59);
		contentPane.add(txtpnAddress);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(320, 23, 611, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(320, 101, 54, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(UIManager.getColor("Button.background"));
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(320, 173, 97, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(UIManager.getColor("Button.background"));
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(320, 245, 116, 36);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(UIManager.getColor("Button.background"));
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(320, 317, 175, 36);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(UIManager.getColor("Button.background"));
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(320, 389, 207, 36);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(UIManager.getColor("Button.background"));
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(320, 461, 611, 36);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(UIManager.getColor("Button.background"));
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(320, 533, 611, 36);
		contentPane.add(textField_7);
		try
		{
			Connection conn=null;
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
			Statement stm=conn.createStatement();
			ResultSet res=stm.executeQuery("select * from address_book.info where Name='"+sel+"'");
		
			while(res.next())
			{
				textField.setText(res.getString(1));
				textField_1.setText(res.getString(2));
				textField_2.setText(res.getString(5));
				textField_3.setText(res.getString(8));
				textField_4.setText(res.getString(3));
				textField_5.setText(res.getString(4));
				textField_6.setText(res.getString(7));
				textField_7.setText(res.getString(6));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				int res=0;
				try
				{
					Connection conn=null;
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
					String s1=textField.getText();
					String s2=textField_1.getText();
					String s3=textField_2.getText();
					String s4=textField_3.getText();
					String s5=textField_4.getText();
					String s6=textField_5.getText();
					String s7=textField_6.getText();
					String s8=textField_7.getText();
					Date d=new Date();
					SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat ff=new SimpleDateFormat("hh:mm a");
					
		PreparedStatement we=(PreparedStatement) conn.prepareStatement("UPDATE address_book.info SET Name=?, Age=?, Phone_No=?, Mobile_No=?, Gender=?, Address=?, EMail=?, Date_of_Birth=?,Date=?,Time=? WHERE Name=?");
					 
				
				we.setString(1, s1);	
				we.setString(2, s2);
				we.setString(3, s5);
				we.setString(4, s6);
				we.setString(5, s3);
				we.setString(6, s8);
				we.setString(7, s7);
				we.setString(8, s4);
				we.setString(9,f.format(d));
				we.setString(10, ff.format(d));
				we.setString(11, sel);
				
				res=we.executeUpdate();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				dispose();
				nameList.setModel(lm);
				lm.clear();
				try
				{
					Connection conn=null;
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
					Statement stm=conn.createStatement();
					ResultSet ress=stm.executeQuery("select Name from address_book.info order by Name ASC");
					while(ress.next())
					{
						lm.addElement(ress.getString("Name"));
					}
					ress.close();
				}
				catch(Exception k)
				{
					k.printStackTrace();
				}
				nameList.setSelectedIndex(0);
			}
			
	
		});
		
		btnUpdate.setBounds(519, 619, 97, 31);
		contentPane.add(btnUpdate);
	}
}