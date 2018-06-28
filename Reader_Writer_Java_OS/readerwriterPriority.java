//Reader-Writer Priority in Operating Systems

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.IOException;

public class readerwriterPriority {
	final Lock mutex = new ReentrantLock();
	final Condition readerQueue = mutex.newCondition();
	final Condition writerQueue = mutex.newCondition();
	int nReaders = 0; // number of reader threads
	int nWriters = 0; // number of writer threads (0 or 1)
	int nWriterActive = 0; // number of active writer threads
	String file = "counter.txt";
	public static Random rand = new Random();	

	void reader() throws InterruptedException {
		mutex.lock(); //mutual exclusion
		while (!(nWriters == 0)) {
			readerQueue.await();//wait in readerQueue till no more writers
		}
		nReaders++; //one more reader
		mutex.unlock(); 
		readFile(file);
		mutex.lock(); //need mutual exclusion
		if (--nReaders == 0) {
			writerQueue.signal();//wake up a waiting writer
		}
		mutex.unlock();
	}

	void writer() throws InterruptedException {
		mutex.lock();
		nWriters++; //one writer
		while (!((nReaders == 0) && (nWriterActive == 0))) {
			writerQueue.await();//wait in writerQueue until no more writer & readers
		} 
		nWriterActive++; // one active writer
		mutex.unlock(); 
		writeFile(file);
		mutex.lock(); //need mutual exclusion
		nWriterActive--; //only one  active writer at a time
		if (--nWriters == 0) 
		{ 
			readerQueue.signalAll();
		} 
		else 
		{
			writerQueue.signal();
		}
		mutex.unlock();
	}

	void readFile(String path){
		try{
			Scanner reader = new Scanner(new FileInputStream(path));
			int readCounter = reader.nextInt(); 
			System.out.printf("Reader Name: " + Thread.currentThread().getName() + " Value of counter: %d\n", readCounter);
		}
		catch(FileNotFoundException ex) {
            System.out.printf("Unable to open file");                
        }
		//System.out.printf(" Counter: %d\n", x);
	}

	void writeFile(String path){
		int writeCounter;
		try{
			Scanner reader = new Scanner(new FileInputStream(path));
			writeCounter = (int) reader.nextInt();
			writeCounter++;
		
			FileWriter fw = new FileWriter(new File(path));
			fw.write(new Integer(writeCounter).toString());
			fw.close(); 
			System.out.printf("Writer Name: " + Thread.currentThread().getName() + "Value of Counter: %d\n", writeCounter );
		} 
		catch(FileNotFoundException ex) {
            System.out.printf("Unable to open file");                
        }
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}



