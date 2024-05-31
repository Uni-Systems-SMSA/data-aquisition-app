package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.ParkingSpot;

import java.util.List;
/**
 * Service interface for managing {@link ParkingSpot} entities.
 * <p>
 * This interface defines the business logic for handling user-related operations.
 * Implementations of this interface should provide the actual logic for creating,
 * retrieving, updating, and deleting users.
 * </p>
 *
 * @author StavrouA
 * @version 1.0
 * @since 2024-05-31
 */
public interface ParkingSpotService {
    List<ParkingSpot> findAll();
    ParkingSpot findById(Long Id);
    ParkingSpot save(ParkingSpot data);
    void deleteBy(Long Id);
    ParkingSpot update(Long Id, boolean IsFree);
}
