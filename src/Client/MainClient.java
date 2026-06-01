package src.Client;
public class MainClient {
    public static void main(String[] args) {
        Client c = new Client("localhost", 1099, "ServerCalcul");
        c.afficherImage("simple.txt");
    }
}
