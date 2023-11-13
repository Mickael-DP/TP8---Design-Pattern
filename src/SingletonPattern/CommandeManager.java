package SingletonPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandeManager {
    private static CommandeManager instance;
    private final List<Commande> commandes;

    private CommandeManager() {
        // Constructeur privé pour empêcher l'instanciation externe
        this.commandes = new ArrayList<>();
    }

    public static  CommandeManager getInstance() {
        // Implémentation du pattern Singleton pour assurer une seule instance de CommandeManager
        if (instance == null) {
            instance = new CommandeManager();
        }
        return instance;
    }

    // Méthode pour ajouter une commande
    public  void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    // Méthode pour supprimer une commande
    public  void supprimerCommande(Commande commande) {
        commandes.remove(commande);
    }

    // Méthode pour récupérer la liste des commandes
    public List<Commande> getListeCommandes() {
        // Retourne une copie de la liste pour éviter la modification externe
        return new ArrayList<>(commandes);
    }

    // Classe Commande
    public static class Commande {
        private final String nom;
        private final String adresse;
        private final String telephone;

        public Commande(String nom, String adresse, String telephone) {
            this.nom = nom;
            this.adresse = adresse;
            this.telephone = telephone;
        }

        public String getNom() {
            return nom;
        }

        public String getAdresse() {
            return adresse;
        }

        public String getTelephone() {
            return telephone;
        }
    }
}

