package src.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        Client c = new Client("localhost", 1099, "ServeurCalcul");
        c.afficherImage("data/simple.txt", Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
}
