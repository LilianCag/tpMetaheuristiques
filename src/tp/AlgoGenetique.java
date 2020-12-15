package tp;

import java.util.Arrays;

public class AlgoGenetique {

    private int population;
    private double taux_mutation;
    private int nb_simulation;

    public AlgoGenetique(int population, double taux_mutation, int nb_simulation) {
        this.population = population;
        this.taux_mutation = taux_mutation;
        this.nb_simulation = nb_simulation;
    }

    public void algo() {
        Individu[] individus = generation();
    }

    public Individu[] generation() {
        Individu[] individus = new Individu[population];
        for(int i = 0; i < population; i++) {
            individus[i] = new Individu();
        }
        return individus;
    }

    public void selection(Individu[] individus) {
        Arrays.sort(individus, (a,b) -> b.getScore() - a.getScore());

    }

    public void procreation() {

    }

    public void mutation() {

    }
}
