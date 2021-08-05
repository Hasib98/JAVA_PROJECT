package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entity.*;
import repository.*;

public class ChangePasswordFrame extends JFrame implements ActionListener
{
	private JButton logoutBtn,backBtn, changePasswordBtn;
	private JLabel passwordLabel,newPassLabel,confirmPassLabel,backLabel;
	private JTextField passwordTF;
	private JPasswordField newpasswordPF, confirmpasswordPF; 
	//UserRepo ur;
	
	private JPanel panel;
	
	User user;


	public ChangePasswordFrame(User user)
	{
		super("Change Passowrd");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.user = user;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		passwordLabel = new JLabel("Password : ");
		passwordLabel.setBounds(300, 100, 80, 30);
		panel.add(passwordLabel);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(420, 100, 100, 30);
		panel.add(passwordTF);
		
		newPassLabel = new JLabel(" New Password : ");
		newPassLabel.setBounds(300, 150, 120, 30);
		panel.add(newPassLabel);
		
		newpasswordPF = new JPasswordField();
		newpasswordPF.setBounds(420, 150, 100, 30);
		newpasswordPF.setEchoChar('*');
		panel.add(newpasswordPF);
		
		confirmPassLabel = new JLabel(" Confrim Password : ");
		confirmPassLabel.setBounds(300, 200, 120, 30);
		panel.add(confirmPassLabel);
		
		confirmpasswordPF = new JPasswordField();
		confirmpasswordPF.setBounds(420, 200, 100, 30);
		confirmpasswordPF.setEchoChar('*');
		panel.add(confirmpasswordPF);
		
		
		
		
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds( 420, 250, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		backLabel = new JLabel(new ImageIcon("resources/prison8.jpg"));
		backLabel.setBounds(0,0,800,450);
		panel.add(backLabel);
		
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(backBtn.getText()))
		{
			UserHome uh = new UserHome(user);
			uh.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		
		else if(command.equals(changePasswordBtn.getText()))
		{
			String confirmpassword=confirmpasswordPF.getText();
			if( confirmpassword.equals(newpasswordPF.getText()))
			{
				User user = new User();
				user= this.user;
				
				if(user.getPassword().equals(passwordTF.getText()))
				{
					user.setPassword(newpasswordPF.getText());
					try 
					{
						UserRepo ur =new UserRepo();
						
						ur.ChangePasswordInDB(user);
						JOptionPane.showMessageDialog(this, "Updated");
						
						passwordTF.setText("");
						newpasswordPF.setText("");
						confirmpasswordPF.setText("");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(this, "Error");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Current Passoword is Wrong");
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Confirm Password Doesn't match with new Password");
			}
			
			
		}
		
		
		
		else {}
	}
	
	
	
}