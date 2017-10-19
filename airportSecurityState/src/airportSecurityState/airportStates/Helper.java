package airportSecurityState.airportStates;

public class Helper {

	private int noTraveller=0,noDays=0,noProhibitedItems=0;
	private int preDay=0;
	private int avgTrafficPerDay = 0;
	private int avgProhibItemPerDay = 0;
	private String level;
	public String getSecurityLevel(String temp ,Helper hlObj) {
		// TODO Auto-generated method stub
		

		String strday,day, stritem,item;
		int currday;
		String [] arrayInfo = temp.split(";");
		strday = arrayInfo[0];
		stritem = arrayInfo[3];
		
		String [] arrayDayValue = strday.split(":");
		String [] arrayItemValue = stritem.split(":");
		
		day = arrayDayValue[1];
		item = arrayItemValue[1];
		if((!day.isEmpty()) && (!item.isEmpty()))
		{
			currday=Integer.parseInt(day);
			if(currday>0)
			{
				noTraveller++;
				if(preDay == 0)
				{
					preDay = currday;
					noDays++;
				}
				else if (preDay < currday)
				{
					preDay = currday;
					noDays++;
				}	
				
				if(item.equals("Gun")||item.equals("NailCutter")||item.equals("Blade")||item.equals("Knife"))
				{
					noProhibitedItems++;
				}
				//System.out.println(currday + ":" + item);
				//System.out.println("noTraveller-"+noTraveller + ":" +"noDays-"+noDays + ":" +"noProhibitedItems-"+noProhibitedItems);
				
			}
					
		}

		avgTrafficPerDay = noTraveller / noDays;
		avgProhibItemPerDay = noProhibitedItems / noDays;
		//System.out.println("AvgtrafficItem :" + avgTrafficPerDay +" prohibitedItem :" + avgProhibItemPerDay);
		
		if((avgTrafficPerDay >= 8 ) || (avgProhibItemPerDay >= 2))
		{
			level = "High";
		}
		else if((avgTrafficPerDay >= 4 && avgTrafficPerDay < 8) || (avgProhibItemPerDay >= 1 && avgProhibItemPerDay <2))
		{
			level = "Moderate";
		}
		else if((avgTrafficPerDay >= 0 && avgTrafficPerDay < 4) || (avgProhibItemPerDay >= 0 && avgProhibItemPerDay <1))
		{
			level = "Low";
		}
		
		
		//System.out.println(level);
		return level;
	}

}
