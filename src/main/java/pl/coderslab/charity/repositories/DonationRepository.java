package pl.coderslab.charity.repositories;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Long bagsSum();

    @Query(value = "select count(DISTINCT institution_id) from donations", nativeQuery = true)
    Long institutionsSum();


    @Modifying
    @Transactional
   @Query(value = "DELETE FROM donations_categories WHERE donation_id = ? ",nativeQuery = true)
    List<Long> deleteCategoriesByDonationId(Long id);

    @Transactional
    @Query(value = "SELECT id FROM donations WHERE institution_id = ? ",nativeQuery = true)
    List<Long> showIds(Long id);


    @Modifying
    @Transactional
    @Query (value = "DELETE FROM donations WHERE institution_id = ?",nativeQuery = true)
    void deleteDonationsByInstitutionId(Long id);

}
