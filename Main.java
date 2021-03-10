import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;; 

public class Main {
	
  public static String getData(String data, String oldFileName) {//helper function to convert the .txt file into a string
	
	try {
		data = new String(Files.readAllBytes(Paths.get(oldFileName))); 
	} catch (IOException e) {
		e.printStackTrace();
	}
	return data;
  }
  
  public static void makeFile(File newFile, String newFileName) { //helper function to make the file
		
	  try {
		if (newFile.createNewFile()) {
		        System.out.println("File created: " + newFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
	  } catch (IOException e) {
		e.printStackTrace();
	  	}
	 }
  
  public static void writeFile(String data, String newFileName) { //helper function to write onto the file
	    try {
	        FileWriter myWriter = new FileWriter(newFileName);
	        myWriter.write(data);
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	  
	 }
  
  public static ArrayList<Integer> parse(String data) { //Filters out the String data to be only reservation group counts return integer arraylist
	    
	  	String delims = "\\s+";
	  	String[] tokens = data.split(delims);
	  	
	  	ArrayList<Integer> seatNum = new ArrayList<Integer>();
	  	
	  	for (int i = 0; i < tokens.length; i++)
	  		if (i%2 != 0){
	  			seatNum.add(Integer.parseInt(tokens[i]));
	  		}
	  	 
	  	return seatNum;
	 }
  
  public static ArrayList<String> parseList(String data) { //Filters out the String data to be only reservation number return integer arraylist
	  
	    
	  	String delims = "\\s+";
	  	String[] tokens = data.split(delims);
	  	
	  	ArrayList<String> resNum = new ArrayList<String>();
	  	
	  	for (int i = 0; i < tokens.length; i++) {
	  		if (i%2 == 0){
	  			resNum.add(tokens[i]);
	  		}
	  	}
	  	 
	  	return resNum;
	 }
  
  private static String getCharForNumber(int i) { //helper function that converts row number to letter EX: 0-9 to A-J
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
  	
  public static ArrayList<Row> assignSeats(ArrayList<Integer> parsedData) { //takes the parsed data and assigns the proper seats
  		ArrayList<Row> row = new ArrayList<Row>();
  		int count = 0;
  		for(int i = 0; i < 10; i++) {
  			row.add(new Row(getCharForNumber(i+1)));
  			
  			for(int j = 0+count; row.get(i).remainingSeats() > parsedData.get(j); j++) {
  				if(i%2 != 0) {
  					break;
  				}
  					row.get(i).claimSeats(parsedData.get(j));
  	  				count++;
  	  				if(parsedData.size()-1 == j) {
  	  					row.get(i).displayRow();
  	  					return row;
  	  				}
  				}
  			row.get(i).displayRow();
  		}
  		return row;
	 }
  
  public static String compileRows(ArrayList<Integer> parsedData, ArrayList<Row> rows, String data) {//compiles all data into one final string
	  String newData = "";

	  for(int j = 0, l = 0; l < parsedData.size(); j++) {
		  if(j == 10) {
		  		return newData;
		  	}
		  
		  ArrayList<String> a = rows.get(j).printFullSeats();
		  	for(int i = 0, k = 0; i < rows.get(j).reservations; k+=4, i++, l++){
		  		newData = newData+parseList(data).get(l)+ " " +a.get(k)+"\n";
		  		
		  	}
		  	
	  }
	return newData;
  }

  
  public static void main(String[] args) { //main
	  
	String oldFileName = args[0]+".txt"; //take arguments from command line
	String newFileName = args[1]+".txt";
	
	String data = ""; 
    data = getData(data, oldFileName); //Call to function that interprets file into a string
    
    
    ArrayList<Integer> parsedData = parse(data); //Call to function that parses the string into just the necessary information
    
    ArrayList<Row> rows = assignSeats(parsedData); //Creation of Rows for the theater, using a a function
    
    String finalData = compileRows(parsedData, rows, data);//Compiles all the seats and reservations into one final string
    
	
    File newFile = new File(newFileName); // Creates new file
    makeFile(newFile, newFileName); //call Helper function to create the new .txt file

	writeFile(finalData, newFileName); //call Helper function to write to the newly created .txt
  }
}