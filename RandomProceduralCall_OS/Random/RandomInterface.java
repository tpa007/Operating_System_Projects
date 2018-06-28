import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RandomInterface extends Remote {
	String generateRandom(int n) throws RemoteException;
	String generateRandomBounds(int min, int max) throws RemoteException;
}