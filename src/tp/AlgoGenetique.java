package tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoGenetique {

    private int nb_groupes; // Nombre de groupes de 3 items
    private int capacite; // Capacité du sac
    private Item[] tabItems; // Tableau d'items
    private int opt_value; // Valeur optimale théorique

    private int population; // Population par génération
    private double taux_meilleurs; // Taux de sélection par meilleur score
    private double taux_mutation; // Taux de mutation
    private int nb_generations; // Nombre de générations

    // Constructeur
    public AlgoGenetique(int nb_groupes, int capacite, Item[] tabItems, int opt_value, int population, double taux_meilleurs, double taux_mutation, int nb_generations) {
        this.nb_groupes = nb_groupes;
        this.capacite = capacite;
        this.tabItems = tabItems;
        this.opt_value = opt_value;

        this.population = population;
        this.taux_meilleurs = taux_meilleurs;
        this.taux_mutation = taux_mutation;
        this.nb_generations = nb_generations;
    }

    public void algo() {
        long tempsDebut = System.currentTimeMillis();
        int generation = 0;
        Individu[] individus = generation();
        tri(individus);
        while (generation < nb_generations && individus[0].getScore() != opt_value && opt_value != 0) {
            Individu[] selectionIndividus = selection(individus);
            Individu[] nouvelleGeneration = procreation(selectionIndividus);
            individus = mutation(nouvelleGeneration);
            tri(individus);
            if (generation % 500 == 0) System.out.println("Meilleur résultat de la génération " + generation + " :\n " + individus[0].getScore());
            generation++;
        }
        long tempsFin = System.currentTimeMillis();
        float secondes = (tempsFin - tempsDebut) / 1000F;
        System.out.println("Valeur optimale théorique : "+ this.opt_value);
        if(individus[0].getScore() == opt_value) System.out.println("Résultat trouvé à la génération " + generation + " en " + secondes + " secondes.");
        else System.out.println("Programme terminé en " + secondes + " secondes. " +
                "Résultat : "+ individus[0].getScore()
                + ", " + (((float) individus[0].getScore() / (float) this.opt_value) * 100) + "%.");
    }

    /**
     * Fonction de tri par score décroissant
     * @param individus : tableau d'entrée
     */
    public void tri(Individu[] individus) {
        Arrays.sort(individus, (a,b) -> b.getScore() - a.getScore());
    }

    /**
     * Création de la population par génération aléatoire
     * @return Tableau de la population
     */
    public Individu[] generation() {
        Individu[] individus = new Individu[this.population];
        for(int i = 0; i < this.population; i++) {
            individus[i] = new Individu(this.tabItems, this.capacite);
        }
        return individus;
    }

    public Individu[] selection(Individu[] individus) {
        Individu[] selectionIndividus = new Individu[this.population/2];
        // Sélection des meilleurs
        int i;
        int indexMeilleurs = (int) Math.floor(this.population*taux_meilleurs);
        for(i=0; i<indexMeilleurs; i++) {
            selectionIndividus[i] = individus[i];
        }
        List<Integer> used = new ArrayList<>();
        while(i < selectionIndividus.length) {
            int rand = (int) (Math.random() * (this.population - indexMeilleurs) + indexMeilleurs);
            if(used.contains(rand)) {
                while (used.contains(rand)) {
                    rand = (int) (Math.random() * (this.population - indexMeilleurs) + indexMeilleurs);
                }
            }
            selectionIndividus[i] = individus[rand];
            i++;
        }
        return selectionIndividus;
    }

    public Individu[] procreation(Individu[] selectionIndividus) {
        Individu[] nouvelleGeneration = new Individu[this.population];
        // Ajout du meilleur individu
        nouvelleGeneration[0] = selectionIndividus[0];
        // Procréations
        int i = 2;
        while (i < nouvelleGeneration.length) {
            int j = i / 2;
            nouvelleGeneration[i-1] = new Individu(selectionIndividus[j-1], selectionIndividus[j], this.tabItems, this.capacite);
            nouvelleGeneration[i] = new Individu(selectionIndividus[j], selectionIndividus[j-1], this.tabItems, this.capacite);
            i+=2;
        }
        nouvelleGeneration[this.population-1] = new Individu(selectionIndividus[0], selectionIndividus[selectionIndividus.length-1], this.tabItems, this.capacite);
        //afficherPopulation(nouvelleGeneration);
        return nouvelleGeneration;
    }

    public Individu[] mutation(Individu[] nouvelleGeneration) {
        for(int i = 0; i < this.population; i++) {
            nouvelleGeneration[i].mutation(this.taux_mutation);
        }
        return nouvelleGeneration;
    }

    /**
     * Affichage du tableau individus
     * @param individus tableau à afficher
     */
    public void afficherPopulation(Individu[] individus) {
        int i = 0;
        while (i < individus.length) {
            System.out.println((i+1) + " " + individus[i].toString());
            i++;
        }
    }
}
