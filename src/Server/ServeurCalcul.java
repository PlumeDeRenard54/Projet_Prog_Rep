package src.Server;

import java.rmi.RemoteException;
import java.util.List;
import src.Noeud.ServiceNoeudCalcul;

public class ServeurCalcul implements ServiceServeur {

    private List<ServiceNoeudCalcul> noeuds;

    @Override
    public List<ServiceNoeudCalcul> getAllNoeuds() throws RemoteException {
        return noeuds;
    }

    @Override
    public boolean enregistrerNoeudCalcul(ServiceNoeudCalcul serv) throws RemoteException {
        return noeuds.add(serv);
    }

}