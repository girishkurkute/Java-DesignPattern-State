package airportSecurityState.util;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Results {

	private String outputFileName;
	//public ArrayList<String> operationIDValues = new ArrayList<String>();
	
	
	public Results(String outputfile) {
		// TODO Auto-generated constructor stub
		MyLogger.writeMessage("Inside parameterized Results constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		this.outputFileName=outputfile;
		
	}
	
	
	public void writeToFile(ArrayList<String> arrList) throws IOException {
		// TODO Auto-generated method stub
		FileWriter FWrt = null;
		try
		{
			FWrt = new FileWriter(this.outputFileName);
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		
		for(String currentLine : arrList)
		{
			MyLogger.writeMessage("Results from data structure added into Output file", MyLogger.DebugLevel.IN_RESULTS);
			FWrt.write(currentLine);
			FWrt.write("\r\n");
		}
		FWrt.close();
	}

}
