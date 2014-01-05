/*
 *  Pareser class
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParsePosition;


public class Parser {
	private  String strFile;  //for reading line by line from file
	public  String strFileArr[];  //string array
	public static String currComm;// actualy line in string array
	public int lineCount; //line counter
	public BufferedReader br;
	public static commandType comType;  //A,C,L Command
	public static int symbValue  = 16; //symbol value
	
	
	//c-tor opens the input file and gets ready to parse it 
	Parser(String exFileName)
	{
		lineCount = 0;//init's line count
		
		FileInputStream fstream = null; 
		try {
			fstream = new FileInputStream(exFileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//converts to srting
		int content;
        try {
			while ((content = fstream.read()) != -1) {
			    strFile += (char) content; 	// convert to char and display it
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		    br = new BufferedReader(new InputStreamReader(in));
		    
		    
		   strFile =  removeComments(strFile);
		   //copies string to string array
		   strFileArr = strFile.split("\n");
		   //trim
		   for(int i=0; i < strFileArr.length; i++){
			   strFileArr[i] =  strFileArr[i].trim();
       }
		   
	}
	
	

	//has more command
	public boolean hasMoreCommand() {
		if(lineCount != strFileArr.length) return true;
		return false;
		
	}
	
	//reads next command
	public  void advance()
	{
		lineCount++;
	}
	
	//Returns type of current command
	public commandType commandType()
	{
		if(strFileArr[lineCount].startsWith("("))
		{
			return comType = commandType.L_COMMAND;
		}
		else if(strFileArr[lineCount].startsWith("@"))
		{
			return comType = commandType.A_COMMAND;
		}
		return commandType.C_COMMAND;
	}
	
	//symbol
	public String symbol()
	{
		String retLable = "";
		if(strFileArr[lineCount].startsWith("@"))
		{
			retLable = strFileArr[lineCount];
			retLable = retLable.replaceAll("@", "");
		}
		else 
			if(strFileArr[lineCount].startsWith("("))
			{
				retLable = strFileArr[lineCount];
				retLable = retLable.replaceAll("\\((.*?)\\)", "$1");
			}
		return retLable;
	}
	
	//dest
	public String dest() {
		if(strFileArr[lineCount].contains("="))
		{
		String retDest = strFileArr[lineCount];
		
		int endIndex = retDest.lastIndexOf("=");
		retDest =  retDest.substring(0,endIndex);
		return retDest;
		}
		return null;
	}
	//comp
	public String comp() {
		String retComp = strFileArr[lineCount]; 
		if(strFileArr[lineCount].contains("="))
		{
		int endIndex = retComp.lastIndexOf("=");
		retComp =  retComp.substring(endIndex+1,retComp.length());
		}
		else if(strFileArr[lineCount].contains(";"))
		{
			//retComp =  retComp.substring(0,1) ;
			int endIndex = retComp.lastIndexOf(";");
			retComp =  retComp.substring(0,endIndex);
		}
		return retComp;
		
	}
	
	//jump
	public String jump() {
		if(strFileArr[lineCount].contains(";"))
		{
			String retJump = strFileArr[lineCount]; 
			int endIndex = retJump.lastIndexOf(";");
			return retJump.substring(endIndex+1,retJump.length());
		}
		return null;
		
	}
	
	
	/*
	 * help methods
	 */
	//removes comments from source file
	public String removeComments(String file) {
		String tmpFile =  file.replaceAll( "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/|(?m)^[ \t]*\r?\n|null|\t", "" );
		tmpFile = tmpFile.replaceAll("(?m)^[ \t]*\r?\n", "");
        return tmpFile;
	}
	
	//command type, enums
	public enum commandType
	{
		A_COMMAND,L_COMMAND,C_COMMAND
	}
	
	//dec to bin converter
	public static String dexToBin(int value) {
	String binVal = Integer.toBinaryString(value);
		return binVal;
		
	}
	//check's if number
	public boolean isNum(String num)
	{
		NumberFormat formatter = NumberFormat.getInstance();
		  ParsePosition pos = new ParsePosition(0);
		  formatter.parse(num, pos);
		  return  num.length() == pos.getIndex();
		
	}
	
	//adds zeroes
	public String addZero(String num)
	{
		StringBuilder sb = new StringBuilder();

		for (int toPrepend=16-num.length(); toPrepend>0; toPrepend--) {
		    sb.append('0');
		}

		sb.append(num);
		String result = sb.toString();
		return result;
	}

	
}//end parser
