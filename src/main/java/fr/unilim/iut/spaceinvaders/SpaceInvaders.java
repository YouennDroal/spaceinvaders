    package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

	    private static final char MARQUE_FIN_LIGNE = '\n';
		private static final char MARQUE_VIDE = '.';
		private static final char MARQUE_VAISSEAU = 'V';
		int longueur;
	    int hauteur;
	    Vaisseau vaisseau;

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	   }

		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}
	    
		
		public String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					espaceDeJeu.append(recupérerMarqueDeLaPosition(x, y));
				}
				espaceDeJeu.append(MARQUE_FIN_LIGNE);
			}
			return espaceDeJeu.toString();
		}

		private char recupérerMarqueDeLaPosition(int x, int y) {
			char marque;
			  if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			      marque=MARQUE_VAISSEAU;
			  else
			      marque=MARQUE_VIDE;
			return marque;
		}
		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}

		private boolean aUnVaisseau() {
			return vaisseau!=null;
		}

		public void deplacerVaisseauVersLaDroite() {
			if (vaisseau.abscisseLaPlusADroite() < (longueur - 1))
				vaisseau.seDeplacerVersLaDroite();
		}

		public void deplacerVaisseauVersLaGauche() {
           	if (peutSeDeplacerGauche()) vaisseau.seDeplacerVersLaGauche();
			
		}

		private boolean peutSeDeplacerGauche() {
			return vaisseau.abscisseLaPlusAGauche()>1;
		}
		
		private boolean peutSeDeplacerDroite() {
			return vaisseau.abscisseLaPlusAGauche()< (longueur-1);
		}
		
		 public void positionnerUnNouveauVaisseau(Dimension dimension, Position position) {
				
				int x = position.abscisse();
				int y = position.ordonnee();
				
				if (!estDansEspaceJeu(x, y))
					throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

				int longueurVaisseau = dimension.longueur();
				int hauteurVaisseau = dimension.hauteur();
				
				if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
					throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
				if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
					throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

				vaisseau = new Vaisseau(longueurVaisseau, hauteurVaisseau);
				vaisseau.positionner(x, y);
			}

		
}