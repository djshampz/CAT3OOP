import sample.RMI.MyRemote;
import sample.StartApplication;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends StartApplication {
    public Server(){}

    public static void main(String[] args) {
        try {
            StartApplication implRemote = new StartApplication();
            MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(implRemote, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("MyRemote", stub);

            System.err.println("Server is ready");

        } catch (Exception e){
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}