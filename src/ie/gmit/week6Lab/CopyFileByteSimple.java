package ie.gmit.week6Lab;

import java.io.*;

public class CopyFileByteSimple {
	public static void main(String args[]) throws IOException{
		
		//create stream reference
		FileInputStream byteInputStream = new FileInputStream(".\\resources\\input.txt");
		FileOutputStream byteOutputStream = new FileOutputStream(".\\resources\\output.txt");
		
		//create int to read and write bytes
		int b =0;
		
		//read in bytes. NOTE If no bytes is available because the end of the stream
		//has been reached, the returned value is -1.
		while ((b = byteInputStream.read()) != -1) {
			byteOutputStream.write(b); //write out bytes
		}
		//close stream
		byteInputStream.close();
		byteOutputStream.close();
		
	}//end main

}//end class
