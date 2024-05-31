package gr.uninystems.rdi.iot_data_aquisition.repository;

import gr.uninystems.rdi.iot_data_aquisition.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Repository interface for {@link ParkingSpot} instances.
 * Provides basic CRUD operations due to the extension of {@link JpaRepository}.
 * Includes custom defined queries for additional retrieval operations.
 * <p>
 * This repository is marked with the {@link Repository} annotation to indicate
 * that it's a Spring Data repository.
 * </p>
 *
 * @see ParkingSpot
 * @see JpaRepository
 * @see org.springframework.data.repository.Repository
 * @see org.springframework.stereotype.Repository
 *
 * @author StavrouA
 * @version 1.0
 * @since 2024-05-31
 */
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

}
