package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.Cicicom;

import java.util.List;

public interface CicicomService {
    List<Cicicom> findAll();
    Cicicom findById(Long Id);
    Cicicom save(Cicicom data);
    void deleteBy(Long Id);
    Cicicom update(Long Id, boolean IsFree);
}
