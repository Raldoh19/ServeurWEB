package Test;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A test class that allows us to generate data
 * @author Aymane RAMACH, Michel NGATIMO, Morad SANBA
 */
public class GenerateData
{

    /**
     * Generate a list of Node
     * @return a list of node with their direction
     */
    public static List<Node> route()
    {
        Information informations[] = new Information[5];
        informations[0] = new Information("Entrée", Type.Orientation, "/images/entree.jpg");
        informations[1] = new Information("Bas - Rampe", Type.Orientation, "/images/basrampe.jpg");
        informations[2] = new Information("Haut - Rampe", Type.Orientation, "/images/hautrampe.jpg");
        informations[3] = new Information("Boole", Type.SallesTD, "/images/boole.jpg");
        informations[4] = new Information("Von Neumann", Type.SallesTD, "/images/vonneuman.jpg");

        ArrayList<Node> route = new ArrayList<>();
        route.add(new Node(informations[0], Direction.West)); // On pars de l'entrée, on tourne a gauche pour aller en bas de la rampe
        route.add(new Node(informations[1], Direction.North)); // Bas de la rampe, on va tout droit pour nous retrouver au sommet
        route.add(new Node(informations[2], Direction.East)); // On tourne a droite pour aller vers Boole
        route.add(new Node(informations[3], Direction.North)); // On continue tout droit pour aller a Von Neumann
        route.add(new Node(informations[4], Direction.None)); // Aucune direction, on est arrivé a destination.

        return route;
    }

    /**
     * Generate informations about the nodes, can be display when a user connect
     * @return A list that contains informations
     */
    public static List<Information> informations()
    {
        List<Information> lotOfInformations = new ArrayList<>();
        lotOfInformations.add(new Information("Babbage", Type.SallesTD,"/images/babbage.png"));
        lotOfInformations.add(new Information("Shannon", Type.SallesTD,"/images/shannon.png"));
        lotOfInformations.add(new Information("Boole", Type.SallesTD,"/images/boole.png"));
        lotOfInformations.add(new Information("Von Neuman", Type.SallesTD,"/images/vonneuman.png"));
        lotOfInformations.add(new Information("K'Fet", Type.SallesDiverses,"/images/kfet.png"));
        lotOfInformations.add(new Information("BDE", Type.SallesDiverses,"/images/bde.png"));
        lotOfInformations.add(new Information("Pascal", Type.Amphis,"/images/pascal.png"));
        lotOfInformations.add(new Information("Turing", Type.Amphis,"/images/turing.png"));
        return lotOfInformations;
    }
}
