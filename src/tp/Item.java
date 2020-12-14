package tp;

public class Item {

    private int[] p; // Couts d'un item
    private int[] w; // Poids d'un item

    /**
     * Constructeur
     * @param p : tableau de 3 coûts provenant du fichier
     * @param w : tableau de 3 poids provenant du fichier
     */
    public Item(int[] p, int[] w) {
        this.p = p;
        this.w = w;
    }

}
