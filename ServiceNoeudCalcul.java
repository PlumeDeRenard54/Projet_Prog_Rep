import java.rmi.Remote;
import raytracer.Image;

public interface ServiceNoeudCalcul extends Remote {

    public Image calculer(int x0, int y0, int largeur, int hauteur);

}
