package FactoryPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PizzaFactoryTest {

    @Test
    void testCreatePizzaFromage() {
        PizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("fromage");
        assertNotNull(pizza);
        assertEquals("Preparing pizza fromage", pizza.prepare());
        assertEquals("Baking pizza fromage", pizza.bake());
        assertEquals("Boxing pizza fromage", pizza.box());
    }

    @Test
    void testCreatePizzaVegetarienne() {
        PizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("vegetarienne");
        assertNotNull(pizza);
        assertEquals("Preparing pizza vegetarienne", pizza.prepare());
        assertEquals("Baking pizza vegetarienne", pizza.bake());
        assertEquals("Boxing pizza vegetarienne", pizza.box());
    }

    @Test
    void testCreatePizzaUnknownType() {
        PizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("unknown");
        assertNull(pizza);
    }
}
