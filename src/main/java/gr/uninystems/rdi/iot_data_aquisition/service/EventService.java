package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();
    Event findById(Long Id);
    Event save(Event data);
    void deleteBy(Long Id);
    Event update(Long Id);
}
