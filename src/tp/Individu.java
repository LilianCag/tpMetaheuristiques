package tp;

import java.lang.Math;

public class Individu {

    private int n; // Taille du génome
    private int[] genome; // Génome de l'individu (-1 : pas d'objet choisi, 0 : objet 1, 1 : objet 2, 2 : objet 3)
    private int poids; // Poids de l'individu (total du sac)
    private int cout; // Coût de l'individu (total du sac)
    private int score; // Score de l'individu (0 si poids < capacité, coût sinon)

    /**
     * Constructeur : Génération aléatoire
     */
    public Individu() {
        this.n = 50;
        this.genome = new int[n];
        this.poids = 0;
        this.cout = 0;
        for (int i = 0; i < n; i++) {
            int rand = (int)(Math.random() * 4) - 1;
            this.genome[i] = rand;
            // this.poids += tab[i].getCoutAtIndex(rand);
            // this.cout += tab[i].getPoidsAtIndex(rand);
        }
    }

    /**
     * Constructeur : Procréation
     * @param i1 : Parent 1
     * @param i2 : Parent 2
     */
    public Individu(Individu i1, Individu i2) {

    }

    public int[] getGenome() {
        return genome;
    }

    public void setGenome(int[] genome) {
        this.genome = genome;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
