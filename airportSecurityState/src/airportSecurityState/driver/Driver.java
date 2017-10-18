package airportSecurityState.driver;

import java.util.ArrayList;

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
		
		while((currLine = fprObj.readLine())!= null)
		{
			String strday,day, stritem,item;
			int currday;
			String [] arrayInfo = currLine.split(";");
			strday = arrayInfo[0];
			stritem = arrayInfo[3];
			
			String [] arrayDayValue = strday.split(":");
			String [] arrayItemValue = stritem.split(":");
			
			day = arrayDayValue[1];
			item = arrayItemValue[1];
			System.out.println(day);
			System.out.println(item);
			
			
			currday=Integer.parseInt(day);
			
			if(currday>0)
			{
				if(TotalDaysList.size() == 0)
				{
					//when list is empty
					TotalDaysList.add(currday);
				}
				else
				{
					for(int temp : TotalDaysList)
					{
						if(temp == currday)
						{
							break;
						}
					}
				}
			}
		}
		
	}

}
