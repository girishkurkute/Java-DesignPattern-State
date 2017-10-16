package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String inputfile;
		String currLine;
		
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
			String day, item;
			String [] arrayInfo = currLine.split(";");
			day = arrayInfo[0];
			item = arrayInfo[3];
			
			System.out.println(day);
			System.out.println(item);
			
			
		}
		
	}

}
