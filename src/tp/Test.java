package tp;

public class Test {

    public static void main(String[] args) {
        /*
         * Variables d'environnement
         */
        int population = 100;
        double taux_mutation = 0.01;
        AlgoGenetique ag = new AlgoGenetique(population, taux_mutation);
        ag.algo();
    }
}
