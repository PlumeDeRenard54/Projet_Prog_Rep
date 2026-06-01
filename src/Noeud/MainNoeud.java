package src.Noeud;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import src.Server.ServiceServeur;

public class MainNoeud {
    public static void main(String[] args) throws Exception {
        
        if (args.length != 1){
            throw new Exception("Veuillez donner une addresse");
        }

        ServiceNoeudCalcul noeud = (ServiceNoeudCalcul) UnicastRemoteObject.exportObject(new Noeud(),0);

        Registry reg = LocateRegistry.getRegistry(args[1],1099);
        ((ServiceServeur) reg.lookup("ServeurCalcul")).enregistrerNoeudCalcul(noeud);

    }
}
