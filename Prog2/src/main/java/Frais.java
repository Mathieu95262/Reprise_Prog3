package model;
import java.util.List;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Frais {
    private int id;
    private String label;
    private double montantaPayer;
    private ChronoLocalDate deadline;
    private List<DifferentPaiement> differentPaiements;
    private Etudiants etudiant;


public Frais(int id, String label, double montantaPayer, ChronoLocalDate deadline, List<DifferentPaiement> differentPaiements, Etudiants etudiant) {
    this.id = id;
    this.label = label;
    this.montantaPayer = montantaPayer;
    this.deadline = deadline;
    this.differentPaiements = differentPaiements;
    this.etudiant = etudiant;
}


    public Etudiants getEtudiant() {
        return etudiant;
    }

    public void ajoutPaiement(DifferentPaiement paiement) {
        this.differentPaiements.add(paiement);
    }

    public double getTotalPaye() {
        return differentPaiements.stream()
                .mapToDouble(DifferentPaiement::getMontant)
                .sum();
    }

    public FraisStatus getStatus(LocalDate currentDate) {
        Double somme = getTotalPaye();

        if (somme == 0) {
            return FraisStatus.NOT_PAID;
        }

        if (somme > montantaPayer) {
            return FraisStatus.OVERPAID;
        }

        if (somme == montantaPayer) {
            return FraisStatus.PAID;
        }

        if (currentDate.isAfter(deadline)) {
            return FraisStatus.LATE;
        }

        return FraisStatus.IN_PROGRESS;
    }


    public List<DifferentPaiement> getDifferentPaiements() {
        return differentPaiements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getMontantaPayer() {
        return montantaPayer;
    }

    public void setMontantaPayer(double montantaPayer) {
        this.montantaPayer = montantaPayer;
    }

    public ChronoLocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(ChronoLocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDifferentPaiements(List<DifferentPaiement> differentPaiements) {
        this.differentPaiements = differentPaiements;
    }
}