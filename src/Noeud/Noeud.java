package src.Noeud;

import java.rmi.RemoteException;

import src.raytracer.Image;
import src.raytracer.Scene;

public class Noeud implements ServiceNoeudCalcul {

    private boolean free = true;

    @Override
    public Image calculer(Scene s,int x0, int y0, int largeur, int hauteur) {
        free = false;
        System.out.println("Calcul de la part de largeur " + largeur + " et de hauteur " + hauteur + " à partir du pixel de coordonnées x = " + x0 + " y0 = " + y0);
        Image i = s.compute(x0, y0, largeur, hauteur);
        free = true;
        return i;
    }

    @Override
    public boolean isFree() throws RemoteException {
        return free;
    }
    
}
