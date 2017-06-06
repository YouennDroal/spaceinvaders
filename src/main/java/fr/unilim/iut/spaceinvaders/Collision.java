package fr.unilim.iut.spaceinvaders;
 
 public class Collision{
 	
 	public static boolean detecterCollision(Sprite missile, Sprite envahisseur){
 		if (superpositionDeSprites(missile, envahisseur)){
 			return true;
 		} else {
 			return false;
 		}
 	}
 
 	private static boolean superpositionDeSprites(Sprite missile, Sprite envahisseur) {
 		return missile.abscisseLaPlusAGauche()<envahisseur.abscisseLaPlusADroite() 
 				&& missile.abscisseLaPlusADroite()> envahisseur.abscisseLaPlusAGauche() 
 				&& missile.ordonneeLaPlusBasse() < envahisseur.ordonneeLaPlusHaute() 
 				&& missile.ordonneeLaPlusHaute() > envahisseur.ordonneeLaPlusBasse();
 	}
 }