package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class HighRiskState implements AirportStateI {
	
	private AirportSecurity airportSecurity;
	private String level;
	
	public HighRiskState(AirportSecurity airportSecurity)
	{
		MyLogger.writeMessage("Inside parameterized HighRiskState constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		this.airportSecurity = airportSecurity;
	}

	@Override
	public String tightenOrLoosenSecurity(String temp,Helper hlObj) {
		// TODO Auto-generated method stub
		//System.out.println("In high");
		
		level = hlObj.getSecurityLevel(temp,hlObj);
		
		return level;
	}

}
