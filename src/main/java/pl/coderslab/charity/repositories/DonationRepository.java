package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entities.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Long bagsSum();

    @Query(value = "select count(DISTINCT institution_id) from donations", nativeQuery = true)
    Long institutionsSum();
}
