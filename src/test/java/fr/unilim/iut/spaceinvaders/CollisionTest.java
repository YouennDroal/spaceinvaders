package fr.unilim.iut.spaceinvaders;
 
 import static org.junit.Assert.assertEquals;
 
 import org.junit.Before;
 import org.junit.Test;
 
 import fr.unilim.iut.spaceinvaders.Collision;
 import fr.unilim.iut.spaceinvaders.Dimension;
 import fr.unilim.iut.spaceinvaders.Position;
 import fr.unilim.iut.spaceinvaders.SpaceInvaders;
 
 public class CollisionTest {
 
 	private SpaceInvaders spaceinvaders;
 	
 	@Before
     public void initialisation() {
     spaceinvaders = new SpaceInvaders(15, 10);
 	    spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 1);
    	spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(7,1), 1);
 	   	spaceinvaders.tirerUnMissile(new Dimension(1,2),2);
    }
 	
 	@Test
	public void testCollision_Pas_De_Collision(){ 
		assertEquals(false,Collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
 	}
 	
 	@Test
 	public void testCollision_Collision(){
 		for(int i=0;i<3;i++){
 		spaceinvaders.deplacerMissile();
 		}
 		assertEquals(true,Collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
 	}
}