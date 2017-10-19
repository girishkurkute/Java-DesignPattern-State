package airportSecurityState.airportStates;

import java.io.IOException;
import java.util.ArrayList;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class AirportSecurity {

	AirportStateI lowSecurity;
	AirportStateI moderateSecurity;
	AirportStateI highSecurity;
	
	public ArrayList<String> OperationIDValues = new ArrayList<String>();
	
	AirportStateI state;
	String level;
	Helper hlObj = new Helper();
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
			state = lowSecurity;
			OperationIDValues.add("1 3 5 7 9");
		}
		else if (level == "Moderate")
		{
			state = moderateSecurity;
			OperationIDValues.add("2 3 5 8 9");
		}
		else if (level == "High")
		{
			state = highSecurity;
			OperationIDValues.add("2 4 6 8 10");
		}
	}



	public void printID(Results relt) throws IOException {
		// TODO Auto-generated method stub
		relt.writeToFile(OperationIDValues);
	}
}
