package tp;

import java.util.Arrays;

public class AlgoGenetique {

    private int population;
    private double taux_mutation;
    private int nb_generations;

    public AlgoGenetique(int population, double taux_mutation, int nb_generations) {
        this.population = population;
        this.taux_mutation = taux_mutation;
        this.nb_generations = nb_generations;
    }

    public void algo() {
        Individu[] individus = generation();
    }

    public Individu[] generation() {
        Individu[] individus = new Individu[this.population];
        for(int i = 0; i < this.population; i++) {
            individus[i] = new Individu();
        }
        return individus;
    }

    public Individu[] selection(Individu[] individus) {
        Arrays.sort(individus, (a,b) -> b.getScore() - a.getScore());
        Individu[] selectionIndividus = new Individu[this.population/2];
        return selectionIndividus;
    }

    public void procreation() {
        Individu[] nouvelleGeneration = new Individu[this.population];
    }

    public void mutation() {

    }
}
