package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class UserHome extends JFrame implements ActionListener
{

	JButton logoutBtn, manageEmpBtn, managePrisonerBtn, manageFoodBtn, changePasswordBtn;
	JPanel panel;
	JLabel backLabel;
	
	User user;
	
	
	public UserHome(User user)
	{
		
		
		super("Welcome Employee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
	
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(600, 300, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		managePrisonerBtn = new JButton("Manage Prisoner");
		managePrisonerBtn.setBounds(300, 100, 150, 30);
		managePrisonerBtn.addActionListener(this);
		panel.add(managePrisonerBtn);
		
		manageEmpBtn = new JButton("Manage Employee");
		manageEmpBtn.setBounds(300, 190, 150, 30);
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		
		manageFoodBtn = new JButton("Manage Foods");
		manageFoodBtn.setBounds(300, 280, 150, 30);
		manageFoodBtn.addActionListener(this);
		panel.add(manageFoodBtn);
		
		backLabel = new JLabel(new ImageIcon("resources/prison8.jpg"));
		backLabel.setBounds(0,0,800,450);
		panel.add(backLabel);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				EmployeeFrame ef = new EmployeeFrame(user);
				ef.setVisible(true);
				this.setVisible(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(managePrisonerBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				PrisonerFrame pf = new PrisonerFrame(user);
				pf.setVisible(true);
				this.setVisible(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(manageFoodBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==2)
			{
				FoodFrame ff = new FoodFrame(user);
				ff.setVisible(true);
				this.setVisible(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(changePasswordBtn.getText()))
		{
			
				ChangePasswordFrame ff = new ChangePasswordFrame(user);
				ff.setVisible(true);
				this.setVisible(false);
		}
		else{}
	}
}