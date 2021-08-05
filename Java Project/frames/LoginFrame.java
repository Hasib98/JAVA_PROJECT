package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.border.*;
import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	
	JLabel title, userLabel, passLabel, backgroundImageLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, showPassBtn;
	Color panelColor;
	Font Lebelfont;
	Border border;
	JPanel panel;
	
	public LoginFrame()
	{
		super("Prison Management System - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.Lebelfont = new Font("Cambria", Font.PLAIN | Font.BOLD, 14);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		
		title = new JLabel("Prison Management System");
		title.setBounds(270, 50, 350, 40);
		title.setFont(new Font("Cambria", Font.PLAIN | Font.BOLD, 18));
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		userLabel = new JLabel("User   ID     :");
		userLabel.setBounds(280, 100, 80, 30);
		userLabel.setFont(Lebelfont);
		userLabel.setForeground(Color.WHITE);
		panel.add(userLabel);
		
		userTF = new JTextField("e00001");
		userTF.setBounds(370, 100, 130, 30);
		userTF.setFont(Lebelfont);
		userTF.setForeground(Color.WHITE);
		border= BorderFactory.createMatteBorder(0,0,3,0, new Color(160,160,160));
		userTF.setBorder(border);
		userTF.setOpaque(false);
		panel.add(userTF);
		
		passLabel = new JLabel("Password  :");
		passLabel.setBounds(280, 150, 80, 30);
		passLabel.setFont(Lebelfont);
		passLabel.setForeground(Color.WHITE);
		
		panel.add(passLabel);
		
		passPF = new JPasswordField("1234");
		passPF.setBounds(370, 150, 100, 30);
		passPF.setFont(Lebelfont);
		passPF.setForeground(Color.WHITE);
		border= BorderFactory.createMatteBorder(0,0,3,0, new Color(160,160,160));
		passPF.setBorder(border);
		passPF.setOpaque(false);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPassBtn = new JButton();
		showPassBtn.setIcon(new ImageIcon("resources/show1.png"));
		showPassBtn.setBounds(470,150,30,30);
		showPassBtn.setBackground(Color.BLACK);
		border= BorderFactory.createMatteBorder(0,0,3,0, new Color(160,160,160));
		showPassBtn.setBorder(border);
		showPassBtn.setOpaque(false);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.setBackground(new Color(172,0,172));
		loginBtn.setFont(Lebelfont);
		loginBtn.setForeground(Color.WHITE);
		border= BorderFactory.createMatteBorder(0,0,0,0, new Color(160,160,160));
		loginBtn.setBorder(border);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this); 
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.setBackground(new Color(172,0,172));
		exitBtn.setFont(Lebelfont);
		exitBtn.setForeground(Color.WHITE);
		border= BorderFactory.createMatteBorder(0,0,0,0, new Color(160,160,160));
		exitBtn.setBorder(border);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(this);
		panel.add(exitBtn);
		
		backgroundImageLabel = new JLabel(new ImageIcon("resources/prison5.jpg"));
		backgroundImageLabel.setBounds(0,0,800,450);
		panel.add(backgroundImageLabel);
		
		
		
		this.add(panel);
	}
	//override
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 || user.getStatus() == 1 || user.getStatus() == 2)
				{
					UserHome uh = new UserHome(user);
					uh.setVisible(true);
					this.setVisible(false);
				}
				
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		
		else{}
	}
	//override
	public void mouseClicked(MouseEvent me)
	{
		
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(new Color(233,0,233));
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(new Color(233,0,233));
		}
		
		else if(me.getSource() == showPassBtn)
		{
			
			passPF.setEchoChar((char)0);
			
			showPassBtn.setIcon(new ImageIcon("resources/show2.png"));
		}
		else{}
		
	}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource() == showPassBtn)
		{
			passPF.setEchoChar('*');
			showPassBtn.setIcon(new ImageIcon("resources/show1.png"));
		}
		
	}
	public void mouseEntered(MouseEvent me)
	{
		
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(new Color(215,0,215));
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(new Color(215,0,215));
		}
		else{}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(new Color(172,0,172));
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(new Color(172,0,172));
		}
		else{}
	}
}