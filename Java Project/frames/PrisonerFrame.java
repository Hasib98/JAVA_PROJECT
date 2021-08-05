package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;  

import entity.*;
import repository.*;

public class PrisonerFrame extends JFrame implements ActionListener
{
	private JButton logoutBtn,backBtn,searchBtn, getAllBtn, deleteBtn, insertBtn, updateBtn, formUpdateBtn,formInsertBtn,defaultBtn;
	private JTable prisonerTable;
	private JScrollPane prisonerTableScrollPane;
	private JLabel searchguideLebel, prisonIdLabel, prisonNameLabel, formIdLabel,formNameLabel,formAgeLabel,formCellNumberLabel,formCrimeTypeLabel, formGenderLebel,formEntryDateLabel, formReleaseDateLabel,borderLabel1,borderLabel2,borderLabel3;
	private JTextField prisonIdTF, prisonNameTF, formIdTF,formNameTF, formAgeTF, formCellNumberTF, formCrimeTypeTF;
	private JComboBox genderCombo;
	private JSpinner formEntryDateSpinner, formReleaseDateSpinner;
	private Date date;
	private DateFormat dateFormat;
	private String id;
	
	private JPanel panel;
	
	User user;
	
	private PrisonerRepo pr;
	private UserRepo ur;
	
	private int X=110,Y=260;


