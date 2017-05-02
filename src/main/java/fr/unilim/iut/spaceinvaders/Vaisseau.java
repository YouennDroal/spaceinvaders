package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

    int x;
    int y;
    int longueur;
    int hauteur;

	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}
    
    public Vaisseau(int longueur, int hauteur, int x, int y) {
	   this.longueur=longueur;
	   this.hauteur=hauteur;
	   this.x = x;
	   this.y = y;
    }

	
    public boolean occupeLaPosition(int x, int y) {
	     if ((this.x<=x) && abscisseLaPlusADroite(x)) 
		      if ( (this.y-this.hauteur+1<=y) && (y<=this.y))
			  return true;
		
	     return false;
    }

	private boolean abscisseLaPlusADroite(int x) {
		return x<=this.x+this.longueur-1;
	}

	public void seDeplacerVersLaDroite() {
		this.x = this.x + 1 ;		
	}
	
	public int abscisse() {
        return this.x;
	}

	public void seDeplacerVersLaGauche() {
		this.x = this.x - 1 ;		
		
	}

	 public void positionner(int x, int y) {
		    this.x = x;
		    this.y = y;
	}
	
	
    
}
