package fr.diginamic;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Locale;

@Entity
@DiscriminatorValue("Ass_Vie")
public class AssuranceVie extends Compte{

    private LocalDate dateFin;
    private double taux;

    public AssuranceVie() {}

    public AssuranceVie(String numero, Double solde, Double taux, LocalDate dateFin) {
        super(numero, solde);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
