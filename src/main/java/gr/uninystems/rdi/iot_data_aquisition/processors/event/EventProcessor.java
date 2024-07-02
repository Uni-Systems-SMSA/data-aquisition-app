package gr.uninystems.rdi.iot_data_aquisition.processors.event;

import gr.uninystems.rdi.iot_data_aquisition.model.Event;
import gr.uninystems.rdi.iot_data_aquisition.service.EventService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EventProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(EventProcessor.class);

    @Autowired
    private EventService eventService;
    @Override
    public void process(Exchange exchange) throws Exception {
        String routeId = exchange.getFromRouteId();

        // Determine the route and process accordingly
        if ("direct:getAllEvents".equals(routeId)) {
            processGetAllEvents(exchange);
        } else if ("direct:getEventById".equals(routeId)) {
            processGetEventById(exchange);
        } else if ("direct:createEvent".equals(routeId)) {
            processCreateEvent(exchange);
        } else if ("direct:updateEvent".equals(routeId)) {
            processUpdateEvent(exchange);
        } else if ("direct:deleteEvent".equals(routeId)) {
            processDeleteEvent(exchange);
        }
    }

    private void processGetAllEvents(Exchange exchange) {
        logger.info("Fetching all events");

        // Retrieve all events from the service
        List<Event> events = eventService.findAll();

        // Check if the event list is empty and log accordingly
        if (events.isEmpty()) {
            logger.info("No events found");
        } else {
            logger.info("Found {} events", events.size());
        }

        // Set the response body to the list of events
        exchange.getIn().setBody(events);

        // Optionally, you can add custom headers or other processing here
        exchange.getIn().setHeader("Total-Events", events.size());
    }

    private void processGetEventById(Exchange exchange) {
        Long eventId = exchange.getIn().getHeader("id", Long.class);
        if (eventId == null) {
            throw new IllegalArgumentException("Event ID must be provided");
        }
        // Additional processing for fetching event by ID can be done here
    }

    private void processCreateEvent(Exchange exchange) {
        Event event = exchange.getIn().getBody(Event.class);
        if (event == null) {
            throw new IllegalArgumentException("Event data must be provided");
        }
        // Additional validation or processing logic for creating an event can be done here
    }

    private void processUpdateEvent(Exchange exchange) {
        Long eventId = exchange.getIn().getHeader("id", Long.class);
        Boolean isFree = exchange.getIn().getHeader("isFree", Boolean.class);
        if (eventId == null) {
            throw new IllegalArgumentException("Event ID must be provided");
        }
        if (isFree == null) {
            throw new IllegalArgumentException("isFree parameter must be provided");
        }
        // Additional validation or processing logic for updating an event can be done here
    }

    private void processDeleteEvent(Exchange exchange) {
        Long eventId = exchange.getIn().getHeader("id", Long.class);
        if (eventId == null) {
            throw new IllegalArgumentException("Event ID must be provided");
        }
        // Additional processing for deleting an event can be done here
    }
}