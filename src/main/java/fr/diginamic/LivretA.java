package fr.diginamic;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LivretA")
public class LivretA extends Compte {

    private Double taux;

    public LivretA() {
    }

    public LivretA(String numero, Double solde, Double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}