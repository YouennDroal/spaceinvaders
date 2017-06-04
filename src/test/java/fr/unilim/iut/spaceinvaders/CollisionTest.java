package fr.unilim.iut.spaceinvaders;
 
 import static org.junit.Assert.assertEquals;
 
 import org.junit.Before;
 import org.junit.Test;
 
 import fr.unilim.iut.spaceinvaders.Collision;
 import fr.unilim.iut.spaceinvaders.Dimension;
 import fr.unilim.iut.spaceinvaders.Position;
 import fr.unilim.iut.spaceinvaders.SpaceInvaders;
 
 public class CollisionTest {
 
 	private SpaceInvaders spaceInvaders;
 	
 	@Before
     public void initialisation() {
     spaceInvaders = new SpaceInvaders(15, 10);
 	    spaceInvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 1);
    	spaceInvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(7,1), 1);
 	   	spaceInvaders.tirerUnMissile(new Dimension(1,2),2);
    }
 	
 	@Test
 	public void test_InitialisationDuJeu() {
 		assertEquals("" + 
 		".......EEE.....\n" + 
 		".......EEE.....\n" +
 		"...............\n" + 
 		"...............\n" + 
 		"...............\n" + 
 		"...............\n" + 
 		"........M......\n" + 
 		"........M......\n" + 
 		".......VVV.....\n" + 
 		".......VVV.....\n" , spaceInvaders.recupererEspaceJeuDansChaineASCII());
 	}
 
 	@Test
	public void CollisionTest_Pas_De_Collision(){ 
		assertEquals(false,Collision.detecterCollision(spaceInvaders.recupererMissile(), spaceInvaders.recupererEnvahisseur()));
 	}
 	
 	@Test
 	public void CollisionTest_Collision(){
 	spaceInvaders.deplacerMissile();
 		spaceInvaders.deplacerMissile();
 		spaceInvaders.deplacerMissile();
 		assertEquals(true,Collision.detecterCollision(spaceInvaders.recupererMissile(), spaceInvaders.recupererEnvahisseur()));
 	}
}