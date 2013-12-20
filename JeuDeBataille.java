
public class JeuDeBataille {

    private Joueur raoul;
    private Joueur toto;

    private Paquet pioche;

    // preparer le jeu
    public JeuDeBataille() {

        // creer les joueurs
        raoul = new Joueur("Raoul");
        toto = new Joueur("Toto");

        // creer les cartes
        pioche = new Paquet("depart");

        // distribuer les cartes ( on distribue pas : c'est le joueur qui tire les cartes)
         while (pioche.aDesCartes()) {

            Carte c = pioche.tirerUneCarteAuHasard();
            raoul.prends(c);

            toto.prends(pioche.tirerUneCarteAuHasard());
        }

        // on affiche la distribution des cartes pour verifier que tout est en ordre
        System.out.println("pioche : " + pioche.getCartes().size());
        System.out.println("Raoul : " + raoul.nombreDeCartes());
        System.out.println("Toto : " + toto.nombreDeCartes());

    }

    // jouer une partie
    public void jouerUnePartie() {

        int i = 0 ;

        while (raoul.aDesCartes() && toto.aDesCartes()) {
            jouerUnTour();
        }

    }

    // joueur un tour
    private void jouerUnTour() {

        Carte carteDeRaoul = raoul.tirerUneCarte();
        Carte carteDeToto = toto.tirerUneCarte();

        System.out.println("Raoul : " + carteDeRaoul.getTitre() + " Vs " + "Toto : " + carteDeToto.getTitre());

        if (carteDeRaoul.estPlusForteQue(carteDeToto)) {
            raoul.gagne(carteDeToto);
            toto.perdre(carteDeToto);
            raoul.mettreEnDessous(carteDeRaoul);
            raoul.gagne(pioche);
        }

        else if (carteDeToto.estPlusForteQue(carteDeRaoul)) {
            toto.gagne(carteDeRaoul);
            raoul.perdre(carteDeRaoul);
            toto.mettreEnDessous(carteDeToto);
            toto.gagne(pioche);
        }

        else {
            System.out.println("Bataille!!!");

            toto.parierUneCarte(carteDeToto, pioche);
            raoul.parierUneCarte(carteDeRaoul, pioche);

            if(toto.aDesCartes() && raoul.aDesCartes()) {
                toto.parierUneCarte(toto.tirerUneCarte(), pioche);
                raoul.parierUneCarte(raoul.tirerUneCarte(), pioche);
            }
        }
        System.out.println("Raoul : " + raoul.nombreDeCartes() + " / " + "Toto : " + toto.nombreDeCartes() + " : " + (raoul.nombreDeCartes() + toto.nombreDeCartes()) + "\n");
    }
}

