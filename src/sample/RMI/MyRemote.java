package sample.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    void startApp() throws RemoteException;
}
