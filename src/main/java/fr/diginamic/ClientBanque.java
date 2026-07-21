package fr.diginamic;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ClientBanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;


    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name= "id_client", referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName="id"))
    private List<Compte> comptes = new ArrayList<>();



    public ClientBanque() {}

    public ClientBanque(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
    }
// getters / setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}