	public PrisonerFrame(User user)
	{
		super("Prisoner Management");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.user = user;
		
		pr = new PrisonerRepo();
		ur= new UserRepo();
		dateFormat = new SimpleDateFormat("yyyy:MM:dd");
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		/*...border label....*/
		
		borderLabel1 = new JLabel();
		borderLabel1.setBounds(0,230,350,3);
		borderLabel1.setBackground(Color.BLACK);
		borderLabel1.setOpaque(true);
		panel.add(borderLabel1);
		
		borderLabel2 = new JLabel();
		borderLabel2.setBounds(350,0,3,440);
		borderLabel2.setBackground(Color.BLACK);
		borderLabel2.setOpaque(true);
		panel.add(borderLabel2);
		
		borderLabel3 = new JLabel();
		borderLabel3.setBounds(0,440,800,3);
		borderLabel3.setBackground(Color.BLACK);
		borderLabel3.setOpaque(true);
		panel.add(borderLabel3);
		
		
		
		
		
		String data[][] = {{"", "", "", "","", "","","",""}};
		String head[] = {"PrisonerId", "PrisonerName", "Gender", "Age","CrimeType","CellNumber","EntryDate","ReleaseDate","DayLeft"};
		
		prisonerTable = new JTable(data,head);
		prisonerTableScrollPane = new JScrollPane(prisonerTable);
		prisonerTableScrollPane.setBounds(0,515, 800, 250);
		prisonerTable.setEnabled(false);
		panel.add(prisonerTableScrollPane);
		
		
		searchguideLebel = new JLabel("Search by either ID or Name");
		searchguideLebel.setBounds(90,60,200,20);
		panel.add(searchguideLebel);
	
		
		prisonIdLabel = new JLabel("Prison ID:");
		prisonIdLabel.setBounds(20,80,80,30);
		panel.add(prisonIdLabel);
		
		prisonIdTF = new JTextField();
		prisonIdTF.setBounds(120,80,100,30);
		panel.add(prisonIdTF);
		
		prisonNameLabel = new JLabel("Name:");
		prisonNameLabel.setBounds(20, 130,80,30);
		panel.add(prisonNameLabel);
		
		prisonNameTF = new JTextField();
		prisonNameTF.setBounds(120,130,100,30);
		panel.add(prisonNameTF);
		
		
		
		formIdLabel = new JLabel("ID:");
		formIdLabel.setBounds(370,80,30,30);
		panel.add(formIdLabel);
		
		formIdTF = new JTextField();
		formIdTF.setBounds(440,80,100,30);
		formIdTF.setEnabled(false);
		panel.add(formIdTF);
		
		formNameLabel = new JLabel("Name:");
		formNameLabel.setBounds(570, 80,40,30);
		panel.add(formNameLabel);
		
		formNameTF = new JTextField();
		formNameTF.setBounds(660,80,100,30);
		formNameTF.setEnabled(false);
		panel.add(formNameTF);
		
		
		formGenderLebel = new JLabel("Gender:");
		formGenderLebel.setBounds(370,130,50,30);
		panel.add(formGenderLebel);
		
		String gender[] = new String []{"", "Male", "Female"};
		genderCombo = new JComboBox(gender);
		genderCombo.setBounds(440, 130,100,30);
		genderCombo.setEnabled(false);
		panel.add(genderCombo);
		
		formAgeLabel = new JLabel("Age:");
		formAgeLabel.setBounds(570,130,30,30);
		panel.add(formAgeLabel);
		
		formAgeTF = new JTextField();
		formAgeTF.setBounds(660,130,100,30);
		formAgeTF.setEnabled(false);
		panel.add(formAgeTF);
		
		//////
		formCellNumberLabel = new JLabel("Cell No:");
		formCellNumberLabel.setBounds(370,180,50,30);
		panel.add(formCellNumberLabel);
		
		
		formCellNumberTF = new JTextField();
		formCellNumberTF.setBounds(440,180,100,30);
		formCellNumberTF.setEnabled(false);
		panel.add(formCellNumberTF);
		
		
		formCrimeTypeLabel = new JLabel("Crime:");
		formCrimeTypeLabel.setBounds(570,180,40,30);
		panel.add(formCrimeTypeLabel);
		
		
		formCrimeTypeTF = new JTextField();
		formCrimeTypeTF.setBounds(660,180,100,30);
		formCrimeTypeTF.setEnabled(false);
		panel.add(formCrimeTypeTF);
		
		
		formEntryDateLabel = new JLabel("Entry Date:");
		formEntryDateLabel.setBounds(370,230,70,30);
		panel.add(formEntryDateLabel);
		
		
		date =new Date();
		SpinnerDateModel esdm = new SpinnerDateModel(date,null,null, Calendar.DAY_OF_MONTH);
		formEntryDateSpinner = new JSpinner(esdm);
		formEntryDateSpinner.setBounds(440,230,100,30);
		JSpinner.DateEditor ede = new JSpinner.DateEditor(formEntryDateSpinner, "yyyy:MM:dd");
		formEntryDateSpinner.setEditor(ede);
		formEntryDateSpinner.setEnabled(false);
		panel.add(formEntryDateSpinner);
		//DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
		//String strDate = dateFormat.format(formReleaseDateSpinner.getValue());
		
		
		
		formReleaseDateLabel = new JLabel("Release Date:");
		formReleaseDateLabel.setBounds(570,230,80,30);
		panel.add(formReleaseDateLabel);
		
		
		date =new Date();
		SpinnerDateModel rsdm = new SpinnerDateModel(date,null,null, Calendar.DAY_OF_MONTH);
		formReleaseDateSpinner = new JSpinner(rsdm);
		formReleaseDateSpinner.setBounds(660,230,100,30);
		JSpinner.DateEditor rde = new JSpinner.DateEditor(formReleaseDateSpinner, "yyyy:MM:dd");
		formReleaseDateSpinner.setEditor(rde);
		formReleaseDateSpinner.setEnabled(false);
		panel.add(formReleaseDateSpinner);
		
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
		//String strDate = dateFormat.format(formReleaseDateSpinner.getValue());
		
		
		
		
		
		
		
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(620, 20, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(20, 20, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(130, 190, 80, 30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);
		
		updateBtn = new JButton("Update Data");
		updateBtn.setBounds(X,Y,110,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		
		insertBtn = new JButton("Insert Data");
		insertBtn.setBounds(X,Y+50,110,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		
		
		deleteBtn = new JButton("Delete Data");
		deleteBtn.setBounds(X,Y+100,110,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		
		
		getAllBtn = new JButton("All Prisoner Data");
		getAllBtn.setBounds(300, 480, 170, 25);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		//////////////////
		
		formUpdateBtn = new JButton("Update");
		formUpdateBtn.setBounds(520,310,100,30);
		formUpdateBtn.addActionListener(this);
		formUpdateBtn.setVisible(false);
		panel.add(formUpdateBtn);
		//formUpdateBtn.setVisible(false);
		
		
		
		formInsertBtn = new JButton("Insert");
		formInsertBtn.setBounds(520,310,100,30);
		formInsertBtn.setVisible(false);
		formInsertBtn.addActionListener(this);
		panel.add(formInsertBtn);
		//formInsertBtn.setVisible(false);
		
		
		defaultBtn = new JButton("Default");
		defaultBtn.setBounds(670, 480, 80, 25);
		defaultBtn.addActionListener(this);
		panel.add(defaultBtn);
		
		
		
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
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllPrisoner();;
			String head[] = {"PrisonerId", "PrisonerName", "Gender", "Age","CrimeType","CellNumber","EntryDate","ReleaseDate","DayLeft"};
			
			panel.remove(prisonerTableScrollPane);
			
			prisonerTable = new JTable(data,head);
			prisonerTable.setEnabled(false);
			prisonerTableScrollPane = new JScrollPane(prisonerTable);
			prisonerTableScrollPane.setBounds(0,515, 800, 250);
			panel.add(prisonerTableScrollPane);
			
			panel.revalidate();
			panel.repaint();
		}
		
		else if(command.equals(searchBtn.getText()))
		{
			
			String IdBoxText = prisonIdTF.getText();
			String NameBoxText = prisonNameTF.getText();
			
			
			
			//if(!IdBoxText.equals("") || !IdBoxText.equals(null))
			if(!IdBoxText.equals(""))
			{
				
				String data[][] = pr.searchPrisonerByPrisonerId(prisonIdTF.getText());
				System.out.println(data.length);
				
				if(data.length!=0)
				{
					id=IdBoxText;
					String head[] = {"PrisonerId", "PrisonerName", "Gender", "Age","CrimeType","CellNumber","EntryDate","ReleaseDate","DayLeft"};
					
					panel.remove(prisonerTableScrollPane);
					
					prisonerTable = new JTable(data,head);
					prisonerTable.setEnabled(false);
					prisonerTableScrollPane = new JScrollPane(prisonerTable);
					prisonerTableScrollPane.setBounds(0,515, 800, 250);
					panel.add(prisonerTableScrollPane);
					
					panel.revalidate();
					panel.repaint();
					
					
					updateBtn.setEnabled(true);
					insertBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					prisonIdTF.setText("");
					prisonNameTF.setText("");
					
					
					formIdTF.setEnabled(false);
					formNameTF.setEnabled(false);
					genderCombo.setEnabled(false);
					formAgeTF.setEnabled(false);
					formCellNumberTF.setEnabled(false);
					formCrimeTypeTF.setEnabled(false);
					formEntryDateSpinner.setEnabled(false);
					formReleaseDateSpinner.setEnabled(false);
					
					formUpdateBtn.setVisible(false);
					formInsertBtn.setVisible(false);
				}
				else
				{
					
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
				
				
				
			}
			
			//else if(!NameBoxText.equals("") || !NameBoxText.equals(null))
			else if(!NameBoxText.equals(""))
			{
				
				String data[][] = pr.searchPrisonerByPrisonerName(prisonNameTF.getText());
				System.out.println(data.length);
				
				if(data.length!=0)
				{
					String head[] = {"PrisonerId", "PrisonerName", "Gender", "Age","CrimeType","CellNumber","EntryDate","ReleaseDate","DayLeft"};
				
					panel.remove(prisonerTableScrollPane);
					
					prisonerTable = new JTable(data,head);
					prisonerTable.setEnabled(false);
					prisonerTableScrollPane = new JScrollPane(prisonerTable);
					prisonerTableScrollPane.setBounds(0,515, 800, 250);
					panel.add(prisonerTableScrollPane);
					
					panel.revalidate();
					panel.repaint();
					
					updateBtn.setEnabled(false);
					deleteBtn.setEnabled(false);
					prisonIdTF.setText("");
					prisonNameTF.setText("");
					
					
					formIdTF.setEnabled(false);
					formNameTF.setEnabled(false);
					genderCombo.setEnabled(false);
					formAgeTF.setEnabled(false);
					formCellNumberTF.setEnabled(false);
					formCrimeTypeTF.setEnabled(false);
					formEntryDateSpinner.setEnabled(false);
					formReleaseDateSpinner.setEnabled(false);
					
					formUpdateBtn.setVisible(false);
					formInsertBtn.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Name");
				}
				
				
				
				
				
			}
			else{JOptionPane.showMessageDialog(this," Fields are empty. Input ID or Name to Search Data");}
		}
		
		else if(command.equals(defaultBtn.getText()))
		{
			
			String data[][] = {{"", "", "", "","", "","","",""}};
			String head[] = {"PrisonerId", "PrisonerName", "Gender", "Age","CrimeType","CellNumber","EntryDate","ReleaseDate","DayLeft"};
				
			panel.remove(prisonerTableScrollPane);
			
			prisonerTable = new JTable(data,head);
			prisonerTable.setEnabled(false);
			prisonerTableScrollPane = new JScrollPane(prisonerTable);
			prisonerTableScrollPane.setBounds(0,515, 800, 250);
			panel.add(prisonerTableScrollPane);
			
			panel.revalidate();
			panel.repaint();
			
			
			prisonIdTF.setText("");
			prisonNameTF.setText("");
			formIdTF.setText("");
			formNameTF.setText("");
			genderCombo.setSelectedIndex(0);
			formAgeTF.setText("");
			formCellNumberTF.setText("");
			formCrimeTypeTF.setText("");
			
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			
			
			formNameTF.setEnabled(false);
			genderCombo.setEnabled(false);
			formAgeTF.setEnabled(false);
			formCellNumberTF.setEnabled(false);
			formCrimeTypeTF.setEnabled(false);
			formEntryDateSpinner.setEnabled(false);
			formReleaseDateSpinner.setEnabled(false);
			formInsertBtn.setVisible(false);
			formUpdateBtn.setVisible(false);
			
		}
		
		else if(command.equals(updateBtn.getText()))
		{
			insertBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			formUpdateBtn.setVisible(true);
			formNameTF.setEnabled(true);
			genderCombo.setEnabled(true);
			formAgeTF.setEnabled(true);
			formCellNumberTF.setEnabled(true);
			formCrimeTypeTF.setEnabled(true);
			formEntryDateSpinner.setEnabled(true);
			formReleaseDateSpinner.setEnabled(true);
			
		}
		
		else if(command.equals(insertBtn.getText()))
		{
			formInsertBtn.setVisible(true);
			formInsertBtn.setEnabled(true);
			formIdTF.setEnabled(true);
			formNameTF.setEnabled(true);
			genderCombo.setEnabled(true);
			formAgeTF.setEnabled(true);
			formCellNumberTF.setEnabled(true);
			formCrimeTypeTF.setEnabled(true);
			formEntryDateSpinner.setEnabled(true);
			formReleaseDateSpinner.setEnabled(true);
		}
		
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(id);
			JOptionPane.showMessageDialog(this,"Prisoner '"+id+"' is Parmanently Deleted");
		}
		
		else if(command.equals(formUpdateBtn.getText()))
		{
			Prisoner p= new Prisoner();
			
			p.setPrisonerId(id);
			p.setPrisonerName(formNameTF.getText());
			p.setGender(genderCombo.getSelectedItem().toString());
			p.setCrimeType(formCrimeTypeTF.getText());
			p.setAge(Integer.parseInt(formAgeTF.getText()));
			p.setCellNumber(Integer.parseInt(formCellNumberTF.getText()));
			
			System.out.println(formNameTF.getText());
			System.out.println(genderCombo.getSelectedItem().toString());
			System.out.println(formCrimeTypeTF.getText());
			System.out.println(Integer.parseInt(formAgeTF.getText()));
			System.out.println(Integer.parseInt(formCellNumberTF.getText()));
			
			
			String strDate = dateFormat.format(formEntryDateSpinner.getValue());
			p.setEntryDate(strDate);
			
			System.out.println(strDate);
			
			strDate = dateFormat.format(formReleaseDateSpinner.getValue());
			p.setReleaseDate(strDate);
			
			System.out.println(strDate);
			
			
			
			
			pr.updateInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			formIdTF.setText("");
			formNameTF.setText("");
			genderCombo.setSelectedIndex(0);
			formAgeTF.setText("");
			formCellNumberTF.setText("");
			formCrimeTypeTF.setText("");
			
			insertBtn.setEnabled(false);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			
		}
		
		else if(command.equals(formInsertBtn.getText()))
		{
			Prisoner p= new Prisoner();
			
			try
			{
				p.setPrisonerId(formIdTF.getText());
				p.setPrisonerName(formNameTF.getText());
				p.setGender(genderCombo.getSelectedItem().toString());
				p.setCrimeType(formCrimeTypeTF.getText());
				p.setAge(Integer.parseInt(formAgeTF.getText()));
				p.setCellNumber(Integer.parseInt(formCellNumberTF.getText()));
				
				String strDate = dateFormat.format(formEntryDateSpinner.getValue());
				p.setEntryDate(strDate);
				
				//System.out.println(strDate);
				
				strDate = dateFormat.format(formReleaseDateSpinner.getValue());
				p.setReleaseDate(strDate);
				
				//System.out.println(strDate);
			
			
			
			
			
			
			
			
			pr.insertInDB(p);
			
			JOptionPane.showMessageDialog(this, "Inserted");
			}
			
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Invaild Input");
			}
			
			formIdTF.setText("");
			formNameTF.setText("");
			genderCombo.setSelectedIndex(0);
			formAgeTF.setText("");
			formCellNumberTF.setText("");
			formCrimeTypeTF.setText("");
			
			insertBtn.setEnabled(false);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			
		}
		
		
		
		
		
		else {}
	}
	
	
	
}