package fr.diginamic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Banque {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    @OneToMany(mappedBy = "banque")
    private List<ClientBanque> clientBanques = new ArrayList<>();


    public Banque() {}

    public Banque(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<ClientBanque> getClientBanques() {
        return clientBanques;
    }

    public void setClientBanques(List<ClientBanque> clientBanques) {
        this.clientBanques = clientBanques;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
