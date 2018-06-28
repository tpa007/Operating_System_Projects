import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private Client() {}
	
	public static void main(String[] args) {
	
	String host = (args.length < 1) ? "127.0.0.1" : args[0];
	try{
		Registry registry = LocateRegistry.getRegistry(host);
		RandomInterface stub = (RandomInterface) registry.lookup("RandomInterface");
		int n  = Integer.parseInt(args[1]);
		String response = "";
		if(args.length > 2) {
			int min = Integer.parseInt(args[1]);
			int max = Integer.parseInt(args[2]);
			response = stub.generateRandomBounds(min, max);
		}
		else {
			response = stub.generateRandom(n);
		}
		System.out.println("response: " + response); 
	} catch (Exception e) {
		System.err.println("Client exception: " + e.toString());
		e.printStackTrace();

	}
}
}
