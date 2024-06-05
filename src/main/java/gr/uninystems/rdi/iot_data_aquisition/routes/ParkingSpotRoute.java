package gr.uninystems.rdi.iot_data_aquisition.routes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 */

@Component
public class ParkingSpotRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        rest()
//                from("direct:parking")
//                .get("/GetAllParkingSensors")
//
//                .to("direct:parking");

//        from("")
//                .setHeader("CamelHttpMethod", constant("GET"))
//                .setHeader("Authorization", constant("CicicomOath rjb7FyHbIUCuMiUa8MY83w=="))
//                .setHeader("Content-Type", constant("application/json"))
//                .to("http://dev.smartgridnet.com/smartGridPortalDev/api/CitizentsΒΟ/GetAllParkingSensors")
//                .process(exchange -> {
//                    String body = exchange.getIn().getBody(String.class);
//                    body.split("Result");




                //.unmarshal().json() // Unmarshal JSON to a Map
                //.split().jsonpath("$.Result[*]") // Split the JSON array in the Result field
                //.log("Processing item: ${body}");


//});
    }

}
