package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestStatistics {

    @Test
    public void testGetLateFees() {
        LocalDate today = LocalDate.now();

        Frais f1 = new Frais(1, "A", 50000, today.minusDays(1), Arrays.asList(new DifferentPaiement(1, 10000, today)));
        Frais f2 = new Frais(2, "B", 50000, today.plusDays(2), Arrays.asList());

        List<Frais> result = Statistics.getLateFees(Arrays.asList(f1, f2), today);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(f1, result.get(0));
    }

    @Test
    public void testTotalMissingFees() {
        LocalDate today = LocalDate.now();

        Frais f1 = new Frais(1, "A", 50000, today.minusDays(1), Arrays.asList(new DifferentPaiement(1, 20000, today)));
        Frais f2 = new Frais(2, "B", 60000, today.minusDays(1), Arrays.asList(new DifferentPaiement(1, 10000, today)));

        double missing = Statistics.getTotalMissingFees(Arrays.asList(f1, f2), today);

        Assertions.assertEquals(80000, missing);
    }

    @Test
    public void testTotalPaidByStudent() {
        Etudiants student = new Etudiants(10, "John", "Doe", LocalDate.now(), null, null);

        Frais f1 = new Frais(1, "A", 50000, LocalDate.now(), Arrays.asList(new DifferentPaiement(1, 20000, LocalDate.now())));
        Frais f2 = new Frais(2, "B", 50000, LocalDate.now(), Arrays.asList(new DifferentPaiement(2, 15000, LocalDate.now())));
        f1.setDifferentPaiements(Arrays.asList(new DifferentPaiement(1, 20000, LocalDate.now())));
        f2.setDifferentPaiements(Arrays.asList(new DifferentPaiement(2, 15000, LocalDate.now())));
        double total = Statistics.getTotalPaidByStudent(student, Arrays.asList(f1, f2), LocalDate.now());

        Assertions.assertEquals(35000, total);
    }
}
