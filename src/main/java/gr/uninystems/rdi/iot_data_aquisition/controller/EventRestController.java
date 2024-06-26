package gr.uninystems.rdi.iot_data_aquisition.controller;

import gr.uninystems.rdi.iot_data_aquisition.model.Event;
import gr.uninystems.rdi.iot_data_aquisition.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EventRestController {
    private EventService eventService;

    @Autowired
    public EventRestController(EventService theEventService){
        this.eventService = theEventService;
    }

    @GetMapping({"/events/"})
    public List<Event> findAll() {
        return this.eventService.findAll();
    }

    @GetMapping({"/event/{eventId}"})
    public Event getEvent(@PathVariable Long eventId) {
        Event theEvent = this.eventService.findById(eventId);
        return theEvent;
    }

    @PostMapping({"/event/"})
    public Event addEvent(@RequestBody Event theEvent) {
        theEvent.setEventId(0L);
        Event dbEvent = this.eventService.save(theEvent);
        return dbEvent;
    }

    @DeleteMapping({"/event/{eventId}"})
    public String deleteEvent(@PathVariable Long eventId) {
        this.eventService.deleteBy(eventId);
        return "the id " + eventId + " deleted";
    }
}
