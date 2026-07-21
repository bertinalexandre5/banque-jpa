package fr.diginamic;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public abstract class Compte {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private Double solde;


    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name= "id_compte", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName="id"))
    private List<ClientBanque> clients = new ArrayList<>();



    public Compte() {};

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<ClientBanque> getClients() {
        return clients;
    }

    public void setClients(List<ClientBanque> clients) {
        this.clients = clients;
    }


    @Override
    public String toString() {
        return "Compte{" +
                "numero='" + numero + '\'' +
                '}';
    }
}
