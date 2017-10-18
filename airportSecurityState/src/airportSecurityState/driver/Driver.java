package airportSecurityState.driver;

import java.util.ArrayList;

import airportSecurityState.airportStates.AirportSecurity;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String inputfile,outputfile;
		String currLine;
		ArrayList<Integer> TotalDaysList = new ArrayList<Integer>();
		
		if(args.length !=2)
		{			
			throw new RuntimeException("Please provide 2 arguments");
		}
		else
		{
			////Assigning text file names
			inputfile = args[0];
			outputfile = args[1];

		}
		
		FileProcessor fprObj = new FileProcessor(inputfile);
		AirportSecurity aptObj = new AirportSecurity();
		Results resltObj = new Results(outputfile);
		
		while((currLine = fprObj.readLine())!= null)
		{
			if(!currLine.isEmpty())
			aptObj.calculateRisk(currLine);
			
			
		}
		aptObj.printID(resltObj);
	}

}
