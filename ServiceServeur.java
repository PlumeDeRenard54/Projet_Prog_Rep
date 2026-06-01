
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServiceServeur extends Remote {

    public boolean enregistrerNoeudCalcul(ServiceNoeudCalcul serv) throws RemoteException;

    public List<ServiceNoeudCalcul> getAllNoeuds() throws RemoteException;

}
