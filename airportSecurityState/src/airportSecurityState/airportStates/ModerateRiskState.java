package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class ModerateRiskState implements AirportStateI{
	
AirportSecurity airportSecurity;
String level;
	
	public ModerateRiskState(AirportSecurity airportSecurity)
	{
		MyLogger.writeMessage("Inside parameterized ModerateRiskState constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		this.airportSecurity = airportSecurity;
	}

	@Override
	public String tightenOrLoosenSecurity(String temp,Helper hlObj) {
		// TODO Auto-generated method stub
		//System.out.println("In moderate");
		
		level = hlObj.getSecurityLevel(temp,hlObj);
		
		return level;
	}

}
