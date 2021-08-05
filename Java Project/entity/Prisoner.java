package entity;

import java.lang.*;

public class Prisoner
{
	private String prisonerId;
	private String prisonerName;
	private String gender;
	private String crimeType;
	private int  age;
	private int cellno, daysLeft;
	private String entryDate, releaseDate;
	
	public Prisoner(){}
	public Prisoner(String prisonerId, String prisonerName, String gender, String crimeType, int age, int cellno, String entryDate, String releaseDate, int daysLeft)
	{
		this.prisonerId = prisonerId;
		this.prisonerName = prisonerName;
		this.gender = gender;
		this.crimeType = crimeType;
		this.age = age;
		this.cellno=cellno;
		this.entryDate=entryDate;
		this.releaseDate=releaseDate;
		this.daysLeft=daysLeft;
	}
	
	public void setPrisonerId(String prisonerId){this.prisonerId = prisonerId;}
	public void setPrisonerName(String prisonerName){this.prisonerName = prisonerName;}
	public void setGender(String gender){this.gender = gender;}
	public void setCrimeType(String crimeType){this.crimeType = crimeType;}
	public void setAge(int age){this.age = age;}
	public void setCellNumber(int cellno){this.cellno=cellno;}
	public void setEntryDate(String entryDate){this.entryDate=entryDate;}
	public void setReleaseDate( String releaseDate){ this.releaseDate=releaseDate;}
	public void setDaysLeft(int daysLeft){this.daysLeft=daysLeft;}
	
	
	public String getPrisonerId(){return prisonerId;}
	public String getPrisonerName(){return prisonerName;}
	public String getGender(){return gender;};
	public String getCrimeType(){return crimeType;}
	public int getAge(){return age;}
	public int getCellNumber(){return cellno;}
	public String getEntryDate(){return entryDate;}
	public String getReleaseDate(){return releaseDate;}
	public int getDaysLeft(){return daysLeft;}
}