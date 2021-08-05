package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entity.*;


public class FoodFrame extends JFrame implements ActionListener
{
	private JLabel backLabel;
	private JButton clearBtn, logoutBtn,backBtn, breakFastBtn, lunchBtn, dinnerBtn;
	private JCheckBox rice, beef, fish, dal, milk, fruits, bread, butter, chicken, toast, noodles, tea;
	//private JCheckBox c[];
	private JScrollPane foodTableScrollPane;
	private JTable foodTable;
	
	private String data[][];
	private JPanel panel;
	
	User user;

	public FoodFrame(User user)
	{
		super("Food Management");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		//String data[][] ={{"", "", ""}};
		//String data[][] = new String[12][3];
		//JCheckBox c[] = new JCheckBox[12];
		data = new String[12][3];
		String head[] = {"Breakfast", "lunch", "Dinner"};
		
		
		
		//////////
		
		/*for (int i=0; i<12;i++)
		{
			data[i][0]="food";
		}*/
		
		foodTable = new JTable(data,head);
		foodTableScrollPane = new JScrollPane(foodTable);
		foodTableScrollPane.setBounds(30,200, 470, 200);
		foodTable.setEnabled(false);
		panel.add(foodTableScrollPane);
		
		
		
		
		
		
		
		//checkboxes.........................
		
		
		rice = new JCheckBox("Rice");
		rice.setBounds(30, 100, 70, 30);
		rice.setOpaque(false);
		panel.add(rice);
		
		beef = new JCheckBox("Beef");
		beef.setBounds(30, 150, 70, 30);
		beef.setOpaque(false);
		panel.add(beef);
		
		
		fish = new JCheckBox("Fish");
		fish.setBounds(130, 100, 70, 30);
		fish.setOpaque(false);
		panel.add(fish);
		
		dal = new JCheckBox("Daal");
		dal.setBounds(130, 150, 70, 30);
		dal.setOpaque(false);
		panel.add(dal);
		
		
		milk = new JCheckBox("Milk");
		milk.setBounds(230, 100, 70, 30);
		milk.setOpaque(false);
		panel.add(milk);
		
		fruits = new JCheckBox("Fruits");
		fruits.setBounds(230, 150, 70, 30);
		fruits.setOpaque(false);
		panel.add(fruits);
		
		
		bread = new JCheckBox("Bread");
		bread.setBounds(330, 100, 70, 30);
		bread.setOpaque(false);
		panel.add(bread);
		
		butter = new JCheckBox("Buter");
		butter.setBounds(330, 150, 70, 30);
		butter.setOpaque(false);
		panel.add(butter);
		
		chicken = new JCheckBox("Chiken");
		chicken.setBounds(430, 100, 70, 30);
		chicken.setOpaque(false);
		panel.add(chicken);
		
		toast = new JCheckBox("Toast");
		toast.setBounds(430, 150, 70, 30);
		toast.setOpaque(false);
		panel.add(toast);
		
		noodles = new JCheckBox("Noodles");
		noodles.setBounds(530, 100, 80, 30);
		noodles.setOpaque(false);
		panel.add(noodles);
		
		tea = new JCheckBox("Tea");
		tea.setBounds(530, 150, 70, 30);
		tea.setOpaque(false);
		panel.add(tea); 
		
		
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(650, 340, 80, 30);
		clearBtn.addActionListener(this);
		panel.add(clearBtn);
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(20, 50, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		breakFastBtn = new JButton("Add Breakfast");
		breakFastBtn.setBounds(630, 140, 120, 30);
		breakFastBtn.addActionListener(this);
		panel.add(breakFastBtn);
		
		lunchBtn = new JButton("Add Lunch");
		lunchBtn.setBounds(630, 200, 120, 30);
		lunchBtn.addActionListener(this);
		panel.add(lunchBtn);
		
		dinnerBtn = new JButton("Add Dinner");
		dinnerBtn.setBounds(630, 260, 120, 30);
		dinnerBtn.addActionListener(this);
		panel.add(dinnerBtn);
		
		
		
		
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
		
		else if(command.equals(backBtn.getText()))
		{
			UserHome uh = new UserHome(user);
			uh.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(breakFastBtn.getText()))
		{
			for(int i=0; i<12;i++)
			{
				data[i][0]="";
			}
			
			
			
			
			for (int i=0; i<12;i++)
			{
				if(rice.isSelected())
				{
					data[i][0]=rice.getText();
					rice.setSelected(false);
					
				}
				
				else if(beef.isSelected())
				{
					data[i][0] = beef.getText();
					beef.setSelected(false);
				}
				
				else if(fish.isSelected())
				{
					data[i][0] = fish.getText();
					fish.setSelected(false);
				}
				
				else if(dal.isSelected())
				{
					data[i][0]=dal.getText();
					dal.setSelected(false);
				}
				
				else if(milk.isSelected())
				{
					data[i][0]=milk.getText();
					milk.setSelected(false);
				}
				
				else if(fruits.isSelected())
				{
					data[i][0]=fruits.getText();
					fruits.setSelected(false);
				}
				
				else if(bread.isSelected())
				{
					data[i][0]=bread.getText();
					bread.setSelected(false);
				}
				
				else if(butter.isSelected())
				{
					data[i][0]=butter.getText();
					butter.setSelected(false);
				}
				
				else if(chicken.isSelected())
				{
					data[i][0]=chicken.getText();
					chicken.setSelected(false);
				}
				
				else if(toast.isSelected())
				{
					data[i][0]=toast.getText();
					toast.setSelected(false);
				}
				
				else if(noodles.isSelected())
				{
					data[i][0]=noodles.getText();
					noodles.setSelected(false);
				}
				
				else if(tea.isSelected())
				{
					data[i][0]=tea.getText();
					tea.setSelected(false);
				}
				else{}
				
				String head[] = {"Breakfast", "lunch", "Dinner"};
				foodTable = new JTable(data,head);
				foodTableScrollPane = new JScrollPane(foodTable);
				foodTableScrollPane.setBounds(30,200, 470, 200);
				foodTable.setEnabled(false);
				panel.add(foodTableScrollPane);
			}
			
			
		}
		
		else if(command.equals(lunchBtn.getText()))
		{
			for(int i=0; i<12;i++)
			{
				data[i][1]="";
			}
			
			for (int i=0; i<12;i++)
			{
				if(rice.isSelected())
				{
					data[i][1]=rice.getText();
					rice.setSelected(false);
					
				}
				
				else if(beef.isSelected())
				{
					data[i][1] = beef.getText();
					beef.setSelected(false);
				}
				
				else if(fish.isSelected())
				{
					data[i][1] = fish.getText();
					fish.setSelected(false);
				}
				
				else if(dal.isSelected())
				{
					data[i][1]=dal.getText();
					dal.setSelected(false);
				}
				
				else if(milk.isSelected())
				{
					data[i][1]=milk.getText();
					milk.setSelected(false);
				}
				
				else if(fruits.isSelected())
				{
					data[i][1]=fruits.getText();
					fruits.setSelected(false);
				}
				
				else if(bread.isSelected())
				{
					data[i][1]=bread.getText();
					bread.setSelected(false);
				}
				
				else if(butter.isSelected())
				{
					data[i][1]=butter.getText();
					butter.setSelected(false);
				}
				
				else if(chicken.isSelected())
				{
					data[i][1]=chicken.getText();
					chicken.setSelected(false);
				}
				
				else if(toast.isSelected())
				{
					data[i][1]=toast.getText();
					toast.setSelected(false);
				}
				
				else if(noodles.isSelected())
				{
					data[i][1]=noodles.getText();
					noodles.setSelected(false);
				}
				
				else if(tea.isSelected())
				{
					data[i][1]=tea.getText();
					tea.setSelected(false);
				}
				else{}
				
				String head[] = {"Breakfast", "lunch", "Dinner"};
				foodTable = new JTable(data,head);
				foodTableScrollPane = new JScrollPane(foodTable);
				foodTableScrollPane.setBounds(30,200, 470, 200);
				foodTable.setEnabled(false);
				panel.add(foodTableScrollPane);
			}
				
				
				
			
		}
		
		else if(command.equals(dinnerBtn.getText()))
		{
			for(int i=0; i<12;i++)
			{
				data[i][2]="";
			}
			
			for (int i=0; i<12;i++)
			{
				if(rice.isSelected())
				{
					data[i][2]=rice.getText();
					rice.setSelected(false);
					
				}
				
				else if(beef.isSelected())
				{
					data[i][2] = beef.getText();
					beef.setSelected(false);
				}
				
				else if(fish.isSelected())
				{
					data[i][2] = fish.getText();
					fish.setSelected(false);
				}
				
				else if(dal.isSelected())
				{
					data[i][2]=dal.getText();
					dal.setSelected(false);
				}
				
				else if(milk.isSelected())
				{
					data[i][2]=milk.getText();
					milk.setSelected(false);
				}
				
				else if(fruits.isSelected())
				{
					data[i][2]=fruits.getText();
					fruits.setSelected(false);
				}
				
				else if(bread.isSelected())
				{
					data[i][2]=bread.getText();
					bread.setSelected(false);
				}
				
				else if(butter.isSelected())
				{
					data[i][2]=butter.getText();
					butter.setSelected(false);
				}
				
				else if(chicken.isSelected())
				{
					data[i][2]=chicken.getText();
					chicken.setSelected(false);
				}
				
				else if(toast.isSelected())
				{
					data[i][2]=toast.getText();
					toast.setSelected(false);
				}
				
				else if(noodles.isSelected())
				{
					data[i][2]=noodles.getText();
					noodles.setSelected(false);
				}
				
				else if(tea.isSelected())
				{
					data[i][2]=tea.getText();
					tea.setSelected(false);
				}
				else
				{
					
				}
				
				String head[] = {"Breakfast", "lunch", "Dinner"};
				foodTable = new JTable(data,head);
				foodTableScrollPane = new JScrollPane(foodTable);
				foodTableScrollPane.setBounds(30,200, 470, 200);
				foodTable.setEnabled(false);
				panel.add(foodTableScrollPane);
			}
		
			
		}
		else if(command.equals(clearBtn.getText()))
		{
			for(int i=0; i<12;i++)
			{
				data[i][0]="";
			}
			
			for(int i=0; i<12;i++)
			{
				data[i][1]="";
			}
			
			for(int i=0; i<12;i++)
			{
				data[i][2]="";
			}
			
			
			String head[] = {"Breakfast", "lunch", "Dinner"};
			foodTable = new JTable(data,head);
			foodTableScrollPane = new JScrollPane(foodTable);
			foodTableScrollPane.setBounds(30,200, 470, 200);
			foodTable.setEnabled(false);
			panel.add(foodTableScrollPane);
		}
		
		else {}
	}
	
	
	
}