package gr.uninystems.rdi.iot_data_aquisition.service;

import gr.uninystems.rdi.iot_data_aquisition.model.Event;
import gr.uninystems.rdi.iot_data_aquisition.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public Event save(Event data) {
        return eventRepository.save(data);
    }

    @Override
    public void deleteBy(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event update(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            return eventRepository.save(event);
        }
        return null;
    }
}