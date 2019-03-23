package FC;

import junit.framework.TestCase;

public class RadiologueTest extends TestCase {

    private Radiologue radiologue;
    private Utilisateur utilisateur;

    public void setUp() throws Exception {
        super.setUp();
        radiologue = new Radiologue("Labus","Jean","25343","1234",TypeConnexion.MED);
        utilisateur= new Utilisateur("Labus","Jean","25343","1234",TypeConnexion.MED);
    }

    public void tearDown() throws Exception {
        super.tearDown();
        radiologue=null;
    }

    public void testSetNom() {
        radiologue.setNom("Leau");
        assertEquals("Le nom est incorrect","Leau",radiologue.getNom());
    }

    public void testSetPrenom() {
        radiologue.setPrenom("Edgard");
        assertEquals("Le prenom est incorrect","Edgard",radiologue.getPrenom());
    }

    public void testSetMdp() {
        radiologue.setMdp("1234");
        assertEquals("Le mot de passe est incorrect","1234",radiologue.getMdp());
    }

    public void testGetNom() {

        assertEquals("Le nom est incorrect","Labus",utilisateur.getNom());
    }

    public void testGetPrenom() {
        assertEquals("Le prenom est incorrect","Jean",utilisateur.getPrenom());
    }

    public void testGetId() {
        assertEquals("L'Id est incorrect","25343",utilisateur.getId());
    }

    public void testGetMdp() {
        assertEquals("Le mdp est incorrect","1234",utilisateur.getMdp());
    }
}