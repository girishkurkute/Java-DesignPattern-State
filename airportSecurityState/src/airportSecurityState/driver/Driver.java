package airportSecurityState.driver;

import java.util.ArrayList;

import airportSecurityState.airportStates.AirportSecurity;
import airportSecurityState.util.FileProcessor;

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String inputfile;
		String currLine;
		ArrayList<Integer> TotalDaysList = new ArrayList<Integer>();
		
		if(args.length !=1)
		{			
			throw new RuntimeException("Please provide 1 arguments");
		}
		else
		{
			////Assigning text file names
			inputfile = args[0];

		}
		
		FileProcessor fprObj = new FileProcessor(inputfile);
		AirportSecurity aptObj = new AirportSecurity();
		
		while((currLine = fprObj.readLine())!= null)
		{
			if(!currLine.isEmpty())
			aptObj.calculateRisk(currLine);
			
			
		}
		
	}

}
