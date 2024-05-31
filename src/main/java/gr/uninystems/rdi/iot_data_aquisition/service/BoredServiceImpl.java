package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.Bored;
import gr.uninystems.rdi.iot_data_aquisition.repository.BoredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoredServiceImpl {

    @Autowired
    private BoredRepository repository;

    public void saveBored(Bored data) {
        repository.save(data);
    }


}
