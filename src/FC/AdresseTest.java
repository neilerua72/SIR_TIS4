package FC;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AdresseTest extends TestCase {

    public void testToString() {

        Adresse adresse = new Adresse("rue de la brouette", "nada",38100,"marseille");
        String expected="rue de la brouette nada 38100 marseille";
        Assert.assertEquals(expected,adresse.toString());
    }
}