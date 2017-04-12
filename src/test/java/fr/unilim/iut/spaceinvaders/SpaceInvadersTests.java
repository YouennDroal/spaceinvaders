 package fr.unilim.iut.spaceinvaders;

    import static org.junit.Assert.assertEquals;
    import org.junit.Test;

    public class SpaceInvadersTests {
	
	   @Test
	   public void test_AuDebut_JeuSpaceInvaderEstVide() {
		    SpaceInvaders spaceInvaders = new SpaceInvaders(15, 10);
		    assertEquals("" + 
		    "...............\n" + 
		    "...............\n" +
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" , spaceInvaders.toString());
		    
	        }
		@Test
		public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			spaceinvaders.positionnerUnNouveauVaisseau(7,9);
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			".......V.......\n" , spaceinvaders.toString());
			
		}

       }