package gr.uninystems.rdi.iot_data_aquisition.repository;

import gr.uninystems.rdi.iot_data_aquisition.model.TrashBin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashBinRepository extends JpaRepository<TrashBin, Long> {

}
