/*  Symbol table class
 * 
 * 
 * 
 */
import java.util.Map;
import java.util.TreeMap;


public class SymbolTable {

	private static Map<String, String> symbols;
	 
	public SymbolTable()
	 {
		 symbols = new TreeMap<String,String>();
		  //  Symbol Table, Copied from class presentation
		 	symbols.put("SP", "0");
			symbols.put("LCL", "1");
			symbols.put("ARG", "2");
			symbols.put("THIS", "3");
			symbols.put("THAT", "4");
			symbols.put("R0", "0");
			symbols.put("R1", "1");
			symbols.put("R2", "2");
			symbols.put("R3", "3");
			symbols.put("R4", "4");
			symbols.put("R5", "5");
			symbols.put("R6", "6");
			symbols.put("R7", "7");
			symbols.put("R8", "8");
			symbols.put("R9", "9");
			symbols.put("R10", "10");
			symbols.put("R11", "11");
			symbols.put("R12", "12");
			symbols.put("R13", "13");
			symbols.put("R14", "14");
			symbols.put("R15", "15");
			symbols.put("SCREEN", "16384");
			symbols.put("KBD", "24576");
	 }
	
	// add's entry in to table
	public void addEntry(String key, String value) {
		symbols.put(key, value);	
	}
	
	//checks if symbol exists
	public boolean containKey(String key){
		return symbols.containsKey(key);
	}
	
	public String getValue(String val)
	{
		return	symbols.get(val);	
	}
	
}//end symbol table class

