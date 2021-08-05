package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;  
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter; 

import entity.*;
import repository.*;


public class EmployeeFrame extends JFrame implements ActionListener
{
	private JButton logoutBtn,backBtn,searchBtn, getAllBtn, deleteBtn, insertBtn, updateBtn, formUpdateBtn,formInsertBtn,defaultBtn,printBtn;
	private JTable empTable;
	private JScrollPane empTableScrollPane, printScrollpane;
	private JLabel searchguideLebel, empIdLabel, empNameLabel, formIdLabel,formNameLabel,formAgeLabel, formGenderLebel,formDesignationLabel,formSalaryLabel,borderLabel1,borderLabel2,borderLabel3;
	private JTextField empIdTF, empNameTF, formIdTF,formNameTF, formAgeTF,formDesignationTF,formSalaryTF;
	private JComboBox genderCombo;
	private String id;
	private 
	
	JPanel panel;
	
	private User user;
	
	private EmployeeRepo er;
	private UserRepo ur;
	
	private int X=110,Y=260;


	public EmployeeFrame(User user)
	{
		super("Employee Management");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.user = user;
		
		er = new EmployeeRepo();
		ur= new UserRepo();
		
		
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
		
		
		
		
		
		String data[][] = {{"", "", "", "","", ""}};
		String head[] = {"EmployeeId", "EmployeeName", "Age", "Gender"," Designation","Salary"};
		
		empTable = new JTable(data,head);
		empTableScrollPane = new JScrollPane(empTable);
		empTableScrollPane.setBounds(0,515, 800, 250);
		empTable.setEnabled(false);
		panel.add(empTableScrollPane);
	
	
		searchguideLebel = new JLabel("Search by either ID or Name");
		searchguideLebel.setBounds(90,60,200,20);
		panel.add(searchguideLebel);
		
		empIdLabel = new JLabel("Employee ID:");
		empIdLabel.setBounds(20,80,80,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(120,80,100,30);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name:");
		empNameLabel.setBounds(20, 130,80,30);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(120,130,100,30);
		panel.add(empNameTF);
		
		
		
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
		
		formDesignationLabel = new JLabel("Designation:");
		formDesignationLabel.setBounds(370,180,80,30);
		panel.add(formDesignationLabel);
		
		
		formDesignationTF = new JTextField();
		formDesignationTF.setBounds(440,180,100,30);
		formDesignationTF.setEnabled(false);
		panel.add(formDesignationTF);
		
		
		formSalaryLabel = new JLabel("Salary:");
		formSalaryLabel.setBounds(570,180,40,30);
		panel.add(formSalaryLabel);
		
		
		formSalaryTF = new JTextField();
		formSalaryTF.setBounds(660,180,100,30);
		formSalaryTF.setEnabled(false);
		panel.add(formSalaryTF);
		
		
		
		
		
		
		
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
		
		
		
		getAllBtn = new JButton("All Employee Data");
		getAllBtn.setBounds(300, 480, 170, 25);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);

		printBtn = new JButton("print");
		printBtn.setBounds(520, 480, 110, 25);
		printBtn.addActionListener(this);
		panel.add(printBtn);
		
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
			String data[][] = er.getAllEmployee();;
			String head[] = {"EmployeeId", "EmployeeName", "Age", "Gender"," Designation","Salary"};
			
			panel.remove(empTableScrollPane);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableScrollPane = new JScrollPane(empTable);
			empTableScrollPane.setBounds(0,515, 800, 250);
			panel.add(empTableScrollPane);
			printScrollpane=empTableScrollPane;
			
			panel.revalidate();
			panel.repaint();
		}

