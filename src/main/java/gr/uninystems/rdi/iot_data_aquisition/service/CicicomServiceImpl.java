package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.Cicicom;
import gr.uninystems.rdi.iot_data_aquisition.repository.CicicomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CicicomServiceImpl implements CicicomService {

    private CicicomRepository repository;

    @Autowired
    public CicicomServiceImpl(CicicomRepository theCicicomRepository) {
        this.repository = theCicicomRepository;
    }

    @Transactional
    @Override
    public List<Cicicom> findAll() {
        return this.repository.findAll();
    }

    @Transactional
    @Override
    public Cicicom findById(Long Id) {
        Optional<Cicicom> result = repository.findById(Id);

        Cicicom theCicicom = null;

        if(result.isPresent()) {
            theCicicom = result.get();
        }
//        else {
//            // throw exception
//        }
        return theCicicom;
    }

    @Override
    public Cicicom save(Cicicom data) {
        return this.repository.save(data);
    }

    @Override
    public void deleteBy(Long Id) {

    }

    @Override
    public Cicicom update(Long Id, boolean IsFree) {
        return null;
    }
}
