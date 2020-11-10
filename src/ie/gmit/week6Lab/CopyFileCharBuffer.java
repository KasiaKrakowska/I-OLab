package ie.gmit.week6Lab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileCharBuffer {
	public static void main(String[] args) {
		File inputFile = null;
		File outputFile = null;
		FileReader charInputStream = null;
		FileWriter charOutputStream = null;
		BufferedReader charInputStreamBuffer = null;
		BufferedWriter charOutputStreamBuffer = null;
		String bufferData = null;
		
		try {
			//create file instances
			inputFile = new File(".\\resources\\inputHamlet.txt");
			outputFile = new File(".\\resources\\outputHamlet.txt");
			//create streams
			charInputStream = new FileReader(inputFile);
			charOutputStream = new FileWriter(outputFile);
			//create stream buffers
			charInputStreamBuffer = new BufferedReader(charInputStream);
			charOutputStreamBuffer = new BufferedWriter(charOutputStream);
			//read in buffer from file
			while((bufferData = charInputStreamBuffer.readLine()) !=null) {
				//show buffer data
				System.out.println(bufferData);
				
				charOutputStreamBuffer.write(bufferData);
				charOutputStreamBuffer.newLine();
				
				//sleep for 500 milliseconds (half second) so we can write process
				TimeUnit.MILLISECONDS.sleep(500);
			}
			System.out.println("---------------------------------");
			System.out.println("Copy completed sucessfully! See resources/otputHamlet.txt");
		}catch (NullPointerException nullPtExc) {
			nullPtExc.printStackTrace();
		}catch (FileNotFoundException fnfExc) {
			fnfExc.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (InterruptedException intExc) {
			intExc.printStackTrace();
		}finally {
			try {
				if (charInputStream !=null) {
					charInputStreamBuffer.close(); 
					charInputStream.close();
				}
				if (charOutputStream !=null) {
					charOutputStreamBuffer.close(); //flushes the buffer, which transfers buffer data to the file and closes the file
					charOutputStream.close();
			}
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		}
		
	}//end main
	
	}//end class
