package SingletonPattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandeManagerTest {

    @Test
    void testSingleInstance() {
        // Tester si CommandeManager crée une seule instance
        CommandeManager instance1 = CommandeManager.getInstance();
        CommandeManager instance2 = CommandeManager.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    void testMultithreading() {
        // Tester l'instanciation de CommandeManager dans un contexte multithread
        Runnable getInstanceTask = () -> {
            CommandeManager instance = CommandeManager.getInstance();
        };

        // Créer plusieurs threads pour obtenir des instances simultanément
        Thread thread1 = new Thread(getInstanceTask);
        Thread thread2 = new Thread(getInstanceTask);

        thread1.start();
        thread2.start();

        // Attendre que les threads se terminent
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCommandeManagement() {
        // Tester l'ajout, la suppression, et la récupération de commandes dans CommandeManager
        CommandeManager commandeManager = CommandeManager.getInstance();
        CommandeManager.Commande commande1 = new CommandeManager.Commande("Nom1", "Adresse1", "123456789");
        CommandeManager.Commande commande2 = new CommandeManager.Commande("Nom2", "Adresse2", "987654321");

        // Ajouter une commande
        commandeManager.ajouterCommande(commande1);

        // Vérifier si la commande a été ajoutée
        assertTrue(commandeManager.getListeCommandes().contains(commande1));

        // Supprimer une commande
        commandeManager.supprimerCommande(commande1);

        // Vérifier si la commande a été supprimée
        assertFalse(commandeManager.getListeCommandes().contains(commande1));

        // Ajouter une autre commande
        commandeManager.ajouterCommande(commande2);

        // Vérifier la récupération de la liste des commandes
        assertEquals(1, commandeManager.getListeCommandes().size());
        assertTrue(commandeManager.getListeCommandes().contains(commande2));
    }
}
