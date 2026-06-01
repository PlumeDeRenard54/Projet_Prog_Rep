package src.graphe;

import src.raytracer.Disp;
import src.raytracer.Image;
import src.raytracer.Scene;

import java.time.Duration;
import java.time.Instant;

public class LancerRaytracerGraphe {

    public static String aide = "Raytracer : synthèse d'image par lancé de rayons (https://en.wikipedia.org/wiki/Ray_tracing_(graphics))\n\nUsage : java LancerRaytracer [fichier-scène] [largeur] [hauteur]\n\tfichier-scène : la description de la scène (par défaut simple.txt)\n\tlargeur : largeur de l'image calculée (par défaut 512)\n\thauteur : hauteur de l'image calculée (par défaut 512)\n";

    public static void main(String args[]) {
        int nbIt = 30;
        int res = 100;
        double[] xData = new double[30];
        double[] yData = new double[30];
        for (int i = 0; i < nbIt; i ++) {
            // Le fichier de description de la scène si pas fournie
            String fichier_description = "./data/simple.txt";

            // largeur et hauteur par défaut de l'image à reconstruire
            int largeur = res, hauteur = res;

//            if (args.length > 0) {
//                fichier_description = "./data/" + args[0];
//                if (args.length > 1) {
//                    largeur = Integer.parseInt(args[1]);
//                    if (args.length > 2) {
//                        hauteur = Integer.parseInt(args[2]);
//                    }
//                }
//            } else {
//                System.out.println(aide);
//            }

            // création d'une fenêtre
//            Disp disp = new Disp("Raytracer", largeur, hauteur);

            // Initialisation d'une scène depuis le modèle
            Scene scene = new Scene(fichier_description, largeur, hauteur);

            // Calcul de l'image de la scène les paramètres :
            // - x0 et y0 : correspondant au coin haut à gauche
            // - l et h : hauteur et largeur de l'image calculée
            // Ici on calcule toute l'image (0,0) -> (largeur, hauteur)
            int x0 = 0, y0 = 0;

            // Chronométrage du temps de calcul
            Instant debut = Instant.now();
            System.out.println("Calcul de l'image :\n - Coordonnées : " + x0 + "," + y0
                    + "\n - Taille " + largeur + "x" + hauteur);
            //méthode de calcul
            Image image = scene.compute(x0, y0, largeur, hauteur);
            Instant fin = Instant.now();

            long duree = Duration.between(debut, fin).toMillis();

            //ajout des données dans les tableaux
            xData[i] = res*res;
            yData[i] = duree;

            System.out.println("Image calculée en :" + duree + " ms");

            // Affichage de l'image calculée
//            disp.setImage(image, x0, y0);
            res += 100;
        }

        (new Graphe()).getGraphe(xData, yData);
//        for (int i = 0; i < 15; i++) {
//            System.out.println("nbPixel : " + xData[i]);
//            System.out.println("Temps : " + yData[i]);
//            System.out.println("------------------------");
//        }

    }
}
