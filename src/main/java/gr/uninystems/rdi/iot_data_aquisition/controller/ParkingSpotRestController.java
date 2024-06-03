package gr.uninystems.rdi.iot_data_aquisition.controller;

import gr.uninystems.rdi.iot_data_aquisition.model.ParkingSpot;
import gr.uninystems.rdi.iot_data_aquisition.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for {@link ParkingSpot} instances.
 * Provides basic CRUD operations for the {@link ParkingSpot} model.
 *
 * This Rest Controller is marked with the {@link RestController} annotation to indicate
 * that it's a Spring Rest Controller.
 *
 *
 */
@RestController
public class ParkingSpotRestController {
    private ParkingSpotService parkingSpotService;

    @Autowired
    public ParkingSpotRestController(ParkingSpotService theParkingSpotService){
        this.parkingSpotService = theParkingSpotService;
    }

    @GetMapping({"/cicicom/parkingspot/"})
    public List<ParkingSpot> findAll() {
        return this.parkingSpotService.findAll();
    }

    @GetMapping({"/cicicom/parkingspot/{Id}"})
    public ParkingSpot getParkingSpot(@PathVariable Long Id) {
        ParkingSpot theParkingSpot = this.parkingSpotService.findById(Id);
        return theParkingSpot;
    }

    @PostMapping({"/cicicom/parkingspot/"})
    public ParkingSpot addParkingSpot(@RequestBody ParkingSpot theParkingSpot) {
        theParkingSpot.setId(0);
        ParkingSpot dbParkingSpot = this.parkingSpotService.save(theParkingSpot);
        return dbParkingSpot;
    }

    @DeleteMapping({"/cicicom/parkingspot/{Id}"})
    public String deleteParkingSpot(@PathVariable Long Id) {
        this.parkingSpotService.deleteBy(Id);
        return "the id " + Id + " deleted";
    }
}
