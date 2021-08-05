package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo
{
	DatabaseConnection dbc;
	
	public EmployeeRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Employee e)
	{
		String query = "INSERT INTO employees VALUES ('"+e.getEmpId()+"','"+e.getName()+"',"+e.getAge()+",'"+e.getGender()+"','"+e.getDesignation()+"',"+e.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String empId)
	{
		String query = "DELETE from employees WHERE empId='"+empId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Employee e)
	{
		//String query = "UPDATE employees SET employeeName='"+e.getName()+"', designation = '"+e.getDesignation()+"', salary = "+e.getSalary()+","+e.getAge()+",'"+e.getGender()+"' WHERE empId='"+e.getEmpId()+"'";
		String query="UPDATE employees SET employeeName='"+e.getName()+"',Age="+e.getAge()+",Gender='"+e.getGender()+"',designation='"+e.getDesignation()+"',salary="+e.getSalary()+" WHERE empId='"+e.getEmpId()+"'";
					//UPDATE employees SET employeeName='emp22',Age=36,Gender='female',designation='abal',salary=12000 WHERE empId='e00002'
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Employee searchEmployee(String empId)
	{
		Employee emp = null;
		String query = "SELECT `employeeName`, `designation`, `salary` FROM `employees` WHERE `empId`='"+empId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				emp = new Employee();
				emp.setEmpId(empId);
				emp.setName(name);
				emp.setDesignation(designation);
				emp.setSalary(salary);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	/*............................*/
	
	public String[][] searchEmployeeByEmployeeId(String empId)
	{ 
		System.out.println("ID enterd");

		ArrayList<Employee> arraylist = new ArrayList<Employee>();
		
		String query = "SELECT * FROM Employees where empId='"+empId+"' ORDER BY empId ASC;";
		 
		
		try
		{
			dbc.openConnection();
			
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String empID = dbc.result.getString("empId");
				String name = dbc.result.getString("EmployeeName");
			    String gender = dbc.result.getString("Gender");
				int age = dbc.result.getInt("Age");
				String designation=dbc.result.getString("Designation");
				double salary = dbc.result.getDouble("salary");
				
				
				Employee e = new Employee(empID,name,age,gender,designation,salary);
				arraylist.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = arraylist.toArray();
		String data[][] = new String [arraylist.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId();
			data[i][1] = ((Employee)obj[i]).getName();
			data[i][2] = (((Employee)obj[i]).getAge())+"";
			data[i][3] = ((Employee)obj[i]).getGender();
			data[i][4] = ((Employee)obj[i]).getDesignation();
			data[i][5] = (((Employee)obj[i]).getSalary())+"";
		}
		return data;
	}
	
	
	public String[][] searchEmployeeByEmployeeName(String empName)
	{
		System.out.println("Name enterd");

		ArrayList<Employee> arraylist = new ArrayList<Employee>();
		
		String query = "SELECT * FROM Employees where EmployeeName LIKE'%"+empName+"%' ORDER BY empId ASC;";
		 
		
		try
		{
			dbc.openConnection();
			
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String empId = dbc.result.getString("empId");
				String name = dbc.result.getString("EmployeeName");
			    String gender = dbc.result.getString("Gender");
				int age = dbc.result.getInt("Age");
				String designation=dbc.result.getString("Designation");
				double salary = dbc.result.getDouble("salary");
				
				
				Employee e = new Employee(empId,name,age,gender,designation,salary);
				arraylist.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = arraylist.toArray();
		String data[][] = new String [arraylist.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId();
			data[i][1] = ((Employee)obj[i]).getName();
			data[i][2] = (((Employee)obj[i]).getAge())+"";
			data[i][3] = ((Employee)obj[i]).getGender();
			data[i][4] = ((Employee)obj[i]).getDesignation();
			data[i][5] = (((Employee)obj[i]).getSalary())+"";
		}
		return data;
	}
	
	
	
	
	
	public String[][] getAllEmployee()
	{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		String query = "SELECT * FROM employees ORDER BY empId ASC ;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String empId = dbc.result.getString("empId");
				String name = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				String gender = dbc.result.getString("Gender");
				int age = dbc.result.getInt("Age");
				
				Employee e = new Employee(empId,name,age,gender,designation,salary);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId();
			data[i][1] = ((Employee)obj[i]).getName();
			data[i][2] = (((Employee)obj[i]).getAge())+"";
			data[i][3] = ((Employee)obj[i]).getGender();
			data[i][4] = ((Employee)obj[i]).getDesignation();
			data[i][5] = (((Employee)obj[i]).getSalary())+"";
		}
		return data;
	}
}