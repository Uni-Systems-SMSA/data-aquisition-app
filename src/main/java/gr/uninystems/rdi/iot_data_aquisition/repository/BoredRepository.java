package gr.uninystems.rdi.iot_data_aquisition.repository;

import gr.uninystems.rdi.iot_data_aquisition.model.Bored;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoredRepository extends JpaRepository<Bored, Long> {
}
