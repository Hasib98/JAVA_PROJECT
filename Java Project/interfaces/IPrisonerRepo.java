package interfaces;

import java.lang.*;

import entity.*;

public interface IPrisonerRepo
{
	public void insertInDB(Prisoner p);
	public void deleteFromDB(String prisonerId);
	public void updateInDB(Prisoner p);
	public String[][] searchPrisonerByPrisonerName(String prisonName);
	public String[][] searchPrisonerByPrisonerId(String prisonerId);
	public String[][] getAllPrisoner();
}