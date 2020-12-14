package tp;

public class Individu {

    private int[] genome; // Génome de l'individu (-1 : pas d'objet choisi, 0 : objet 1, 1 : objet 2, 2 : objet 3)
    private int poids; // Poids de l'individu (total du sac)
    private int cout; // Coût de l'individu (total du sac)
    private int score; // Score de l'individu (0 si poids < capacité, coût sinon)

    /**
     * Constructeur : Génération aléatoire
     */
    public Individu() {

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
