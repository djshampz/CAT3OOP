package sample.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            MyRemote stub = (MyRemote) registry.lookup("MyRemote");

            stub.startApp();

            System.out.println("Remote Method Invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
