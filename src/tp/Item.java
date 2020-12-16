package tp;

import java.util.Arrays;

public class Item {

    private int[] p; // Couts d'un item
    private int[] w; // Poids d'un item

    /**
     * Constructeur
     * @param p : tableau de 3 coûts provenant du fichier
     */
    public Item(int[] p) {
        this.p = p;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

    public int[] getW() {
        return w;
    }

    public void setW(int[] w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "Item{" +
                "p=" + Arrays.toString(p) +
                ", w=" + Arrays.toString(w) +
                '}';
    }
}
