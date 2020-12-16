package tp;

import java.util.Arrays;

public class AlgoGenetique {

    private int nb_groupes;
    private int capacite;
    private Item[] tabItems;
    private int opt_value;

    private int population;
    private double taux_meilleurs;
    private double taux_mutation;
    private int nb_generations;

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
        selection(individus);
    }

    public Individu[] generation() {
        Individu[] individus = new Individu[this.population];
        for(int i = 0; i < this.population; i++) {
            individus[i] = new Individu(this.tabItems, this.capacite);
        }
        return individus;
    }

    public Individu[] selection(Individu[] individus) {
        Arrays.sort(individus, (a,b) -> b.getScore() - a.getScore());
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
}
