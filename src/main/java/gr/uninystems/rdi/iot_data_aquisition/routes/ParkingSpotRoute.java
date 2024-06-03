package gr.uninystems.rdi.iot_data_aquisition.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 *
 */

@Component
public class ParkingSpotRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://foo?period=1000")
                .setHeader("CamelHttpMethod", constant("GET"))
                .to("https://api.thingspeak.com/channels/1221862/feeds.json?api_key=Q2ZQZ2ZQZ2ZQZ2ZQ&results=1")
                .log("Response: Test +  ${body}");
    }

}
