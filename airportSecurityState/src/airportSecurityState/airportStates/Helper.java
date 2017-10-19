package airportSecurityState.airportStates;

public class Helper {

	public int noTraveller=0,noDays=0,noProhibitedItems=0;
	public int preDay=0;
	public float avgTrafficPerDay = 0;
	public float avgProhibItemPerDay = 0;
	String level;
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
				//System.out.println(noTraveller + ":" +noDays + ":" +noProhibitedItems);
				
			}
					
		}

		avgTrafficPerDay = (float)noTraveller / noDays;
		avgProhibItemPerDay = (float)noProhibitedItems / noDays;
		//System.out.println("AvgtrafficItem :" + avgTrafficPerDay);
		//System.out.println("prohibitedItem :" + avgProhibItemPerDay);
		if((avgTrafficPerDay >= 0 && avgTrafficPerDay < 4) || (avgProhibItemPerDay >= 0 && avgProhibItemPerDay <1))
		{
			level = "Low";
		}
		else if((avgTrafficPerDay >= 4 && avgTrafficPerDay < 8) || (avgProhibItemPerDay >= 1 && avgProhibItemPerDay <2))
		{
			level = "Moderate";
		}
		else if((avgTrafficPerDay >= 8 ) || (avgProhibItemPerDay >= 2))
		{
			level = "High";
		}
		//System.out.println(level);
		return level;
	}

}
