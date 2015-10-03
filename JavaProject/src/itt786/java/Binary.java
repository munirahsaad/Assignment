package itt786.java;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


public class Binary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fn = "munirah.bin";
		String rfn = "munirah_Binary_Reverse.bin";
		String fc = "Nama\t:\tNoor Munirah bt Md Saad\nId\t:\t2014828976\nKursus\t:\tCS708\nUniversiti\t:\tUiTM Kampus Shah Alam\n";
		
		Binary b1 = new Binary();
		
		//Call method to write string
		b1.writeFile(fn,fc);
		
		//Call method to read file content into byte
		byte [] content = b1.readFile(fn);
		
		//Printing binary content to console
		System.out.println("\n\nPrinting binary content of the file to console");
		for(int x= 0 ; x < content.length; x++) {
	         System.out.print(content[x]);
	    }
		System.out.println("\nEnd printing binary content of the file to console");
		
		
		//Printing character content to console
		System.out.println("\n\nPrinting character content of the file to console");
		for(int i= 0 ; i < content.length; i++) {
	         System.out.print((char)content[i]);
	    }
		System.out.println("\nEnd printing character content of the file to console");
		
		//Call method to reverse the file content and write binary content to file
		b1.writeReverse(rfn,content);

	}
	
	public void writeFile(String filename, String filecontent){
		try {
			System.out.println("Writing File!");
			Files.write( FileSystems.getDefault().getPath(".", filename), 
			        filecontent.getBytes(), 
			        StandardOpenOption.CREATE);
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeReverse(String filename, byte [] filecontent){
		String[] sentenceList = new String(filecontent).split("\n");
		String reverseContent="";
		for(int i =sentenceList.length-1; i >=0; i--){
			reverseContent=reverseContent+sentenceList[i]+"\n";
		}
		try {
			System.out.println("\nWriting File Reverse!");
			Files.write( FileSystems.getDefault().getPath(".", filename), 
					reverseContent.getBytes(), 
			        StandardOpenOption.CREATE);
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	public byte[] readFile(String filename){
		byte[] content = null;
		try {
			content = Files.readAllBytes(FileSystems.getDefault().getPath(".", filename));
			} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

}
