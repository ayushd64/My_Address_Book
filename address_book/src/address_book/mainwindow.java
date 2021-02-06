package address_book;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.NameList;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.SystemColor;
import java.awt.geom.Line2D;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.lang.model.element.Element;
import javax.naming.TimeLimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class mainwindow extends JFrame
{	
 	private static Object res;
	private JPanel contentPane;
	static mainwindow frame;
	private JTextField textField;
	
	
	
	public mainwindow() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(70, 130, 180));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label.setBounds(877, 179, 929, 63);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(70, 130, 180));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_1.setBounds(877, 251, 453, 63);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(70, 130, 180));
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_2.setBounds(877, 327, 453, 63);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(new Color(70, 130, 180));
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_3.setBounds(877, 399, 453, 63);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(new Color(70, 130, 180));
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_4.setBounds(877, 471, 453, 63);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(new Color(70, 130, 180));
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_5.setBounds(877, 547, 453, 63);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(new Color(70, 130, 180));
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_6.setBounds(877, 615, 453, 63);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(new Color(70, 130, 180));
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_7.setBounds(877, 687, 1011, 83);
		contentPane.add(label_7);

		JLabel label_11 = new JLabel("");
		label_11.setForeground(Color.DARK_GRAY);
		label_11.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_11.setBounds(1738, 902, 133, 42);
		contentPane.add(label_11);
		Connection conn=null;
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
		DefaultListModel lm;
		lm=new DefaultListModel();
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(52, 179, 411, 729);
	contentPane.add(scrollPane);
	final JList nameList = new JList(lm);
	nameList.setForeground(Color.DARK_GRAY);
	scrollPane.setViewportView(nameList);
	nameList.setSelectionBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
	nameList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	nameList.setValueIsAdjusting(true);
	nameList.setFont(new Font("Segoe Print", Font.BOLD, 20));
	nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	nameList.setCellRenderer(getRenderer());
	nameList.setSelectionBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
	//nameList.setBackground(UIManager.getColor("ComboBox.disabledBackground"));
	nameList.addListSelectionListener(new ListSelectionListener() 
	{
		@Override
	public void valueChanged(ListSelectionEvent e)
	{
		try
		{
		if(!e.getValueIsAdjusting())
		{
			label.setText(nameList.getSelectedValue().toString());

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
	
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery("select * from address_book.info where Name='"+label.getText()+"'");
	
		while(res.next())
		{
			label_1.setText(res.getString(2));
			label_2.setText(res.getString(5));
			label_3.setText(res.getString(8));
			label_4.setText(res.getString(3));
			label_5.setText(res.getString(4));
			label_6.setText(res.getString(7));
			label_7.setText(res.getString(6));
			Date d=new Date();
			SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			if(df.format(d).equals(res.getString(9)))
			{
				label_11.setText(res.getString(10));
			}
			else
			{
				label_11.setText(res.getString(9));
			}
			}
	}}
catch(Exception e2)
{
	
}
	}	
	}
);
	
	try
		{
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery("select Name from address_book.info order by Name ASC");
		
		while(res.next())
		{
			lm.addElement(res.getString("Name"));
			nameList.setSelectedIndex(0);
			label.setText(nameList.getSelectedValue().toString());
			Statement stmm=conn.createStatement();
			ResultSet rees=stmm.executeQuery("select * from address_book.info where Name='"+label.getText()+"'");
			while(rees.next())
			{
			
				label_1.setText(rees.getString(2));
				label_2.setText(rees.getString(5));
				label_3.setText(rees.getString(8));
				label_4.setText(rees.getString(3));
				label_5.setText(rees.getString(4));
				label_6.setText(rees.getString(7));
				label_7.setText(rees.getString(6));
			}
		
		}
		res.close();
		}
		catch(SQLException ex)
		{
			
		}
		
		JTextPane txtpnContractInfo = new JTextPane();
		txtpnContractInfo.setEnabled(false);
		txtpnContractInfo.setFont(new Font("Times New Roman", Font.BOLD, 70));
		txtpnContractInfo.setForeground(SystemColor.controlDkShadow);
		txtpnContractInfo.setEditable(false);
		txtpnContractInfo.setBackground(SystemColor.controlHighlight);
		txtpnContractInfo.setText("Contact Info");
		txtpnContractInfo.setBounds(605, 75, 422, 95);
		contentPane.add(txtpnContractInfo);
		
		JTextPane txtpnName = new JTextPane();
		txtpnName.setEnabled(false);
		txtpnName.setEditable(false);
		txtpnName.setForeground(SystemColor.controlDkShadow);
		txtpnName.setBackground(SystemColor.controlHighlight);
		txtpnName.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnName.setText("NAME");
		txtpnName.setBounds(605, 183, 228, 59);
		contentPane.add(txtpnName);
		
		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setEnabled(false);
		txtpnAge.setEditable(false);
		txtpnAge.setText("AGE");
		txtpnAge.setForeground(SystemColor.controlDkShadow);
		txtpnAge.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnAge.setBackground(SystemColor.controlHighlight);
		txtpnAge.setBounds(605, 255, 238, 59);
		contentPane.add(txtpnAge);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setText("PHONE");
		textPane.setForeground(SystemColor.controlDkShadow);
		textPane.setFont(new Font("Times New Roman", Font.BOLD, 40));
		textPane.setBackground(SystemColor.controlHighlight);
		textPane.setBounds(605, 475, 228, 59);
		contentPane.add(textPane);
		
		JTextPane txtpnGender = new JTextPane();
		txtpnGender.setEnabled(false);
		txtpnGender.setEditable(false);
		txtpnGender.setText("GENDER");
		txtpnGender.setForeground(SystemColor.controlDkShadow);
		txtpnGender.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnGender.setBackground(SystemColor.controlHighlight);
		txtpnGender.setBounds(605, 331, 228, 59);
		contentPane.add(txtpnGender);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEnabled(false);
		textPane_1.setEditable(false);
		textPane_1.setText("MOBILE");
		textPane_1.setForeground(SystemColor.controlDkShadow);
		textPane_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		textPane_1.setBackground(SystemColor.controlHighlight);
		textPane_1.setBounds(605, 551, 228, 59);
		contentPane.add(textPane_1);
		
		JTextPane txtpnDateOfBirth = new JTextPane();
		txtpnDateOfBirth.setEnabled(false);
		txtpnDateOfBirth.setEditable(false);
		txtpnDateOfBirth.setText("D.O.B");
		txtpnDateOfBirth.setForeground(SystemColor.controlDkShadow);
		txtpnDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnDateOfBirth.setBackground(SystemColor.controlHighlight);
		txtpnDateOfBirth.setBounds(605, 403, 238, 59);
		contentPane.add(txtpnDateOfBirth);
		
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setEnabled(false);
		txtpnAddress.setEditable(false);
		txtpnAddress.setText("ADDRESS");
		txtpnAddress.setForeground(SystemColor.controlDkShadow);
		txtpnAddress.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnAddress.setBackground(SystemColor.controlHighlight);
		txtpnAddress.setBounds(605, 704, 238, 59);
		contentPane.add(txtpnAddress);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEnabled(false);
		txtpnEmail.setEditable(false);
		txtpnEmail.setText("E-MAIL");
		txtpnEmail.setForeground(SystemColor.controlDkShadow);
		txtpnEmail.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtpnEmail.setBackground(SystemColor.controlHighlight);
		txtpnEmail.setBounds(605, 619, 238, 59);
		contentPane.add(txtpnEmail);
		JButton btnNew = new JButton("New");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent at)
			{
				nw n=null;
				n = new nw(nameList, lm,label_11);
				n.setLocation(500, 175);
				n.setVisible(true);
				nameList.clearSelection();
				
			}
		});
		btnNew.setBounds(699, 902, 110, 42);
		contentPane.add(btnNew);
		
		JButton btnDelete = new JButton("Edit");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent at)
			{
				edit e=null;
				String sel=nameList.getSelectedValue().toString();
					e = new edit(sel,lm,nameList,label_11);
					e.setLocation(500, 175);
					e.setVisible(true);
				
			}
		});
		btnDelete.setBounds(877, 902, 133, 42);
		contentPane.add(btnDelete);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int warn=JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete?", "Warning", JOptionPane.YES_NO_OPTION);
				if(warn==JOptionPane.YES_OPTION)
				{
					String selected=nameList.getSelectedValue().toString();
					String b="delete from address_book.info where Name='"+selected+"'";
					
					try
				{
					Connection conn=null;
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
					Statement stm=conn.prepareStatement(b);
					stm.execute(b);
				}
				catch(Exception m)
				{
				}
					nameList.setModel(lm);
					lm.clear();
					nameList.setSelectedIndex(0);
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
		}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete_1.setBounds(1078, 902, 121, 42);
		contentPane.add(btnDelete_1);
		
		
		JButton btnSetLogInfo = new JButton("Set Log Info");
		btnSetLogInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				log l=new log();
				l.setLocation(800, 400);
				l.setVisible(true);
			}
		});
		btnSetLogInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSetLogInfo.setBounds(1266, 902, 147, 42);
		contentPane.add(btnSetLogInfo);
		
		JLabel lblNames = new JLabel("Names");
		lblNames.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblNames.setForeground(SystemColor.controlDkShadow);
		lblNames.setBounds(52, 57, 473, 81);
		contentPane.add(lblNames);
		
		JLabel label_8 = new JLabel("\u00A9ayushd");
		label_8.setBounds(1858, 985, 56, 16);
		contentPane.add(label_8);				
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(new Color(60, 179, 113));
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 60));
		label_9.setBounds(1506, 95, 220, 59);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(new Color(60, 179, 113));
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 60));
		label_10.setBounds(1738, 95, 115, 59);
		contentPane.add(label_10);
		
		JLabel lblLastUpdatedOn = new JLabel("Last updated on");
		lblLastUpdatedOn.setForeground(Color.DARK_GRAY);
		lblLastUpdatedOn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblLastUpdatedOn.setBounds(1556, 902, 170, 42);
		contentPane.add(lblLastUpdatedOn);
		
		Timer timer=new Timer(1000,new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				SimpleDateFormat f=new SimpleDateFormat("hh:mm:ss");
				Date d=new Date();
				label_9.setText(f.format(d).toString());
				SimpleDateFormat ff=new SimpleDateFormat("a");
				label_10.setText(ff.format(d).toString());
			}
		});
		timer.start();
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("ComboBox.disabledBackground"));
		textField.setForeground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		textField.setBounds(52, 137, 411, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFocusable(false);
		textField.setText("Search...");
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.DARK_GRAY);
		label_12.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		label_12.setBounds(141, 913, 228, 31);
		contentPane.add(label_12);
		label_12.setText("Displaying "+lm.getSize()+" Names");
		textField.addFocusListener(new FocusListener() 
		{
			
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				// TODO Auto-generated method stub
				textField.setText("Search...");
			}
			
			@Override
			public void focusGained(FocusEvent arg0)
			{
				// TODO Auto-generated method stub
				textField.setText(null);
			}
		});
		textField.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				textField.setFocusable(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				
				textField.setText(null);
			}
		});
		textField.addKeyListener(new KeyListener() 
		{
			
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub
				String r=textField.getText().toLowerCase();
				Vector v=new Vector();
				try
				{
					Connection ceo=null;
					Class.forName("com.mysql.jdbc.Driver");
					ceo=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false", "root", "oracle");
					Statement stt=ceo.createStatement();
					ResultSet rrs=stt.executeQuery("select Name from address_book.info order by Name ASC");
				while(rrs.next())
				{
					if(rrs.getString("Name").toString().toLowerCase().indexOf(r)>=0)
					{
						v.addElement(rrs.getString("Name"));
						lm.clear();
					}
				}
				nameList.setListData(v);
				if(v.size()==1)
				{
				label_12.setText(v.size()+" result found");	
				}
				else
					if(v.size()==0)
					{
						label_12.setText("no result found");	
					}
				else
				{
				label_12.setText(v.size()+" results found");
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent k) 
			{
				// TODO Auto-generated method stub
			}
		});
	}
	private ListCellRenderer<? super String>getRenderer()
	{
		return new DefaultListCellRenderer()
		{
		@Override
		public Component getListCellRendererComponent(JList<?>list,Object value,int index,boolean isSelected,boolean cellHasFocus)
		{
			JLabel listCellRendererComponent=(JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			//listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			if(index%2==0)
			{
				setBackground(UIManager.getColor("ComboBox.disabledBackground"));
				
			}
			else
			{
				setBackground(Color.WHITE);
			}
			if(isSelected)
			{
				setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
				setForeground(Color.WHITE);
			}
			
			
			return listCellRendererComponent;
		}
		};
	}
}
