package Sesion7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWord extends Remote {
	String sayHello() throws RemoteException;

}
