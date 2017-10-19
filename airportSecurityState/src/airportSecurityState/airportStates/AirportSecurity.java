package airportSecurityState.airportStates;

import java.io.IOException;
import java.util.ArrayList;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class AirportSecurity {

	private AirportStateI lowSecurity;
	private AirportStateI moderateSecurity;
	private AirportStateI highSecurity;
	
	public ArrayList<String> OperationIDValues = new ArrayList<String>();
	
	private AirportStateI state;
	private String level;
	private Helper hlObj = new Helper();
	public AirportSecurity()
	{
		MyLogger.writeMessage("Inside parameterized AirportSecurity constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		lowSecurity = new LowRiskState(this);
		moderateSecurity = new ModerateRiskState(this);
		highSecurity = new HighRiskState(this);
		state = lowSecurity;
	}
	
	
	
	/*public void tightenOrLoosenSecurity()
	{
		state.tightenOrLoosenSecurity();
	}*/



	public void calculateRisk(String currString) {
		// TODO Auto-generated method stub
		
		level = state.tightenOrLoosenSecurity(currString,hlObj);
		if(level == "Low")
		{
			MyLogger.writeMessage("State changed to Low Risk", MyLogger.DebugLevel.IN_RUN);
			state = lowSecurity;
			OperationIDValues.add("1 3 5 7 9");
			MyLogger.writeMessage("Result is added into data structure", MyLogger.DebugLevel.FROM_RESULTS);
			
		}
		else if (level == "Moderate")
		{
			MyLogger.writeMessage("State changed to Moderate Risk", MyLogger.DebugLevel.IN_RUN);
			state = moderateSecurity;
			OperationIDValues.add("2 3 5 8 9");
			MyLogger.writeMessage("Result is added into data structure", MyLogger.DebugLevel.FROM_RESULTS);
			
		}
		else if (level == "High")
		{
			MyLogger.writeMessage("State changed to High Risk", MyLogger.DebugLevel.IN_RUN);
			state = highSecurity;
			OperationIDValues.add("2 4 6 8 10");
			MyLogger.writeMessage("Result is added into data structure", MyLogger.DebugLevel.FROM_RESULTS);
		}
	}



	public void printID(Results relt) throws IOException {
		// TODO Auto-generated method stub
		relt.writeToFile(OperationIDValues);
	}
}
