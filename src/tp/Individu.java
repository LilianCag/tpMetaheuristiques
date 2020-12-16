package tp;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Individu {

    private int n; // Taille du génome
    private int[] genome; // Génome de l'individu (-1 : pas d'objet choisi, 0 : objet 1, 1 : objet 2, 2 : objet 3)
    private int poids; // Poids de l'individu (total du sac)
    private int cout; // Coût de l'individu (total du sac)
    private int score; // Score de l'individu (0 si poids > capacité, coût sinon)

    /**
     * Constructeur : Génération aléatoire
     */
    public Individu(Item[] tabItems, int capacite) {
        this.n = tabItems.length;
        this.genome = new int[n];
        this.poids = 0;
        this.cout = 0;
        for (int i = 0; i < n; i++) {
            int rand = (int)(Math.random() * 4) - 1;
            this.genome[i] = rand;
            if(rand != -1) {
                this.poids += tabItems[i].getW()[rand];
                this.cout += tabItems[i].getP()[rand];
            }
        }
        determinerScore(capacite);
    }

    /**
     * Constructeur : Procréation
     * @param i1 : Parent 1
     * @param i2 : Parent 2
     */
    public Individu(Individu i1, Individu i2, Item[] tabItems, int capacite) {
        this.n = tabItems.length;
        this.genome = new int[n];
        this.poids = 0;
        this.cout = 0;
        for (int i = 0; i < n/2; i++) {
            this.genome[i] = i1.getGenome()[i];
            if(this.genome[i] != -1) {
                this.poids += tabItems[i].getW()[this.genome[i]];
                this.cout += tabItems[i].getP()[this.genome[i]];
            }
        }
        for (int i = n/2; i < n; i++) {
            this.genome[i] = i2.getGenome()[i];
            if(this.genome[i] != -1) {
                this.poids += tabItems[i].getW()[this.genome[i]];
                this.cout += tabItems[i].getP()[this.genome[i]];
            }
        }
        determinerScore(capacite);
    }

    public void determinerScore(int capacite) {
        if (this.poids > capacite) {
            this.score = 0;
        }
        else {
            this.score = this.cout;
        }
    }

    public void mutation(double taux_mutation) {
        int imax = (int) Math.round(taux_mutation * n);

        // Liste d'index que l'on mute
        List<Integer> listIndex = new ArrayList<>();
        for(int i = 0; i < imax; i++) {
            int indexRand = (int) (Math.random() * n);
            if (listIndex.contains(indexRand)) {
                while (listIndex.contains(indexRand)) {
                    indexRand = (int) (Math.random() * n);
                }
            }
            listIndex.add(indexRand);
        }
        // Mutation des index de la liste
        for (Integer index : listIndex) {
            int i = 0;
            int rand = (int) ((Math.random() * 3) + 1);
            while (i < rand) {
                if (this.genome[index] == 2) this.genome[index] = -1;
                else this.genome[index] ++;
                i++;
            }
        }
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

    @Override
    public String toString() {
        return "Individu{" +
                "genome=" + Arrays.toString(genome) +
                ", poids=" + poids +
                ", cout=" + cout +
                ", score=" + score +
                '}';
    }
}
