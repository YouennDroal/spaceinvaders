    package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.moteurJeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurJeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders implements Jeu {

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
				espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
			}
			return espaceDeJeu.toString();
		}

		private char recupérerMarqueDeLaPosition(int x, int y) {
			char marque;
			  if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			      marque=Constante.MARQUE_VAISSEAU;
			  else
			      marque=Constante.MARQUE_VIDE;
			return marque;
		}
		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}

		public boolean aUnVaisseau() {
			return vaisseau!=null;
		}

		public void deplacerVaisseauVersLaDroite() {
			if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
				vaisseau.seDeplacerVersLaDroite();
				if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
					vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
				}
			}
		}

		public void deplacerVaisseauVersLaGauche() {
			if (0 < vaisseau.abscisseLaPlusAGauche())
				vaisseau.seDeplacerVersLaGauche();
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
			}
		}

		private boolean peutSeDeplacerGauche() {
			return vaisseau.abscisseLaPlusAGauche()>1;
		}
		
		private boolean peutSeDeplacerDroite() {
			return vaisseau.abscisseLaPlusAGauche()< (longueur-1);
		}
		
		 public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {
				
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

			    vaisseau = new Vaisseau(dimension,position,vitesse);
				vaisseau.positionner(x, y);
			}
		 
		 public Vaisseau recupererVaisseau() {
				return this.vaisseau;
			}
		 
		  @Override
	       public void evoluer(Commande commandeUser) {
			
	          if (commandeUser.gauche) {
	              deplacerVaisseauVersLaGauche();
	          }
			
	         if (commandeUser.droite) {
		        deplacerVaisseauVersLaDroite();
	         }

	       }

	   
	      @Override
	      public boolean etreFini() {
	         return false; 
	      }
	      
	      
	      public void initialiserJeu() {
	  		Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
	  		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
	  		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
	  	 }

		
}