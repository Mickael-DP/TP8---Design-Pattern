package BuilderPattern;

// Produit
class Pizza {
    private String pate;
    private String sauce;
    private String[] garnitures;

    // Constructeur pour créer une instance de Pizza avec des attributs spécifiés
    public Pizza(String pate, String sauce, String[] garnitures) {
        this.pate = pate;
        this.sauce = sauce;
        this.garnitures = garnitures;
    }

    // Méthode pour afficher les détails de la pizza
    public void afficherPizza() {
        System.out.println("Pizza avec pâte " + pate + ", sauce " + sauce + ", et garnitures : " + arrayToString(garnitures));
    }

    // Méthode privée pour convertir un tableau en une chaîne de caractères
    private String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}

// Builder
class PizzaBuilder {
    private String pate;
    private String sauce;
    private String[] garnitures;

    // Constructeur pour initialiser le builder avec des valeurs par défaut
    public PizzaBuilder() {
        this.garnitures = new String[]{};
    }

    // Méthode pour choisir le type de pâte
    public PizzaBuilder choisirPate(String pate) {
        this.pate = pate;
        return this;
    }

    // Méthode pour ajouter le type de sauce
    public PizzaBuilder ajouterSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    // Méthode pour ajouter des garnitures (variable en nombre grâce à varargs)
    public PizzaBuilder ajouterGarniture(String... garnitures) {
        this.garnitures = garnitures;
        return this;
    }

    // Méthode pour construire la pizza avec les attributs spécifiés
    public Pizza construire() {
        return new Pizza(pate, sauce, garnitures);
    }
}

// Factory pour créer des pizzas prédéfinies
class PizzaFactory {
    // Méthode pour créer une Pizza Margherita
    public static Pizza creerPizzaMargherita() {
        return new Pizza("Fine", "Tomate", new String[]{"Mozzarella", "Basilic"});
    }

    // Méthode pour créer une Pizza Pepperoni
    public static Pizza creerPizzaPepperoni() {
        return new Pizza("Épaisse", "Tomate", new String[]{"Mozzarella", "Pepperoni", "Champignons"});
    }
}

// Classe principale (main) pour tester le builder et la factory
public class builder {
    public static void main(String[] args) {
        // Utilisation du PizzaBuilder pour créer une pizza personnalisée
        Pizza pizzaCustom = new PizzaBuilder()
                .choisirPate("Épaisse")
                .ajouterSauce("Tomate")
                .ajouterGarniture("Mozzarella", "Jambon", "Champignons")
                .construire();

        // Utilisation de la PizzaFactory pour créer des pizzas prédéfinies
        Pizza pizzaMargherita = PizzaFactory.creerPizzaMargherita();
        Pizza pizzaPepperoni = PizzaFactory.creerPizzaPepperoni();

        // Affichage des pizzas
        pizzaCustom.afficherPizza();
        pizzaMargherita.afficherPizza();
        pizzaPepperoni.afficherPizza();
    }
}



