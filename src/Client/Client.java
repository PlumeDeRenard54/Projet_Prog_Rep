package src.Client;

import src.Server.ServiceServeur;
import src.raytracer.Disp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private String ip;
    private int port;
    private String nomDist;

    public Client(String ip, int port, String nomDist) {
        this.ip = ip;
        this.port = port;
        this.nomDist = nomDist;
    }


    public void afficherImage(String image){

    }

    public ServiceServeur getServeurDistant() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(this.ip, this.port);
        return (ServiceServeur) reg.lookup(this.nomDist);
    }


}
