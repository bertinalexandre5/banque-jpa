package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        // Je crée ma banque
        Banque banque = new Banque("Credit Agricole");

        // Je crée mes clients
        ClientBanque client1 = new ClientBanque("Boulot", "Romain", LocalDate.of(1996,1,5), new Adresse(25, "Rue", 31000, "Toulouse"), banque);
        ClientBanque client2 = new ClientBanque("Fabien", "Durand", LocalDate.of(1978,11,16), new Adresse(45, "Avenue", 51000, "Reims"), banque);

        // Je crée mes persistence (d'abord la banque et ensuite les clients)
        em.persist(banque);
        em.persist(client1);
        em.persist(client2);

        //banque.getClientBanques().add(client1);
        //banque.getClientBanques().add(client2);

        // Je crée un compte joint
        Compte compteJoint = new LivretA("FR562622", 65000.00, 2.5 );
        em.persist(compteJoint);

        // Je crée un compte de type Assurance Vie
        Compte AssVie = new AssuranceVie("FR7893624", 35000.00, 1.5, LocalDate.of(2027,02,03));
        em.persist(AssVie);

        // Je crée la liaison de mes 2 clients
        client1.getComptes().add(compteJoint);
        client2.getComptes().add(compteJoint);

        client1.getComptes().add(AssVie);
        client2.getComptes().add(AssVie);





        //compteJoint.getClients().add(client1);
        //compteJoint.getClients().add(client2);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
