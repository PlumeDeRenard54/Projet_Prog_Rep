package src.Noeud;
import java.rmi.Remote;
import java.rmi.RemoteException;

import src.raytracer.Image;
import src.raytracer.Scene;

public interface ServiceNoeudCalcul extends Remote {

    public Image calculer(Scene s,int x0, int y0, int largeur, int hauteur) throws RemoteException;

}
