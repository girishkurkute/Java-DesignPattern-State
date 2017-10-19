package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LowRiskState implements AirportStateI {
	
	AirportSecurity airportSecurity;
	String level;
	
	
	public LowRiskState(AirportSecurity airportSecurity)
	{
		MyLogger.writeMessage("Inside parameterized LowRiskState constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		this.airportSecurity = airportSecurity;
	}

	@Override
	public String tightenOrLoosenSecurity(String temp,Helper hlObj) {
		// TODO Auto-generated method stub
		//System.out.println("In low");
		
		level = hlObj.getSecurityLevel(temp,hlObj);
		
		return level;
	}

}
