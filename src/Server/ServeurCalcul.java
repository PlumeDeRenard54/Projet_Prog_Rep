package src.Server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import src.Noeud.ServiceNoeudCalcul;

public class ServeurCalcul implements ServiceServeur {

    private List<ServiceNoeudCalcul> noeuds = new ArrayList<>();

    @Override
    public List<ServiceNoeudCalcul> getAllNoeuds() throws RemoteException {
        return noeuds;
    }

    @Override
    public boolean enregistrerNoeudCalcul(ServiceNoeudCalcul serv) throws RemoteException {
        return noeuds.add(serv);
    }

}