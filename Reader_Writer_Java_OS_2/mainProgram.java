
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class mainProgram{
	public static int num_read = 20; 
	public static int num_write = 3;
	public static readerwriter read_write = new readerwriter();
	public static Random rand = new Random();
	static class readThread extends Thread {
		public void run() {
			System.out.print("Read Thread started with thread name :" + getName() + "\n");
			while (true) {
				try { 
					read_write.reader(); 
					Thread.sleep(rand.nextInt(3000));
				} 
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	static class writeThread extends Thread {
		public void run() {
			System.out.print("Write Thread started with thread name :" + getName() + "\n");
			while (true) {
				try { 
					read_write.writer(); 
					Thread.sleep(rand.nextInt(3000));
				} 
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args){
		readThread readThreads[] = new readThread[num_read]; 
		writeThread writeThreads[] = new writeThread[num_write];
		System.out.print("Creating threads\n"); 
		
		for (int i = 0; i < num_write; ++i) {
			writeThreads[i] = new writeThread();			
			writeThreads[i].start();			
		}
		for (int i = 0; i < num_read; ++i) {
			readThreads[i] = new readThread();			
			readThreads[i].start();			
		}
	}
}