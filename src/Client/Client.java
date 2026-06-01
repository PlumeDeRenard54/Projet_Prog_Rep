package src.Client;

import src.Noeud.Noeud;
import src.Noeud.ServiceNoeudCalcul;
import src.Server.ServiceServeur;
import src.raytracer.Disp;
import src.raytracer.Image;
import src.raytracer.Scene;

import java.net.ServerSocket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {

    private String ip;
    private int port;
    private String nomDist;

    public Client(String ip, int port, String nomDist) {
        this.ip = ip;
        this.port = port;
        this.nomDist = nomDist;
    }


    public void afficherImage(String image, int sizeX, int sizeY) throws NotBoundException, RemoteException {
        Disp disp = new Disp("Raytracer", sizeX, sizeY);
        Scene scene = new Scene(image, sizeX, sizeY);
        ServiceServeur serv = getServeurDistant();
        List<ServiceNoeudCalcul> noeuds = serv.getAllNoeuds();
        Decoupe decoupe = new Decoupe(sizeX, sizeY, noeuds.size());
        int ind = 0;

        for (ServiceNoeudCalcul noeud : noeuds){
            int finalInd = ind;
            Thread t = new Thread(){
                @Override
                public void run(){
                    Integer[] d = decoupe.getDecoupe().get(finalInd);
                    int debX = d[0];
                    int debY = d[1];
                    int largeur = d[2];
                    int hauteur = d[3];


                    try {

                        Image i = noeud.calculer(scene, debX, debY, largeur, hauteur);
                        disp.setImage(i, debX, debY);

                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            t.start();
            ind++;
        }
    }

    public ServiceServeur getServeurDistant() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(this.ip, this.port);
        return (ServiceServeur) reg.lookup(this.nomDist);
    }


}