		else if( command.equals(printBtn.getText()))
		{
			Pdf frame = new Pdf();
			frame.pack();
			//frame.setVisible(true);
			frame.print();
		}


		
		else if(command.equals(searchBtn.getText()))
		{
			
			String IdBoxText = empIdTF.getText();
			String NameBoxText = empNameTF.getText();
			
			
			
			//if(!IdBoxText.equals("") || !IdBoxText.equals(null))
			if(!IdBoxText.equals(""))
			{
				
				String data[][] = er.searchEmployeeByEmployeeId(empIdTF.getText());
				System.out.println(data.length);
				
				if(data.length!=0)
				{
					id=IdBoxText;
					String head[] = {"EmployeeId", "EmployeeName", "Age", "Gender"," Designation","Salary"};
					
					panel.remove(empTableScrollPane);
					
					empTable = new JTable(data,head);
					empTable.setEnabled(false);
					empTableScrollPane = new JScrollPane(empTable);
					empTableScrollPane.setBounds(0,515, 800, 250);
					panel.add(empTableScrollPane);
					
					panel.revalidate();
					panel.repaint();
					
					
					updateBtn.setEnabled(true);
					insertBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					empIdTF.setText("");
					empNameTF.setText("");
					
					
					formIdTF.setEnabled(false);
					formNameTF.setEnabled(false);
					genderCombo.setEnabled(false);
					formAgeTF.setEnabled(false);
					formDesignationTF.setEnabled(false);
					formSalaryTF.setEnabled(false);
					
					formUpdateBtn.setVisible(false);
					formInsertBtn.setVisible(false);
				}
				else
				{
					
					JOptionPane.showMessageDialog(this,"Invaild ID");
					empIdTF.setText("");
					empNameTF.setText("");
				}
				
				
				
			}
			
			//else if(!NameBoxText.equals("") || !NameBoxText.equals(null))
			else if(!NameBoxText.equals(""))
			{
				
				String data[][] = er.searchEmployeeByEmployeeName(empNameTF.getText());
				System.out.println(data.length);
				
				if(data.length!=0)
				{
					String head[] = {"EmployeeId", "EmployeeName", "Age", "Gender"," Designation","Salary"};
				
					panel.remove(empTableScrollPane);
					
					empTable = new JTable(data,head);
					empTable.setEnabled(false);
					empTableScrollPane = new JScrollPane(empTable);
					empTableScrollPane.setBounds(0,515, 800, 250);
					panel.add(empTableScrollPane);
					
					panel.revalidate();
					panel.repaint();
					
					updateBtn.setEnabled(false);
					deleteBtn.setEnabled(false);
					empIdTF.setText("");
					empNameTF.setText("");
					
					
					formIdTF.setEnabled(false);
					formNameTF.setEnabled(false);
					genderCombo.setEnabled(false);
					formAgeTF.setEnabled(false);
					formDesignationTF.setEnabled(false);
					formSalaryTF.setEnabled(false);
					
					formUpdateBtn.setVisible(false);
					formInsertBtn.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Name");
					empIdTF.setText("");
					empNameTF.setText("");
				}
				
				
				
				
				
			}
			else{JOptionPane.showMessageDialog(this," Fields are empty. Input ID or Name to Search Data");}
		}
		
		else if(command.equals(defaultBtn.getText()))
		{
			
			String data[][] = {{"" , "" , "", "" , "" , ""}};
			String head[] = {"EmployeeId", "EmployeeName", "Age", "Gender"," Designation","Salary"};
				
			panel.remove(empTableScrollPane);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableScrollPane = new JScrollPane(empTable);
			empTableScrollPane.setBounds(0,515, 800, 250);
			panel.add(empTableScrollPane);
			
			panel.revalidate();
			panel.repaint();
			
			
			empIdTF.setText("");
			empNameTF.setText("");
			formIdTF.setText("");
			formNameTF.setText("");
			genderCombo.setSelectedIndex(0);
			formAgeTF.setText("");
			formDesignationTF.setText("");
			formSalaryTF.setText("");
			
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			
			
			formNameTF.setEnabled(false);
			genderCombo.setEnabled(false);
			formAgeTF.setEnabled(false);
			formDesignationTF.setEnabled(false);
			formSalaryTF.setEnabled(false);;
			
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
			formDesignationTF.setEnabled(true);
			formSalaryTF.setEnabled(true);
			
			/*formNameTF.setText(ur.getName());
			formAgeTF.setText(ur.getAge()+"");
			formSalaryTF.setText(ur.getSalary()+"");
			formDesignationTF.setText(ur.getDesignation());
			genderCombo.setSelectedIndex(urindexOf()
			
			*/
			
		}
		
