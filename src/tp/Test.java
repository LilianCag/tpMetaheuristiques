package tp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String FichierLire = "idkp1_1.txt";
        int n = 0; // nombre de groupes
        int b = 0; // capacité du sac
        Item tabItems[] = null; // tableau d'objets
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
                    n = Integer.parseInt(data);
                    nextLine = line + 1;
                }
                if (line == 2) {
                    //deuxieme Valeur
                    b = Integer.parseInt(data);
                    nextLine = line + 1;
                }
                if (line == 3 || line == 4 || line == 13 || line == 14) {
                    String[] tab = data.split(" ");
                    if (tab.length == 1) {
                        //La Troisieme Valeur
                        opt_value = Integer.parseInt(data);
                        nextLine = line + 10;
                    }
                    else if(tabItems == null) {
                        tabItems = new Item[n];
                        int i = 0;
                        int j = 0;
                        while (i<tab.length) {
                            int[] p = {Integer.parseInt(tab[i]), Integer.parseInt(tab[i+1]), Integer.parseInt(tab[i+2])};
                            Item newItem = new Item(p);
                            tabItems[j] = newItem;
                            i += 3;
                            j++;
                        }
                    }
                    else {
                        int i = 0;
                        int j = 0;
                        while (i<tab.length) {
                            int[] w = {Integer.parseInt(tab[i]), Integer.parseInt(tab[i+1]), Integer.parseInt(tab[i+2])};
                            tabItems[j].setW(w);
                            i += 3;
                            j++;
                        }
                    }
                }
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
        AlgoGenetique ag = new AlgoGenetique(n, b, tabItems, opt_value, population, taux_meilleurs, taux_mutation, nb_generations);
        ag.algo();
    }
}
