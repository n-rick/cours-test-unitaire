import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculTest {

    Calcul calcul;
    @BeforeAll
    static void setUpBeforeClass() throws Exception{}
    @AfterAll
    static void tearDownAfterClass() throws Exception{}
    @BeforeEach
    void setUp() throws Exception{
        calcul = new Calcul();
    }
    @AfterEach
    void tearDown() throws Exception{}
    @Test
    void testSomme() {
        if (calcul.somme(0, 0) != 0) {
            fail("somme de deux nombres nuls");
        }
        if (calcul.somme(5, 2) != 7) {
            fail("somme de deux nombres positifs");
        }
        if (calcul.somme(-5, -3) != -8) {
            fail("somme de deux nombres négatifs");
        }
        if (calcul.somme(5, 0) != 5) {
            fail("somme de deux nombres : un positif et un nul");
        }
        if (calcul.somme(-5, 0) != -5) {
            fail("somme de deux nombres : un négatif et un nul");
        }
    }

    @Test
    void testDivision() {
        assertAll("Premier bloc de test",
                () ->  assertFalse(calcul.division(6, 2) == 0, "Cas de 2 entiers +"),
                () -> assertEquals(-3, calcul.division(6, -2))
        );
        Exception exception = null;
        try {
            calcul.division(10, 0);
        } catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof ArithmeticException);
    }
}
