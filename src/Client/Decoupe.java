package src.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Decoupe {
    private List<Integer[]> decoupe;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Decoupe dec = new Decoupe(66, 64, 4);

        List<Integer[]> list = dec.getDecoupe();
        String result = list.stream()
                .map(Arrays::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);
    }

    /**
     * Crée une image découpée en plusieurs morceaux de taille équivalente
     * @param sizeX - longueur de l'image de base
     * @param sizeY - hauteur de l'image de base
     * @param nbNoeudsCalcul - nombre de découpes à créer
     */

    public Decoupe(int sizeX, int sizeY, int nbNoeudsCalcul) {
        int tailleDecoupeX = sizeX/nbNoeudsCalcul;
        int debutX = 0;
        int mod =  sizeX%nbNoeudsCalcul;
        this.decoupe = new ArrayList<Integer[]>();

        for(int i=0; i<nbNoeudsCalcul; i++){
            int extension = 0;
            if(mod > 0){
                mod --;
                extension = 1;
            }

            decoupe.add(new Integer[]{debutX, 0, tailleDecoupeX+extension, sizeY});
            debutX += tailleDecoupeX;

            debutX += extension;


        }
    }

    public List<Integer[]> getDecoupe() {
        return this.decoupe;
    }
}
