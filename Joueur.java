
public class Joueur {

    private final String nom;
    private Paquet paquet;

    public Joueur (String nom) {
        this.nom = nom;
        paquet = new Paquet("vide");
    }

    public void prends(Carte c) {
        paquet.ajouterUnCarteAuDessus(c);
    }

    public int nombreDeCartes() {
        return paquet.getCartes().size();
    }

    public boolean aDesCartes() {
        return ! paquet.getCartes().isEmpty();
    }

    public Carte tirerUneCarte() {
        return paquet.carteDuDessus();
    }

    public void gagne(Carte carte) {
        paquet.ajouterAuDessous(carte);
    }

    public void perdre(Carte carte) {
        paquet.retirer(carte);
    }

    public void mettreEnDessous(Carte carte) {
        paquet.mettreEnDessous(carte);
    }

    public void gagne(Paquet p){
        paquet.recupererAuDessous(p);
    }

    public void parierUneCarte(Carte carte, Paquet p){
        perdre(carte);
        p.ajouterUnCarteAuDessus(carte);
    }
}
