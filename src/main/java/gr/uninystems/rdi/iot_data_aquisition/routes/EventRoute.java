package gr.uninystems.rdi.iot_data_aquisition.routes;

import gr.uninystems.rdi.iot_data_aquisition.aspects.TimerAware;
import gr.uninystems.rdi.iot_data_aquisition.aspects.TracingAware;
import gr.uninystems.rdi.iot_data_aquisition.model.Event;
import gr.uninystems.rdi.iot_data_aquisition.processors.event.EventProcessor;
import gr.uninystems.rdi.iot_data_aquisition.service.EventService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EventRoute extends RouteBuilder {

    @Value("/events")

    private String baseRestPath;

    private final EventService eventService;


    private final EventProcessor eventProcessor;

    public EventRoute(EventService eventService, EventProcessor eventProcessor) {
        this.eventService = eventService;
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void configure() throws Exception {
        configureExceptionHandling();
        configureRestEndpoints();
        configureDirectRoutes();


    }



    @TimerAware
    @TracingAware
    private void configureRestEndpoints() {

        rest(baseRestPath)
                //.get("/events")
                .get()
                .id("getAllEvents")
                .description("Retrieves all events")
                .produces("application/json")
                .outType(Event[].class)
                .to("direct:getAllEvents");

        rest(baseRestPath)
                .get("/{id}")
                .id("getEventById")
                .description("Retrieves an event by ID")
                .produces("application/json")
                .outType(Event.class)
                .param().name("id").type(RestParamType.path).dataType("long").description("The ID of the event").endParam()
                .to("direct:getEventById");

        rest(baseRestPath)
                .post("/events")
                .id("createEvent")
                .description("Creates a new event")
                .consumes("application/json")
                .produces("application/json")
                .type(Event.class)
                .outType(Event.class)
                .to("direct:createEvent");

        rest(baseRestPath)
                .put("/events/{id}")
                .id("updateEvent")
                .description("Updates an existing event")
                .consumes("application/json")
                .produces("application/json")
                .param().name("id").type(RestParamType.path).dataType("long").description("The ID of the event").endParam()
                .param().name("isFree").type(RestParamType.query).dataType("boolean").description("The new value for isFree").endParam()
                .to("direct:updateEvent");

        rest(baseRestPath)
                .delete("/events/{id}")
                .id("deleteEvent")
                .description("Deletes an event by ID")
                .param().name("id").type(RestParamType.path).dataType("long").description("The ID of the event").endParam()
                .to("direct:deleteEvent");
    }

    private void configureDirectRoutes() {
        from("direct:getAllEvents")
                .routeId("direct:getAllEvents")
                .process(eventProcessor)
                .bean(eventService, "findAll")
                .marshal().json(JsonLibrary.Jackson, true)
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .log("Fetched all events: ${body}");


        from("direct:getEventById")
                .routeId("direct:getEventById")
                .process(eventProcessor)
                .bean(eventService, "findById(${header.id})")
                .marshal().json(JsonLibrary.Jackson, true)
                .log("Fetched event with id: ${id}");

        from("direct:createEvent")
                .routeId("direct:createEvent")
                .bean(eventService, "save")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.CREATED.value()));

        from("direct:updateEvent")
                .routeId("direct:updateEvent")
                .bean(eventService, "update(${header.id}, ${header.isFree})");

        from("direct:deleteEvent")
                .routeId("direct:deleteEvent")
                .bean(eventService, "deleteBy(${header.id})")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.NO_CONTENT.value()));
    }

    private void configureExceptionHandling() {
        onException(Exception.class)
                .handled(true)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .setBody(simple("Internal server error1"));

        onException(IllegalArgumentException.class)
                .handled(true)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.BAD_REQUEST.value()))
                .setBody(simple("Invalid input"));
    }
}