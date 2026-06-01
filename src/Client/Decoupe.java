package src.Client;

import java.util.ArrayList;
import java.util.List;

public class Decoupe {
    private List<Integer[]> decoupe;

    public Decoupe(int sizeX, int sizeY, int nbNoeudsCalcul) {
        int tailleDecoupeX = sizeX/nbNoeudsCalcul;
        int mod =  sizeX%nbNoeudsCalcul;
        int debutX = 0;
        this.decoupe = new ArrayList<Integer[]>();

        for(int i=0; i<tailleDecoupeX; i++){
            if(mod != 0){
                debutX ++;
                mod --;
            }
            decoupe.add(new Integer[]{debutX, 0, tailleDecoupeX+mod, sizeY});
            debutX += tailleDecoupeX;
        }
    }

    public List<Integer[]> getDecoupe() {
        return this.decoupe;
    }
}
