/*
 This program tests the reversal of all lines on a file.
 It reads each line reverses it and writes the result.
 * @author Naima Jackson
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;

public class ReverseFileLines
{

	public static void main(String[] args)
    {
		Scanner in = new Scanner(System.in);
		try
		{
			System.out.print("What is the name of your input file ");
			String infile = in.next();
			reverseLines(infile, in);
		}
		catch(IOException e)
		{System.out.print(e); }

	}//end of main method
/**
 This will read all the lines of the file. Reverse each line and write to another file
 */
	public static void reverseLines(String infile, Scanner in)throws IOException
	{
		FileInputStream fileIn = new FileInputStream(infile);
		Path srcPath = Paths.get(infile);
		
		//Read all lines
		List<String> lines = Files.readAllLines(srcPath);
		fileIn.close();
		System.out.println("Initial File: " + "\n" + lines);
		//reverse each line amd write the results
		System.out.print("What is the name of your output: ");
		String outfile = in.next();
		FileOutputStream fileOut = new FileOutputStream(outfile);
		for(String aLine: lines)//enhanced for loop
		{
			for(int i = aLine.length()-1; i >= 0; i--)
			{
				fileOut.write(aLine.charAt(i));
			}
			fileOut.write('\n');		
			
		}//end of for loop
		 fileOut.close();
		 Path srcPathR = Paths.get(outfile);
			
		 //Read all lines
		 List<String> reversedLines = Files.readAllLines(srcPathR);
		 System.out.println("\n" + "Reversed File: " + "\n" + reversedLines);
	}//end of reverseLine method
}//end of class
