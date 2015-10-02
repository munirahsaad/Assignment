package itt786.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ASCII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fn = "munirah.txt";
		String rfn = "munirah_ASCII_Reverse.txt";
		String fc = "Nama\t:\tNoor Munirah bt Md Saad\nId\t:\t2014828976\nKursus\t:\tCS708\nUniversiti\t:\tUiTM Kampus Shah Alam\n";
		
		ASCII a1 = new ASCII();
		
		//Call method to write string
		a1.writeFile(fn,fc);
		
		//Call method to read text file content into List of String
		List<String> filecontent = a1.readFile(fn);
		
		//Print the file content to console
		System.out.println("\nEnd printing content of the file to console");
		for(int i =0; i < filecontent.size();i++){
			System.out.println(filecontent.get(i));
		}		
		System.out.println("\nEnd printing content of the file to console");
		
		
		//Reverse the content
		String reversecontent="";
		for(int x=filecontent.size()-1; x >=0; x--){
			reversecontent = reversecontent + filecontent.get(x)+"\n";
		}
		
		//Write the reversed content to file
		a1.writeFile(rfn,reversecontent);
		
	}
	
	public void writeFile(String filename, String filecontent){
		try {
			System.out.println("Writing File!");
			FileWriter writer = new FileWriter(filename, true);
			writer.write(filecontent);
			writer.close();
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> readFile(String filename){
		List<String> line = new ArrayList<String>();	
		try {
			line = Files.readAllLines(FileSystems.getDefault().getPath(".", filename), Charset.forName("ISO-8859-1"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	

}
