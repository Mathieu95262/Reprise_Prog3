package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestFrais {

    @Test
    public void testStatusNotPaid() {
        Frais frais = new Frais(1, "Inscription", 50000, LocalDate.now().plusDays(5), new ArrayList<>());
        Assertions.assertEquals(FraisStatus.NOT_PAID, frais.getStatus(LocalDate.now()));
    }

    @Test
    public void testStatusPaid() {
        List<DifferentPaiement> paiements = new ArrayList<>();
        paiements.add(new DifferentPaiement(1, 50000, LocalDate.now()));

        Frais frais = new Frais(1, "Inscription", 50000, LocalDate.now().plusDays(5), paiements);
        Assertions.assertEquals(FraisStatus.PAID, frais.getStatus(LocalDate.now()));
    }

    @Test
    public void testStatusOverPaid() {
        List<DifferentPaiement> paiements = new ArrayList<>();
        paiements.add(new DifferentPaiement(1, 60000, LocalDate.now()));

        Frais frais = new Frais(1, "Inscription", 50000, LocalDate.now().plusDays(5), paiements);
        Assertions.assertEquals(FraisStatus.OVERPAID, frais.getStatus(LocalDate.now()));
    }

    @Test
    public void testStatusInProgress() {
        List<DifferentPaiement> paiements = new ArrayList<>();
        paiements.add(new DifferentPaiement(1, 20000, LocalDate.now()));

        Frais frais = new Frais(1, "Inscription", 50000, LocalDate.now().plusDays(5), paiements);
        Assertions.assertEquals(FraisStatus.IN_PROGRESS, frais.getStatus(LocalDate.now()));
    }

    @Test
    public void testStatusLate() {
        List<DifferentPaiement> paiements = new ArrayList<>();
        paiements.add(new DifferentPaiement(1, 20000, LocalDate.now().minusDays(10)));

        Frais frais = new Frais(1, "Inscription", 50000, LocalDate.now().minusDays(1), paiements);
        Assertions.assertEquals(FraisStatus.LATE, frais.getStatus(LocalDate.now()));
    }
}
