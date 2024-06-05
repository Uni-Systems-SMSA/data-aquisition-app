package gr.uninystems.rdi.iot_data_aquisition.repository;

import gr.uninystems.rdi.iot_data_aquisition.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
