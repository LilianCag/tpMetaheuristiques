package tp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String FichierLire = "sdkp2_7.txt";
        int n; // nombre de groupes
        int b; // capacité du sac
        Item tabx[]; // tableau d'objets
        int opt_value = 0; // différent de 0 après lecture du fichier si la valeur optimale est fournie

        try {
            File myObj = new File("src/Instances_DKP/" + FichierLire);
            Scanner myReader = new Scanner(myObj);
            int line = 1;
            int nextLine = 0;
            int compteur = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (line == 1) {
                    //premier valeur
                    nextLine = line + 1;
                }
                if (line == 2) {
                    //deuxieme Valeur
                    nextLine = line + 1;
                }
                if (line == 3 || line == 4 || line == 13 || line == 14) {
                    String[] tab = data.split(" ");
                    if (tab.length == 1) {
                        //La Troisieme Valeur
                        nextLine = line + 10;
                    }

                }
                System.out.println(data);
                line = nextLine;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }


        /*
         * Variables d'environnement
         */
        int population = 100;
        double taux_meilleurs = 0.2;
        double taux_mutation = 0.01;
        int nb_generations = 1000;
        AlgoGenetique ag = new AlgoGenetique(population, taux_meilleurs, taux_mutation, nb_generations);
        ag.algo();
    }
}
