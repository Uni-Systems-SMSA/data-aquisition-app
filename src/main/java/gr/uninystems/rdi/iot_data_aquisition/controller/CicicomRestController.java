package gr.uninystems.rdi.iot_data_aquisition.controller;

import gr.uninystems.rdi.iot_data_aquisition.model.Cicicom;
import gr.uninystems.rdi.iot_data_aquisition.service.CicicomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CicicomRestController {
    private CicicomService cicicomService;

    @Autowired
    public CicicomRestController(CicicomService theCicicomService){
        this.cicicomService = theCicicomService;
    }

    @GetMapping({"/cicicom"})
    public List<Cicicom> findAll() {
        return this.cicicomService.findAll();
    }

    @GetMapping({"/cicicom/{Id}"})
    public Cicicom getCicicom(@PathVariable Long Id) {
        Cicicom theCicicom = this.cicicomService.findById(Id);
        return theCicicom;
    }

    @PostMapping({"/cicicom"})
    public Cicicom addCicicom(@RequestBody Cicicom theCicicom) {
        theCicicom.setId(0);
        Cicicom dbCicicom = this.cicicomService.save(theCicicom);
        return dbCicicom;
    }

    @DeleteMapping({"/cicicom/{Id}"})
    public String deleteCicicom(@PathVariable Long Id) {
        this.cicicomService.deleteBy(Id);
        return "the id " + Id + " deleted";
    }
}
