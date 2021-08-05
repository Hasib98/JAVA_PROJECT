package entity;

import java.lang.*;

public class Employee
{
	private String empId;
	private String name;
	private String designation;
	private double salary;
	private int age;
	private String gender;
	
	public Employee(){}
	public Employee(String empId, String name, int age, String gender, String designation, double salary)
	{
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.age=age;
		this.gender=gender;
		
	}

	
	public void setEmpId(String empId){this.empId = empId;}
	public void setName(String name){this.name = name;}
	public void setDesignation(String designation){this.designation = designation;}
	public void setSalary(double salary){this.salary = salary;}
	public void setAge( int age){this.age=age;}
	public void setGender(String gender){this.gender=gender;}
	
	public String getEmpId(){return empId;}
	public String getName(){return name;}
	public String getDesignation(){return designation;}
	public double getSalary(){return salary;}
	public String getGender(){return gender;}
	public int getAge(){return age;}
}