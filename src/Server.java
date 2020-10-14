package Sesion7;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements HelloWord {

	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Helo world";
	}

	public static void main(String[] args) {
		try {
			Server obj = new Server();
			HelloWord stub = (HelloWord) UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("HelloWord", stub);
			System.out.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
