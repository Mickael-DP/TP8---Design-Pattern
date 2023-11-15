package BuilderPattern;

import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaBuilderTest {

    // Test pour vérifier si le PizzaBuilder construit une Pizza avec les attributs corrects
    @Test
    public void testPizzaBuilder() {
        // Création d'une pizza avec le PizzaBuilder
        Pizza pizza = new PizzaBuilder()
                .choisirPate("Fine")
                .ajouterSauce("Tomate")
                .ajouterGarniture("Mozzarella", "Basilic")
                .construire();

        // Vérification des attributs de la pizza
        assertEquals("Fine", pizza.getPate());
        assertEquals("Tomate", pizza.getSauce());
        assertArrayEquals(new String[]{"Mozzarella", "Basilic"}, pizza.getGarnitures());
    }

    // Test pour vérifier si la PizzaFactory crée une Pizza Margherita correcte
    @Test
    public void testPizzaFactory() {
        // Création d'une pizza Margherita avec la PizzaFactory
        Pizza pizzaMargherita = PizzaFactory.creerPizzaMargherita();

        // Vérification des attributs de la pizza Margherita
        assertNotNull(pizzaMargherita); // Vérifie que la pizza n'est pas nulle
        assertEquals("Fine", pizzaMargherita.getPate());
        assertEquals("Tomate", pizzaMargherita.getSauce());
        assertArrayEquals(new String[]{"Mozzarella", "Basilic"}, pizzaMargherita.getGarnitures());
    }
}



