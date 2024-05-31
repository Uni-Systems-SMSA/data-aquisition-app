package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.ParkingSpot;
import gr.uninystems.rdi.iot_data_aquisition.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link ParkingSpotService} interface.
 * <p>
 * This class provides the actual business logic for handling user-related operations.
 * It interacts with the {@link ParkingSpotRepository} to perform CRUD operations.
 * </p>
 *
 * @author StavouA
 * @version 1.0
 * @since 2024-05-31
 */
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    /**
     * Repository for accessing user data.
     */
    private ParkingSpotRepository repository;

    /**
     * Constructs a new {@code CicicomServiceImpl} with the specified repository.
     *
     * @param theParkingSpotRepository the repository for accessing user data
     */
    @Autowired
    public ParkingSpotServiceImpl(ParkingSpotRepository theParkingSpotRepository) {
        this.repository = theParkingSpotRepository;
    }

    @Transactional
    @Override
    public List<ParkingSpot> findAll() {
        return this.repository.findAll();
    }

    @Transactional
    @Override
    public ParkingSpot findById(Long Id) {
        Optional<ParkingSpot> result = repository.findById(Id);

        ParkingSpot theParkingSpot = null;

        if(result.isPresent()) {
            theParkingSpot = result.get();
        }
//        else {
//            // throw exception
//        }
        return theParkingSpot;
    }

    @Override
    public ParkingSpot save(ParkingSpot data) {
        return this.repository.save(data);
    }

    @Override
    public void deleteBy(Long Id) {

    }

    @Override
    public ParkingSpot update(Long Id, boolean IsFree) {
        return null;
    }
}
