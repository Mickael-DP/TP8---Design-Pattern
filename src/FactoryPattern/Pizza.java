package FactoryPattern;
// La classe de base représentant une pizza
public class Pizza {

    // méthode de préparation de la pizza
    public String prepare() {
        return "Preparing pizza";
    }
    // méthode de cuisson de la pizza
    public String bake() {
        return "Baking pizza";
    }
    // méthode d'emballage de la pizza
    public String box() {
        return  "Boxing pizza";
    }
}

// Les classes dérivées représentant les différents types de pizza, étendent la classe Pizza
class PizzaFromage extends Pizza {
    public String prepare() {
        return "Preparing pizza fromage";
    }

    public String bake() {
        return "Baking pizza fromage";
    }

    public String box() {
        return  "Boxing pizza fromage";
    }
}

class PizzaVegetarienne extends Pizza {
    public String prepare() {
        return "Preparing pizza vegetarienne";
    }

    public String bake() {
        return "Baking pizza vegetarienne";
    }

    public String box() {
        return  "Boxing pizza vegetarienne";
    }
}

// Classe représentant une fabrique de pizzas, étend la classe Pizza
class PizzaFactory extends Pizza {

    // Méthode pour créer une pizza en fonction du type spécifié
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        // Vérifier le type de pizza demandé et créer une instance appropriée

        if (type.equals("fromage")) {
            pizza = new PizzaFromage();
        } else if (type.equals("vegetarienne")) {
            pizza = new PizzaVegetarienne();
        }

        // Renvoyer l'instance de pizza créée
        return pizza;
    }
}

