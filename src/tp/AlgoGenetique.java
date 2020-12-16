package tp;

import java.util.Arrays;

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
        Individu[] individus = generation();
        tri(individus);
        afficherPopulation(individus);
        individus[0].mutation(taux_mutation);
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
        int i;
        for(i=0; i<Math.floor(this.population*taux_meilleurs); i++) {
            selectionIndividus[i] = individus[i];
        }
        return selectionIndividus;
    }

    public void procreation() {
        Individu[] nouvelleGeneration = new Individu[this.population];
    }

    public void mutation() {

    }

    /**
     * Affichage du tableau individus
     * @param individus tableau à afficher
     */
    public void afficherPopulation(Individu[] individus) {
        for(int i = 0; i < this.population; i++) {
            System.out.println(individus[i].toString());
        }
    }
}
