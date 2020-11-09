package ie.gmit.week6Lab;

import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileByte {
	public static void main(String args[]) {
	
		//create stream reference
		FileInputStream byteInputStream = null;
		FileOutputStream byteOutputStream = null;
		
		//create int to read and write bytes.
		int b =0;
		
		//protect stream creation and read/write code as it may throw an exception
		try {
		byteInputStream = new FileInputStream(".\\resources\\input.txt");
		byteOutputStream = new FileOutputStream(".\\resources\\output.txt");
		
		System.out.println("Byte \t| Character");
		System.out.println("------------------");
		
		//read in bytes. NOTE If no bytes is available because the end of the stream has been reached, the returned value is -1.
		while ((b = byteInputStream.read()) != -1) {
			//show bytes and characters copied
			System.out.printf("%d \t| %c\n", b, b);
			//sleep for 500 miliseconds (i.e half a second) so we can watch write process
			TimeUnit.MILLISECONDS.sleep(500);
			
			//write byte to output.txt
			byteOutputStream.write(b);
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
				if (byteInputStream !=null) {
					byteInputStream.close();
		}
		if (byteOutputStream !=null) {
			byteOutputStream.close();
		}
	} catch (IOException ioObject) {
		ioObject.printStackTrace();
	}
		
}		
			
	}//end main
}//end class
