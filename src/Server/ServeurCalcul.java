package src.Server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import src.Noeud.Noeud;
import src.Noeud.ServiceNoeudCalcul;

public class ServeurCalcul implements ServiceServeur {

    private List<ServiceNoeudCalcul> noeuds = new ArrayList<>();

    @Override
    public List<ServiceNoeudCalcul> getAllNoeuds() throws RemoteException {
        for (int i = 0; i < noeuds.size(); i++) {
            try {
                boolean res = noeuds.get(i).isFree();
            } catch(Exception e) {
                noeuds.remove(noeuds.get(i));
                i--;
            }
        }
        return noeuds;
    }

    @Override
    public boolean enregistrerNoeudCalcul(ServiceNoeudCalcul serv) throws RemoteException {
        return noeuds.add(serv);
    }

}