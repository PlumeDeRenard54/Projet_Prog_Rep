package src.Noeud;

import src.raytracer.Image;
import src.raytracer.Scene;

public class Noeud implements ServiceNoeudCalcul {

    @Override
    public Image calculer(Scene s,int x0, int y0, int largeur, int hauteur) {
        System.out.println("Calcul de la part de largeur " + largeur + " et de hauteur " + hauteur + " à partir du pixel de coordonnées x = " + x0 + " y0 = " + y0);
        return s.compute(x0, y0, largeur, hauteur);
        
    }
    
}
