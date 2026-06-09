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
        List<Integer[]> decoupe = new Decoupe(sizeX, sizeY, noeuds.size()).getDecoupe();
        int ind = 0;

        for (Integer[] parcelle : decoupe){
            
            int debX = parcelle[0];
            int debY = parcelle[1];
            int largeur = parcelle[2];
            int hauteur = parcelle[3];

            ServiceNoeudCalcul currentNode = noeuds.get(0);
            int index = 0;

            while (noeuds.size()>0) {
                try {
                    if (currentNode.isFree()){
                        break;
                    }else{
                        index = (index+1)%noeuds.size();
                        currentNode = noeuds.get(index);
                    }

                } catch (Exception e) {
                    noeuds.remove(currentNode);
                }
            }

            final ServiceNoeudCalcul finalNode = currentNode; 
            new Thread(()->{
                try {
                    Image i = finalNode.calculer(scene, debX, debY, largeur, hauteur);
                    disp.setImage(i, debX, debY);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();


            
        
        }
    }

    public ServiceServeur getServeurDistant() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(this.ip, this.port);
        return (ServiceServeur) reg.lookup(this.nomDist);
    }


}
