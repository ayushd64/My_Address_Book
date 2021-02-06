package address_book;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.NameList;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;

public class nw extends JFrame {

	private JPanel contentPane;
	private JTextField txtHello;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	
	public nw(JList nameList, DefaultListModel lm,JLabel label_11)
	{
		setTitle("Address Book");
		setResizable(false);
		setBounds(100, 100, 1012, 697);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setText("NAME");
		textPane.setForeground(SystemColor.controlDkShadow);
		textPane.setFont(new Font("Times New Roman", Font.BOLD, 40));
		textPane.setBackground(UIManager.getColor("Button.light"));
		textPane.setBounds(12, 13, 228, 59);
		contentPane.add(textPane);
		
		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setEnabled(false);
		txtpnAge.setEditable(false);
		txtpnAge.setText("AGE");
		txtpnAge.setForeground(SystemColor.controlDkShadow);
		txtpnAge.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnAge.setBackground(UIManager.getColor("Button.light"));
		txtpnAge.setBounds(12, 85, 228, 59);
		contentPane.add(txtpnAge);
		
		JTextPane txtpnGender = new JTextPane();
		txtpnGender.setEnabled(false);
		txtpnGender.setEditable(false);
		txtpnGender.setText("GENDER");
		txtpnGender.setForeground(SystemColor.controlDkShadow);
		txtpnGender.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnGender.setBackground(UIManager.getColor("Button.light"));
		txtpnGender.setBounds(12, 157, 228, 59);
		contentPane.add(txtpnGender);
		
		JTextPane txtpnDob = new JTextPane();
		txtpnDob.setEnabled(false);
		txtpnDob.setEditable(false);
		txtpnDob.setText("D.O.B");
		txtpnDob.setForeground(SystemColor.controlDkShadow);
		txtpnDob.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnDob.setBackground(UIManager.getColor("Button.light"));
		txtpnDob.setBounds(12, 229, 228, 59);
		contentPane.add(txtpnDob);
		
		JTextPane txtpnPhone = new JTextPane();
		txtpnPhone.setEnabled(false);
		txtpnPhone.setEditable(false);
		txtpnPhone.setText("PHONE");
		txtpnPhone.setForeground(SystemColor.controlDkShadow);
		txtpnPhone.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnPhone.setBackground(UIManager.getColor("Button.light"));
		txtpnPhone.setBounds(12, 301, 228, 59);
		contentPane.add(txtpnPhone);
		
		JTextPane txtpnMobile = new JTextPane();
		txtpnMobile.setEnabled(false);
		txtpnMobile.setEditable(false);
		txtpnMobile.setText("MOBILE");
		txtpnMobile.setForeground(SystemColor.controlDkShadow);
		txtpnMobile.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnMobile.setBackground(UIManager.getColor("Button.light"));
		txtpnMobile.setBounds(12, 373, 228, 59);
		contentPane.add(txtpnMobile);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEnabled(false);
		txtpnEmail.setEditable(false);
		txtpnEmail.setText("E-MAIL");
		txtpnEmail.setForeground(SystemColor.controlDkShadow);
		txtpnEmail.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnEmail.setBackground(UIManager.getColor("Button.light"));
		txtpnEmail.setBounds(12, 445, 228, 59);
		contentPane.add(txtpnEmail);
		
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setEnabled(false);
		txtpnAddress.setEditable(false);
		txtpnAddress.setText("ADDRESS");
		txtpnAddress.setForeground(SystemColor.controlDkShadow);
		txtpnAddress.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnAddress.setBackground(UIManager.getColor("Button.light"));
		txtpnAddress.setBounds(12, 517, 228, 59);
		contentPane.add(txtpnAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(506, 629, 97, 33);
		contentPane.add(btnSave);
		
		txtHello = new JTextField("");
		txtHello.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHello.setBackground(UIManager.getColor("Button.background"));
		txtHello.setBounds(252, 24, 609, 33);
		contentPane.add(txtHello);
		txtHello.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setColumns(10);
		textField.setBounds(252, 95, 43, 33);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setColumns(10);
		textField_1.setBounds(252, 168, 116, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setBackground(UIManager.getColor("Button.background"));
		textField_2.setColumns(10);
		textField_2.setBounds(252, 236, 116, 33);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setBackground(UIManager.getColor("Button.background"));
		textField_3.setColumns(10);
		textField_3.setBounds(252, 312, 304, 33);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_4.setBackground(UIManager.getColor("Button.background"));
		textField_4.setColumns(10);
		textField_4.setBounds(252, 385, 304, 33);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_5.setBackground(UIManager.getColor("Button.background"));
		textField_5.setColumns(10);
		textField_5.setBounds(252, 455, 397, 33);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.menu);
		textField_6.setBounds(252, 529, 609, 33);
		contentPane.add(textField_6);
		
		JLabel lblDd = new JLabel("(DD-MM-YYYY)");
		lblDd.setForeground(Color.DARK_GRAY);
		lblDd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblDd.setBounds(451, 236, 152, 33);
		contentPane.add(lblDd);
		
		btnSave.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String s1=txtHello.getText();
				String s2=textField.getText();
				String s3=textField_1.getText();
				String s4=textField_2.getText();
				String s5=textField_3.getText();
				String s6=textField_4.getText();
				String s7=textField_5.getText();
				String s8=textField_6.getText();
				
				String Query="insert into address_book.info values(?,?,?,?,?,?,?,?,?,?)";
				int i=0;	
				Date d=new Date();
				SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat ff=new SimpleDateFormat("hh:mm a");
				try
			{
				Connection conn=null;
			
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
				PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(Query);		
				pstmt.setString(1, s1);
				pstmt.setString(2, s2);
				pstmt.setString(5, s3);
				pstmt.setString(8, s4);
				pstmt.setString(3, s5);
				pstmt.setString(4, s6);
				pstmt.setString(7, s7);
				pstmt.setString(6, s8);
				pstmt.setString(9, f.format(d));
				pstmt.setString(10, ff.format(d));
				i=pstmt.executeUpdate();
						}
						catch(Exception e3)
						{
							e3.printStackTrace();
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
			ResultSet res=stm.executeQuery("select Name from address_book.info order by Name ASC");
			while(res.next())
			{
				lm.addElement(res.getString("Name"));
			}
			res.close();
		}
		catch(Exception k)
		{
			k.printStackTrace();
		}
		
		nameList.setSelectedIndex(1);
			}
		});
	}
}