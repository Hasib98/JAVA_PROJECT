package repository;

import java.lang.*;
import java.util.ArrayList;
import java.sql.*;
import entity.*;
import interfaces.*;

public class PrisonerRepo implements IPrisonerRepo
{
	DatabaseConnection dbc;
	
	
	public PrisonerRepo()
	{
		dbc = new DatabaseConnection();
		
	}
	
	//overrride
	public void insertInDB(Prisoner prisnr)
	{
		int x=0;
		//String query = "INSERT INTO Prisoners VALUES ('"+prisnr.getPrisonerId()+"','"+prisnr.getPrisonerName()+"','"+prisnr.getPrisonerGender()+"','"+prisnr.getCrimeType()+"',"+prisnr.getAge()+","+prisnr.getCellNumber()+",'"prisnr.getEntryDate()+"','" prisnr.getReleaseDate()+"');";
		String query = "INSERT INTO Prisoners VALUES ('"+prisnr.getPrisonerId()+"','"+prisnr.getPrisonerName()+"','"+prisnr.getGender()+"','"+prisnr.getCrimeType()+"',"+prisnr.getAge()+","+prisnr.getCellNumber()+",'"+prisnr.getEntryDate()+"','"+prisnr.getReleaseDate()+"','"+x+"');";

		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	//overrride
	public void deleteFromDB(String prisonerId)
	{
		String query = "DELETE from Prisoners WHERE PrisonerId='"+prisonerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	//overrride
	public void updateInDB(Prisoner prsnr)
	{
		String query = "UPDATE Prisoners SET PrisonerId='"+prsnr.getPrisonerId()+"', PrisonerName='"+prsnr.getPrisonerName()+"', CrimeType = '"+prsnr.getCrimeType()+"', Gender = '"+prsnr.getGender()+"', Age = "+prsnr.getAge()+ ", CellNumber="+prsnr.getCellNumber()+",EntryDate='"+prsnr.getEntryDate()+"', ReleaseDate='"+prsnr.getReleaseDate()+ "' WHERE PrisonerId='"+prsnr.getPrisonerId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	//overrride
	public String[][] searchPrisonerByPrisonerId(String prisonerId)
	{

		ArrayList<Prisoner> arraylist = new ArrayList<Prisoner>();
		
		String query = "SELECT * FROM Prisoners where PrisonerId='"+prisonerId+"' ORDER BY PrisonerId ASC;";
		String updatequery = "update prisoners set DaysLeft=ReleaseDate-CURRENT_DATE";
		 
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(updatequery);
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String PrisonerId = dbc.result.getString("PrisonerId");
				String PrisonerName = dbc.result.getString("PrisonerName");
			    String Gender = dbc.result.getString("Gender");
				int Age = dbc.result.getInt("Age");
				String CrimeType=dbc.result.getString("CrimeType");
				int CellNumber = dbc.result.getInt("CellNumber");
				String EntryDate=dbc.result.getString("EntryDate");
				String ReleaseDate = dbc.result.getString("ReleaseDate");
				
				int DaysLeft = dbc.result.getInt("DaysLeft");
				
				Prisoner prsnr = new Prisoner(PrisonerId,PrisonerName,Gender,CrimeType,Age,CellNumber,EntryDate,ReleaseDate,DaysLeft);
				arraylist.add(prsnr);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = arraylist.toArray();
		String data[][] = new String [arraylist.size()][9];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Prisoner)obj[i]).getPrisonerId();
			data[i][1] = ((Prisoner)obj[i]).getPrisonerName();
			data[i][2] = ((Prisoner)obj[i]).getGender();
			data[i][3] = (((Prisoner)obj[i]).getAge())+"";
			data[i][4] = ((Prisoner)obj[i]).getCrimeType();
			data[i][5] = (((Prisoner)obj[i]).getCellNumber())+"";
			data[i][6] = ((Prisoner)obj[i]).getEntryDate();
			data[i][7] = ((Prisoner)obj[i]).getReleaseDate();
			data[i][8] = (((Prisoner)obj[i]).getDaysLeft())+"";
		}
		return data;
	}
	
