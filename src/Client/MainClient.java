package src.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        Client c = new Client("localhost", 1099, "ServerCalcul");
        c.afficherImage("simple.txt", 300,300);
    }
}
