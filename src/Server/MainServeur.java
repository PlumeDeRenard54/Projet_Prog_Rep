package src.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServeur {
    
    public static void main(String[] args) throws Exception {
        
        ServeurCalcul servCalc = new ServeurCalcul();

        ServiceServeur servDistant = (ServiceServeur) UnicastRemoteObject.exportObject(servCalc, 0);

        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("ServeurCalcul", servDistant);
        System.out.println("Annuaire lancé sur 1099");
    }

}
