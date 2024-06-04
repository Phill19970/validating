package grid.capstone.service.repository;

import grid.capstone.service.domain.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Javaughn Stephenson
 * @since 15/06/2023
 */

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