		else if(command.equals(insertBtn.getText()))
		{
			formInsertBtn.setVisible(true);
			formInsertBtn.setEnabled(true);
			formIdTF.setEnabled(true);
			formNameTF.setEnabled(true);
			genderCombo.setEnabled(true);
			formAgeTF.setEnabled(true);
			formDesignationTF.setEnabled(true);
			formSalaryTF.setEnabled(true);
		}
		
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDB(id);
			ur.deleteUser(id);
			JOptionPane.showMessageDialog(this,"User '"+id+"' is Parmanently Deleted");
		}
		
		else if(command.equals(formUpdateBtn.getText()))
		{
			Employee e = new Employee();
			try
			{
				e.setEmpId(id);
				e.setName(formNameTF.getText());
				e.setAge(Integer.parseInt(formAgeTF.getText()));
				e.setGender(genderCombo.getSelectedItem().toString());
				e.setDesignation(formDesignationTF.getText());
				e.setSalary(Double.parseDouble(formSalaryTF.getText()));
				
				System.out.println(formNameTF.getText());
				System.out.println(genderCombo.getSelectedItem().toString());
				System.out.println(formDesignationTF.getText());
				System.out.println(Integer.parseInt(formAgeTF.getText()));
				System.out.println(Double.parseDouble(formSalaryTF.getText()));
			
			er.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this, "Inputted Data type is wrong or fields are empty");
			}
			
			formIdTF.setText("");
			formNameTF.setText("");
			genderCombo.setSelectedIndex(0);
			formAgeTF.setText("");
			formDesignationTF.setText("");
			formSalaryTF.setText("");
			
			insertBtn.setEnabled(false);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			
		}
		
		else if(command.equals(formInsertBtn.getText()))
		{
			Employee e = new Employee();
			
			User u= new User();
			Random rd= new Random();
			int x = rd.nextInt(9999)+1;
			
			try
			{
				e.setEmpId(formIdTF.getText());
				e.setName(formNameTF.getText());
				e.setAge(Integer.parseInt(formAgeTF.getText()));
				e.setGender(genderCombo.getSelectedItem().toString());
				e.setDesignation(formDesignationTF.getText());
				e.setSalary(Double.parseDouble(formSalaryTF.getText()));
				
				
				System.out.println(genderCombo.getSelectedItem().toString()+"  gendercombo");
				System.out.println(e.getGender()+"  genderGet");
				
				u.setUserId(formIdTF.getText());
				u.setPassword(x+"");
				
				if((formDesignationTF.getText()).equals("Admin") || (formDesignationTF.getText()).equals("admin"))
				{
					u.setStatus(0);
				}
				else if((formDesignationTF.getText()).equals("Security")|| (formDesignationTF.getText()).equals("security"))
				{
					u.setStatus(1);
				}
				else 
				{
					u.setStatus(2);
				}
				
				
				er.insertInDB(e);
				ur.insertUser(u);
				
				JOptionPane.showMessageDialog(this, "Inserted, Id: "+formIdTF.getText()+"and Password: "+x);
			}
			
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,"Invaild Input");
			}
			
			formIdTF.setText("");
			formNameTF.setText("");
			genderCombo.setSelectedIndex(0);
			formAgeTF.setText("");
			formDesignationTF.setText("");
			formSalaryTF.setText("");
			
			insertBtn.setEnabled(false);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			
		}
		
		
		
		
		
		else {}
	}
	
	
	
}