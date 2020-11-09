package ie.gmit.week6Lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileChar {
	public static void main(String args[]) {
	
		//create stream reference
		FileReader charInputStream = null;
		FileWriter charOutputStream = null;
		
		//create int to read and write char.
		int c;
		
		//protect stream creation and read/write code as it may throw an exception
		try {
		charInputStream = new FileReader(".\\resources\\input.txt");
		charOutputStream = new FileWriter(".\\resources\\output.txt");
		
		System.out.println("Byte \t| Character");
		System.out.println("------------------");
		
		//read in bytes. NOTE If no bytes is available because the end of the stream has been reached, the returned value is -1.
		while ((c = charInputStream.read()) != -1) {
			//show bytes and characters copied
			System.out.printf("%d \t| %c\n", c, c);
			//sleep for 500 miliseconds (i.e half a second) so we can watch write process
			TimeUnit.MILLISECONDS.sleep(500);
			//write byte to output.txt
			charOutputStream.write(c);
		}
		
		System.out.println("-----------------");
		System.out.println("Copy completed succesfully! See resources/output.txt");
		} catch (FileNotFoundException fnfExceptionObject){
			System.out.println("Copy FAILED because file not found! See error below: ");
			fnfExceptionObject.printStackTrace();
		} catch (InterruptedException ieExceptionObject){
			System.out.println("Copy Failed because sleep was interrupted! See error below: ");
			ieExceptionObject.printStackTrace();
		} catch (IOException ioExceptionObject) {
			System.out.println("Copy Failed because write was interrupted! See error below: ");
			ioExceptionObject.printStackTrace();
	} finally {
			//Try and finally close streams
			try {
				if (charInputStream !=null) {
					charInputStream.close();
		}
		if (charOutputStream !=null) {
			charOutputStream.close();
		}
	} catch (IOException ioObject) {
		ioObject.printStackTrace();
	}
		
}		
			
	}//end main
}//end class
