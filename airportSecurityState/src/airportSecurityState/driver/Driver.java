package airportSecurityState.driver;

import java.util.ArrayList;

import airportSecurityState.airportStates.AirportSecurity;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String inputfile = null;
		String outputfile = null;
		String currLine = null;
		int debug_Value = 0;
		ArrayList<Integer> TotalDaysList = new ArrayList<Integer>();
		
		if(args.length !=3)
		{			
			throw new RuntimeException("Please provide 3 arguments");
		}
		else
		{
			////Assigning text file names
			inputfile = args[0];
			outputfile = args[1];
			debug_Value = Integer.parseInt(args[2]);

		}
		
		if(!(debug_Value >=0 && debug_Value <=4))
		{
			System.err.println("DEBUG_VALUE must be in range 0 to 4");
			System.exit(1);
		}
		
		MyLogger.setDebugValue(debug_Value);
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
