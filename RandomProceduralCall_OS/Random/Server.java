import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.util.Random;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;

public class Server implements RandomInterface {

	public Server() {}
	
	
	public String generateRandom(int n) {
	  try{	
		Random rand = new Random();
		String response ="";
		for(int i=0;i<n;i++) {
			response += Integer.toString(rand.nextInt(n) + 1) + "  ";
		}
		return response;
	  } catch ( Exception e){
		return "Unable to add two numbers";	  
	  }	
	}
	
	public String generateRandomBounds(int min, int max) {
	  try{	
		int range = (max - min) + 1;
		String response ="";
		for(int i=0;i<range;i++) {
			response += Integer.toString((int)(Math.random() * range) + min) + "  ";
		}
		return response;
	  } catch ( Exception e){
		return "Unable to add two numbers";	  
	  }	
	}
	
	public static void main(String args[]) {
	
		try {
		Server obj = new Server();
		RandomInterface stub = (RandomInterface) UnicastRemoteObject.exportObject(obj, 0);
		
		//Bind the remote object's stub in the registry
		Registry registry = LocateRegistry.getRegistry();
		registry.bind("RandomInterface", stub);
		
		System.err.println("Server ready");
		
	} catch (Exception e) {
	
		System.err.println("Server exception: " + e.toString());
		e.printStackTrace();
	}
	
	
	}
}