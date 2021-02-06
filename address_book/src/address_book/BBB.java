package address_book;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BBB
{

	public static void main(String[] args) throws Exception
	{		
	
		JFrame frmAddressBook=new JFrame();
		frmAddressBook.setTitle("Address Book");
		frmAddressBook.setResizable(false);
		frmAddressBook.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAddressBook.setLocation(650, 300);
		frmAddressBook.setSize(645, 504);
		frmAddressBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00A9ayushd");
		lblNewLabel.setBounds(571, 440, 56, 16);
		frmAddressBook.getContentPane().add(lblNewLabel);
		final JProgressBar progressBar=new JProgressBar(0,100);
		progressBar.setForeground(new Color(0, 128, 0));
		progressBar.setBounds(0, 456, 640, 14);
		progressBar.setValue(0);
		progressBar.setBorderPainted(true);
		frmAddressBook.getContentPane().add(progressBar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BBB.class.getResource("/address_book/ab.jpg")));
		label.setBounds(0, 0, 640, 455);
		frmAddressBook.getContentPane().add(label);
		frmAddressBook.setVisible(true);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Thread()
		{
			public void run()
			{
				while(true)
				{
					if(progressBar.getValue()>=99)
					{
						
						frmAddressBook.dispose();
						menu m=new menu();
						m.setVisible(true);
						m.setLocationRelativeTo(frmAddressBook);
						m.setResizable(false);
						break;
					}
					SwingUtilities.invokeLater(new Runnable() 
					{
						
						@Override
						public void run() 
						{
							progressBar.setValue(progressBar.getValue() + 5);
						}
					});
					try
					{
						Thread.sleep(450);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}