	public String[][] searchPrisonerByPrisonerName(String prisonName)
	{

		ArrayList<Prisoner> arraylist = new ArrayList<Prisoner>();
		
		//String query = "SELECT * FROM Prisoners where PrisonerName='"+prisonName+"'  ORDER BY PrisonerId ASC ;";
		String query = "SELECT * FROM Prisoners where PrisonerName LIKE'%"+prisonName+"%'  ORDER BY PrisonerId ASC ;";
		String updatequery = "update prisoners set DaysLeft=ReleaseDate-CURRENT_DATE";
		 
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(updatequery);
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String PrisonerId = dbc.result.getString("PrisonerId");
				String PrisonerName = dbc.result.getString("PrisonerName");
			    String Gender = dbc.result.getString("Gender");
				int Age = dbc.result.getInt("Age");
				String CrimeType=dbc.result.getString("CrimeType");
				int CellNumber = dbc.result.getInt("CellNumber");
				String EntryDate=dbc.result.getString("EntryDate");
				String ReleaseDate = dbc.result.getString("ReleaseDate");
				
				int DaysLeft = dbc.result.getInt("DaysLeft");
				
				Prisoner prsnr = new Prisoner(PrisonerId,PrisonerName,Gender,CrimeType,Age,CellNumber,EntryDate,ReleaseDate,DaysLeft);
				arraylist.add(prsnr);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = arraylist.toArray();
		String data[][] = new String [arraylist.size()][9];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Prisoner)obj[i]).getPrisonerId();
			data[i][1] = ((Prisoner)obj[i]).getPrisonerName();
			data[i][2] = ((Prisoner)obj[i]).getGender();
			data[i][3] = (((Prisoner)obj[i]).getAge())+"";
			data[i][4] = ((Prisoner)obj[i]).getCrimeType();
			data[i][5] = (((Prisoner)obj[i]).getCellNumber())+"";
			data[i][6] = ((Prisoner)obj[i]).getEntryDate();
			data[i][7] = ((Prisoner)obj[i]).getReleaseDate();
			data[i][8] = (((Prisoner)obj[i]).getDaysLeft())+"";
		}
		return data;
	}
	
	
	//overrride
	/* public Prisoner searchPrisonerByPrisonerId(String prisonerId)
	{
		Prisoner prsnr = null;
		String query = "SELECT `PrisonerId`, `PrisonerName`, `Gender`, `Age`, `CrimeType`, `CellNumber`, `EntryDate`, `ReleaseDate`, `DaysLeft`  FROM `Prisoners` WHERE `PrisonerId`='"+prisonerId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				String PrisonerId = dbc.result.getString("PrisonerId");
				String PrisonerName = dbc.result.getString("PrisonerName");
				String CrimeType = dbc.result.getString("CrimeType");
				String Gender = dbc.result.getString("Gender");
				int Age = dbc.result.getInt("Age");
				int CellNumber = dbc.result.getInt("CellNumber");
				String EntryDate=dbc.result.getString("EntryDate");
				String ReleaseDate = dbc.result.getString("ReleaseDate");
				int DaysLeft = dbc.result.getInt("DaysLeft");
				
				
				prsnr = new Prisoner();
				prsnr.setPrisonerId(PrisonerId);
				prsnr.setPrisonerName(PrisonerName);
				prsnr.setGender(Gender);
				prsnr.setCrimeType(CrimeType);
				prsnr.setAge(Age);
				prsnr.setCellNumber(CellNumber);
				prsnr.setEntryDate(EntryDate);
				prsnr.setReleaseDate(ReleaseDate);
				prsnr.setDaysLeft(DaysLeft);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return prsnr;
	}
	*/
	
	
	//overrride
	
	/*public Prisoner searchPrisonerByPrisonerName(String prisonerName)
	{
		Prisoner prsnr = null;
		String query = "SELECT `PrisonerId`, `PrisonerName`, `Gender`, `Age`, `CrimeType`, `CellNumber`, `EntryDate`, `ReleaseDate`, `DaysLeft`  FROM `Prisoners` WHERE `PrisonerName`='"+prisonerName+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String PrisonerId = dbc.result.getString("PrisonerId");
				String PrisonerName = dbc.result.getString("PrisonerName");
			    String Gender = dbc.result.getString("Gender");
				int Age = dbc.result.getInt("Age");
				String CrimeType=dbc.result.getString("CrimeType");
				int CellNumber = dbc.result.getInt("CellNumber");
				String EntryDate=dbc.result.getString("EntryDate");
				String ReleaseDate = dbc.result.getString("ReleaseDate");
				int DaysLeft = dbc.result.getInt("DaysLeft");
				
				
				prsnr = new Prisoner();
				prsnr.setPrisonerId(PrisonerId);
				prsnr.setPrisonerName(PrisonerName);
				prsnr.setGender(Gender);
				prsnr.setCrimeType(CrimeType);
				prsnr.setAge(Age);
				prsnr.setCellNumber(CellNumber);
				prsnr.setEntryDate(EntryDate);
				prsnr.setReleaseDate(ReleaseDate);
				prsnr.setDaysLeft(DaysLeft);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return prsnr;
	}*/
	
	//overrride
	public String[][] getAllPrisoner()
	{

		ArrayList<Prisoner> arraylist = new ArrayList<Prisoner>();
		
		String query = "SELECT * FROM Prisoners  ORDER BY PrisonerId ASC;";
		String updatequery = "update prisoners set DaysLeft=ReleaseDate-CURRENT_DATE";
		 
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(updatequery);
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String PrisonerId = dbc.result.getString("PrisonerId");
				String PrisonerName = dbc.result.getString("PrisonerName");
			    String Gender = dbc.result.getString("Gender");
				int Age = dbc.result.getInt("Age");
				String CrimeType=dbc.result.getString("CrimeType");
				int CellNumber = dbc.result.getInt("CellNumber");
				String EntryDate=dbc.result.getString("EntryDate");
				String ReleaseDate = dbc.result.getString("ReleaseDate");
				
				int DaysLeft = dbc.result.getInt("DaysLeft");
				
				Prisoner prsnr = new Prisoner(PrisonerId,PrisonerName,Gender,CrimeType,Age,CellNumber,EntryDate,ReleaseDate,DaysLeft);
				arraylist.add(prsnr);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = arraylist.toArray();
		String data[][] = new String [arraylist.size()][9];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Prisoner)obj[i]).getPrisonerId();
			data[i][1] = ((Prisoner)obj[i]).getPrisonerName();
			data[i][2] = ((Prisoner)obj[i]).getGender();
			data[i][3] = (((Prisoner)obj[i]).getAge())+"";
			data[i][4] = ((Prisoner)obj[i]).getCrimeType();
			data[i][5] = (((Prisoner)obj[i]).getCellNumber())+"";
			data[i][6] = ((Prisoner)obj[i]).getEntryDate();
			data[i][7] = ((Prisoner)obj[i]).getReleaseDate();
			data[i][8] = (((Prisoner)obj[i]).getDaysLeft())+"";
		}
		return data;
	}
}