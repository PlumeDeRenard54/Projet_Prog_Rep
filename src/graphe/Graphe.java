// package src.graphe;
//
// import org.knowm.xchart.*;
// import org.knowm.xchart.style.markers.SeriesMarkers;
// import org.knowm.xchart.style.lines.SeriesLines;
//
// import javax.swing.*;
//
// public class Graphe {
//
//
//     public Graphe() {}
//
//     public void getGraphe(double[] xData, double[] yData) {
//         XYChart chart = QuickChart.getChart(
//                 "Graphe représentant le temps de calcul en fonction de la résolution de l'image",
//                 "Résolution de l'image",
//                 "Temps de calcul en ms",
//                 "Serie 1",
//                 xData,
//                 yData
//         );
//
//         XChartPanel<XYChart> chartPanel = new XChartPanel<>(chart); // panel interactif avec zoom
//         JFrame frame = new JFrame("Graphique");
//         frame.add(chartPanel);
//         frame.pack();
//         frame.setVisible(true);
//     }
// }